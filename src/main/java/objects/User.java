/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AsusPC
 */
public class User {
    private final String name;
    private Game currentGame;
    private List<Game> playedGames;
    
    public User(String name){
        this.name = name;
        this.currentGame = null;
        this.playedGames = new ArrayList<>();
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
        this.playedGames.add(currentGame);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", playedGames=" + playedGames + 
               ", currentGame=" + currentGame + '}';
    }
    
    
}
