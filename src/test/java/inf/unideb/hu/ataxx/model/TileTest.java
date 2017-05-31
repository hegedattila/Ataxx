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
public class TileTest {
    
    public TileTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of hasPiece method, of class Tile.
     */
    @Test
    public void testHasPiece() {
        System.out.println("hasPiece");
        Tile instance = new Tile();
        boolean expResult = false;
        boolean result = instance.hasPiece();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPiece method, of class Tile.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Tile instance = new Tile();
        Piece expResult = null;
        Piece result = instance.getPiece();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPiece method, of class Tile.
     */
    @Test
    public void testSetPiece() {
        System.out.println("setPiece");
        Piece piece = null;
        Tile instance = new Tile();
        instance.setPiece(piece);
    }
    
}
