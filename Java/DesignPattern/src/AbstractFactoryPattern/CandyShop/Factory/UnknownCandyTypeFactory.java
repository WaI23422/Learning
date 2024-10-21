package AbstractFactoryPattern.CandyShop.Factory;

import AbstractFactoryPattern.CandyShop.Candy.PopingCandy;
import AbstractFactoryPattern.CandyShop.Candy.Interface.Candy;

public class UnknownCandyTypeFactory extends AbstractCandy{
    @Override
    public Candy getCandy(String candyType){    
        if(candyType.equalsIgnoreCase("Poping Candy")){
            return new PopingCandy();         
        } 
        
        return null;
    }
}
