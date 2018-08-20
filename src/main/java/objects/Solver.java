/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import interfaces.ISolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author AsusPC
 */
public class Solver implements ISolver {

    private final Game game;
    private int[][] currentGrid;
    private final Checker checker;
    private int index = 0;

    public Solver(Game g) {
        game = g;
        checker = g.checker;
        currentGrid = g.gameGrid.getGrid();
    }

    public void fillSudoku(Grid grid) {
        currentGrid = grid.getGrid();
        checker.setCurrentGrid(currentGrid);
        solve(0, 0);
    }

    public void fillSudoku(int[][] grid) {
        currentGrid = grid;
        checker.setCurrentGrid(currentGrid);
        index = 0;
        solve(0, 0);
    }

    public void fillSudoku() {
        checker.setCurrentGrid(currentGrid);
        solve(0, 0);
    }

    @Override
    public boolean solve(int row, int col) {
        if (currentGrid[row][col] == 0) {
            List<Integer> list = initList();
            do {
                int num = list.get(0);
                list.remove(0);
                if (checker.checkOneNumber(currentGrid, row, col, num)) {
                    currentGrid[row][col] = num;
                    if (pickNext(row, col)) {
                        return true;
                    } else {
                        currentGrid[row][col] = 0;
                    }
                }
            } while (!list.isEmpty());
            return false;
        } else {
            pickNext(row, col);
        }
        return true;
    }

    private boolean pickNext(int row, int col) {
        int c = col;
        int r = row;
        c++;
        if (c == 9) {
            c = 0;
            r++;
        }
        if (r == 9) {
            return true;
        }
        return solve(r, c);
    }

    /**
     * Initializes a list with numbers from 1 to 9, shuffles them and returns
     * the list.
     *
     * @return shuffled list of numbers from 1 to 9.
     */
    public List<Integer> initList() {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }
}
