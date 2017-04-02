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
        //free item id, % if discount is a %, items payable if 3 for 2 etc
        this.getDiscountSignature().add(0);
        this.getDiscountSignature().add(0);
        this.getDiscountSignature().add(quantity/2);
        return this.getDiscountSignature();
    }

    public ArrayList<Integer> getDiscountSignature() {
        return discountSignature;
    }

    public void setDiscountSignature(ArrayList<Integer> discountSignature) {
        this.discountSignature = discountSignature;
    }

}
    
