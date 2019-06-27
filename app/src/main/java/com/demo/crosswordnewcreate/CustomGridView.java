package com.demo.crosswordnewcreate;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class CustomGridView extends View {

    private int numRows, numColumns;

    private int cellWidth = 0, cellHeight = 0;

    private Paint blackPaint = new Paint();

    private Paint backgroundPaint = new Paint();

    private Paint backgroundSelectedPaint = new Paint();

    private Paint textPaint = new Paint();

    private Paint textNumberPaint = new Paint();

    private Paint borderPaint = new Paint();

    private boolean isClicked = false;

    private static Random sRand = new Random();

    private CrosswordCell[][] grid;

    public CustomGridView(Context context) {
        super(context);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.STROKE);

        textNumberPaint.setColor(Color.BLACK);
        textNumberPaint.setStyle(Paint.Style.STROKE);

        backgroundPaint.setColor(Color.WHITE);
        backgroundPaint.setStyle(Paint.Style.FILL);

        backgroundSelectedPaint.setColor(Color.YELLOW);
        backgroundSelectedPaint.setStyle(Paint.Style.FILL);
    }

    public CustomGridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.STROKE);

        textNumberPaint.setColor(Color.BLACK);
        textNumberPaint.setStyle(Paint.Style.STROKE);

        backgroundPaint.setColor(Color.YELLOW);
        backgroundPaint.setStyle(Paint.Style.FILL);

        backgroundSelectedPaint.setColor(Color.YELLOW);
        backgroundSelectedPaint.setStyle(Paint.Style.FILL);
    }

    public CustomGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.STROKE);

        textNumberPaint.setColor(Color.BLACK);
        textNumberPaint.setStyle(Paint.Style.STROKE);

        backgroundPaint.setColor(Color.YELLOW);
        backgroundPaint.setStyle(Paint.Style.FILL);

        backgroundSelectedPaint.setColor(Color.YELLOW);
        backgroundSelectedPaint.setStyle(Paint.Style.FILL);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //Getters and Setters

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
        calculateDimensions();
    }

    public CrosswordCell[][] getGrid() {
        return grid;
    }

    public void setGrid(CrosswordCell[][] grid) {
        this.grid = grid;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions(){

        if (numColumns < 1 || numRows < 1){
            return;
        }

        cellWidth = getWidth() / numColumns;

        cellHeight = getHeight() / numRows;

        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (numColumns == 0 || numRows == 0){

            return;

        }

        int width = getWidth();

        int height = getHeight();

        for (int r = 0; r < numRows; r++){

            for (int c = 0; c < numColumns; c++){

                if (grid != null){

                    if (grid[r][c] != null){

                        CrosswordCell crosswordCell = grid[r][c];

                        if (crosswordCell.isSelected){

                            canvas.drawRect(c * cellWidth, r * cellHeight, (c + 1) * cellWidth, (r + 1) * cellHeight, backgroundSelectedPaint);

                        }
                        else {

                            canvas.drawRect(c * cellWidth, r * cellHeight, (c + 1) * cellWidth, (r + 1) * cellHeight, backgroundPaint);

                        }

                        canvas.drawLine(0, r * cellHeight, width, r * cellHeight, blackPaint);

                        canvas.drawLine(c * cellWidth, 0, c * cellWidth, height, blackPaint);

                        if (crosswordCell.acrossNode != null){

                            CrosswordCellNode crosswordCellNode = crosswordCell.acrossNode;

                                if (crosswordCellNode.isStartOfWord){

                                    textNumberPaint.setTextSize(22);

                                    int pos = crosswordCellNode.index + 1;

                                    canvas.drawText(String.valueOf(pos), c  * cellWidth + 6, (r + 1) * cellHeight - 58, textNumberPaint);

                                }

                        }

                        if (crosswordCell.downNode != null){

                            CrosswordCellNode crosswordCellNode = crosswordCell.downNode;

                                if (crosswordCellNode.isStartOfWord){

                                    textNumberPaint.setTextSize(22);

                                    int pos = crosswordCellNode.index + 1;

                                    canvas.drawText(String.valueOf(pos), c  * cellWidth + 6, (r + 1) * cellHeight - 58, textNumberPaint);

                                }

                        }

                        textPaint.setTextSize(40);

                        canvas.drawText(crosswordCell.character, c  * cellWidth + 16, (r + 1) * cellHeight - 24, textPaint);

                    }

                    else {

                        canvas.drawRect(c * cellWidth, r * cellHeight, (c + 1) * cellWidth, (r + 1) * cellHeight, backgroundPaint);

                        canvas.drawLine(0, r * cellHeight, width, r * cellHeight, blackPaint);

                        canvas.drawLine(c * cellWidth, 0, c * cellWidth, height, blackPaint);

                        textPaint.setTextSize(40);

                        //canvas.drawText(String.valueOf(getRandomChar()), c  * cellWidth + 16, (r + 1) * cellHeight - 24, textPaint);



                        //canvas.drawRect(c * cellWidth, r * cellHeight, (c + 1) * cellWidth, (r + 1) * cellHeight, blackPaint);
                    }
                }

            }

        }

//        for (int r = 0; r < numRows; r++){
//
//            canvas.drawLine(0, r * cellHeight, width, r * cellHeight, blackPaint);
//
//        }
//
//        for (int c = 0; c < numColumns; c++){
//            canvas.drawLine(c * cellWidth, 0, c * cellWidth, height, blackPaint);
//        }

    }

    public static char getRandomChar() {
        // ASCII A = 65 - Z = 90
        return (char) getRandomIntRange(65, 90);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();

        int y = (int) event.getY();

        int col = x / cellWidth;

        int row = y / cellHeight;

        CrosswordCell crosswordCell = getGrid()[row][col];

        switch (event.getActionMasked()){

            case MotionEvent.ACTION_MOVE:

                /*try {

                    if (crosswordCell != null){

                        crosswordCell.isSelected = true;

                        Log.e("demo is ", "x : " + row + " y : " + col + " word : " + crosswordCell.character);

                        invalidate();

                    }
                    else {

                        Log.e("demo is ", "x : " + row + " y : " + col + " is null");

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }*/

                break;

            case MotionEvent.ACTION_DOWN:
                Log.e("Down", "Clicked");
                break;

            default:
                return false;


        }

//        if (crosswordCell != null){
//
//            crosswordCell.isSelected = true;
//
//            Log.e("demo is ", "x : " + row + " y : " + col + " word : " + crosswordCell.character);
//
//            invalidate();
//
//        }
//        else {
//
//            Log.e("demo is ", "x : " + row + " y : " + col + " is null");
//
//        }

        return true;
    }

    public static int getRandomIntRange(int min, int max) {
        return min + (getRandomInt() % ((max - min) + 1));
    }

    public static int getRandomInt() {
        return Math.abs(sRand.nextInt());
    }


}
