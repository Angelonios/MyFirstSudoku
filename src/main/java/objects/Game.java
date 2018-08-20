/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import interfaces.IGame;

/**
 *
 * @author AsusPC
 */
public class Game implements IGame {

    private boolean isRunning;
    protected Grid gameGrid;
    
    protected Solver solver;
    protected Checker checker;
    protected Riddler riddler;
    private Grid solvedGrid;
    
    public Game() {
        isRunning = false;
        gameGrid = new Grid();
        
        checker = new Checker(this);
        solver = new Solver(this);
        riddler = new Riddler(this);
    }
    
//    public void startGame() {
//        isRunning = true;
//        solver.fillSudoku();
//        solvedGrid = new Grid(gameGrid);
//        setGrid(0);
//    }
    
    public void endGame(){
        isRunning = false;
        gameGrid = null;
    }
    
    @Override
    public void setGrid(int game_level) {
        gameGrid = new Grid(gameGrid);
        if(game_level < 1){
            riddler.generateEasySudoku(gameGrid);
        } else if(game_level < 2){
            riddler.generateMediumSudoku(gameGrid);
        } else{
            riddler.generateHardSudoku(gameGrid);
        }
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public Grid getGameGrid() {
        return gameGrid;
    }

    @Override
    public Solver getSolver() {
        return solver;
    }

    @Override
    public Checker getChecker() {
        return checker;
    }

    @Override
    public Riddler getRiddler() {
        return riddler;
    }

    @Override
    public Grid getSolvedGrid() {
        return solvedGrid;
    }
    
    public static void main(String[] args) {
        Game game1 = new Game();
        
        game1.solver.fillSudoku();
        game1.gameGrid.printGrid();
        game1.solvedGrid = new Grid(game1.gameGrid);
        
        game1.setGrid(GAME_LEVEL_EASY);
        game1.gameGrid.printGrid();
        
        game1.solver.fillSudoku(game1.gameGrid);
        game1.gameGrid.printGrid();
    }
}