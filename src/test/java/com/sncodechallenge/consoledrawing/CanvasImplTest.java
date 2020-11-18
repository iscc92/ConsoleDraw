package com.sncodechallenge.consoledrawing;

import com.sncodechallenge.consoledrawing.entities.Canvas;
import com.sncodechallenge.consoledrawing.entities.CanvasImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CanvasImplTest {
    private Canvas canvas;

    @Before
    public void wire() throws Exception {
        canvas = new CanvasImpl(3, 18);
    }

    @Test
    public void testDisplayEmptyCanvas() throws Exception {

        Assert.assertEquals(canvas.displayCanvas(),
                "--------------------\n" +
                        "|                  |\n" +
                        "|                  |\n" +
                        "|                  |\n" +
                        "--------------------");
    }
/***
 @Test public void testDisplayCanvasWithVerticalLine() throws Exception {
 Line line = new Line(4,1,4,3);
 canvas.directToGeometricEntity(line);

 Assert.assertEquals(canvas.displayCanvas(),
 "--------------------\n" +
 "|   x              |\n" +
 "|   x              |\n" +
 "|   x              |\n" +
 "--------------------");
 } ***/
}
