/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import objects.Game;

/**
 *
 * @author AsusPC
 */
public class GameGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane panel = new BorderPane();

        Game game = new Game();
     
        Table table = new Table(game);
        Controller controller = new Controller(game, table);

        panel.setCenter(table.createContent() /*sudokuUI*/);
        panel.setRight(controller.createContent());

        EventHandler<KeyEvent> onKeyPress = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                String keyPressed = e.getText();
                if (keyPressed.matches("\\d")) {
                    table.getCurrentCell().setNumber(Integer.parseInt(keyPressed));
                } else if (e.getCode() == KeyCode.BACK_SPACE
                        || e.getCode() == KeyCode.DELETE) {
                    table.getCurrentCell().setNumber(0);
                }

            }
        };
        panel.addEventHandler(KeyEvent.KEY_PRESSED, onKeyPress);
        panel.setBackground(Background.EMPTY);
        panel.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        primaryStage.setTitle("Sudoku: The game");
        primaryStage.setScene(new Scene(panel));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
