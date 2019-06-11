package com.S98809.fractalTools.entity;

import com.S98809.fractalTools.entity.support.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Mandelbrot implements Fractal, FractalClass {
    private String iteration;
    private int iter;

    private Position mandelbrot = new Position(-1.9, 0.5, -1.2, 1.2) {
    };

    public Mandelbrot(String iteration) {
        this.iteration = iteration;
    }

    public Mandelbrot(int iter) {
        this.iter = iter;
    }

    public Mandelbrot() {
    }

    @Override
    public Position getZoom() {
        return mandelbrot.zoom(40).move(-1.25, 2).zoom(5);
    }

    @Override
    public int getFunction(double a, double b, int iter) {
        double r = 0;
        double x = 0;
        double y = 0;

        int color = iter;
        while (color > 0 && r < 4) {
            double x2 = x * x;
            double y2 = y * y;
            double xy = x * y;
            x = x2 - y2 + a;
            y = 2 * xy + b;
            r = x2 + y2;
            color--;
        }
        return color;
    }

    @Override
    public void drawFractal() throws IOException {

        Fractal fractal = new Mandelbrot(Integer.parseInt(iteration));

        BmpImage bmp = new BmpImage();
        Pallete palette = new BlackAndWhite256Pallete();
        ((BlackAndWhite256Pallete) palette).setIteration(Integer.parseInt(iteration));
        Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
        bmp.image = image;
        Date data = new Date();
        File file = new File("D:\\my\\fractalTools\\target\\classes\\static\\image\\mandelbrot.bmp");
        FileOutputStream out = new FileOutputStream(file);
        BmpWriter.write(out, bmp);
        out.close();
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }
}

