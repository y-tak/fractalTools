package com.S98809.fractalTools.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Speransky extends JPanel implements FractalClass{
    //  private static Graphics2D g2d;
    private  int nn;
    private String iteration;

public Speransky(String iteration)
{this.iteration=iteration;}

public Speransky(){}

    public Speransky(int nn)
    {
        this.nn=nn;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   //сглаживание
        drawSerpinsky(nn, new  int[]{40, 320, 600}, new  int[]{470, 10, 470},g2d);           //центр и размер фрактала
    }
    private void drawSerpinsky(int n,  int[] x,  int[] y,Graphics2D g2d) {
        if(n > 0) {
            int x1 = (x[0] + x[1]) / 2;
            int y1 = (y[0] + y[1]) / 2;

            int x2 = (x[1] + x[2]) / 2;
            int y2 = (y[1] + y[2]) / 2;

            int x3 = (x[2] + x[0]) / 2;
            int y3 = (y[2] + y[0]) / 2;

            g2d.setColor(Color.BLACK);
            g2d.fillPolygon(x, y, 3);

            g2d.setColor(Color.WHITE);
            g2d.fillPolygon(new  int[]{x1, x2, x3}, new  int[]{y1, y2, y3}, 3);

            drawSerpinsky(n-1, new  int[]{x[0], x1, x3}, new  int[]{y[0], y1, y3},g2d);
            drawSerpinsky(n-1, new  int[]{x1, x[1], x2}, new  int[]{y1, y[1], y2},g2d);
            drawSerpinsky(n-1, new  int[]{x3, x2, x[2]}, new  int[]{y3, y2, y[2]},g2d);
        }

    }


    @Override
    public void drawFractal() throws IOException {
        Image  img = new ImageIcon("src/main/resources/static/image/test.png").getImage();

        BufferedImage bufferedImage = new BufferedImage(650, 650,
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.createGraphics();
        Speransky sp=new Speransky(Integer.parseInt(iteration));
        sp.paintComponent(g);
        g.dispose();

        try {
            ImageIO.write(bufferedImage, "png", new File("D:\\my\\fractalTools\\target\\classes\\static\\image\\speransky.png"));
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
