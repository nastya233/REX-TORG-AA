/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rex.torg.aa;

/**
 *
 * @author Alina
 */
public class Tovar {

    private int Price;
    private String Tovar;



    public Tovar(int Price, String Tovar) {
        this.Price = Price;
        this.Tovar = Tovar;


    }

    public Tovar() {
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getTovar() {
        return Tovar;
    }

    public void setTovar(String Tovar) {
        this.Tovar = Tovar;
    }



 
}