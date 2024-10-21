package FactoryPattern.SimpleMath;

import java.util.Scanner;

import FactoryPattern.SimpleMath.Calculation.Interface.Calculation;
import FactoryPattern.SimpleMath.Factory.CalculationFactory;

public class MathCalculation {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Type of Calculation: Plus, Minus, Divide, Multiply");
        String calType = myScanner.nextLine();

        if (!calType.equalsIgnoreCase("Plus") && !calType.equalsIgnoreCase("Minus") 
            && !calType.equalsIgnoreCase("Divide") && !calType.equalsIgnoreCase("Muliply")) {
            
            System.out.println("Wrong Input.");
        } else {
            System.out.println("Input First Number:");
            int num1 = myScanner.nextInt();
            System.out.println("Input Second Number:");
            int num2 = myScanner.nextInt();

            CalculationFactory calculationFactory = new CalculationFactory();

            Calculation cal = calculationFactory.getCalculation(calType);
            
            System.out.println("Calculation Complete:");
            System.out.println(cal.Cal(num1, num2));
        }
        
        System.gc();
        myScanner.close();
    }
}
