package Exercise26;

class First {
    static class InnerFirst {
        InnerFirst(String x) {
            System.out.println("Inner Class" + " " + x);
        }
    }
}

class Second extends First {
    public static class InnerSecond extends InnerFirst {
        InnerSecond(String x) {
            super(x);
        }
    }
}

public class InheritInner {
    public static void main(String[] args) {
        new First.InnerFirst("First");
        new Second.InnerSecond("Second");
    }    
}