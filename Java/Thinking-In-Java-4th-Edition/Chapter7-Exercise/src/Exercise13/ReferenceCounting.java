package Exercise13;

public class ReferenceCounting {
    Shared shared = new Shared();
    Composing[] composing;

    public ReferenceCounting() throws Throwable {
        System.out.println("Create " + this);
        composing = new Composing[]{new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)};
        finalize();
    }

    protected void finalize() throws Throwable {
        System.out.println("Disposing " + this);
        for(Composing c : composing)
            c.dispose();

        super.finalize();
    }

    @Override
    public String toString() {
        return "ReferenceCounting";
    }
}