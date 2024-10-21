package AbstractFactoryPattern.CandyShop.Factory;

import AbstractFactoryPattern.CandyShop.Candy.GummyBear;
import AbstractFactoryPattern.CandyShop.Candy.Interface.Candy;

public class GummiesFactory extends AbstractCandy{
    @Override
    public Candy getCandy(String candyType){    
        if(candyType.equalsIgnoreCase("Gummy Bear")){
            return new GummyBear();         
        } 
        
        return null;
    }
}
