package com.sncodechallenge.consoledrawing.entities;

import com.sncodechallenge.consoledrawing.operations.DrawLineOperation;
import com.sncodechallenge.consoledrawing.operations.DrawRectangleOperation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntitiesFactoryTest {

    private EntitiesFactory entitiesFactory;

    @Before
    public void wire() throws Exception {
        entitiesFactory = new EntitiesFactory();
    }

    @Test
    public void testDrawLineOperationConnectedToLineGeometricEntity() throws Exception {
        DrawLineOperation drawLineOperation = new DrawLineOperation("1", "2", "1", "5");
        assertEquals(entitiesFactory.getGeometricEntity(drawLineOperation), new Line(1, 2, 1, 5));

    }

    @Test
    public void testDrawRectangleOperationConnectedToRectangleGeometricEntity() throws Exception {
        DrawRectangleOperation drawrectangleOperation = new DrawRectangleOperation("1", "1", "2", "2");
        assertEquals(entitiesFactory.getGeometricEntity(drawrectangleOperation), new Rectangle(1, 1, 2, 2));

    }

}
