package com.sncodechallenge.consoledrawing.entities;

import org.junit.Assert;
import org.junit.Test;

public class CanvasImplTest {

    @Test
    public void testDisplayEmptyCanvas() throws Exception {
        Canvas canvas = new CanvasImpl(3, 18);

        Assert.assertEquals(canvas.displayCanvas(),
                "--------------------\n" +
                        "|                  |\n" +
                        "|                  |\n" +
                        "|                  |\n" +
                        "--------------------");
    }

}
