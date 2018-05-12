/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

/**
 * A három lehetséges lépést definiáló osztály.
 * 
 * @author Hegedűs Attila
 */
public enum MoveType {
    
    /**
     * Az érvénytelen lépés.
     * 
     * Ez a lépés típusa, ha kettőnél több mezőt szeretett volna lépni a
     * játékos, vagy már foglalt mezőt választott ki célnak.
     */
    NONE,

    /**
     * Az egymezős lépés.
     * 
     * Ez a lépés típusa ha a célmező a szomszédja a lépésre kiválasztott
     * mezőnek.
     */
    ONE,

    /**
     * A kétmezős lépés.
     * 
     * Ez a lépés típusa ha a célmező és a lépésre kiválasztott mező között van
     * egy mező.
     */
    TWO
    
}
