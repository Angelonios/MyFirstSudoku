/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import interfaces.IChecker;

/**
 *
 * @author AsusPC
 */
public class Checker implements IChecker{
    
    private Game game;
    
    private int[][] currentGrid;

    public Checker(Game g){
        game = g;
        currentGrid = g.gameGrid.getGrid();
    }
    
    public void setCurrentGrid(int[][] grid){
        currentGrid = grid;
    }
    
    public void setCurrentGrid(Grid grid){
        currentGrid = grid.getGrid();
    }

    @Override
    public boolean rowCheck(int index, int num) {
        for(int i = 0; i < 9; i++){
            if(currentGrid[index][i] == num){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean colCheck(int index, int num) {
        for(int i = 0; i < 9; i++){
            if(currentGrid[i][index] == num){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean sqrCheck(int row, int col, int num) {
        int r = row - row%3;
        int c = col - col%3;
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if (currentGrid[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public boolean checkOneNumber(int[][] grid, int row, int col, int num){
        currentGrid = grid;
        boolean result = rowCheck(row, num) 
                      && colCheck(col, num)
                      && sqrCheck(row, col, num);
        return result;
    }
    
    @Override
    public boolean checkAllNumbers(int row, int col){
        int num = 1;
        do{
            if(rowCheck(row, num) 
            && colCheck(col, num)
            && sqrCheck(row, col, num)){
                if(col < 9){
                    checkAllNumbers(row, col++);
                } else if (row < 9){
                    checkAllNumbers(row++, 0);
                }
                num++;
            }
            return false;
        }while(num < 10);
    }
}
