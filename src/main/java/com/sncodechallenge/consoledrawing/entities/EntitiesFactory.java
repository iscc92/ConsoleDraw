package com.sncodechallenge.consoledrawing.entities;

import com.sncodechallenge.consoledrawing.operations.DrawEntityOperation;
import com.sncodechallenge.consoledrawing.operations.DrawLineOperation;
import com.sncodechallenge.consoledrawing.operations.DrawRectangleOperation;

public class EntitiesFactory {

    public GeometricEntity getGeometricEntity(DrawEntityOperation operation) {
        if (operation instanceof DrawLineOperation) {
            DrawLineOperation oper = (DrawLineOperation) operation;
            return new Line(oper.getX1(), oper.getY1(), oper.getX2(), oper.getY2());

        } else if (operation instanceof DrawRectangleOperation) {
            DrawRectangleOperation oper = (DrawRectangleOperation) operation;
            return new Rectangle(oper.getX1(), oper.getY1(), oper.getX2(), oper.getY2());

        }
        return null;
    }
}
