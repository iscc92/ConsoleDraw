package com.sncodechallenge.consoledrawing.operations;

public class DrawRectangleOperation implements DrawEntityOperation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public DrawRectangleOperation(String... params) {

        if (params.length < 4) {
            throw new IllegalArgumentException("Operation expects 4 params - R, x1, x2, y1 and y2");
        }

        x1 = Integer.parseInt(params[0]);
        y1 = Integer.parseInt(params[1]);
        x2 = Integer.parseInt(params[2]);
        y2 = Integer.parseInt(params[3]);

        if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0) {
            throw new IllegalArgumentException("Dimensions should be positive integer values");
        }

        if (x1 < x2 && y1 > y2 ) {
            throw new IllegalArgumentException(
                    "Vertices are presented in the wrong order, please, insert: Upper Left, Lower Right");
        }

    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
