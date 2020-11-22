package com.sncodechallenge.consoledrawing.operations;

import com.sncodechallenge.consoledrawing.exceptions.InvalidInputException;

public class CreateCanvas implements Operation {

    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public CreateCanvas setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public CreateCanvas setWidth(int width) {
        this.width = width;
        return this;
    }

    public CreateCanvas(String... params) {
        if (params.length < 2) {
            throw new InvalidInputException("Operation expects 2 params - w and h");
        }

        height = Integer.parseInt(params[0]);
        width = Integer.parseInt(params[1]);

        if (height <= 0 || width <= 0) {
            throw new InvalidInputException("Dimensions should be positive integer values");
        }


    }

}
