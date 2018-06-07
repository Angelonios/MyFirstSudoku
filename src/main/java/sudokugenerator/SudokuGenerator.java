/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokugenerator;

/**
 *
 * @author AsusPC
 */
public class SudokuGenerator {

    /**
     * Only instance of this class.
     */
    public static final SudokuGenerator SINGLETON;
    
    /**
     * 
     */
    private int[][] grid;
    
    static{
        SINGLETON = new SudokuGenerator();
    }
    
    private boolean checkRow(int rowNum){
        return false;
    }
    
    private boolean checkCol(int colNum){
        return false;
    }
    
    private boolean checkSquare(int squareIndex){
        return false;
    }
    
    private void fillGrid(){
        grid = new int[8][8];
        
    }
    /**
     * the main method of the application
     * @param args
     */
    public static void main(String[] args){
        
    }
}
