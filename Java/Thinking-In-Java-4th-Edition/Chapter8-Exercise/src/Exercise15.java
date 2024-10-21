/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 15: Modify the previous exercise by creating an abstract class and inheriting that into the derived class.
 *      </body>
 * </html>
 */
public class Exercise15 {
    public static void main(String[] args) {
        System.out.println("Exercise 15 Result: ");

        Input Teacher = new Input("Thao","Teacher",25);

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

abstract class Profile {
    String name;
    String pos;
    int age;
    Profile(String n, String p, int a) {name = n; pos =p; age = a;}
}

class Input extends Profile implements Staff {
    Input(String name, String pos, int age) {super(name, pos, age);}

    public String name() {return name;}
    public int age() {return age;}
    public String position() {return pos;}
}

