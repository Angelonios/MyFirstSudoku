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
    
    private Grid currentGrid;

    /**
     *
     * @param g
     */
    public Checker(Game g){
        game = g;
        currentGrid = g.gameGrid;
    }
    
//    public void setCurrentGrid(int[][] grid){
//        currentGrid = grid;
//    }
//    

    /**
     *
     * @param grid
     */
    public void setCurrentGrid(Grid grid){
        currentGrid = grid;
    }

    @Override
    public boolean rowCheck(int index, int num) {
        for(int i = 0; i < 9; i++){
            if(currentGrid.getNum(new Point(index, i)) == num){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean colCheck(int index, int num) {
        for(int i = 0; i < 9; i++){
            if(currentGrid.getNum(new Point(i, index)) == num){
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
                if (currentGrid.getNum(new Point(i, j)) == num) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public boolean checkNum(Grid grid, int row, int col, int num){
        currentGrid = grid;
        boolean result = rowCheck(row, num) 
                      && colCheck(col, num)
                      && sqrCheck(row, col, num);
        return result;
    }
    
//    @Override
//    public boolean checkAll(int row, int col){
//        int num = 1;
//        do{
//            if(rowCheck(row, num) 
//            && colCheck(col, num)
//            && sqrCheck(row, col, num)){
//                if(col < 9){
//                    checkAll(row, col++);
//                } else if (row < 9){
//                    checkAll(row++, 0);
//                }
//                num++;
//            }
//            return false;
//        }while(num < 10);
//    }
}
