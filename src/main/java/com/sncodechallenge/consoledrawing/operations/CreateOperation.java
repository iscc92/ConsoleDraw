package com.sncodechallenge.consoledrawing.operations;

public class CreateOperation implements Operation {

    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public CreateOperation setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public CreateOperation setWidth(int width) {
        this.width = width;
        return this;
    }

    public CreateOperation(String... params) {
        if (params.length < 2) {
            throw new RuntimeException("Operation expects 2 params - w and h");
        }

        height = Integer.parseInt(params[0]);
        width = Integer.parseInt(params[1]);

        if (height <= 0 || width <= 0) {
            throw new RuntimeException("Dimensions should be positive integer values");
        }


    }

}
