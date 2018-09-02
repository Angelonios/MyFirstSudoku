/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import objects.Grid;

/**
 *
 * @author AsusPC
 */
public interface IRiddler {
    
    /**
     * This method generates an easy sudoku puzzle, meaning it removes 15
     * symmetric pairs of cells from a validly filled grid.
     * @param grid
     */
    public void generateEasySudoku(Grid grid);
    
    /**
     * This method generates an easy sudoku puzzle, meaning it removes 20
     * symmetric pairs of cells from a validly filled grid.
     * @param grid
     */
    public void generateMediumSudoku(Grid grid);
    
    /**
     * This method generates an easy sudoku puzzle, meaning it removes 25
     * symmetric pairs of cells from a validly filled grid.
     * @param grid
     */
    public void generateHardSudoku(Grid grid);
    
}
