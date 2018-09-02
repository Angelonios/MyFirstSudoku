/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import interfaces.IGrid;

/**
 *
 * @author AsusPC
 */
public class Grid_old {

    private static final int DIMENSION = 9;
    /*Sudoku is expressed with a 2D array.*/
    private int[][] grid;

    /**
     * Constructor of grid, takes final values of rows and columns and
     * initializes an empty 2D array.
     */
    public Grid_old() {
        grid = new int[DIMENSION][DIMENSION];
    }
    
    /**
     *
     * @param grid
     */
    public Grid_old(Grid_old grid){
        this();
        for(int i = 0; i < DIMENSION; i++){
            System.arraycopy(grid.grid[i], 0, this.grid[i], 0, DIMENSION);
        }
    }
    
    /**
     *
     * @param grid
     */
    public Grid_old(int[][] grid){
        this();
        for(int i = 0; i < DIMENSION; i++){
            System.arraycopy(grid[i], 0, this.grid[i], 0, DIMENSION);
        }
    }

//    @Override
//    public void addNum(int row, int col, int num) {
//        grid[row][col] = num;
//    }
//
//    @Override
//    public int getNum(int row, int col) {
//        return grid[row][col];
//    }

//    public int[][] getGrid() {
//        return grid;
//    }

//    @Override
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j % 3 != 2) {
                    if (grid[i][j] == 0) {
                        System.out.print("_" + "  ");
                    } else {
                        System.out.print(grid[i][j] + "  ");
                    }
                } else {
                    if (grid[i][j] == 0) {
                        System.out.print("_" + "    ");
                    } else {
                        System.out.print(grid[i][j] + "    ");
                    }
                }
            }
            if (i % 3 != 2) {
                System.out.println();
            } else {
                System.out.println("\n");
            }
        }
    }

//    @Override
    public void parseSudoku(String string) {
        char[] digits = string.toCharArray();

        if (digits.length != 81) {
            throw new IllegalArgumentException(
                    "String doesn't have exactly 81 characters!");
        }

        int[][] result = new int[DIMENSION][DIMENSION];

        int temp = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                result[i][j] = Character.getNumericValue(digits[temp]);
                ++temp;
            }
        }

        this.grid = result;
    }

//    @Override
    public String exportSudoku() {
        String result = "";

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                result += Integer.toString(this.grid[i][j]);
            }
        }
        return result;
    }
    
    /**
     *
     * @param grid
     * @return
     */
    public String exportSudoku(int[][] grid) {
        String result = "";

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                result += Integer.toString(grid[i][j]);
            }
        }
        return result;
    }
    
    /**
     *
     * @param grid
     * @return
     */
    public String exportSudoku(Grid_old grid) {
        String result = "";

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
//                result += Integer.toString(grid.getNum(i, j));
            }
        }
        return result;
    }
}