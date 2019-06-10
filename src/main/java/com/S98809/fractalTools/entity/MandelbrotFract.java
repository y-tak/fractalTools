package com.S98809.fractalTools.entity;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MandelbrotFract {

private String name="mandelbrot";

    public void drawM() throws IOException {

       Fractal fractal=new Mandelbrot();

        BmpImage bmp = new BmpImage();
        Pallete palette = new BlackAndWhite256Pallete();
        Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
        bmp.image = image;
        Date data=new Date();
        File file = new File("D:\\my\\fractalTools\\target\\classes\\static\\image\\mandelbrot.bmp");
        FileOutputStream out = new FileOutputStream(file);
        BmpWriter.write(out, bmp);
        out.close();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
