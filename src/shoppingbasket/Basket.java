/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author user
 */

public class Basket {
   private HashMap<Item, Integer >itemsHash;
    private ArrayList<Item> itemsArray;

    public Basket() {
       
        this.itemsArray = new ArrayList<>(); //items ordered
        this.itemsHash = new HashMap<>(); //items and quantity ordered     
    }   

    public HashMap<Item, Integer> getItemsHash() {
        return itemsHash;
    }

    public ArrayList<Item> getItemsArray() {
        return itemsArray;
    }
    
    
    public void addItem(Item item){
        boolean exists = false;
        Integer val;
        for(Item arrayItem : this.itemsArray){
            if (arrayItem==item){ exists = true; }                  
        } 
        if(exists){
           val = itemsHash.get(item);
           itemsHash.put(item, val+1);   
        } else {
            itemsArray.add(item);
        }
    }
    
    
    
    
    
}
