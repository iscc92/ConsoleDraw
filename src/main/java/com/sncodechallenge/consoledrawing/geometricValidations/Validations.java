package com.sncodechallenge.consoledrawing.geometricValidations;

public class Validations {

    public static void areCoordinatesPositive(int[] coordinates) {
        for (int coordinate: coordinates) {
            if (coordinate < 1) {
                throw new IllegalArgumentException(coordinate + " - Coordinate is not positive");
            }
        }
    }





}
