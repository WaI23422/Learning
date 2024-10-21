package Exercise6_7_8.Polymorphism.music;
import static net.mindview.util.Print.*;

public class Instrument {
    void play(Note n) { print("Instrument.play() " + n); }
    String what() { return "Instrument"; }
    void adjust() { print("Adjusting Instrument"); }
}