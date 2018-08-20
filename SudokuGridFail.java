/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokugenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author AsusPC
 */
public class SudokuGridFail {

    private static int[][] grid;
//    private static boolean[][] map;

    public SudokuGridFail() {
//        grid = new int[9][9];
//        map = new boolean[9][9];
    }

    public int[][] getGrid() {
        return grid;
    }

//    public boolean[][] getMap(){
//        return map;
//    }
//    public void fillGrid() {
//        grid = new int[9][9];
//        List<Integer> list = initList(9);
//        do {
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid.length; j++) {
//                    grid[i][j] = list.get(j) + 1;
//                }
//                list = moveIndex(list);
//            }
//        } while (!validate());
//        printGrid();
//    }
//
//    private boolean validate() {
//        if (this.grid == null) {
////            System.out.println("Grid is not initialized!");
//            return false;
//        }
//        
//        for (int num = 1; num < 10; num++) {
//            for(int i = 0; i < grid.length; i++){
//                int count = 0;
//                for(int j = 0; j < grid.length; j++){
//                    if(grid[i][j] == num){
//                        ++count;
//                    }
//                }
//                if(count > 1 || count == 0){
//                    return false;
//                }
//            }
//            for (int i = 0; i < grid.length; i++) {
//                int count = 0;
//                for (int j = 0; j < grid.length; j++) {
//                    if (grid[j][i] == num) {
//                        ++count;
//                    }
//                }
//                if (count > 1 || count == 0) {
//                    return false;
//                }
//            }
//        }
//        
//        //TODO squareCheck!!!
//        return true;
//    }

//    public void fillGrid2() {
//        int r = 0;
//        int c = 0;
//        boolean[][] map;
//        for (int num = 1; num < 10; num++) {
//            map = mapFreePlaces();
//            for (int i = 0; i < 3; i++) {
//                List<Integer> rows = initShuffledList(3);
//                List<Integer> cols = initShuffledList(3);
//                for (int j = 0; j < 3; j++) {
//                    r = i * 3 + rows.get(0);
//                    c = j * 3 + cols.get(0);
//                    if (checkCol(c, num) || checkRow(r, num) || (grid[r][c] != 0)) {
//                        List<Integer> temp_rows = new ArrayList<>();
//                        List<Integer> temp_cols = new ArrayList<>();
//                        List<Integer> list = localMapping(r, c, num);
//                        for (int l = 0; l < list.size(); l++) {
//                            if (l % 2 == 0) {
//                                temp_rows.add(list.get(l));
//                            } else {
//                                temp_cols.add(list.get(l));
//                            }
//                        }
//                        do {
//                            Collections.shuffle(temp_rows);
//                            Collections.shuffle(temp_cols);
//                            r = i * 3 + temp_rows.get(0);
//                            c = j * 3 + temp_cols.get(0);
//                        } while (checkCol(c, num) || checkRow(r, num) || (grid[r][c] != 0));
//                    }
//
//                    printAdd(r, c, num);
//                    map[r][c] = true;
//                    rows.remove(0);
//                    cols.remove(0);
//                }
//            }
//        }
//    }

//    private List<Integer> localMapping(int r, int c, int num) {
//        List<Integer> result = new ArrayList<>();
//        boolean[][] miniMap = new boolean[3][3];
//        if (checkCol(c, num)) {
//            for (int i = 0; i < 3; i++) {
//                miniMap[i][c % 3] = true;
//            }
//        }
//        if (checkRow(r, num)) {
//            for (int i = 0; i < 3; i++) {
//                miniMap[r % 3][i] = true;
//            }
//        }
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (!miniMap[i][j]) {
//                    result.add(i);
//                    result.add(j);
//                }
//            }
//        }
//        return result;
//    }

//    /**
//     * Returns coordinates of free places...
//     * @param r
//     * @param c
//     * @param num
//     * @return 
//     */
//    private List<Integer> globalMapping(int r, int c, int num) {
//        List<Integer> result = new ArrayList<>();
//        boolean[][] map = new boolean[9][9];
//        if (checkCol(c, num)) {
//            for (int i = 0; i < 9; i++) {
//                map[i][c] = true;
//            }
//        }
//        if (checkRow(r, num)) {
//            for (int i = 0; i < 9; i++) {
//                map[r][i] = true;
//            }
//        }
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (!map[i][j]) {
//                    result.add(i);
//                    result.add(j);
//                }
//            }
//        }
//        return result;
//    }

//    private boolean[][] mapFreePlaces() {
//        boolean[][] result = new boolean[9][9];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid.length; j++) {
//                if (grid[i][j] != 0) {
//                    result[i][j] = true;
//                }
//            }
//        }
//        return result;
//    }

//    /**
//     * This method checks whether there will be left room for rest
//     * @param map
//     * @param r
//     * @param c
//     * @param num
//     * @return 
//     */
//    private boolean simulateAdd(boolean[][] map, int r, int c, int num){
//        boolean[][] temp_map = map;
//        temp_map[r][c] = true;
//        for(int i = 0; i < temp_map.length; i++){
//            temp_map[r][i] = true;
//        }
//        for(int j = 0; j < temp_map.length; j++){
//            temp_map[j][c] = true;
//        }
//        for(int k = 0; k < 3; k++){
//            for(int l = 0; l < temp_map.length; l++){
//                if(temp_map[k][l]){
//                    
//                }
//            }
//        }
//        return false;
//    }
//    public void fillGrid3(int row, int col, int num){
//        if(!(checkCol(col, num) && checkRow(row, num))){
//            grid[row][col] = num;
//            fillGrid3(row, col, num);
//        }
//    }
    /**
     * Returns True if there is the given number in given column. Otherwise
     * returns False - thus there is no such number in the given column.
     *
     * @param col
     * @param number
     * @return true/false
     */
    public static boolean checkCol(int col, int number) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns True if there is the given number in given row. Otherwise returns
     * False - thus there is no such number in the given row.
     *
     * @param row
     * @param number
     * @return true/false
     */
    public static boolean checkRow(int row, int number) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    
    private List<Integer> initShuffledList(int length) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }

    private List<Integer> initList(int length) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(i);
        }
        return result;
    }

    private List<Integer> moveIndex(List<Integer> list) {
        List<Integer> result = list;
        int[] nums = new int[3];
        for(int i = 0; i < 3; i++){
            nums[i] = result.get(i);
        }
        for(int i = 0; i < 3; i++){
            result.add(result.size(), nums[i]);
            result.remove(i);
        }
//        result.add(result.size(), num);
//        result.remove(0);
        return result;
    }

    private void printAdd(int row, int col, int number) {
        grid[row][col] = number;
        System.out.println("Added number " + number
                + " at: " + row + ", " + col);
        printGrid();
        System.out.println();
    }

    void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j % 3 != 2) {
                    System.out.print(grid[i][j] + "  ");
                } else {
                    System.out.print(grid[i][j] + "    ");
                }
            }
            if (i % 3 != 2) {
                System.out.println();
            } else {
                System.out.println("\n");
            }
        }
    }
}
