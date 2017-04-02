/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingbasket;

/**
 *
 * @author user
 */

public class Item {
    private int price;
    private String name;
    private Discountable discount;

    public Item(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Item(int price, String name, Discountable discount) {
        this.price = price;
        this.name = name;
        this.discount = discount;
    }
   
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public Discountable getDiscount() {
        return discount;
    }

    public void setDiscount(Discountable discount) {
        this.discount = discount;
    }
    
   
}
