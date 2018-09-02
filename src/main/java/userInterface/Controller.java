/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import objects.Game;

/**
 *
 * @author AsusPC
 */
public class Controller {

    private static final int BUTTON_WIDTH = 40;

    private Game game;
    private Table table;
//    private Solver solver = game.getSolver();

    /**
     *
     * @param g
     * @param t
     */
    public Controller(Game g, Table t){
        this.game = g;
        this.table = t;
    }

    /**
     *
     * @return
     */
    public Parent createContent() {
        GridPane controlPane = new GridPane();

        GridPane numPad = new GridPane();
        for (int i = 0; i < 9; i++) {
            Button b = new Button(Integer.toString(i + 1));
            b.setPrefWidth(BUTTON_WIDTH);
            b.setOnAction(event -> {
                if (table.getCurrentCell() == null) {
                    return;
                }
                if(table.validate){
                    table.showWrongCells();
                }
                table.getCurrentCell().setColor(Color.BEIGE);
                table.getCurrentCell().setNumber(Integer.parseInt(b.getText()));
            });
            numPad.add(b, i % 3, i / 3);
        }
        numPad.setVgap(2.5);
        numPad.setHgap(2.5);
        numPad.setAlignment(Pos.TOP_CENTER);

        CheckBox btnValidate = new CheckBox("Show erros");
        btnValidate.setOnAction((event) -> {
            if (btnValidate.isSelected()) {
                table.showWrongCells();
            } else {
                table.hideWrongCells();
            }
        });

        Button btnSolveCell = new Button("Hint");
        btnSolveCell.setOnAction((event) -> {
            Cell cell = table.getCurrentCell();
            if(cell == null){
                return;
            }
            cell.setNumber(
                    game.getSolvedGrid().getNum(cell.getRow(), cell.getCol())
            );
        });

        Button btnClearCell = new Button("Clear cell");
        btnClearCell.setOnAction((event) -> {
            table.getCurrentCell().setNumber(0);
        });

        Button btnReset = new Button("Reset");
        btnReset.setOnAction(event -> {
            table.getGameGrid().parseSudoku(table.startingGrid);
            table.updateGameGrid();
            if(table.validate){
                table.hideWrongCells();
                table.showWrongCells();
            }
        });

        btnValidate.setPrefWidth(120);
        btnSolveCell.setPrefWidth(127);
        btnClearCell.setPrefWidth(127);
        btnReset.setPrefWidth(127);

        controlPane.add(numPad, 0, 0);
        controlPane.add(btnValidate, 0, 1);
        controlPane.add(btnSolveCell, 0, 2);
        controlPane.add(btnClearCell, 0, 3);
        controlPane.add(btnReset, 0, 4);
        controlPane.setAlignment(Pos.TOP_CENTER);
        controlPane.setVgap(13);
        return controlPane;
    }
}
