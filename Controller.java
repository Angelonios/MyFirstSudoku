/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import interfaces.IController;

/**
 *
 * @author AsusPC
 */
public class Controller {

    private Cell[] currentCells;
    private Cell currentCell;
    
    public Controller(){
        currentCells = null;
        currentCell = null;
    }
    
    public Controller(Cell[] cells){
        currentCells = cells;
        currentCell = null;
    }
    
    public Controller(Grid grid){
        currentCells = grid.getCells(grid);
        currentCell = null;
    }
    
    public void setCurrentCell(Point point) {
        currentCell = currentCells[point.getPosition()];
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public Point getCurrentCellPosition() {
        return currentCell.getPoint();
    }

    public Cell[] getCurrentCells() {
        return currentCells;
    }
}
