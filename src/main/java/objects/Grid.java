/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import interfaces.IGrid;
import java.util.stream.Stream;

/**
 *
 * @author AsusPC
 */
public class Grid implements IGrid{
    
    public static final int DIMENSION = 9;
    private Cell[] cells;
    private Cell currentCell;
    
    public Grid(){
        cells = new Cell[DIMENSION*DIMENSION];
        buildGrid();
        currentCell = null;
    }
    
    public Grid(Grid grid){
        this.cells = grid.cells;
        currentCell = null;
    }
    public Grid(Cell[] cells){
        this.cells = cells;
        currentCell = null;
    }
    
    @Override
    public void addCell(int num, int row, int col){
        cells[Point.getPosition(row, col)] = 
                new Cell(num, num, row, col);
    }
    
    @Override
    public void addCell(int num, int position) {
        int row = position/9;
        int col = position%9;
        cells[position] = new Cell(num, num, row, col);
    }
    
    @Override
    public void addCell(int num, Point point) {
        cells[point.getPosition()] = new Cell(num, num, point);
    }

    @Override
    public Cell getCell(int row, int col){
        return cells[Point.getPosition(row, col)];
    }

    @Override
    public Cell getCell(int position) {
        return cells[position]; 
    }

    @Override
    public Cell getCell(Point point) {
        return cells[point.getPosition()];
    }
        
    @Override
    public void setCurrentCell(int row, int col) {
        currentCell = cells[Point.getPosition(row, col)];
    }

    @Override
    public void setCurrentCell(Point point) {
        currentCell = cells[point.getPosition()];
    }

    @Override
    public void setCurrentCell(int position) {
        currentCell = cells[position];
    }

    @Override
    public Cell getCurrentCell() {
        return currentCell;
    }

    @Override
    public Point getCurrentCellPoint() {
        return currentCell.getPoint();
    }

    @Override
    public int getCurrentCellPosition() {
        return currentCell.getPoint().getPosition();
    }
    
    @Override
    public Cell[] getCells(){
        return cells;
    }

    @Override
    public Cell[] getCells(Grid grid){
        return grid.getCells();
    }    
    
    @Override
    public void setNum(int num, int row, int col){
        cellAt(row, col).setNum(num);
    }
    
    @Override
    public void setNum(int num, int position) {
        cellAt(position).setNum(num);
    }
    
    @Override
    public void setNum(int num, Point point) {
        cellAt(point).setNum(num);
    }
    
    @Override
    public int getNum(int row, int col){
        return cellAt(row, col).getNum();
    }

    @Override
    public int getNum(int position) {
        return cellAt(position).getNum();
    }
    
    @Override
    public int getNum(Point point) {
        return cellAt(point).getNum();
    }
    
    @Override
    public int getRightNum(int row, int col){
        return cellAt(row, col).getRightNum();
    }

    @Override
    public int getRightNum(int position) {
        return cellAt(position).getRightNum();
    }
    
    @Override
    public int getRightNum(Point point) {
        return cellAt(point).getRightNum();
    }
    
    @Override
    public void printGrid(){
        //TODO
    }
    
    @Override
    public void parseSudoku(String string) {
        cells = new Cell[DIMENSION*DIMENSION];
        buildGrid(string);
    }
    
    @Override
    public String exportSudoku() {
        String result = new String();
        Stream.of(cells)
              .forEach(cell -> result.concat(Integer.toString(cell.getNum())));
        return result;
    }
    
    @Override
    public String exportSudoku(Grid grid) {
        String result = new String();
        Stream.of(grid.getCells())
              .forEach(cell -> result.concat(Integer.toString(cell.getNum())));
        return result;
    }

    private Cell cellAt(int row, int col){
        Cell cell = cells[Point.getPosition(row, col)];
        if(cell == null){
            throw new IllegalArgumentException("No number at this point.");
        }
        return cell;
    }
    
    private Cell cellAt(int position){
        Cell cell = cells[position];
        if(cell == null){
            throw new IllegalArgumentException("No number at this point.");
        }
        return cell;
    }
    
    private Cell cellAt(Point point){
        Cell cell = cells[point.getPosition()];
        if(cell == null){
            throw new IllegalArgumentException("No number at this point.");
        }
        return cell;
    }
    
    private void buildGrid(){
        for(int i = 0; i < 81; i++){
            addCell(0, i);
        }
    }
    
    private void buildGrid(String exportedSudoku){
        char[] digits = exportedSudoku.toCharArray();
        for(int i = 0; i < 81; i++){
            addCell(Character.getNumericValue(digits[i]), i);
        }
    }
}
