package com.sncodechallenge.consoledrawing.operations;

import org.junit.Test;

public class DrawRectangleOperationTest {

    @Test
    public void testDrawRectangleWithValidCoordinates() throws Exception {
        new DrawRectangleOperation("1", "1", "2", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawRectangleWithNegativeCoordinates() throws Exception {
        new DrawRectangleOperation("1", "-1", "2", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawRectangleWithIncompleteCoordinates() throws Exception {
        new DrawRectangleOperation("1", "2", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawRectangleWithNoCoordinates() throws Exception {
        new DrawRectangleOperation();
    }
}
