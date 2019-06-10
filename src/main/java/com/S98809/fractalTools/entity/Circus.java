package com.S98809.fractalTools.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Circus {

    private String iteration;


    public void drawCircFract() {

        Image img = new ImageIcon("src/main/resources/static/image/test.png").getImage();

        BufferedImage bufferedImage = new BufferedImage(650, 650,
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.createGraphics();
        CircFract sp=new CircFract(Integer.parseInt(iteration));
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

