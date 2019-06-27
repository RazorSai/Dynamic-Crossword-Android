package com.demo.crosswordnewcreate;

public class BestPositionModel {

    int intersections = 0;

    int row = 0;

    int column = 0;

    String direction = "";

    public BestPositionModel() {

    }

    public int getIntersections() {
        return intersections;
    }

    public void setIntersections(int intersections) {
        this.intersections = intersections;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
