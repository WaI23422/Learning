// Turn the AllTheColorsOfTheRainbow example into a program that
// compiles and runs. 

/**
* Insert a list:
* <ol>
* <li> Item eleven
* </ol>
*/

import java.util.Scanner;

class AllTheColorsOfTheRainbow {
    int anIntegerRepresentingColors = 1;
    void changeTheHueOfTheColor(int newHue) {
        switch (newHue) {
            case 1:
                System.out.println("Change Color to Red");
                anIntegerRepresentingColors = 1;
                break;
            case 2:
                System.out.println("Change Color to Orange");
                anIntegerRepresentingColors = 2;
                break;
            case 3:
                System.out.println("Change Color to Yellow");
                anIntegerRepresentingColors = 3;
                break;
            case 4:
                System.out.println("Change Color to Green");
                anIntegerRepresentingColors = 4;
                break;
            case 5:
                System.out.println("Change Color to Blue");
                anIntegerRepresentingColors = 5;
                break;
            case 6:
                System.out.println("Change Color to Indigo");
                anIntegerRepresentingColors = 6;
                break;
            case 7:
                System.out.println("Change Color to Violet");
                anIntegerRepresentingColors = 7;
                break;
            default:
                System.out.println("Invalid Color Change");
                break;
        } 
    }

    static void getColor(int anIntegerRepresentingColors){
        switch (anIntegerRepresentingColors) {
            case 1:
                System.out.println("Color is Red");
                break;
            case 2:
                System.out.println("Color is Orange");
                break;
            case 3:
                System.out.println("Color is Yellow");
                break;
            case 4:
                System.out.println("Color is Green");
                break;
            case 5:
                System.out.println("Color is Blue");
                break;
            case 6:
                System.out.println("Color is Indigo");
                break;
            case 7:
                System.out.println("Color is Violet");
                break;
            default:
                System.out.println("Invalid Color");
                break;
        }
    }
} 

public class Exercise11 {
    public static void main(String[] args) {
        System.out.println("// Exercise 11 Result //");

        AllTheColorsOfTheRainbow Color = new AllTheColorsOfTheRainbow();
        AllTheColorsOfTheRainbow.getColor(Color.anIntegerRepresentingColors);

        System.out.println("Type a number from 1 to 7 to change color:");
        
        Scanner myScanner1 = new Scanner(System.in);
        while (myScanner1.hasNext()) {
            String Line = myScanner1.nextLine();
            if (!Line.isEmpty()) {
                int number = Integer.parseInt(Line);
                Color.changeTheHueOfTheColor(number);
                break;
            } else {
                Color.changeTheHueOfTheColor(Color.anIntegerRepresentingColors);
                break;
            }
        }
        
        myScanner1.close();

        System.out.println("----------------------------------------------------");
    }
}
