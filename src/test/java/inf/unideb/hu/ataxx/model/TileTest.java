package inf.unideb.hu.ataxx.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * Logolásért felelős példány.
     */
    private static Logger logger = LoggerFactory.getLogger(TileTest.class);

    /**
     * Test of hasPiece method, of class Tile.
     */
    @Test
    public void testHasPiece() {
        logger.info("hasPiece");
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
        logger.info("getPiece");
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
        logger.info("setPiece");
        Piece piece = null;
        Tile instance = new Tile();
        instance.setPiece(piece);
    }
    
}
