package com.sncodechallenge.consoledrawing.entities;

import com.sncodechallenge.consoledrawing.operations.Validations;

import java.util.Objects;

public class Line implements GeometricEntity {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {


        if (x1 != x2 && y1 != y2) {
            throw new IllegalArgumentException(
                    (x1 + "," + y1 + "," + x2 + "," + y2) + " - Diagonal lines are not supported"); }

        int[] coordinatesArray = new int[]{x1, y1, x2, y2};

        Validations.areCoordinatesPositive(coordinatesArray);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() { return x1; }

    public int getY1() { return y1; }

    public int getX2() { return x2; }

    public int getY2() { return y2; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return x1 == line.x1 &&
                y1 == line.y1 &&
                x2 == line.x2 &&
                y2 == line.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}
