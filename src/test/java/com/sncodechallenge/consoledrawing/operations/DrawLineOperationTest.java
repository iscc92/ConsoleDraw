package com.sncodechallenge.consoledrawing.operations;

import com.sncodechallenge.consoledrawing.exceptions.InvalidInputException;
import org.junit.Test;

public class DrawLineOperationTest {

    @Test
    public void testDrawLineWithValidCoordinates() throws Exception {
        new DrawLineOperation("1","1","2","1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawLineWithOneNegativeCoordinate() throws Exception {
        new DrawLineOperation("1","1","-2","1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawLineInDiagonal() throws Exception {
        new DrawLineOperation("1","1","2","2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawLineWithIncompleteCoordinates() throws Exception {
        new DrawLineOperation("1","1","1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawLineWithNoCoordinates() throws Exception {
        new DrawLineOperation();
    }

}
