/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingbasket;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Two4One implements Discountable{
    private ArrayList<Integer>discountSignature;
    
    public Two4One() {
        this.discountSignature= new ArrayList<>();
    }
    
    @Override
      public  ArrayList<Integer> discount(Item item, int quantity){
        //free item id, number to trigger free item, %discount
        this.getDiscountSignature().add(0);
        this.getDiscountSignature().add(0);
        this.getDiscountSignature().add(quantity/2);
        return this.getDiscountSignature();
    }

    /**
     * @return the discountSignature
     */
    public ArrayList<Integer> getDiscountSignature() {
        return discountSignature;
    }

    /**
     * @param discountSignature the discountSignature to set
     */
    public void setDiscountSignature(ArrayList<Integer> discountSignature) {
        this.discountSignature = discountSignature;
    }

}
    
