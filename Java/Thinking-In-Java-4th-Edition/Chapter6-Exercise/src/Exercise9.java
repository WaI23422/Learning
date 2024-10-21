/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 9: Create a class called Root that contains an instance of each of the classes (that you also create) named Component1, Component2, and Component3. Derive a class Stem from Root that also contains an instance of each “component.” All classes should have default constructors that print a message about that class.  
 *      </body>
 * </html>
 */
public class Exercise9 {
    public static void main(String[] args) {
        System.out.println("Exercise 9 Result: ");
        
        Stem stem = new Stem();
        stem.dispose();

        System.out.println("----------------------------------------------------");
    }
}

class Component1{
    Component1(String s){
        System.out.println("This is Component 1 in " + s);
    }

    void dispose() {
       System.out.println("Disposing of " + this);
    }
}

class Component2{
    Component2(String s){
        System.out.println("This is Component 2 in " + s);
    }

    void dispose() {
        System.out.println("Disposing of " + this);
    }
}

class Component3{
    Component3(String s){
        System.out.println("This is Component 3 in " + s);
    }

    void dispose() {
        System.out.println("Disposing of " + this);
    }
}

class Root{
    // Instance of Component in Root:
    Component1 component1;
    Component2 component2;
    Component3 component3;

    void dispose() {
        System.out.println("Erasing Root"); 
    }

    Root() {
        System.out.println("This is Root");
        component1 = new Component1("Root");
        component2 = new Component2("Root");
        component3 = new Component3("Root");
    }
}

class Stem extends Root {
    // Instance of Component in Stem:
    Component1 component1;
    Component2 component2;
    Component3 component3;

    Stem() {
        System.out.println("This is Stem");
        component1 = new Component1("Stem");
        component2 = new Component2("Stem");
        component3 = new Component3("Stem");
    }
}