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
public class TovarRMK {

    private int Price;
    private int Id;
    private int Kolvo;
    private int Sum;
    private String TovarRMK;



    public TovarRMK(int Price, String TovarRMK, int Id, int Kolvo, int Sum) {
        this.Price = Price;
        this.TovarRMK = TovarRMK;
        this.Id = Id;
        this.Kolvo = Kolvo;
        this.Sum = Sum;

    }

    public TovarRMK() {
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getTovarRMK() {
        return TovarRMK;
    }

    public void setTovarRMK(String TovarRMK) {
        this.TovarRMK = TovarRMK;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }    

    public int getKolvo() {
        return Kolvo;
    }

    public void setKolvo(int Kolvo) {
        this.Kolvo = Kolvo;
    }   
 
    public int getSum() {
        return Sum;
    }

    public void setSum(int Sum) {
        this.Sum = Sum;
    }   
}
