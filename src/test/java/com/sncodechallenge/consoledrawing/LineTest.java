package com.sncodechallenge.consoledrawing;

import com.sncodechallenge.consoledrawing.operations.DrawLineOperation;
import org.junit.Test;


public class LineTest {

    @Test
    public void testVerticalLineWithValidCoordinates() throws Exception {
        new DrawLineOperation("1", "2", "1", "5");

    }

    @Test
    public void testHorizontalLineWithValidCoordinates() throws Exception {
        new DrawLineOperation("1", "5", "2", "5");

    }


    @Test(expected = IllegalArgumentException.class)
    public void testLineWithNegativeCoordinates() throws Exception {
        new DrawLineOperation("-1", "2", "-2", "2");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testLineWithInsufficientNumberOfCoordinates() throws Exception {
        new DrawLineOperation("3", "2");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testLineWithEmptySetOfCoordinates() throws Exception {
        new DrawLineOperation();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDiagonalLine() throws Exception {
        new DrawLineOperation("1", "1", "2", "2");

    }
}
