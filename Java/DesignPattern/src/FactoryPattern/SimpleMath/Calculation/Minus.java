package FactoryPattern.SimpleMath.Calculation;

import FactoryPattern.SimpleMath.Calculation.Interface.Calculation;

public class Minus implements Calculation{
    @Override
    public int Cal(int x, int y) {
        return x - y;
    }
}
