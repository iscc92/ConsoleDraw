package com.sncodechallenge.consoledrawing.operations;

import com.sncodechallenge.consoledrawing.exceptions.InvalidInputException;
import com.sncodechallenge.consoledrawing.exceptions.InvalidOperationException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperationsManagerTest {

    private OperationsManager operationsManager;

    @Before
    public void wire() throws Exception {
        operationsManager = new OperationsManager();
    }

    @Test(expected = InvalidOperationException.class)
    public void testOperationAskedIsNotOneOfTheOptions() throws Exception {
        operationsManager.getOperation("I");
    }

    @Test
    public void testOperationAskedIsQuit() throws Exception {
        operationsManager.getOperation("Q");
    }

    @Test(expected = InvalidInputException.class)
    public void testCreateCanvasWithNegativeDimensions() throws Exception {
        operationsManager.getOperation("C 10 -20");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateLineWithNegativeDimensions() throws Exception {
        operationsManager.getOperation("L 1 1 -2 1");
    }

    @Test
    public void testCreateLineWithValidDimensions() throws Exception {
        Operation operation = operationsManager.getOperation("L 1 1 2 1");
        Assert.assertThat(operation, CoreMatchers.instanceOf(DrawLineOperation.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateRectangleWithNegativeDimensions() throws Exception {
        operationsManager.getOperation("R 1 1 -2 2");
    }

    @Test
    public void testCreateRectangleWithValidDimensions() throws Exception {
        Operation operation = operationsManager.getOperation("R 1 1 2 2");
        Assert.assertThat(operation, CoreMatchers.instanceOf(DrawRectangleOperation.class));
    }

}
