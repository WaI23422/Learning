package AbstractFactoryPattern.CandyShop.Factory.Generator;

import AbstractFactoryPattern.CandyShop.Factory.AbstractCandy;
import AbstractFactoryPattern.CandyShop.Factory.GummiesFactory;
import AbstractFactoryPattern.CandyShop.Factory.LolipopFactory;
import AbstractFactoryPattern.CandyShop.Factory.UnknownCandyTypeFactory;

public class FactoryProducer {
    public static AbstractCandy getFactory(boolean gummies, boolean lolipop){   
        if(gummies){
            return new GummiesFactory();         
        }else if (lolipop) {
            return new LolipopFactory();
        } else {
            return new UnknownCandyTypeFactory();
        }
    }
}
