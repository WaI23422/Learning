import static net.mindview.util.Print.*;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 6:  Using Chess.java, prove the statements in the previous paragraph.
 *          <ul>
 *              <li> If you don’t call the base-class constructor in BoardGame( ), the compiler will complain that it can’t find a constructor of the form Game( ). In addition, the call to the base-class constructor must be the first thing you do in the derived-class constructor. (The compiler will remind you if you get it wrong.)
 *      </body>
 * </html>
 */
public class Exercise6 {
    public static void main(String[] args) {
        System.out.println("Exercise 6 Result: ");
        
        Chess.main(args);

        System.out.println("----------------------------------------------------");
    }
}

class Game {
    Game(int i) { 
        print("Game constructor");
    }
}
class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}

class Chess extends BoardGame {
    Chess() {
        super(11);
        // without super() -> Implicit super constructor BoardGame() is undefined. Must explicitly invoke another constructorJava(134217871)
        print("Chess constructor");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
}