package com.S98809.fractalTools.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TFractal extends JPanel implements FractalClass{
    private static final long serialVersionUID = 1L;
    private int iter;
    private String iteration;

    public TFractal(int nn) {
        this.iter = nn;
    }
    public TFractal(String iteration) {
        this.iteration= iteration;
    }
    public TFractal() {
    }

    public static int drawTSQ(Graphics g, Point A, int size, int iter) {
        //параметры А - координата левого верхнего угла квадрата
        //size - длина стороны
        //iter - кол-во итераций
        //g - экземпляр библиотечного класса, ответственного за отрисовку

        if (iter == 1) {//если итерация одна, просто рисуем заполненный прямоугольник
            g.fillRect(A.x, A.y, size, size);
            return 0;
        }
        int d = size / 4; //вспомогательная переменная, четверть длины исходного квадрата
        Point M[] = new Point[4];//координаты левых верхних углов порожденных квадратов
        for (int i = 0; i < 4; i++) {
            M[i] = new Point();
        }
        M[0].x = A.x - d;//левый верхний квадрат
        M[0].y = A.y - d;
        M[1].x = A.x - d;//левый нижний
        M[1].y = A.y + size - d;
        M[2].x = A.x + size - d;//правый верхний
        M[2].y = A.y - d;
        M[3].x = A.x + size - d;//правый нижний
        M[3].y = A.y + size - d;


        for (int i = 0; i < 4; i++) {
            drawTSQ(g, M[i], size / 2, iter - 1);//вызываем рекурсивно для каждого квадрата
         //   System.out.println("iter = " + iter);
        }
        g.setColor(Color.WHITE);
        g.fillRect(A.x, A.y, size, size);//отрисовываем исходный квадрат
        return 0;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.YELLOW);
        g.setColor(Color.BLACK);
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Dimension size = kit.getScreenSize();
        int h = 900;
        int w = 1600;

        Point A = new Point(w / 2 - h / 4, h / 4);//координаты левого верхнего угла исходного квадрата
        drawTSQ(g, A, h / 2 - h / 10, iter);//вызываем отрисовку фрактала
        repaint();

    }

    @Override
    public void drawFractal() throws IOException {
        Image  img = new ImageIcon("src/main/resources/static/image/test.png").getImage();

        BufferedImage bufferedImage = new BufferedImage(2000,1000,
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.createGraphics();

        TFractal sp=new TFractal(Integer.parseInt(iteration));
        sp.paintComponent(g);
        g.dispose();

        try {
            ImageIO.write(bufferedImage, "png", new File("D:\\my\\fractalTools\\target\\classes\\static\\image\\tfract.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }
}
