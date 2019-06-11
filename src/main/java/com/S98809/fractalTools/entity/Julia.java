package com.S98809.fractalTools.entity;

import com.S98809.fractalTools.entity.support.Pallete;
import com.S98809.fractalTools.entity.support.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Julia implements Fractal,FractalClass {
    private String ax;
    private String bx;

    private String iteration;
    private int iter;



    private double a;
    private double b;
//
    public Julia(double a, double b,int iter) {
      this.a = a;
      this.b = b;
      this.iter=iter;
    }
    public Julia() {

    }
    public Julia(String ax,String bx,String iteration) {
        this.ax = ax;
        this.bx = bx;
        this.iteration=iteration;
    }

    @Override
    public Position getZoom() {
        return new Position(-1.59, 1.527, -1.558, 1.558); }

    @Override
    public int getFunction(double x0, double y0,int iterations) {
        double r = 0;
       // double xCord = -0.55;
      //  double yCord = -0.55;

        double x = x0;
        double y = y0;
        int color = iterations;
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

          System.out.println("xCord = " + ax);
            System.out.println("yCord = " + bx);
            Fractal fractal=new Julia(Double.parseDouble(ax),Double.parseDouble(bx),Integer.parseInt(iteration));
            BmpImage bmp = new BmpImage();
            Pallete palette = new BlackAndWhite256Pallete();
            ((BlackAndWhite256Pallete) palette).setIteration(Integer.parseInt(iteration));
            Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
            bmp.image = image;
            File file = new File("D:\\my\\fractalTools\\target\\classes\\static\\image\\julia.bmp");
            FileOutputStream out = new FileOutputStream(file);
            BmpWriter.write(out, bmp);
            out.close();
    }
    public String getAx() {
        return ax;
    }

    public void setAx(String ax) {
        this.ax = ax;
    }

    public String getBx() {
        return bx;
    }

    public void setBx(String bx) {
        this.bx = bx;
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }
}
