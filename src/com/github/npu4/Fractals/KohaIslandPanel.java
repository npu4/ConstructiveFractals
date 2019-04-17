package com.github.npu4.Fractals;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KohaIslandPanel extends JPanel {
    public static int sizeOfPanel = 590;

    public static boolean flagToContinue = true;
    public static java.util.List<MyLine> lines = new ArrayList<MyLine>();

    public static double[][] pattern = {
            {0,             0},
            {0.3333333333,  0},
            {0.5,           0.2886751345},
            {0.6666666666,  0},
            {1,             0}
    };

    static Point A = new Point(sizeOfPanel-10,sizeOfPanel-80);
    static Point B = new Point(10,sizeOfPanel-80);
    static Point C = new Point(sizeOfPanel/2,sizeOfPanel-(int)((sizeOfPanel-20)*Math.sqrt(3)/2)-80);

    public static int draw(Graphics g) {
        if(flagToContinue) {
            if (lines.size() == 0) {
                lines.add(new MyLine(A.x, A.y, B.x, B.y));
                lines.add(new MyLine(B.x, B.y, C.x, C.y));
                lines.add(new MyLine(C.x, C.y, A.x, A.y));
                //выключаем необходимость продолжения
                flagToContinue = false;
                return 0;
            }
            java.util.List<MyLine> bufferLines = new ArrayList<MyLine>(); // буферный лист, сюда мы будем записывать новые линии
            java.util.List<Point> bufferPoints = new ArrayList<Point>(); // буферный лист точек, которые мы получаем

            // перебираем все линиии и преобразовываем их
            for (MyLine line :
                    lines) {
                bufferPoints.clear(); // очищаем лист точек, так как иначе он заполнится не нужными точками от предыдущих линий
                for (int i = 0; i < pattern.length; i++) {
                    double xRes = (line.X - line.x) * pattern[i][0] - (line.Y - line.y) * pattern[i][1] + line.x;
                    double yRes = (line.Y - line.y) * pattern[i][0] + (line.X - line.x) * pattern[i][1] + line.y;
                    bufferPoints.add(new Point((int) xRes, (int) yRes)); // получи точку запоминаем ее
                }
                //в этом цикле проходим по существующим точкам и создаем линии, добавляем их в буфер линий
                for (int i = 0; i < bufferPoints.size() - 1; i++) {
                    bufferLines.add(new MyLine(bufferPoints.get(i).x,
                            bufferPoints.get(i).y,
                            bufferPoints.get(i + 1).x,
                            bufferPoints.get(i + 1).y));
                }
            }
            flagToContinue = false; // отключаем флаг прохода
            lines = bufferLines; // забываем про старые линии, так как они не актуальны, и запоминаем новые
        }
        return 0;
    }

    @Override
    protected void paintComponent(Graphics g) { // этот медот вызывается у компонента при каждом обновлении кадра
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        draw(g);
        //цикл перебирает все существующие линии и отрисовывает их
        for (MyLine line:
                lines) {
            g.drawLine(line.x, line.y, line.X, line.Y);
        }
        repaint();
    }
}