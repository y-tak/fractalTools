package com.S98809.fractalTools.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Circus extends JPanel implements FractalClass {

    private String iteration;

    private int nn;

    public Circus(int iter) {
        this.nn = iter;
    }
    public Circus(){}

    public Circus(String iteration)
    { this.iteration=iteration;}

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   //сглаживание
        DrCirc(300, 300, 200, g);           //центр и размер фрактала
    }

    public void DrCirc(double x, double y, int size, Graphics g) {
        int N = nn, c = 3, rad = 0, den = 0;
        //всего получится (N+1) окружность
        //новые окружности будут иметь радиус size/c
        if (size > 0) {
            rad = Math.round(size / c);       //уменьшаем радиус
            den = Math.round(size * (c - 1) / c);
            DrCirc(x, y, rad, g);           //центральная окружность
            for (int i = 0; i < N; i++) {     //все остальные окружности
                DrCirc(x - Math.round(den * Math.sin(2 * Math.PI / N * i)), y + Math.round(den * Math.cos(2 * Math.PI / N * i)), rad, g);
            }
            g.setColor(Color.WHITE);
            g.drawOval((int) x - size, (int) y - size, 2 * size, 2 * size);
        }
    }

    @Override
    public void drawFractal() throws IOException {

        Image img = new ImageIcon("src/main/resources/static/image/test.png").getImage();

        BufferedImage bufferedImage = new BufferedImage(650, 650,
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.createGraphics();
        Circus sp = new Circus(Integer.parseInt(iteration));
        sp.paintComponent(g);
        g.dispose();

        try {
            ImageIO.write(bufferedImage, "png", new File("D:\\my\\fractalTools\\target\\classes\\static\\image\\circus.png"));
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
