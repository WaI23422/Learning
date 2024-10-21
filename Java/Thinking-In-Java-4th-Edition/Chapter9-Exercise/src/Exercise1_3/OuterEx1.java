package Exercise1_3;

public class OuterEx1 {

    public static InnerEx1 getInner() { return new InnerEx1();} 

    static class InnerEx1 {
        
        String Identify = "This is Inner Class";
        
        InnerEx1() { System.out.println(Identify);}

    }
}
