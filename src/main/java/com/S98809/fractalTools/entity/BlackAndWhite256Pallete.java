package com.S98809.fractalTools.entity;

public class BlackAndWhite256Pallete implements Pallete {
    @Override
    public int getColor(int r) {
        return (r) | (r << 8) | (r << 16);
    }

    @Override
    public int getSize() {
        return 256;
    }
}
