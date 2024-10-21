package Exercise6_7_8.Polymorphism.music;
import static net.mindview.util.Print.*; 

class Percussion extends Instrument {
    void play(Note n) { print("Percussion.play() " + n); }
    String what() { return "Percussion"; }
    void adjust() { print("Adjusting Percussion"); }
}

// 7: Add new Instrument:
class Saxophone extends Instrument{
    void play(Note n) { print("Saxophone.play() " + n); }
    String what() { return "Saxophone"; }
    void adjust() { print("Adjusting Saxophone"); }
}

class Woodwind extends Wind {
    void play(Note n) { print("Woodwind.play() " + n); }
    String what() { return "Woodwind"; }
}

public class Music3 {
    private static RandomInstrument gen = new RandomInstrument();
    // Doesn’t care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind(),
            new Saxophone()
        };
        tuneAll(orchestra);

        // 6: Add a loop to print Instrument:
        for (Instrument instrument : orchestra) {
            System.out.println(instrument.what());
        }

        // 8: Random generate:
        Instrument[] orchestra1 = new Instrument[9];
        // Fill up the array with shapes:
        for(int i = 0; i < orchestra1.length; i++)
            orchestra1[i] = gen.next();
        tuneAll(orchestra1);
    }
}