package packexercise.exercise5;

public class Access {
    private void PrivateAccess(){
        System.out.println("This is private");
    }

    public void PublicAccess(){
        System.out.println("This is public");

        System.out.println("Access Through Public:");
        PrivateAccess();
        ProtectedAccess();
        PackageAccess();
    }

    protected void ProtectedAccess(){
        System.out.println("This is protected");
    }

    void PackageAccess(){
        System.out.println("This is package access");
    }
}