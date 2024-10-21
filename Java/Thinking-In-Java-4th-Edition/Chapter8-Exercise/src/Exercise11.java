import Exercise11.interfaceprocessor.*;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 11: Create a class with a method that takes a String argument and produces a result that swaps each pair of characters in that argument. Adapt the class so that it works with interfaceprocessor.Apply.process( ).
 *      </body>
 * </html>
 */
public class Exercise11 {
    public static void main(String[] args) { 
        System.out.println("Exercise 11 Result: ");

        Apply.process(new SwapperAdapter(), "This is a test string");
        Apply.process(new SwapperAdapter(), "0123456789");
        Apply.process(new SwapperAdapter(), "abcdefg");
        
        System.out.println("----------------------------------------------------");
    }
}

class Swapper {
    public static String swapCharacters(String arg) {
        char[] c = arg.toCharArray();

        for (int i = 0; i < c.length - 1; i += 2) {
            char temp = c[i];
            c[i] = c[i + 1];
            c[i + 1] = temp;
        }

        String result = new String(c);
        return result;
    }
}

class SwapperAdapter implements Processor {
    public String name() {
        return Swapper.class.getSimpleName();
    }

    public String process(Object input) {
        return Swapper.swapCharacters( (String) input );
    }
}