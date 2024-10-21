// Write a program that calculates velocity using a constant distance and a
// constant time. 

import java.math.BigDecimal;
import java.math.RoundingMode;

class constanNumber{
    BigDecimal distance = new BigDecimal(195.4452).setScale(2, RoundingMode.HALF_UP);
    BigDecimal time = new BigDecimal(24).setScale(2, RoundingMode.HALF_UP);
}

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("Exercise 4 Result: ");
        constanNumber number = new constanNumber();
        BigDecimal velocity = number.distance.divide(number.time, 2, RoundingMode.HALF_UP);

        System.out.println("Velocity with distance (km) "+number.distance +" and time (h) "+ number.time +" is: "+velocity+ " (km/h)");
        System.out.println("----------------------------------------------------");
    }
}
