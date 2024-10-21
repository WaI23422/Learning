package Exercise9_10_11;

interface SomeInterface {
    void f();
}

public class WithInAScopeInAMethod {

    SomeInterface getInstance() {
        {
            class SomeClass implements SomeInterface {
                public void f() {
                    System.out.println("SomeClass.f()");
                }
            }
            return new SomeClass();
        }
    }

    public static void main(String[] args) {

        WithInAScopeInAMethod wm = new WithInAScopeInAMethod();
        wm.getInstance().f();
    }
}