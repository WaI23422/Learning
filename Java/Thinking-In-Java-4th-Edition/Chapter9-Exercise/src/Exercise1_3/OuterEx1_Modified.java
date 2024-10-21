package Exercise1_3;

public class OuterEx1_Modified {
    private String field;

    public OuterEx1_Modified(String str) {field = str;}

    public class InnerEx1 {
        String str;
        InnerEx1(String str) { this.str = str; }
        public void print() { System.out.println(str); }
        public String toString() { return field; }
    }

    public InnerEx1 getInner() { return new InnerEx1("Inner String");} 
}
