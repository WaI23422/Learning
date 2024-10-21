package Exercise5;

class Outer {
    int numb1;

    Outer(int numb1) {
        System.out.println("Outer(" + numb1 + ") created.");
        this.numb1 = numb1;
    }

    class Inner {
        int numb2;
        
        Inner(int numb2) {
            System.out.println("Inner(" + numb2 + ") created.");
            this.numb2 = numb2; 
        }
    }
}

public class InnerInstance {
    public InnerInstance() {
        Outer outer = new Outer(0);
        outer.new Inner(0);
    }

    public InnerInstance(int numb) {
        Outer outer = new Outer(numb);
        outer.new Inner(numb);
    }
}
