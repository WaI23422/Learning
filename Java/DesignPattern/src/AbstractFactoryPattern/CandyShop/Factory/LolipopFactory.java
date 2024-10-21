package AbstractFactoryPattern.CandyShop.Factory;

import AbstractFactoryPattern.CandyShop.Candy.NormalLolipop;
import AbstractFactoryPattern.CandyShop.Candy.SaltyLolipop;
import AbstractFactoryPattern.CandyShop.Candy.Interface.Candy;

public class LolipopFactory extends AbstractCandy{
    @Override
    public Candy getCandy(String candyType){    
        if(candyType.equalsIgnoreCase("Salty Lolipop")){
            return new SaltyLolipop();         
        }else if(candyType.equalsIgnoreCase("Normal Lolipop")){
            return new NormalLolipop();
        }	 
        
        return null;
    }
}
