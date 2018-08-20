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
public interface ISolver {
    
    /**
     * Solves sudoku puzzles on any difficulty. It can be used to fill an empty
     * grid in order to create a sudoku puzzle.
     * @param r
     * @param c
     */
    public boolean solve(int r, int c);
    
}
