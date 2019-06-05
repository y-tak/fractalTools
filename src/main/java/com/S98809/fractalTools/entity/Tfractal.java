package com.S98809.fractalTools.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tfractal {

        private String iteration;
        private  final long serialVersionUID = 1L;

        public void drawTFract()
        {
            Image  img = new ImageIcon("src/main/resources/static/image/test.png").getImage();

            BufferedImage bufferedImage = new BufferedImage(2000,1000,
                    BufferedImage.TYPE_INT_RGB);

            Graphics g = bufferedImage.createGraphics();

           TFract sp=new TFract(Integer.parseInt(iteration));
            sp.paintComponent(g);
            g.dispose();

            try {
                ImageIO.write(bufferedImage, "png", new File("src/main/resources/static/image/tfract.bmp"));
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

