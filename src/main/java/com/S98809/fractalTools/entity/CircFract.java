package com.S98809.fractalTools.entity;

import javax.swing.*;
import java.awt.*;

public class CircFract extends JPanel {

    private  int nn;

    public CircFract(int nn)
    {
        this.nn=nn;
    }


    public void paintComponent(Graphics g){
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
            rad = Math.round(size/c);       //уменьшаем радиус
            den = Math.round(size*(c-1)/c);
            DrCirc(x, y, rad, g);           //центральная окружность
            for(int i = 0; i < N; i++){     //все остальные окружности
                DrCirc(x - Math.round(den*Math.sin(2*Math.PI/N*i)), y + Math.round(den*Math.cos(2*Math.PI/N*i)), rad, g);
            }
            g.setColor(Color.BLUE);
            g.drawOval((int)x-size, (int)y-size, 2*size, 2*size);
        }
    }
}
