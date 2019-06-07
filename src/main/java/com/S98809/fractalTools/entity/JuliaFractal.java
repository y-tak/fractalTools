package com.S98809.fractalTools.entity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class JuliaFractal {

    private String ax;
    private String bx;

    public void drawJulia() throws IOException {

        System.out.println("xCord = " + ax);
        System.out.println("yCord = " + bx);
       /// Fractal fractal=new Julia(-0.55,-0.55);
        Fractal fractal=new Julia(Double.parseDouble(ax),Double.parseDouble(bx));
      //  Fractal fractal=new Julia();
        BmpImage bmp = new BmpImage();
        Pallete palette = new BlackAndWhite256Pallete();
        Progress image = new Progress(new FractalImage(1920, 1080, fractal, palette));
        bmp.image = image;

        File file = new File("src/main/resources/static/image/julia.bmp");
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
}

