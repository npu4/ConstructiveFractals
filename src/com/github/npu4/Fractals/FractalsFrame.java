package com.github.npu4.Fractals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class FractalsFrame extends JFrame{
    public static int sizeOfFrame = 600;
    public JPanel panel;
    private JFileChooser chooser;

    private final String questionMcg = "Хотите сохранить картинку?";
    private final String questionTitle = "Запрос сохранения";

    FractalsFrame(){
        chooser = new JFileChooser();
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem saveItem = new JMenuItem("Сохранить", new ImageIcon("save.jpg"));
        saveItem.addActionListener(e -> save());
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        JMenuItem KohaCurveItem = new JMenuItem("Фрактал \"Кривая Коха\"", new ImageIcon("1.jpg"));
        KohaCurveItem.addActionListener(e -> {
            KohaCurvePanel panel = new KohaCurvePanel();
            panel.setLayout(new BorderLayout());
            getContentPane().removeAll();
            getContentPane().add(panel);
            JButton updateButton = new JButton("Еще одна итерация");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.flagToContinue = true;
                }
            });
            panel.add(updateButton, BorderLayout.SOUTH);
            pack();
        });

        JMenuItem KohaIslandItem = new JMenuItem("Фрактал \"Остров Коха\"", new ImageIcon("2.jpg"));
        KohaIslandItem.addActionListener(e -> {
            KohaIslandPanel panel = new KohaIslandPanel();
            panel.setLayout(new BorderLayout());
            getContentPane().removeAll();
            getContentPane().add(panel);
            JButton updateButton = new JButton("Еще одна итерация");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.flagToContinue = true;
                }
            });
            panel.add(updateButton, BorderLayout.SOUTH);
            pack();
        });

        JMenuItem MinkowskiFractalItem = new JMenuItem("Фрактал Минковского", new ImageIcon("3.jpg"));
        MinkowskiFractalItem.addActionListener(e -> {
            MinkowskiFractalPanel panel = new MinkowskiFractalPanel();
            panel.setLayout(new BorderLayout());
            getContentPane().removeAll();
            getContentPane().add(panel);
            JButton updateButton = new JButton("Еще одна итерация");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.flagToContinue = true;
                }
            });
            panel.add(updateButton, BorderLayout.SOUTH);
            pack();
        });

        JMenuItem cutSquareFractalItem = new JMenuItem("Фрактал \"Резаный квадрат\"", new ImageIcon("4.jpg"));
        cutSquareFractalItem.addActionListener(e -> {
            CutSquareFractalPanel panel = new CutSquareFractalPanel();
            panel.setLayout(new BorderLayout());
            getContentPane().removeAll();
            getContentPane().add(panel);
            JButton updateButton = new JButton("Еще одна итерация");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.flagToContinue = true;
                }
            });
            panel.add(updateButton, BorderLayout.SOUTH);
            pack();
        });

        JMenuItem iceSquareFractalItem = new JMenuItem("Фрактал \"Ледовый квадрат\"", new ImageIcon("5.jpg"));
        iceSquareFractalItem.addActionListener(e -> {
            IceSquareFractalPanel panel = new IceSquareFractalPanel();
            panel.setLayout(new BorderLayout());
            getContentPane().removeAll();
            getContentPane().add(panel);
            JButton updateButton = new JButton("Еще одна итерация");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.flagToContinue = true;
                }
            });
            panel.add(updateButton, BorderLayout.SOUTH);
            pack();
        });

        JMenuItem iceTriangleFractalItem = new JMenuItem("Фрактал \"Ледовый треугольник\"", new ImageIcon("6.jpg"));
        iceTriangleFractalItem.addActionListener(e -> {
            IceTriangleFractalPanel panel = new IceTriangleFractalPanel();
            panel.setLayout(new BorderLayout());
            getContentPane().removeAll();
            getContentPane().add(panel);
            JButton updateButton = new JButton("Еще одна итерация");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.flagToContinue = true;
                }
            });
            panel.add(updateButton, BorderLayout.SOUTH);
            pack();
        });

        JMenuItem LevyFractalItem = new JMenuItem("Фрактал Леви", new ImageIcon("7.jpg"));
        LevyFractalItem.addActionListener(e -> {
            LevyFractalPanel panel = new LevyFractalPanel();
            panel.setLayout(new BorderLayout());
            getContentPane().removeAll();
            getContentPane().add(panel);
            JButton updateButton = new JButton("Еще одна итерация");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.flagToContinue = true;
                }
            });
            panel.add(updateButton, BorderLayout.SOUTH);
            pack();
        });

        JMenuItem exitItem = new JMenuItem("Выход", new ImageIcon("exit.jpg"));
        exitItem.addActionListener(e->{
            boolean neededSaving = requestSaving();
            if(neededSaving){
                save();
            }
            System.exit(0);
        });
        exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));


        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(KohaCurveItem);
        fileMenu.add(KohaIslandItem);
        fileMenu.add(MinkowskiFractalItem);
        fileMenu.add(cutSquareFractalItem);
        fileMenu.add(iceSquareFractalItem);
        fileMenu.add(iceTriangleFractalItem);
        fileMenu.add(LevyFractalItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);


        JMenuItem aboutItem = new JMenuItem("О программе");
        aboutItem.addActionListener(e -> {
            JDialog dialog = new AboutDialog(this);
            dialog.setVisible(true);
        });
        JMenu helpMenu = new JMenu("Справка");
        helpMenu.add(aboutItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        setPreferredSize(new Dimension(sizeOfFrame, sizeOfFrame)); // задаем размеры окна
        pack();
    }


    private boolean requestSaving(){
        int selection = JOptionPane.showConfirmDialog(this,
                questionMcg,
                questionTitle,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return selection == JOptionPane.OK_OPTION;
    }

    private void save() {
        BufferedImage img = new BufferedImage(sizeOfFrame,sizeOfFrame,BufferedImage.TYPE_INT_ARGB);
        paint(img.getGraphics());
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showDialog(FractalsFrame.this,"Save");
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            try
            {
                ImageIO.write(img,"png", file);
                JOptionPane.showMessageDialog(FractalsFrame.this,"Изображение сохранено!", "Сохранение",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex)
            {
                JOptionPane.showMessageDialog(FractalsFrame.this,"Ошибка!", "Сохранение",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(FractalsFrame.this,"Отменено", "Сохранение", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}