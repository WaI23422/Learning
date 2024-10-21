package FactoryPattern.SimpleMath.Factory;

import FactoryPattern.SimpleMath.Calculation.Divide;
import FactoryPattern.SimpleMath.Calculation.Minus;
import FactoryPattern.SimpleMath.Calculation.Multiply;
import FactoryPattern.SimpleMath.Calculation.Plus;
import FactoryPattern.SimpleMath.Calculation.Interface.Calculation;

public class CalculationFactory {
    public Calculation getCalculation(String type) {
        if(type == null){ return null; }		

        if(type.equalsIgnoreCase("PLUS")){ return new Plus(); }  
        else if(type.equalsIgnoreCase("MINUS")){ return new Minus(); } 
        else if(type.equalsIgnoreCase("DIVIDE")){ return new Divide(); }
        else if(type.equalsIgnoreCase("MULTIPLY")){ return new Multiply();}
    
        return null;
    }
}
