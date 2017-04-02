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

public class Customer {
    private String name;
    private Boolean loyaltyCard;
    private Basket basket;

    public Customer(String name, Boolean loyaltyCard) {
        this.name = name;
        this.loyaltyCard = loyaltyCard;
        this.basket = new Basket(loyaltyCard);
    }

    public Basket getBasket() {
        return basket;
    }  

    public String getName() {
        return name;
    }

    public Boolean getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoyaltyCard(Boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    
}
