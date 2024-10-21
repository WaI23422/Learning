package AbstractFactoryPattern.CandyShop.Factory;

import AbstractFactoryPattern.CandyShop.Candy.Interface.Candy;

public abstract class AbstractCandy {
    abstract Candy getCandy(String candyType) ;
}