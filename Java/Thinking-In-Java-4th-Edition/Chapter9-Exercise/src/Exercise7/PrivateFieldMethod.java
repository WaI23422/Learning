package Exercise7;

public class PrivateFieldMethod {
    private String field = "Initial string";
    private void print() { System.out.println("String = " + field); }

    private void secondMethod() {
        new Inner().modify();
    }

    class Inner {
        void modify() { field += " modified"; print(); }
    }

    public static void main(String[] args) {
        PrivateFieldMethod io = new PrivateFieldMethod();
        io.print();
        io.secondMethod();
    }
}
