package com.S98809.fractalTools.entity.support;

import com.S98809.fractalTools.entity.Fractal;
import com.S98809.fractalTools.entity.Position;

public class FractalImage implements Rgb888Image {

    private int width;
    private int height;
    private Fractal fractal;
    private Pallete palette;
    private Position zoom;

    public FractalImage(int width, int height, Fractal fractal, Pallete palette) {
        this.width = width;
        this.height = height;
        this.fractal = fractal;
        this.palette = palette;
        zoom = fractal.getZoom().resize(width, height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getRgb888Pixel(int x, int y) {
        double x1 = zoom.getXMin() + (x + 0.5) / width * (zoom.getXMax() - zoom.getXMin());
        double y1 = zoom.getYMax() - (y + 0.5) / height * (zoom.getYMax() - zoom.getYMin());
        int r = fractal.getFunction(x1, y1, palette.getSize() - 1);
        return palette.getColor(r);
    }

    public String getFractalName() {
        return fractal.getClass().getSimpleName();
    }
}