package inf.unideb.hu.ataxx.controller;

import inf.unideb.hu.ataxx.model.Game;
import inf.unideb.hu.ataxx.view.Board;
import inf.unideb.hu.ataxx.view.PieceView;
import inf.unideb.hu.ataxx.view.TileView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainApp extends Application {
    
//    @FXML
//    private Label red;
//
//    @FXML
//    private Label blue;
    
//    @FXML
//    private Label label;

    private int toBoard(double pixel) {
        return (int)(pixel - 50)/ Board.TILE_SIZE;
    }
    
    static boolean choosing = true;
    int oldX, oldY, newX, newY;
    
    TileView oldTile, newTile;
    VBox vbox;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Game game = new Game(7, 7);
        game.startNewGame();
        Board board = new Board();
//        PieceView piece = new PieceView();
        
        vbox = new VBox(root, board.draw());
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(0,0,Board.TILE_SIZE,0));
        vbox.setPrefSize(Board.TILE_SIZE * Board.WIDTH + 100, Board.TILE_SIZE * Board.HEIGHT + 100);
        
        Scene scene = new Scene(vbox);
        scene.getStylesheets().add("/styles/Styles.css");
        
        
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (choosing){
                    oldX = toBoard(mouseEvent.getSceneX());
                    oldY = toBoard(mouseEvent.getSceneY());
                    System.out.println("You choosed the: " + oldX + ", " + oldY);
                    if(game.validChoose(oldX, oldY)){
                        choosing = !choosing;
                        System.out.println("Valid.");
                    }
                    else
                        System.out.println("Choose another!");
                }
                else{
                    newX = toBoard(mouseEvent.getSceneX());
                    newY = toBoard(mouseEvent.getSceneY());
                    if(game.move(oldX, oldY, newX, newY)){
                        choosing = !choosing;
                        System.out.println("valid");
                        
//                        red.setText(String.valueOf(game.redPoints));
//                        blue.setText(String.valueOf(game.bluePoints));
                        
                        
    
    
//                        oldTile = new TileView(oldX, oldY);
//                        newTile = new TileView(newX, newY);
//                        board = new Board();
                        vbox = new VBox(root, board.draw());
                        vbox.setAlignment(Pos.CENTER);
                        vbox.setPadding(new Insets(0,0,Board.TILE_SIZE,0));
                        vbox.setPrefSize(Board.TILE_SIZE * Board.WIDTH + 100, Board.TILE_SIZE * Board.HEIGHT + 100);
                        scene.setRoot(vbox);
                        if(game.isEnd()){
                            System.out.println("A játéknak vége. Piros:" + game.redPoints + " Kék: " + game.bluePoints);
//                            FXMLController.label.setText("A játéknak vége. Piros:" + game.redPoints + " Kék: " + game.bluePoints);
                        }
                    }
                    else{
                        System.out.println("Choose again!");
                        choosing = !choosing;
                    }
                }
            }
        });
        
        stage.setTitle("Ataxx");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
