package com.S98809.fractalTools.entity.support;

public class BmpImage {


    public Rgb888Image image;

    public int horizontalResolution;  // In pixels per metre

    public int verticalResolution;  // In pixels per metre


    public BmpImage() {
        horizontalResolution = 3780;  // 96 DPI
        verticalResolution = 3780;  // 96 DPI
    }
}
