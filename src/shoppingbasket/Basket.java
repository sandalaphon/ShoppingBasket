/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 *
 * @author user
 */

public class Basket {
   private HashMap<Item, Integer >orderedItemsHash;
   private Integer costOfBasket; 
   private ArrayList<Integer>discountCode;
   private boolean loyaltyCard;

    public Basket(Boolean loyaltyCard) {
        this.orderedItemsHash = new HashMap<>(); //items and quantity ordered 
        this.discountCode = new ArrayList<>();
        this.loyaltyCard = loyaltyCard;
    }   

    public void addItem(Item item){
        Integer val;

        if(exists(item)){
           val = orderedItemsHash.get(item);
           orderedItemsHash.put(item, val+1);   
        } else {
            orderedItemsHash.put(item, 1);
        }
    }
    
    public void removeItem(Item item){
        if(exists(item)){
            Integer val = orderedItemsHash.get(item);
            orderedItemsHash.put(item, val-1);
        } else {return;}
        if (orderedItemsHash.get(item)==0){
            orderedItemsHash.remove(item);  
        }
    }
    
    public boolean exists(Item item){
          return orderedItemsHash.containsKey(item);
    }
    
    public Integer quantityOrdered(Item item){
        if(exists(item)){
            return orderedItemsHash.get(item);
        } else {
            return 0;
        }
    }
    
    public void emptyBasket(){
        orderedItemsHash.clear();
    }
    
   public Integer undiscountedPriceToPay(){
       costOfBasket=0;
       HashMap<Item, Integer> iteratingHash = new HashMap(orderedItemsHash);
       Iterator it = iteratingHash.entrySet().iterator();
       while (it.hasNext()){
           HashMap.Entry pair = (HashMap.Entry)it.next();
           Item item = (Item)pair.getKey();
           Integer price = item.getPrice();
           Integer quantity = (Integer)pair.getValue();
           costOfBasket += price*quantity;
           it.remove();
       }
       return costOfBasket;
   }
   
   
   //note getItemDiscounts returns a negative Integer
   public Integer getItemDiscounts(){
       Integer discountTotal=0;
       HashMap<Item, Integer> iteratingHash = new HashMap(orderedItemsHash);
       Iterator it = iteratingHash.entrySet().iterator();
       while (it.hasNext()){
           HashMap.Entry pair = (HashMap.Entry)it.next();
           Item item = (Item)pair.getKey();
           Integer price = item.getPrice();
           Integer quantity = (Integer)pair.getValue();
           if(item.getDiscount()!=null){
           discountCode = item.getDiscount().discount(item, quantity);
           //extend via a case statement if multiple discount types
           Integer itemsDeductable = discountCode.get(2);
           discountTotal -= price*itemsDeductable;
           }
           it.remove();
       }
       return discountTotal;
   }
   
   public Integer priceToPay(){
       Integer undeducted = undiscountedPriceToPay();
       Integer itemDeductions = getItemDiscounts();
       Integer cost = undeducted + itemDeductions; // itemsDeductions is negative
//       check for bulk discount and apply
       if (cost>2000){
           cost = 9*cost/10;
       }
       //apply loyaltyCard discount if applicable.
       if (loyaltyCard){
           cost = 98*cost/100;
       }
       return cost;
   }
    
    
    
}
