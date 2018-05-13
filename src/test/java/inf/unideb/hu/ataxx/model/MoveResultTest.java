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
public class MoveResultTest {
    
    public MoveResultTest() {
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
    private static Logger logger = LoggerFactory.getLogger(MoveResultTest.class);    

    /**
     * Test of getType method, of class MoveResult.
     */
    @Test
    public void testGetType() {
        logger.info("getType");
        MoveResult instance = new MoveResult(MoveType.ONE);
        MoveType expResult = MoveType.ONE;
        MoveType result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPiece method, of class MoveResult.
     */
    @Test
    public void testGetPiece() {
        logger.info("getPiece");
        MoveResult instance = new MoveResult(MoveType.ONE);
        Piece expResult = null;
        Piece result = instance.getPiece();
        assertEquals(expResult, result);
    }
    
}
