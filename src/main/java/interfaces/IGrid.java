/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import objects.Cell;
import objects.Grid;
import objects.Point;

/**
 *
 * @author AsusPC
 */
public interface IGrid {
    
    /**
     * @param num
     * @param row
     * @param col
     */
    public void addCell(int num, int row, int col);
    
    /**
     * @param num
     * @param point 
     */
    public void addCell(int num, Point point);
    
    /**
     * @param num
     * @param position 
     */
    public void addCell(int num, int position);
    
    /**
     * @param row
     * @param col
     * @return 
     */
    public Cell getCell(int row, int col);
    
    /**
     * @param point
     * @return 
     */
    public Cell getCell(Point point);
     
    /**
     * @param position
     * @return 
     */
    public Cell getCell(int position);
    
    /**
     * @param num
     * @param row
     * @param col
     */
    public void setNum(int num, int row, int col);
    
    /**
     * @param num
     * @param point 
     */
    public void setNum(int num, Point point);
    
    /**
     * @param num
     * @param position 
     */
    public void setNum(int num, int position);
    
    /**
     * @param row
     * @param col
     * @return 
     */
    public int getNum(int row, int col);
    
    /**
     * @param point
     * @return 
     */
    public int getNum(Point point);
    
    /**
     * @param position
     * @return 
     */
    public int getNum(int position);
    
    /**
     * @param row
     * @param col
     * @return 
     */
    public int getRightNum(int row, int col);
    
    /**
     * @param point
     * @return 
     */
    public int getRightNum(Point point);
    
    /**
     * @param position
     * @return 
     */
    public int getRightNum(int position);
    
    /**
     * @return cells of current grid instance.
     */
    public Cell[] getCells();
    
    /**
     * @param grid of which the cells are being returned.
     * @return cells of given grid.
     */
    public Cell[] getCells(Grid grid);
    
    /**
     * This method is for printing the grid into console.
     * Prints current grid.
     */
    public void printGrid();
    
    /**
     * This method can parse a String of 81 numbers from sudoku into cells of 
     * grid.
     * @param string input of 81 character String
     */
    public void parseSudoku(String string);
    
    /**
     * This method converts from cells of current grid to a String of 81 numbers.
     * @return String of 81 characters.
     */
    public String exportSudoku();
    
    /**
     * This method converts from cells of given grid to a String of 81 numbers.
     * @param grid
     * @return 
     */
    public String exportSudoku(Grid grid);
    
    /******************************GRID CONTROLL***********************************/
    
    /**
     * @param row
     * @param col
     */
    public void setCurrentCell(int row, int col);

    /**
     * @param point 
     */
    public void setCurrentCell(Point point);
    
    /**
     * @param position 
     */
    public void setCurrentCell(int position);
    
    /**
     * @return current cell.
     */
    public Cell getCurrentCell();
    
    /**
     * @return current cell point.
     */
    public Point getCurrentCellPoint();
    
    /**
     * @return 
     */
    public int getCurrentCellPosition();
}
