package Exercise6_7_8.Polymorphism.music;

import java.util.Random;

public class RandomInstrument {
    private Random rand = new Random(100);
    
    public Instrument next() {

        switch(rand.nextInt(6)) {
            default:
                
            case 0: return new Wind();
                
            case 1: return new Percussion();
                
            case 2: return new Stringed();

            case 3: return new Brass();

            case 4: return new Woodwind();

            case 5: return new Saxophone(); 
        }
    }
}
           