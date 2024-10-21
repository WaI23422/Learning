package AbstractFactoryPattern.CandyShop.Candy;

import AbstractFactoryPattern.CandyShop.Candy.Interface.Candy;

public class PopingCandy implements Candy{
    private int Amount = 234; 
    
    @Override
    public void Amount() {
        System.out.println("Poping Candy Remaining: " + Amount);
    }

    @Override
    public void Buy(int x) {
        if (x > Amount) {System.out.println("We don't have that much Candy.");}
        else {
            Amount -= x;
            System.out.println("Total Remaining: " + Amount);
        }
    }

    @Override
    public void Sell(int x){
        Amount+=x;
        System.out.println("Total Remaining: " + Amount);
    }
}