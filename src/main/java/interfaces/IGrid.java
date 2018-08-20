/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author AsusPC
 */
public interface IGrid {
    
    /**
     * This method is for printing the grid into console.
     * Prints current grid.
     */
    public void printGrid();
    
//    /**
//     * This method is for retrieving the data model of sudoku, thus the matrice.
//     * @return 
//     */
//    public int[][] get2DArray();
    
    /**
     * This method is for setting a number into particular cell.
     * @param row row coordinate of cell.
     * @param col col coordinate of cell.
     * @param num number to be inserted in to given cell.
     */
    public void setCell(int row, int col, int num);
    
    /**
     * This method returns a number from a particular cell.
     * @param row row coordinate of cell.
     * @param col col coordinate of cell.
     * @return number from given cell.
     */
    public int getCell(int row, int col);
    
    /**
     * This method can parse a String of length 81 into a sudoku in a form of 
     * 2D array.
     * @param string input of 81 character String
     * @return output 2DArray.
     */
    public void parseSudoku(String string);
    
    /**
     * This method converts current sudoku from 2D array to String of length 81.
     * @return String of 81 characters.
     */
    public String exportSudoku();
}
