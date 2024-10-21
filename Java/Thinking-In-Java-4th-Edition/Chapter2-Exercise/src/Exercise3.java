// Create a class containing a float and use it to demonstrate aliasing
// during method calls. 
/**
 * Recycle Class from Exercise2 (Float Number)
 */
public class Exercise3 {
    public static float ChangeFloatNumber(FloatNumber fnumber, float valueChange){
        fnumber.setFloat(valueChange);
        return fnumber.getFloat();
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Exercise 3 Result: ");

        FloatNumber fnumber = new FloatNumber(23.4f);
        System.out.println("Float Number: "+ fnumber.getFloat());

        ChangeFloatNumber(fnumber, 15.3f);
        System.out.println("Float Number After Changed: "+ fnumber.getFloat());

        System.out.println("----------------------------------------------------");
    }
}
