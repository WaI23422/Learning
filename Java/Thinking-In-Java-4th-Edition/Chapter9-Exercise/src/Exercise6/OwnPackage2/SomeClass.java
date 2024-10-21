package Exercise6.OwnPackage2;

import Exercise6.OwnPackage.SomeInterface;

public class SomeClass {
    protected class Inner implements SomeInterface {
        public Inner() {}
        @Override public void f() { System.out.println("SomeClass.Inner.f()"); }
    }
}
