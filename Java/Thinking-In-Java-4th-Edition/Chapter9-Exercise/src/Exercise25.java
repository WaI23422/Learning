import Exercise24_25.GreenhouseControls;
import Exercise24_25.controller.Event;

/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 25: Inherit from GreenhouseControls in GreenhouseControls.java to add Event inner classes that turn water mist generators on and off. Write a new version of GreenhouseController.java to use these new Event objects.
 * </html>
 */
public class Exercise25 {
    public static void main(String[] args) {
        System.out.println("Exercise 25 Result: ");

        GreenhouseControls gc = new GreenhouseControls();

        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
            gc.new ThermostatNight(0),
            gc.new LightOn(200),
            gc.new LightOff(400),
            gc.new FanOn(100),
            gc.new FanOff(200),
            gc.new WaterOn(600),
            gc.new WaterOff(800),
            gc.new ThermostatDay(1400)
        };	
        gc.addEvent(gc.new Restart(2000, eventList));
        if(args.length == 0)
            gc.addEvent(
                new GreenhouseControls.Terminate(
                    0
                )
            );
        gc.run();

        System.out.println("----------------------------------------------------");
    }
}