/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hegedattila
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of startNewGame method, of class Game.
     */
    @Test
    public void testStartNewGame() {
        System.out.println("startNewGame");
        Game.startNewGame();
    }

    /**
     * Test of validChoose method, of class Game.
     */
    @Test
    public void testValidChoose() {
        System.out.println("validChoose");
        int x0 = 0, y0 = 0, x1 = 1, y1 = 1;
        Game instance = new Game(7, 7);
        instance.startNewGame();
        boolean expResult0 = true, expResult1 = false;
        boolean result0 = instance.validChoose(x0, y0);
        boolean result1 = instance.validChoose(x1, y1);
        assertEquals(expResult0, result0);
        assertEquals(expResult1, result1);
    }

    /**
     * Test of checkNeighbourTypes method, of class Game.
     */
    @Test
    public void testCheckNeighbourTypes() {
        System.out.println("checkNeighbourTypes");
        int x = 0;
        int y = 0;
        Game instance = new Game(7, 7);
        instance.startNewGame();
        instance.checkNeighbourTypes(x, y);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int oldX0 = 0;
        int oldY0 = 0;
        int newX0 = 1;
        int newY0 = 1;
        int oldX1 = 0;
        int oldY1 = 0;
        int newX1 = 2;
        int newY1 = 2;
        int oldX2 = 0;
        int oldY2 = 0;
        int newX2 = 5;
        int newY2 = 5;
        Game instance = new Game(7, 7);
        boolean expResult0 = true, expResult1 = true, expResult2 = false;
        boolean result0 = instance.move(oldX0, oldY0, newX0, newY0);
        boolean result1 = instance.move(oldX1, oldY1, newX1, newY1);
        boolean result2 = instance.move(oldX2, oldY2, newX2, newY2);
        assertEquals(expResult0, result0);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of isEnd method, of class Game.
     */
    @Test
    public void testIsEnd() {
        System.out.println("isEnd");
        Game instance = new Game(7, 7);
        boolean expResult0 = false, expResult1 = true, expResult2 = true;
        boolean result0 = instance.isEnd();
        assertEquals(expResult0, result0);
        instance.setRedPoints(0);
        boolean result1 = instance.isEnd();
        assertEquals(expResult1, result1);
        instance.setRedPoints(47);
        boolean result2 = instance.isEnd();
        assertEquals(expResult2, result2);
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getWIDTH method, of class Game.
     */
    @Test
    public void testGetWIDTH() {
        System.out.println("getWIDTH");
        int expResult = 7;
        int result = Game.getWIDTH();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWIDTH method, of class Game.
     */
    @Test
    public void testSetWIDTH() {
        System.out.println("setWIDTH");
        int WIDTH = 7;
        Game.setWIDTH(WIDTH);
    }

    /**
     * Test of getHEIGHT method, of class Game.
     */
    @Test
    public void testGetHEIGHT() {
        System.out.println("getHEIGHT");
        int expResult = 7;
        int result = Game.getHEIGHT();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHEIGHT method, of class Game.
     */
    @Test
    public void testSetHEIGHT() {
        System.out.println("setHEIGHT");
        int HEIGHT = 7;
        Game.setHEIGHT(HEIGHT);
    }

    /**
     * Test of isIsCurrentRed method, of class Game.
     */
    @Test
    public void testIsIsCurrentRed() {
        System.out.println("isIsCurrentRed");
        boolean expResult = true;
        boolean result = Game.isIsCurrentRed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsCurrentRed method, of class Game.
     */
    @Test
    public void testSetIsCurrentRed() {
        System.out.println("setIsCurrentRed");
        boolean isCurrentRed = false;
        Game.setIsCurrentRed(isCurrentRed);
    }
    
    /**
     * Test of setRedPoints method, of class Game.
     */
    @Test
    public void testSetRedPoints() {
        System.out.println("setRedPoints");
        int redPoints = 2;
        Game.setRedPoints(redPoints);
    }

    /**
     * Test of getRedPoints method, of class Game.
     */
    @Test
    public void testGetRedPoints() {
        System.out.println("getRedPoints");
        int expResult = 2;
        int result = Game.getRedPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBluePoints method, of class Game.
     */
    @Test
    public void testGetBluePoints() {
        System.out.println("getBluePoints");
        int expResult = 2;
        int result = Game.getBluePoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBluePoints method, of class Game.
     */
    @Test
    public void testSetBluePoints() {
        System.out.println("setBluePoints");
        int bluePoints = 2;
        Game.setBluePoints(bluePoints);
    }

    /**
     * Test of getBoard method, of class Game.
     */
//    @Test
//    public void testGetBoard() {
//        System.out.println("getBoard");
//        Tile[][] expResult = new Tile[7][7];
//        Tile[][] result = Game.getBoard();
//        assertArrayEquals(expResult, result);
//    }

    /**
     * Test of setBoard method, of class Game.
     */
    @Test
    public void testSetBoard() {
        System.out.println("setBoard");
        Tile[][] board = new Tile[7][7];
        Game.setBoard(board);
    }
    
}
