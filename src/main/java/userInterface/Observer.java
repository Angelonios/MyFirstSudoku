/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import objects.Game;
import objects.Grid_old;

/**
 *
 * @author AsusPC
 */
public class Observer {
    private Game game;
    private Table table;
    private Controller controller;
    private Grid_old currentGrid;
    
    /**
     *
     * @param game
     * @param table
     * @param controller
     */
    public Observer(Game game, Table table, Controller controller){
        this.game = game;
        this.table = table;
        this.controller = controller;
        currentGrid = game.getGameGrid();
    }
    
    
}
