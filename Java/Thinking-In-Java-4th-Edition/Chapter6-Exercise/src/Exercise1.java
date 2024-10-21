/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 1:  Create a simple class. Inside a second class, define a reference to an object of the first class. Use lazy initialization to instantiate this object.
 *      </body>
 * </html>
 */
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("Exercise 1 Result: ");
        
        LazyInitialization myLazyInitialization = new LazyInitialization();

        // Define a reference to an object of the first class
        myLazyInitialization.setAge(new Age(4));
        System.out.println("Reference of Age class object: "+ myLazyInitialization.getAge().getAge());
        // Use lazy initialization to instantiate this object. 
        myLazyInitialization.setAgeAt(16);

        System.out.println("----------------------------------------------------");
    }
}

class Age {
    private int age;

    Age() {
        this.age = 0;
    }

    Age(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class LazyInitialization {
    private Age age;

    public LazyInitialization() {
        this.age = null;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Age getAge() {
        if (age == null) {
            age = new Age();
        }
        return age;
    }

    public void setAgeAt(int a) {
        Age age = new Age(a);
        System.out.println("New Object of Age set at: " + age.getAge());
    }

}