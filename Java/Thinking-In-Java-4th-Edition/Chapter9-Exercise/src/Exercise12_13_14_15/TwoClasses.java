package Exercise12_13_14_15;

class First {
    First() { System.out.println("First");}
    First(int x) { System.out.println("First(" + x + ")"); }
}

class Second {
    First f(int i) {
        return new First(i) {};
    }

    First f() {
        return new First() {};
    }
}

public class TwoClasses {
    public static void main(String[] args) {
        new Second().f(321);
        new Second().f();
    }
}