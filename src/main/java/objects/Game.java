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

    private static final int SUCCESFUL_GAME = 0;
    
    private boolean isRunning;

    /**
     *
     */
    protected Grid gameGrid;
    
    /**
     *
     */
    protected Solver solver;

    /**
     *
     */
    protected Checker checker;

    /**
     *
     */
    protected Riddler riddler;
    
    /**
     * 
     */
    private Grid solvedGrid;
    
    /**
     *
     */
    public Game() {
        isRunning = false;
        gameGrid = new Grid();
        
        checker = new Checker(this);
        solver = new Solver(this);
        riddler = new Riddler(this);
    }
    
    /**
     *
     */
    public void startGame() {
        isRunning = true;
        solver.fillSudoku();
        solvedGrid = new Grid(gameGrid);
        setGrid(0);
    }
    
    /**
     *
     * @param GAME_RESULT
     */
    public void endGame(int GAME_RESULT){
        if(GAME_RESULT == SUCCESFUL_GAME){
            System.out.println("Congratulations! You solved the puzzle!");
        } else{
            System.out.println("Exiting game. Goodbye!");
        }
        isRunning = false;
        gameGrid = null;
    }
    
    private void checkProgress(){
        int progress = 0;
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(gameGrid.getCell(row, col).isCorrect()){
                    progress++;
                }
            }
        }
        if(progress == 81){
            endGame(SUCCESFUL_GAME);
        }
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
    
//    public static void main(String[] args) {
//        Game game1 = new Game();
//        
//        game1.solver.fillSudoku();
//        game1.gameGrid.printGrid();
//        game1.solvedGrid = new Grid_old(game1.gameGrid);
//        
//        game1.setGrid(GAME_LEVEL_EASY);
//        game1.gameGrid.printGrid();
//        
//        game1.solver.fillSudoku(game1.gameGrid);
//        game1.gameGrid.printGrid();
//    }
}