package com.sncodechallenge.consoledrawing.operations;

import com.sncodechallenge.consoledrawing.exceptions.InvalidInputException;
import com.sncodechallenge.consoledrawing.exceptions.InvalidOperationException;

import java.util.Arrays;

public class OperationsManager {

    public Operation getOperation(String inputFromScanner) throws InvalidInputException, InvalidOperationException {
        inputFromScanner = inputFromScanner.trim().replaceAll(" {2,}", " ");
        String[] discreteInput = inputFromScanner.split(" ");
        String entity = discreteInput[0].toUpperCase();
        String[] dimensions = Arrays.copyOfRange(discreteInput, 1, discreteInput.length);

        switch (entity) {
            case "C":
                return new CreateCanvas(dimensions);
            case "L":
                return new DrawLineOperation(dimensions);
            case "R":
                return new DrawRectangleOperation(dimensions);
            case "Q":
                return new Quit();
            default:
                throw new InvalidOperationException();

        }
    }


}
