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
     * Test of getType method, of class MoveResult.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
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
        System.out.println("getPiece");
        MoveResult instance = new MoveResult(MoveType.ONE);
        Piece expResult = null;
        Piece result = instance.getPiece();
        assertEquals(expResult, result);
    }
    
}
