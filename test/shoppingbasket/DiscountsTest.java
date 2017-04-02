/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingbasket;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author user
 */
public class DiscountsTest {
    Item cheese;
    Item milk;
    Item hifi;
    Item donut;
    Two4One discount;
    Customer albert;
     Customer bob;
    Boolean loyaltyCard;
    Boolean noLoyaltyCard;
    Basket albertBasket;
    Basket bobBasket;
    
    
    @Before
    public void before(){
        discount= new Two4One();
        hifi = new Item(2000, "hifi");
        cheese = new Item(230, "cheese");
        donut = new Item(200, "donut", discount);
        milk = new Item(110, "milk", discount);
        loyaltyCard=true;
        noLoyaltyCard=false;
        albert = new Customer("Albert", loyaltyCard);
        bob = new Customer("Bob", noLoyaltyCard);
        albertBasket = albert.getBasket();
        bobBasket = bob.getBasket();
    }
    
    @Test
    public void testPriceToPay(){
         albertBasket.addItem(cheese);
         albertBasket.addItem(milk);
         long price = 340;
         long actual = (long)albertBasket.undiscountedPriceToPay();
        assertEquals(price, actual);
    }
    
     @Test
    public void testOnlyOne(){
         albertBasket.addItem(cheese);
         albertBasket.addItem(milk);
         long discount = 0;
         long actual = (long)albertBasket.getItemDiscounts();
        assertEquals(discount, actual);
    }
    
    @Test
    public void testTwo4One(){
        albertBasket.addItem(cheese);
         albertBasket.addItem(milk);
          albertBasket.addItem(milk);
         long discount = -110;
         long actual = (long)albertBasket.getItemDiscounts();
        assertEquals(discount, actual);
    }
    
    @Test
    public void testTwo4OneFor3(){
        albertBasket.addItem(cheese);
         albertBasket.addItem(milk);
          albertBasket.addItem(milk);
           albertBasket.addItem(milk);
         long discount = -110;
         long actual = (long)albertBasket.getItemDiscounts();
        assertEquals(discount, actual);
    }
    
    @Test 
    public void testLoyaltyCard(){
       albertBasket.addItem(cheese);
         albertBasket.addItem(milk);
         long priceExpected = 340*98/100;
         long actual = (long)albertBasket.priceToPay();
         assertEquals(priceExpected, actual);
    }
    
    @Test
    public void testBulkDiscountUnloyal(){
        bobBasket.addItem(cheese);
        bobBasket.addItem(milk);
        bobBasket.addItem(hifi);
        long priceExpected = (110+230+2000)*90/100;
        long actual = (long)bobBasket.priceToPay();
        assertEquals(priceExpected, actual);
    }
    
    @Test
    public void allTogetherNow(){
        albertBasket.addItem(cheese);
         albertBasket.addItem(milk);
          albertBasket.addItem(milk);
           albertBasket.addItem(milk);
          albertBasket.addItem(donut);
           albertBasket.addItem(donut);
           albertBasket.addItem(hifi);
           long priceExpected = ((230+220+200+2000)*9/10)*98/100;
           long actual = (long)albertBasket.priceToPay();
           assertEquals(priceExpected, actual);
    }
    
}
