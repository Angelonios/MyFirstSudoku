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
public class Point {

    private final int xCoordinate;
    private final int yCoordinate;
    
    public Point(int x, int y){
        xCoordinate = x;
        yCoordinate = y;
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }
    
    public int getPosition(){
        return (yCoordinate*Grid.DIMENSION + xCoordinate);
    }
    
    public static int getPosition(int row, int col){
        return (col*Grid.DIMENSION + row);
    }
    
    public Point getNext(){
        if(xCoordinate + 1 == 9){
            if(yCoordinate + 1 == 9){
                throw new IllegalAccessError(
                    "There is no next point in grid!"
                );
            }
            return new Point(0, yCoordinate + 1);
        }
        return new Point(xCoordinate + 1, yCoordinate);
    }
    
    public Point getPrevious(){
        if(xCoordinate - 1 == -1){
            if(yCoordinate - 1 == -1){
                throw new IllegalAccessError(
                    "There is no previous point in grid!"
                );
            }
            return new Point(0, yCoordinate - 1);
        }
        return new Point(xCoordinate - 1, yCoordinate);
    }
}
