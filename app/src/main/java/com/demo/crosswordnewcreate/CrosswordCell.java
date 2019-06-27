package com.demo.crosswordnewcreate;

import java.util.ArrayList;

public class CrosswordCell {

    public String character;

    CrosswordCellNode acrossNode = null;

    int[] startAcross = null;

    int[] endAcross = null;

    CrosswordCellNode downNode = null;

    int[] startDown = null;

    int[] endDown = null;

    boolean isSelected = false;

    public CrosswordCell(String character) {
        this.character = character;
    }
}
