package com.sncodechallenge.consoledrawing.operations;

import java.util.Arrays;

public class OperationsManager {

    public Operation getOperation(String inputFromScanner) throws RuntimeException {
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
                System.out.println("An invalid operation was requested!");

        }
        return null;
    }


}
