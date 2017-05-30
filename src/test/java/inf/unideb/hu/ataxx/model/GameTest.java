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
    
}
