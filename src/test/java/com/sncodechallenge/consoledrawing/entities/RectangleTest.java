package com.sncodechallenge.consoledrawing.entities;

import com.sncodechallenge.consoledrawing.operations.DrawRectangleOperation;
import org.junit.Test;


public class RectangleTest {

    @Test
    public void testRectangleWithValidCoordinates() throws Exception {
        new DrawRectangleOperation("1", "1", "2", "2");

    }


    @Test(expected = IllegalArgumentException.class)
    public void testRectangleWithNegativeCoordinates() throws Exception {
        new DrawRectangleOperation("-1", "-1", "-2", "-2");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRectangleWithInsufficientNumberOfCoordinates() throws Exception {
        new DrawRectangleOperation("1");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRectangleWithSwitchedSetOfCoordinates() throws Exception {
        new DrawRectangleOperation("1", "2", "2", "1");

    }

}
