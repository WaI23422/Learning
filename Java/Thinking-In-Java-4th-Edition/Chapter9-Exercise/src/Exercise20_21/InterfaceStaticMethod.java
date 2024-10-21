package Exercise20_21;

interface TestInterface {
    void f();
    void g();

    class Tester {
        static void test(TestInterface t) {
            t.f();
            t.g();
        }
    }
}

public class InterfaceStaticMethod implements TestInterface{
    @Override public void f() { System.out.println("StaticMethod.f()"); }
    @Override public void g() { System.out.println("StaticMethod.g()"); }

    public static void main(String[] args) {
        InterfaceStaticMethod sm = new InterfaceStaticMethod();
        Tester.test(sm);
    }
}
