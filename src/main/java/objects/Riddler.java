/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import interfaces.IRiddler;
import java.util.Random;

/**
 *
 * @author AsusPC
 */
public class Riddler implements IRiddler {

    private static final Random RAND = new Random();

    private final Game g;

    private int[][] currentGrid;

    public Riddler(Game game) {
        this.g = game;
        currentGrid = g.gameGrid.getGrid();
    }

    @Override
    public void generateEasySudoku(Grid grid) {
        currentGrid = grid.grid;
        int iterations = 30;
        do {
            removeNumber();
            iterations--;
        } while (iterations > 0);
        System.out.println("Riddler.generateEasySudoku(): Sudoku is ready!");
        g.gameGrid = new Grid(currentGrid);
    }

    @Override
    public void generateMediumSudoku(Grid grid) {
        currentGrid = grid.grid;
        int iterations = 20;
        do {
            removeNumber();
            iterations--;
        } while (iterations > 0);
        System.out.println("Riddler.generateMediumSudoku(): Sudoku is ready!");
        g.gameGrid = new Grid(currentGrid);
    }

    @Override
    public void generateHardSudoku(Grid grid) {
        currentGrid = grid.grid;
        int iterations = 25;
        do {
            removeNumber();
            iterations--;
        } while (iterations > 0);
        System.out.println("Riddler.generateHardSudoku(): Sudoku is ready!");
        g.gameGrid = new Grid(currentGrid);
    }

    protected void removeNumber() {
        int row;
        int col;
        do {
            row = RAND.nextInt(8);
            col = RAND.nextInt(8);
        } while (currentGrid[row][col] == 0);
        currentGrid[row][col] = 0;
    }
}
