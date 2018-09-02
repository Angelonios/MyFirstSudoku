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
public interface IChecker {
    /**
     * This method checks if number in parameter isn't already present in row.
     * Returns true, if there is no such number in row.
     * @param index y index.
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    public boolean rowCheck(int index, int num);
    
    /**
     * This method checks if number in parameter isn't already present in col.
     * Returns true, if there is no such number in col.
     * @param index x index.
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    public boolean colCheck(int index, int num);
    
    /**
     * This method checks if number in parameter isn't already present in 
     * square. Returns true, if there is no such number in square.
     * @param row x index.
     * @param col y index.
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    public boolean sqrCheck(int row, int col, int num);
    
    /**
     * This method checks the possibility of inserting a number in specific 
     * place in sudoku and not violating the RULE OF ONE.
     * It uses rowCheck(), colCheck() and sqrCheck() all at once.
     * @param grid updated game grid.
     * @param row x index.
     * @param col y index.
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    public boolean checkNum(Grid grid, int row, int col, int num);
}
