package Exercise18_19;

class Outer1 {
    static class Inner1 {
        void f1() {System.out.println("Nested 1");}

        static class Inner2 {
            void f2() {System.out.println("Nested 2");}
        }
    }
}

public class InnerNestedClass {
    public static void main(String[] args) {
        new Outer1.Inner1().f1();
        new Outer1.Inner1.Inner2().f2();
    }
}
