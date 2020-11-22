package com.sncodechallenge.consoledrawing.operations;

import com.sncodechallenge.consoledrawing.exceptions.InvalidInputException;
import org.junit.Test;

public class CreateCanvasTest {

    @Test
    public void testCreateCanvasWithPositiveDimensions() throws Exception {
        new CreateCanvas("10","20");
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateCanvasWithNegativeWidth() throws Exception {
        new CreateCanvas("10","-20");
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateCanvasWithNegativeHeight() throws Exception {
        new CreateCanvas("-10","20");
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateCanvasWithNoDimensions() throws Exception {
        new CreateCanvas();
    }
}
