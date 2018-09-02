/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import objects.Grid;

/**
 * This is and programming interface for Solver object. The Solver object can
 generally solve any difficulty sudoku grid, even an empty grid. That is why
 this solver is used to create a solved sudoku grid from an empty Grid_old object.
 This interface offers three options for generating a solved sudoku grid.
 * @author AsusPC
 */
public interface ISolver {
    
    /**
     * This method takes a Grid_old object and fills it with numbers in order to
 maintain the rule of one
     * @param grid Grid_old object containing int[][].
     */
    public void fillSudoku(Grid grid);
    
    /**
     * This method fills int[][] grid stored in solver class as current grid.
     */
    public void fillSudoku();
    
}
