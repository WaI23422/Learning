/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 14: Create three interfaces, each with two methods. Inherit a new interface that combines the three, adding a new method. Create a class by implementing the new interface and also inheriting from a concrete class. Now write four takes one of the four interfaces as an argument. In main( ), create an object of your class and pass it to each of the methods.
 *      </body>
 * </html>
 */
public class Exercise14 {
    public static void main(String[] args) {
        System.out.println("Exercise 14 Result: ");

        Profile Teacher = new Profile(new Input("Ngoc", "Giao Vien", 25));

        System.out.println(Teacher.name);
        System.out.println(Teacher.age);
        System.out.println(Teacher.pos);

        System.out.println("----------------------------------------------------");
    }
}


interface Security {
    String name();
    int age();
}

interface Teacher {
    String name();
    int age();
}

interface Labor {
    String name();
    int age();
}

interface Staff extends Security, Teacher, Labor{
    String position();
}

class Input {
    String name;
    String pos;
    int age;
    Input(String n,String p, int a) {name = n; pos = p; age = a;}
}

class Profile extends Input implements Staff {
    Profile(Input input) { super(input.name, input.pos, input.age);}

    public String name() {return name;}
    public int age() {return age;}
    public String position() {return pos;}
}

