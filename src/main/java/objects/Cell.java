/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author AsusPC
 */
public class Cell {

    private int num;
    private final int rightNum;
    private final Point position;
    private boolean isCorrect;

    public Cell(int num, int rightNum, int row, int col) {
        this.num = num;
        this.rightNum = rightNum;
        isCorrect = (num == rightNum);
        position = new Point(row, col);
    }
    
    public Cell(int num, int rightNum, Point point) {
        this.num = num;
        this.rightNum = rightNum;
        isCorrect = (num == rightNum);
        position = point;
    }

    public void setNum(int num) {
        this.num = num;
        isCorrect = (num == rightNum);
    }

    public int getNum() {
        return num;
    }

    public int getRightNum() {
        return rightNum;
    }

    public Point getPoint() {
        return position;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

}
