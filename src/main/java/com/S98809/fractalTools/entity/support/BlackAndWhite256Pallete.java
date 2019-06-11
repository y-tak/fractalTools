package com.S98809.fractalTools.entity.support;

public class BlackAndWhite256Pallete implements Pallete {

   int iteration;

    @Override
    public int getColor(int r) {
        return (r) | (r << 8) | (r << 16);
    }

    @Override
    public int getSize() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }
}
