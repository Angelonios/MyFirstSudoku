/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokugenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author AsusPC
 */
public class SudokuGrid{
    
    private static int[][] grid;
    
    public SudokuGrid() {
        grid = new int[9][9];
    }

    public int[][] getGrid(){
        return grid;
    }
    
    public void fillGrid(){
        List<Integer> numbers;
        for(int i = 0; i < 8; i++){
            numbers = shuffleNumbers();
            for(int j = 0; i < 8; j++){
                grid[i][j] = numbers.get(j);
//                numbers.remove(j);
            }
        }
    }

    private List<Integer> shuffleNumbers(){
        List<Integer> result = new ArrayList<>();
        for(int k = 1; k < 10; k++){
            result.add(k);
        }
        Collections.shuffle(result);
        return result;
    }

    public static boolean checkCol(int row, int col, int number) {
        for(int i = 0; i < grid[row].length; i++){
           if(grid[i][col] == number){
               return false;
           }
       }
       return true;
    }

    public static boolean checkSquare(int row, int col, int number) {
       int r = row/3;
       int c = col/3;
       for(int i = 0; i < 3; i++){
           for(int j = 0; j < 3; j++){
               if(grid[r+i][c+j] == number){
                   return false;
               }
           }
       }
       return true;
    }

    void printGrid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
