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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A fő kontroller osztály.
 * 
 * Innen indul az alkalmazás és innen kezeli az adatbázissal kapcsolatos 
 * osztályt is.
 * 
 * @author Hegedűs Attila
 */
public class MainApp extends Application {
    
    /**
     * Logikai érték annak eldöntésére, hogy most mezőt választunk ki lépésre,
     * vagy célmezőt választunk-e.
     */
    static boolean choosing = true;
    /**
     * Létrehozott változók a lépésre és célnak kiválasztott mezők
     * koordinátáihoz, valamint inicializálva a tábla melletti terület nagysága
     * az alkalmazásban (pixelben).
     */
    int oldX, oldY, newX, newY, margin = 100;
    
    /**
     * Lépés előtti és utána tábla.
     */
    TileView oldTile, newTile;
    
    /**
     * EntityManagerFactory az adatbáziskapcsolathoz.
     */
    private static EntityManagerFactory emf;
    /**
     * EntityManager az adatbáziskapcsolathoz.
     */
    private static EntityManager em;
    
    /**
     * Az alkalmazás felülete (tábla és gombok).
     */
    static VBox vbox;
    /**
     * Az alkalmazás felületének szülője.
     */
    static Parent root;
    /**
     * Egy játék példánya.
     */
    static Game game;
    /**
     * Egy tábla példánya.
     */
    static Board board;
    /**
     * Az alkalmazás felülete.
     */
    static Scene scene;
    
    /**
     * Logolásért felelős példány.
     */
    private static Logger logger = LoggerFactory.getLogger(MainApp.class);
    
    /**
     * Visszaadja, hogy a képernyőn kattintott pixel melyik sorindexet,
     * vagy oszlopindexet jelenti, attól függően,
     * hogy az egér X vagy Y koordinátáját kapja-e.
     * 
     * Mivel négyzetalakú a tábla, így működését tekintve ugyanaz.
     * 
     * @param pixel Az egérrel kattintott X vagy Y pixel.
     * @return A táblán kattintott mező sor, vagy oszlopindexe.
     */
    private int toBoard(double pixel) {
        return (int)(pixel - 50)/ Board.TILE_SIZE;
    }
    
    /**
     * Az alkalmazás indulásakor indított metódus.
     * 
     * Itt kapcsolódik össze a legtöbb funkció.
     * Itt van kezelve az adatbáziskapcsolat, innen indul új játék,
     * itt vannak kezelve a lépések fogadása és itt van lekezelve a játék vége is.
     * 
     * @param stage Az alkalmazás felülete.
     * @throws Exception ha valami különleges történik.
     */
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
//                                System.out.println("Choose another!");
                                logger.info("Invalid choose from {} player", game.isIsCurrentRed() ? "RED" : "BLUE");
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
//                                    System.out.println("A játéknak vége. Piros:" + game.getRedPoints() + " Kék: " + game.getBluePoints());
                                    logger.info("A játéknak vége. Piros: {} Kék: {}",game.getRedPoints(), game.getBluePoints());

                                    Result eredmeny = new Result(game.getRedPoints(), game.getBluePoints());



                                    em.getTransaction().begin();
                                    em.persist(eredmeny);
                                    em.getTransaction().commit();
                                }
                            }
                            else{
//                                System.out.println("Choose again!");
                                logger.info("Invalid move from {} player", game.isIsCurrentRed() ? "RED" : "BLUE");
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
    
    /**
     * Az alkalmazás bezárásakor lezárja az adatbáziskapcsolatot.
     */
    private void bezar(){
        em.close();
        emf.close();
    }

    /**
     * A main() függvény jól elkészített JavaFX applikációnál figyelmen kívül
     * lesz hagyva.
     * 
     * A main() akkor lesz használatban, ha valamilyen okból nem indul el a 
     * JavaFX alkalmazás.
     * 
     * @param args a parancssori argumentumok.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
