package com.sncodechallenge.consoledrawing.operations;

import org.junit.Test;

public class ValidationsTest {

    @Test
    public void testCoordinateIsPositive() throws Exception {
        int[] positiveCoordinates = new int[]{1,2,3,4};
        Validations.areCoordinatesPositive(positiveCoordinates);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCoordinateIsNegative() throws Exception {
        int[] negativeCoordinates = new int[]{-1,2,3,4};
        Validations.areCoordinatesPositive(negativeCoordinates);
    }
}
