/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.controller;

/**
 *
 * @author hegedattila
 */
import javax.persistence.*;

/**
 *
 * @author hegedattila
 */
@Entity
@Table(name = "ataxx")
public class Result {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="szekv")
    @SequenceGenerator(name="szekv", sequenceName = "szekvencia", allocationSize=1)
    
    private int id;
    
    private int red;
    private int blue;

    /**
     *
     * @param red
     * @param blue
     */
    public Result(int red, int blue) {
        this.red = red;
        this.blue = blue;
    }

    /**
     *
     */
    public Result() {
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public int getRed() {
        return red;
    }

    /**
     *
     * @return
     */
    public int getBlue() {
        return blue;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param red
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     *
     * @param blue
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }
    
}
