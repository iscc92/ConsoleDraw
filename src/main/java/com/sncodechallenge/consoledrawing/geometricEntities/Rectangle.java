package com.sncodechallenge.consoledrawing.geometricEntities;

import com.sncodechallenge.consoledrawing.geometricValidations.Validations;

import java.util.Objects;

public class Rectangle implements GeometricEntity {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    int[] coordinatesArray = new int[]{x1, x2, y1, y2};

    public Rectangle(int x1, int x2, int y1, int y2) {

        int[] coordinatesArray = new int[]{x1, x2, y1, y2};

        Validations.areCoordinatesPositive(coordinatesArray);

        if ((x1 == x2 && y1 > y2) || (x1 > x2 && y1 == y2)) {

            this.x1 = x2;
            this.x2 = x1;
            this.y1 = y2;
            this.y2 = y1;

        } else {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return x1 == rectangle.x1 &&
                x2 == rectangle.x2 &&
                y1 == rectangle.y1 &&
                y2 == rectangle.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, y1, y2);
    }
}
