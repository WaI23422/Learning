package FactoryPattern.SimpleMath.Calculation;

import FactoryPattern.SimpleMath.Calculation.Interface.Calculation;

public class Multiply implements Calculation {
    @Override
    public int Cal(int x, int y) {
        return x*y;
    } 
}
