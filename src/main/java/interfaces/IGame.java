/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import objects.Checker;
import objects.Grid;
import objects.Riddler;
import objects.Solver;

/**
 *
 * @author AsusPC
 */
public interface IGame {
    
    public static final int GAME_LEVEL_EASY = 0;
    public static final int GAME_LEVEL_MEDIUM = 1;
    public static final int GAME_LEVEL_HARD = 2;
    
    /**
     * Each game instance has an indicator, which shows whether game is running
     * or not. this method returns the value of this indicator.
     * @return isRunning value.
     */
    public boolean isRunning();
    
    /**
     * To play a game the game grid must be set. This method creates a empty 
     * grid. Then it creates a sudoku puzzle template, thus creates a solved 
     * sudoku. The game_level parameter determines how many cells will be 
     * removed in order to create a sudoku puzzle.
     * game levels:
     * 0 - easy
     * 1 - medium
     * 2 - hard 
     * @param game_level
     */
    public void setGrid(int game_level);
    /**
     * Returns GameGrid, which is the puzzle a player solves during playing the 
     * game.
     * @return GameGrid;
     */
    public Grid getGameGrid();
    
    /**
     * Returns SolvedGrid, which is created before the puzzle itself, and it's
     * used to compare and validates players GameGrid.
     * @return SolvedGrid;
     */
    public Grid getSolvedGrid();
    
    /**
     * Returns solver module, which takes a Grid as parameter and solves it.
     * @return solver module.
     */
    public Solver getSolver();
    
    /**
     * Returns checker module, which checks for a given number if it's suitable
     * to be added to a given cell in grid.
     * @return checker module;
     */
    public Checker getChecker();
    
    /**
     * Returns riddler module, which generates sudoku puzzles from given filled
     * grid.
     * @return riddler module.
     */
    public Riddler getRiddler();
}
