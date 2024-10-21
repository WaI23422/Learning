package Exercise12_13_14_15;

interface SomeInterface {
    void f();
}

public class WithInAScopeInAMethod {

    SomeInterface getInstance() {
        return new SomeInterface() {
            public void f() { System.out.println("Anonymous.f()"); }
        };
    }

    public static void main(String[] args) {

        WithInAScopeInAMethod wm = new WithInAScopeInAMethod();
        wm.getInstance().f();
    }
}