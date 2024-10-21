package Exercise24_25;

import Exercise24_25.controller.Event;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
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
    }
}
