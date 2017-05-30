package inf.unideb.hu.ataxx.controller;

import inf.unideb.hu.ataxx.model.Game;
import inf.unideb.hu.ataxx.view.Board;
import inf.unideb.hu.ataxx.view.TileView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainApp extends Application {
    
    static boolean choosing = true;
    int oldX, oldY, newX, newY, margin = 100;
    
    TileView oldTile, newTile;
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    static VBox vbox;
    static Parent root;
    static Game game;
    static Board board;
    static Scene scene;
    
    
    private int toBoard(double pixel) {
        return (int)(pixel - 50)/ Board.TILE_SIZE;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        emf = Persistence.createEntityManagerFactory("db");
            
        em = emf.createEntityManager();
        
        root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        game = new Game(7, 7);
        game.startNewGame();
        board = new Board();
        
        vbox = new VBox(root, board.draw());
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(0,0,Board.TILE_SIZE,0));
        vbox.setPrefSize(Board.TILE_SIZE * Board.WIDTH + margin, Board.TILE_SIZE * Board.HEIGHT + margin);
        
        scene = new Scene(vbox);
        scene.getStylesheets().add("/styles/Styles.css");
        
        
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (!game.isEnd()){
                    if (mouseEvent.getSceneX()-50 >= 0 && mouseEvent.getSceneX()-50 <= game.getWIDTH() * board.TILE_SIZE
                            && mouseEvent.getSceneY()-50 >= 0 && mouseEvent.getSceneY()-50 <= game.getHEIGHT() * board.TILE_SIZE){
                        if (choosing){
                            oldX = toBoard(mouseEvent.getSceneX());
                            oldY = toBoard(mouseEvent.getSceneY());
//                            System.out.println("You choosed the: " + oldX + ", " + oldY);
                            if(game.validChoose(oldX, oldY)){
                                choosing = !choosing;
//                                System.out.println("Valid.");
                            }
                            else
                                System.out.println("Choose another!");
                        }
                        else{
                            newX = toBoard(mouseEvent.getSceneX());
                            newY = toBoard(mouseEvent.getSceneY());
                            if(game.move(oldX, oldY, newX, newY)){
                                choosing = !choosing;
//                                System.out.println("valid");

                                vbox = new VBox(root, board.draw());
                                vbox.setAlignment(Pos.CENTER);
                                vbox.setPadding(new Insets(0,0,Board.TILE_SIZE,0));
                                vbox.setPrefSize(Board.TILE_SIZE * Board.WIDTH + 100, Board.TILE_SIZE * Board.HEIGHT + 100);
                                scene.setRoot(vbox);
                                if(game.isEnd()){
                                    System.out.println("A játéknak vége. Piros:" + game.getRedPoints() + " Kék: " + game.getBluePoints());


                                Result eredmeny = new Result(game.getRedPoints(), game.getBluePoints());



                                em.getTransaction().begin();
                                em.persist(eredmeny);
                                em.getTransaction().commit();
                                }
                            }
                            else{
                                System.out.println("Choose again!");
                                choosing = !choosing;
                            }
                        }
                    }
                }
            }
        });
        
        stage.setTitle("Ataxx");
        
        stage.setOnCloseRequest(e->bezar());
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void bezar(){
        em.close();
        emf.close();
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
