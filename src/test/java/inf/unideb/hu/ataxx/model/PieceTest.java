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
public class PieceTest {
    
    public PieceTest() {
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
     * Test of getType method, of class Piece.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Piece instance = new Piece(PieceType.RED, 0, 0);
        PieceType expResult = PieceType.RED;
        PieceType result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Piece.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        PieceType type = PieceType.BLUE;
        Piece instance = new Piece(PieceType.RED, 0, 0);
        instance.setType(type);
    }

    /**
     * Test of getX method, of class Piece.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Piece instance = new Piece(PieceType.RED, 1, 1);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Piece.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Piece instance = new Piece(PieceType.RED, 1, 1);
        int expResult = 1;
        int result = instance.getY();
        assertEquals(expResult, result);
    }
    
}
