/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingbasket;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class ShoppingBasket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("To open account please enter your name: ");
        String name = input.next();
        System.out.println(name + ", would you like a loyalty card? y/n ");
        String loyalty = input.next();
        boolean loyal = loyalty.equalsIgnoreCase("y");
        Customer one = new Customer(name, loyal);
        System.out.println("Enter how many items of cheese you would like (£1.30 each and a 2 for 1 discount): ");
        int quantity = input.nextInt();
        Item cheese = new Item(130, "cheese", new Two4One());
        Basket basket = one.getBasket();
        for(int i=0; i<quantity;i++){
        basket.addItem(cheese);
        }
        System.out.println("Enter how many bars of choclate you would like (£1.50 each): ");
        int quantitychoc = input.nextInt();
        Item barOfChocolate = new Item(150, "Chocolate Bar");
        for(int i=0; i<quantitychoc;i++){
        basket.addItem(barOfChocolate);
        }
        Integer totalDue = basket.priceToPay();
        System.out.println("Your total due is: " + totalDue + " pence");
        
        
    }
    
}
