package Exercise2_4;

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
        items[next++] = x;
    }
    public class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
        // Exercise 4 adding:
        public Sequence getSequence() { return Sequence.this; }
        // End adding.
    }
    public Selector selector() {
        return new SequenceSelector();
    }
}
