package Exercise9_10_11;

public class PrivateInner {

    private class Inner implements PrivateInnerInterface {
        @Override public void f() { System.out.println("Inner.f()"); }
    }

    PrivateInnerInterface getInner() {
        return new Inner();
    }
}