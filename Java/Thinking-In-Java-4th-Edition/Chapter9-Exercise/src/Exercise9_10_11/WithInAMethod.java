package Exercise9_10_11;

interface SomeInterface {
    void f();
}

public class WithInAMethod {

    SomeInterface getInstance() {
        class SomeClass implements SomeInterface {
            public void f() { System.out.println("SomeClass.f()"); }
        }
        return new SomeClass();
    }

    public static void main(String[] args) {

        WithInAMethod wm = new WithInAMethod();
        wm.getInstance().f();        wm.getInstance().f();

    }
}