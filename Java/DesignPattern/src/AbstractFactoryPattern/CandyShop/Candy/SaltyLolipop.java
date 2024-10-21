package AbstractFactoryPattern.CandyShop.Candy;

import AbstractFactoryPattern.CandyShop.Candy.Interface.Candy;

public class SaltyLolipop implements Candy{
    private int Amount = 252; 
    
    @Override
    public void Amount() {
        System.out.println("Salty Lolipop Remaining: " + Amount);
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
