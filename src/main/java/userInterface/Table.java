/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import objects.Game;
import objects.Grid_old;

/**
 *
 * @author AsusPC
 */
public class Table {
    
    private Pane root;
    private Game game;
    private Cell currentCell;

    /**
     *
     */
    protected boolean validate;
   
    /**
     *
     */
    protected String startingGrid;
    
    /**
     *
     * @param g
     */
    public Table(Game g){
        game = g;
    }
    
    void setValidate(boolean b) {
        validate = b;
    }

    /**
     *
     * @param cell
     */
    public void setCurrentCell(Cell cell) {
        if (currentCell == null) {
            currentCell = cell;
            currentCell.setColor(Color.BEIGE);
        } else {
            if (validate) {
                if (currentCell.isCorrect()) {
                    currentCell.setColor(null);
                    currentCell = cell;
                    currentCell.setColor(Color.BEIGE);
                } else {
                    currentCell.setColor(Color.RED);
                    currentCell = cell;
                    currentCell.setColor(Color.BEIGE);
                }
            } else {
                currentCell.setColor(null);
                currentCell = cell;
                currentCell.setColor(Color.BEIGE);
            }
        }
    }

    /**
     *
     * @return
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * This method generates the Graphical equivalent of the grid. It creates 81
     * cells which contain every number of generated grid. Also it adds 2
     * vertical and 2 horizontal lines to visualize sudoku bands and stacks.
     *
     * @return Parent node containing 81 leaf nodes of class Cell.
     */
    public Parent createContent() {
        root = new Pane();
        startingGrid = game.getGameGrid().exportSudoku();
        List<Cell> cells = fillCellList(startingGrid,
                game.getSolvedGrid().exportSudoku());

        for (int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            cell.setTranslateX(25 * (i % 9));
            cell.setTranslateY(25 * (i / 9));
            root.getChildren().add(cell);
        }

        Line hLine1 = new Line(0, 3 * 25, 9 * 25, 3 * 25);
        hLine1.setUserData("Line");
        Line hLine2 = new Line(0, 6 * 25, 9 * 25, 6 * 25);
        hLine2.setUserData("Line");
        Line vLine1 = new Line(3 * 25, 0, 3 * 25, 9 * 25);
        vLine1.setUserData("Line");
        Line vLine2 = new Line(6 * 25, 0, 6 * 25, 9 * 25);
        vLine2.setUserData("Line");

        root.getChildren().addAll(hLine1, hLine2, vLine1, vLine2);

        return root;
    }

    /**
     * This method prepares a List of Cells containing numbers from an exported
     * sudoku. This list is then used in method createContent(), where every
     * element is added to an Observable list as children of the parent node.
     *
     * @param exportedSudoku exported sudoku string.
     * @return List of cells
     */
    private List<Cell> fillCellList(String gameGrid, String solvedGrid) {
        char[] puzzle = gameGrid.toCharArray();
        char[] solved = solvedGrid.toCharArray();
        if (puzzle.length != 81 /*|| solved.length != 81*/) {
            throw new IllegalArgumentException(
                    "String doesn't have exactly 81 characters!");
        }
        List<Cell> cells = new ArrayList<>();
        int temp = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int number = Character.getNumericValue(solved[temp]);
                String text = Character.toString(puzzle[temp]);
                cells.add(
                        new Cell(row, col, number, text, this)
                );
                ++temp;
            }
        }
        return cells;
    }

    /**
     *
     */
    protected void showWrongCells() {
        validate = true;
        ObservableList<Node> allNodes = root.getChildren();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!game.evaluateCell(i, j) && game.getGameGrid()
                                                   .getNum(i, j) != 0) {
                    for (Node n : allNodes) {
                        if (n.getUserData().equals("Cell")) {
                            Cell cell = (Cell) n;
                            if (cell.getRow() == i && cell.getCol() == j) {
                                cell.setColor(Color.RED);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *
     */
    protected void hideWrongCells() {
        validate = false;
        ObservableList<Node> allNodes = root.getChildren();
        for (Node n : allNodes) {
            if (n.getUserData().equals("Cell")) {
                Cell cell = (Cell) n;
                cell.setColor(null);
            }
        }
        currentCell.setColor(Color.BEIGE);
    }
    
    /**
     *
     */
    protected void updateGameGrid() {
        ObservableList<Node> allNodes = root.getChildren();
        Iterator<Node> it = allNodes.iterator();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (it.hasNext()) {
                    Cell cell = (Cell) it.next();
                    cell.setNumber(game.getGameGrid().getNum(i, j));
                } else {
                    return;
                }
            }
        }
    }

    /**
     * @return the gameGrid
     */
    public Grid_old getGameGrid() {
        return game.getGameGrid();
    }

    /**
     * @return the solvedGrid
     */
    public Grid_old getSolvedGrid() {
        return game.getSolvedGrid();
    }

}
