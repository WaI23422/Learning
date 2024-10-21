package Exercise20_21;

interface SomeInterface {
    void f();
    static class Nested {
        public void f() {
            System.out.println("Nested.f()");
        }
    }
}

public class InterfaceWithNestedClass implements SomeInterface{
    @Override public void f() { System.out.println("NestedInInterface.f()"); }

    public static void main(String[] args) {
        InterfaceWithNestedClass ni = new InterfaceWithNestedClass();
        ni.f();

        Nested n = new Nested();
        n.f();
    }
}
