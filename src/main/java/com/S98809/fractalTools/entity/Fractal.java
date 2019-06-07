package com.S98809.fractalTools.entity;

public interface Fractal {

    Position getZoom();

    int getFunction(double x, double y, int iterations);

}
