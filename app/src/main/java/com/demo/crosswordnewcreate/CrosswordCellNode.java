package com.demo.crosswordnewcreate;

public class CrosswordCellNode {

    boolean isStartOfWord = false;

    int index = 0;

    public CrosswordCellNode(boolean isStartOfWord, int index) {
        this.isStartOfWord = isStartOfWord;
        this.index = index;
    }
}
