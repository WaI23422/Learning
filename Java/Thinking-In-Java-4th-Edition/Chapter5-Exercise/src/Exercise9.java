import packexercise.exercise9.access.local.*;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 9: Create the following file in the access/local directory (presumably in your CLASSPATH):
 *           <pre class="codeblock"><code>
 *  // access/local/PackagedClass.java
 *  package access.local;
 *  class PackagedClass {
 *      public PackagedClass() {
 *          System.out.println("Creating a packaged class");
 *      }
 *  } 
 *           </code></pre>
 *      </body>
 * </html>
 */
public class Exercise9 {
    public static void main(String[] args) {
        System.out.println("Exercise 9 Result: ");

        @SuppressWarnings("unused")
        PackagedClass packagedClass = new PackagedClass();

        System.out.println("----------------------------------------------------");
    }
}