package com.sncodechallenge.consoledrawing.entities;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanvasImpl implements Canvas {
    private static final char VERT_EDGE = '|';
    private static final char HORZ_EDGE = '-';
    private static final char LINE = 'x';
    private static final char NO_FILL = ' ';
    private final char[][] cachedCanvas;
    private int width;
    private int height;
    private String headAndFooter;


    public CanvasImpl(int height, int width) {
        width = this.width;
        height = this.height;
        cachedCanvas = new char[this.height][this.width];

        Arrays.stream(
                cachedCanvas).forEach(
                chars -> Arrays.fill(chars, NO_FILL));

        headAndFooter =
                Stream.generate(
                        () -> String.valueOf(HORZ_EDGE))
                        .limit(width).collect(Collectors.joining());

    }

    @Override
    public void directToGeometricEntity(GeometricEntity geometricEntity) {
        if (geometricEntity instanceof Line) {
            forwardLine((Line) geometricEntity);
        } else if (geometricEntity instanceof Rectangle) {
            forwardRectangle((Rectangle) geometricEntity);
        }
    }


    @Override
    public String displayCanvas() {
        StringBuilder canvasAssembler = null;
        canvasAssembler.append(headAndFooter).append("\n");

        for (int r = 0; r < this.height; r++) {
            canvasAssembler.append(VERT_EDGE);
            for (int c = 0; c < this.width; c++) {
                canvasAssembler.append(cachedCanvas[r][c]);
            }
            canvasAssembler.append(VERT_EDGE).append("\n");
        }
        canvasAssembler.append(headAndFooter).append("\n");
        return canvasAssembler.toString();
    }

    ////// Geometric Entities individual drawing logic //////

    private void drawLine(int x1, int x2, int y1, int y2) {
        if (coordinatesAreInsideRange(x1, y1) && coordinatesAreInsideRange(x2, y2)) {
            for (int r = y1 - 1; r <= y2 - 1 && r < height; r++) {
                for (int c = x1 - 1; c <= x2 - 1 && c < height; c++) {
                    cachedCanvas[r][c] = LINE;
                }
            }
        }
    }

    private void drawRectangle(int x1, int x2, int y1, int y2) {
        //top line (constant y coordinate)
        drawLine(x1, y1, x2, y1);
        //right line (constant x coordinate)
        drawLine(x2, y1, x2, y2);
        //bottom line (constant y coordinate)
        drawLine(x1, y2, x2, y2);
        //right line (constant x coordinate)
        drawLine(x1, y1, x1, y2);
    }

    ////// Auxiliary Methods //////

    private boolean coordinatesAreInsideRange(int x, int y) {
        return (x > 1 || x < width) || (y > 1 || y < height);
    }

    // As it is impossible to instantiate directly the GeometricEntity interface...
    // For Lines
    private void forwardLine(Line line) {
        drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    // For Rectangles (which are sets of Lines, nevertheless)
    private void forwardRectangle(Rectangle rectangle) {
        drawRectangle(rectangle.getX1(), rectangle.getY1(), rectangle.getX2(), rectangle.getY2());
    }

}
