/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 10:  Modify the previous exercise so that each class only has non-default constructors
 *      </body>
 * </html>
 */
public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("Exercise 10 Result: ");
        
        Stem_10 stem_10 = new Stem_10("null");

        System.out.println("----------------------------------------------------");
    }
}

class Component1_10{
    Component1_10(String s){
        System.out.println("This is Component 1 in " + s);
    }
}

class Component2_10{
    Component2_10(String s){
        System.out.println("This is Component 2 in " + s);
    }
}

class Component3_10{
    Component3_10(String s){
        System.out.println("This is Component 3 in " + s);
    }
}

class Root_10{
    // Instance of Component in Root:
    Component1_10 component1_10;
    Component2_10 component2_10;
    Component3_10 component3_10;

    Root_10(String s) {
        System.out.println("This is Root");
        component1_10 = new Component1_10("Root");
        component2_10 = new Component2_10("Root");
        component3_10 = new Component3_10("Root");
    }
}

class Stem_10 extends Root {
    // Instance of Component in Stem:
    Component1_10 component1_10;
    Component2_10 component2_10;
    Component3_10 component3_10;

    Stem_10(String s) {
        System.out.println("This is Stem");
        component1_10 = new Component1_10("Stem");
        component2_10 = new Component2_10("Stem");
        component3_10 = new Component3_10("Stem");
    }
}