package packexercise.exercise4;

public class ProtectedAccess {
    protected void ProtectedMethod(){
        System.out.println("This is a protected method.");
    }

    // Access protected method in the same package:
    public void publicMethod(){
        ProtectedMethod();
    }
}
