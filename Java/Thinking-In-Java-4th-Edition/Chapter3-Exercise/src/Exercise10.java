// A vampire number has an even number of digits and is formed by
// multiplying a pair of numbers containing half the number of digits of the result. The digits
// are taken from the original number in any order. Pairs of trailing zeroes are not allowed.
// Examples include:
// 1260 = 21 * 60
// 1827 = 21 * 87
// 2187 = 27 * 81
// Write a program that finds all the 4-digit vampire numbers. (Suggested by Dan Forhan.) 

class myCal2{
    public static int Power(int numb, int pow){
        int res = 1;

        if (pow == 0) {
            return res;
        }

        for (int i = 0; i < pow; i++) {
            res *= numb;
        }

        return res;
    }
}

class myArray{
    /**
     * Remove a number in an integer Array.
     * @param removeArr Array have number remove.
     * @param removeNumb Number remove.
     * @return an int array.
     */
    public static int[] remove(int[] removeArr, int removeNumb){
        int[] res = new int[removeArr.length -1];
        int i = 0;

        for (int numb : removeArr) {
            if (numb != removeNumb) {
                res[i] = numb;
                i++;
            }
        }
        return res;
    }
    /**
     * Add a number to int array.
     * @param addArr Array adding.
     * @param addNumb Number being add.
     * @return new int Array contain new number added.
     */
    public static int[] add(int[] addArr, int addNumb){
        int[] res = new int[addArr.length+1];
        for (int i = 0; i < res.length; i++) {
            if (i == res.length -1) {
                res[i] = addNumb;
            } else {
                res[i] = addArr[i];
            }
        }

        return res;
    }
}

class VampireNumber{
    /**
     * Check if a number is Vampire number.
     * @param numb number check.
     * @return boolean.
     */
    public static boolean isVampierNumber(int numb){
        int firstValue = 0;
        int secondValue = 0;
        int numbLen = String.valueOf(numb).toCharArray().length;
        if (numbLen%2 != 0) {
            return false;
        }
        
        int[] numbArray = new int[numbLen];
        for (int i = 0; i < numbArray.length; i++) {
            numbArray[i] = Integer.parseInt(String.valueOf(String.valueOf(numb).toCharArray()[i]));
        }

        for (int numb1 : numbArray) {
            int[] numbArray2 = myArray.remove(numbArray, numb1);

            for (int numb2 : numbArray2) {
                int[] numbArray3 = myArray.remove(numbArray2, numb2);
                numb2 *= myCal2.Power(10, 1);

                for (int numb3 : numbArray3) {
                    int[] numbArray4 = myArray.remove(numbArray3, numb3);

                    for (int numb4 : numbArray4) {
                        numb4 *= myCal2.Power(10, 1);

                        firstValue = numb1 + numb2;
                        secondValue = numb3 + numb4;
                        
                        if (firstValue*secondValue == numb) {
                            return true;
                        }

                        firstValue = 0; secondValue=0;
                    }
                }
            }
        }

        return false;
    }
    /**
     * List all the vampire number have number-digit.
     * @param digit number-digits of vampire number. 
     */
    public static void list(int digit){
        for (int i = myCal2.Power(10, digit-1); i < myCal2.Power(10, digit); i++) {
            if (isVampierNumber(i)) {
                System.out.println(i);
            }
        }    
    }
}

public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("Exercise 10 Result: ");
        
        VampireNumber.list(4);

        System.out.println("----------------------------------------------------");
    }
}
