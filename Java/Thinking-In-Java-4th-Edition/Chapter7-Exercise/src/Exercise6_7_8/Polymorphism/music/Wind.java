package Exercise6_7_8.Polymorphism.music;
import static net.mindview.util.Print.*;

public class Wind extends Instrument {
    void play(Note n) { print("Wind.play() " + n); }
    String what() { return "Wind"; }
    void adjust() { print("Adjusting Wind"); }
}
