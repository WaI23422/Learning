package Exercise18_19;

public class NestedClass {
    static class Nested {
        int x;
        
        Nested(int x) {
            this.x = x;
            System.out.println("Nested(" + x + ")");
        }
    }

    public static void main(String[] args) {
        new Nested(123);
    }
}
