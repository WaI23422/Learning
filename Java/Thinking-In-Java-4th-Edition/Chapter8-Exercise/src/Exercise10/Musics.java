package Exercise10;

/**
 * Refactor Musics.java by moving the common methods in Wind, Percussion and Stringed into an abstract class.
 */

import Exercise9.Note.*;
import static net.mindview.util.Print.*;

interface Playable {
  void play(Note n);
}

interface Instrument {
  int VALUE = 5;
  void adjust();
}

class Wind implements Instrument, Playable  {
  public void play(Note n) {
    print(this + ".play() " + n);
  }
  public String toString() { return "Wind"; }
  public void adjust() { print(this + ".adjust()"); }
}

class Percussion implements Instrument, Playable  {
  public void play(Note n) {
    print(this + ".play() " + n);
  }
  public String toString() { return "Percussion"; }
  public void adjust() { print(this + ".adjust()"); }
}

class Stringed implements Instrument, Playable  {
  public void play(Note n) {
    print(this + ".play() " + n);
  }
  public String toString() { return "Stringed"; }
  public void adjust() { print(this + ".adjust()"); }
}

class Brass extends Wind {
  public String toString() { return "Brass"; }
}	

class Woodwind extends Wind {
  public String toString() { return "Woodwind"; }
}

public class Musics {

  static void tune(Playable p) {
    // ...
    p.play(Note.MIDDLE_C);
  }
  static void tuneAll(Playable[] e) {
    for(Playable p : e)
      tune(p);
  }	
  public static void main(String[] args) {

    Playable[] orchestra = {
      new Wind(),
      new Percussion(),
      new Stringed(),
      new Brass(),
      new Woodwind()
    };
    tuneAll(orchestra);
  }
}