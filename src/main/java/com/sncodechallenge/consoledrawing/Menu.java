package com.sncodechallenge.consoledrawing;

import com.sncodechallenge.consoledrawing.entities.Canvas;
import com.sncodechallenge.consoledrawing.entities.CanvasImpl;
import com.sncodechallenge.consoledrawing.entities.EntitiesFactory;
import com.sncodechallenge.consoledrawing.operations.*;

import java.util.Scanner;

class Menu {
    private static Scanner input;
    private static Canvas canvas;
    private static EntitiesFactory entitiesFactory;
    private static OperationsManager operationsManager;

    Menu() {
    }

    void launchMenu() throws NumberFormatException, InterruptedException {

        input = new Scanner(System.in);

        System.out.println("Welcome to the Drawing Console. "
                + "Please, enter the desired operation according to instructions: ");

        while (true) {
            execute(input.nextLine());
            System.out.println("Please, enter the desired operation according to instructions: ");
        }

    }

    private void execute(String input) {
        Operation operation = null;

        try {
            operation = operationsManager.getOperation(input);
        } catch (InvalidOperationException e) {
            System.out.println("An invalid operation was requested!");
        } catch (InvalidInputException invalidInputException) {
            System.out.println("Operation is not well formulated: " + invalidInputException.getMessage());
            System.out.println("Please, introduce accordingly:  " + invalidInputException);
        }

        if (operation instanceof CreateCanvas) {
            initiateCanvas((CreateCanvas) operation);
            return;
        }

        if (operation instanceof DrawEntityOperation) {
            try {
                canvas.directToGeometricEntity(entitiesFactory.getGeometricEntity((DrawEntityOperation) operation));
                System.out.println(canvas.displayCanvas());

            } catch (InvalidGeometricEntity e) {
                System.out.println(
                        "The introduced Geometric Entity is not supported by current version of Console Drawing");
            }

        }

        if (operation instanceof Quit) {
            quitConsoleDrawing();
        }

    }

    private void initiateCanvas(CreateCanvas operation) {
        canvas = new CanvasImpl(operation.getWidth(), operation.getHeight());
        System.out.println(canvas.displayCanvas());
    }

    private static void quitConsoleDrawing() {
        input.close();
        System.out.println("Existing Console Drawing. Bye!");
        System.exit(0);
    }
}