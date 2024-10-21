// Create a class containing a float and use it to demonstrate aliasing
/**
 * "Aliasing" : describes a situation in which a data location in memory can be 
 * accessed through different symbolic names in the program. 
 */ 
class FloatNumber {
    private float fvalue;

    public FloatNumber(float fvalue){
        this.fvalue = fvalue;
    }
    
    public void setFloat(float fvalue) {
        this.fvalue = fvalue;
    }

    public float getFloat() {
        return fvalue;
    }
}   

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Exercise 2 Result: ");

        FloatNumber fnumber1 = new FloatNumber(1.01f);
        System.out.println("First Float Number: "+ fnumber1.getFloat());
        FloatNumber fnumber2 = fnumber1;
        System.out.println("Second Float Number: "+ fnumber2.getFloat());

        fnumber1.setFloat(0.234f);
        System.out.println("First Number After Changed: "+ fnumber1.getFloat());
        System.out.println("Second Number After First Number Change: "+ fnumber2.getFloat());
        System.out.println("Reason: This is because both fnumber1 and fnumber2 refer to the same object in memory. When we change the value of fnumber1, we are actually changing the value of the object in memory.");

        System.out.println("----------------------------------------------------");
    }
}
