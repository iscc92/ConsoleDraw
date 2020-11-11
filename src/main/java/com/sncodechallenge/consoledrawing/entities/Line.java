package com.sncodechallenge.consoledrawing.entities;

import com.sncodechallenge.consoledrawing.validations.Validations;

import java.util.Objects;

public class Line implements GeometricEntity {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Line(int x1, int x2, int y1, int y2) {


        if (x1 != x2 && y1 != y2) {
            throw new IllegalArgumentException(
                    (x1 + "," + x2 + "," + "," + y1 + "," + y2) + " - Diagonal lines are not supported");
        }

        int[] coordinatesArray = new int[]{x1, x2, y1, y2};

        Validations.areCoordinatesPositive(coordinatesArray);

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return x1 == line.x1 &&
                x2 == line.x2 &&
                y1 == line.y1 &&
                y2 == line.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, y1, y2);
    }
}
