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

public interface Discountable {
    ArrayList<Integer> discount(Item item, int quantity);
    
}
