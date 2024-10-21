import Exercise5.School.Class.Student;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 5: Create an interface containing three methods, in its own package. Implement the interface in a different package.
 *      </body>
 * </html>
 */
public class Exercise5 {
    public static void main(String[] args) { 
        System.out.println("Exercise 5 Result: ");

        Student myStudent = new Student();

        System.out.println(myStudent.name());;
        System.out.println(myStudent.age());;
        System.out.println(myStudent.id());;

        System.out.println("----------------------------------------------------");
    }
}