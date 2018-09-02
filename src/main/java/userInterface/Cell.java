/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author AsusPC
 */
public class Cell extends StackPane {

    private final boolean unmodifiable;
    private final int RIGHT_NUMBER;
    private final int ROW;
    private final int COL;

    private Table table;
    private Rectangle border;
    private Text text = new Text();

    /**
     *
     * @return
     */
    public boolean isCorrect() {
        String value = text.getText();
        if (value.isEmpty() || value.equals(" ")) {
            return true;
        }
        return RIGHT_NUMBER == Integer.parseInt(value);
    }

    /**
     *
     * @return
     */
    public int getRightNumber() {
        return RIGHT_NUMBER;
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return ROW;
    }

    /**
     *
     * @return
     */
    public int getCol() {
        return COL;
    }

    /**
     *
     * @return
     */
    public String getNumber() {
        return this.text.getText();
    }

    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        if (number == 0) {
            this.text.setText(" ");
            table.getGameGrid().addNum(this.ROW, this.COL, number);
        } else {
            String s = Integer.toString(number);
            this.text.setText(s);
            table.getGameGrid().addNum(this.ROW, this.COL, number);
        }
    }

    /**
     *
     * @return
     */
    protected Color getColor() {
        return (Color) border.getFill();
    }

    /**
     *
     * @param color
     */
    protected void setColor(Color color) {
        border.setFill(color);
    }

    /**
     *
     * @param row
     * @param col
     * @param number
     * @param text
     * @param t
     */
    public Cell(int row, int col, int number, String text, Table t) {
        this.table = t;
        RIGHT_NUMBER = number;
        ROW = row;
        COL = col;
        if (text.equals("0")) {
            this.text.setText(" ");
            this.text.setFont(Font.font("verdana", FontWeight.LIGHT, 12));
            unmodifiable = false;
            setUserData("Cell");
        } else {
            this.text.setText(text);
            this.text.setFont(Font.font("verdana", FontWeight.BOLD, 12));
            unmodifiable = true;
            setUserData("DefaultCell");
        }
        ObservableList<Node> nodeList = getChildren();

        border = new Rectangle(25, 25);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);

        nodeList.addAll(border, this.text);
        EventHandler<MouseEvent> onClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (unmodifiable) {
                    return;
                }
                if(table.validate){
                    table.showWrongCells();
                }
                table.setCurrentCell(Cell.this);
                Cell.this.requestFocus();
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);

//        ChangeListener changeListener = (ChangeEvent ce) -> System.out.println("Whoah!");
//        this.text.getProperties().addListener(changeListener);        
    }
}
