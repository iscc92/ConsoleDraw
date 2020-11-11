package com.sncodechallenge.consoledrawing.geometricEntities;

public class CanvasImpl implements Canvas {
    private static final char VERT_EDGE = '|';
    private static final char HORZ_EDGE = '-';
    private static final char LINE = 'x';

    private final int height;
    private final int width;

    public CanvasImpl(int height, int width) {
        this.height = height;
        this.width = width;
    }


    @Override
    public void drawGeometricEntity(GeometricEntity geoEntity) {

    }
}
