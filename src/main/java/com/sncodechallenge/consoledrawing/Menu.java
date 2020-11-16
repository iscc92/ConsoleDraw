package com.sncodechallenge.consoledrawing;

import com.sncodechallenge.consoledrawing.entities.Canvas;
import com.sncodechallenge.consoledrawing.entities.CanvasImpl;
import com.sncodechallenge.consoledrawing.entities.EntitiesFactory;
import com.sncodechallenge.consoledrawing.exceptions.InvalidGeometricEntityException;
import com.sncodechallenge.consoledrawing.exceptions.InvalidInputException;
import com.sncodechallenge.consoledrawing.exceptions.InvalidOperationException;
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
            executeMenu(input.nextLine());
            System.out.println("Please, enter the desired operation according to instructions: ");
        }

    }

    private void executeMenu(String input) {
        Operation operation = null;

        try {
            operation = operationsManager.getOperation(input);
        } catch (InvalidOperationException invalidOperationException) {
            System.out.println("An invalid operation was requested. Please try again!");
        } catch (InvalidInputException invalidInputException) {
            System.out.println("Operation is not well enunciated.");
            System.out.println("Please, refer to instructions and introduce parameters accordingly.");
        }

        if (operation instanceof CreateCanvas) {
            initiateCanvas((CreateCanvas) operation);
            return;
        }

        if (operation instanceof DrawEntityOperation) {
            try {
                canvas.directToGeometricEntity(entitiesFactory.getGeometricEntity((DrawEntityOperation) operation));
                System.out.println(canvas.displayCanvas());

            } catch (InvalidGeometricEntityException invalidGeometricEntityException) {
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