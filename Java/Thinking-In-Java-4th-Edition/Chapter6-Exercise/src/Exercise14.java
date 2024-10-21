/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 14: In Car.java add a service( ) method to Engine and call this method in main( )
 *      </body>
 * </html>
 */
public class Exercise14 {
    public static void main(String[] args) {
        System.out.println("Exercise 14 Result: ");
        
        Car.main(args);

        System.out.println("----------------------------------------------------");
    }
}

class Engine {
    public void start() {}
    public void rev() {}
    public void stop() {}
    public void service() {}
}
class Wheel {
    public void inflate(int psi) {}
}
class Window {
    public void rollup() {}
    public void rolldown() {}
}
class Door {
    public Window window = new Window();
    public void open() {}
    public void close() {}
}
class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door
    left = new Door(),
    right = new Door(); // 2-door
    public Car() {
        for(int i = 0; i < 4; i++)
            wheel[i] = new Wheel();
    }
    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.engine.service();
        car.wheel[0].inflate(72);
    }
}