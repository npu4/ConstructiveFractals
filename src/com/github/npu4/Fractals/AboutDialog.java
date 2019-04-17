package com.github.npu4.Fractals;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog{
    private static final String tags =
                    "<html>Программа, изображающая некоторые "  +
                    "конструктивные фракталы:"                  +
                    "<ul>" +
                            "<li> Кривая Коха"              +
                            "<li> Остров Коха"              +
                            "<li> Фрактал Минковского"      +
                            "<li> \"Резаный квадрат\""      +
                            "<li> \"Ледовый квадрат\""      +
                            "<li> \"Ледовый треугольник\""  +
                            "<li> Фрактал Леви"             +
                    "</ul>" +
                    "постепенно по итерациям.<br>" +
                    "Выполнение дополнительной итерации осуществляется " +
                    "с помощью кнопки внизу окна \"Еще одна итерация\"." +
                    "<hr>(c) Пучкова Н.Д., 2019</hr></html>";
    private static final int    DEFAULT_WIDTH = 500;
    private static final int    DEFAULT_HIGHT = 300;
    public AboutDialog(JFrame owner){
        super(owner, "О программе", true);
        add(new JLabel(tags), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(e-> setVisible(false));
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(DEFAULT_WIDTH, DEFAULT_HIGHT);
    }
}