package com.sncodechallenge.consoledrawing.operations;

public class DrawRectangleOperation implements DrawEntityOperation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public DrawRectangleOperation(String... params) {

        if (params.length < 4) {
            throw new RuntimeException("Operation expects 4 params - R, x1, x2, y1 and y2");
        }

        x1 = Integer.parseInt(params[0]);
        y1 = Integer.parseInt(params[1]);
        x2 = Integer.parseInt(params[2]);
        y2 = Integer.parseInt(params[3]);

        if (x1 <= 0 || y1 <= 0 || x2 <= 0 || y2 <= 0) {
            throw new IllegalArgumentException("Dimensions should be positive integer values");
        }

        if (x1 != x2 && y1 != y2) {
            throw new IllegalArgumentException(
                    (x1 + "," + x2 + "," + "," + y1 + "," + y2) + " - Diagonal lines are not supported");
        }
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
