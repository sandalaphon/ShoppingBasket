/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingbasket;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author user
 */
public class BasketTest {
    Item cheese;
    Item milk;
    Two4One discount;
    Customer albert;
    Boolean loyaltyCard;
    
    
    @Before
    public void before(){
        cheese = new Item(230, "cheese");
        discount= new Two4One();
        milk = new Item(110, "milk", discount);
        loyaltyCard=true;
        albert = new Customer("Albert", loyaltyCard);
    }
    
    @Test
    public void testItemPrice(){
        assertEquals(230, cheese.getPrice());
    }
    
    @Test
    public void testItemDiscount(){
        assertEquals(110, milk.getPrice());
    }
    
    @Test
    public void testCustomer(){
        assertEquals("Albert", albert.getName());
    }
    
     @Test
    public void testCustomer2(){
        assertEquals(true, albert.getLoyaltyCard());
    }
    
    @Test
    public void testCustomer3(){
        Basket albertBasket = albert.getBasket();
        albertBasket.addItem(milk);
        assertEquals(true, albertBasket.exists(milk));
    }
    
   @Test
   public void testZeroUnordered(){
       Basket albertBasket = albert.getBasket();
       long num= 0;
       long result = (long)albertBasket.quantityOrdered(milk);
       assertEquals( num, result );
   }
   
   @Test
   public void testTwoOrdered(){
       Basket albertBasket = albert.getBasket();
       albertBasket.addItem(milk);
       albertBasket.addItem(milk);
       long num= 2;
       long result = (long)albertBasket.quantityOrdered(milk);
       assertEquals( num, result );
   }
   
   @Test
   public void testRemoveItem(){
       Basket albertBasket = albert.getBasket();
       albertBasket.addItem(milk);
       albertBasket.addItem(milk);
       albertBasket.removeItem(milk);
       long num= 1;
       long result = (long)albertBasket.quantityOrdered(milk);
       assertEquals( num, result );
   }
   
    @Test
   public void testRemoveNonExistantItem(){
       Basket albertBasket = albert.getBasket();
       albertBasket.removeItem(milk);
       long num= 0;
       long result = (long)albertBasket.quantityOrdered(milk);
       assertEquals( num, result );
   }
   
    @Test
   public void testSeveralItems(){
       Basket albertBasket = albert.getBasket();
       albertBasket.addItem(milk);
       albertBasket.addItem(cheese);
       albertBasket.addItem(cheese);
       long num= 2;
       long result = (long)albertBasket.quantityOrdered(cheese);
       assertEquals( num, result );
   }
   
    @Test
   public void testEmptyBasket(){
       Basket albertBasket = albert.getBasket();
       albertBasket.addItem(milk);
       albertBasket.addItem(cheese);
       albertBasket.addItem(cheese);
       albertBasket.emptyBasket();
       long num= 0;
       long result = (long)albertBasket.quantityOrdered(cheese);
       assertEquals( num, result );
   }
   
}
