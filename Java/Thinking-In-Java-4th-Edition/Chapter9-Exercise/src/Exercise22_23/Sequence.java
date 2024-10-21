package Exercise22_23;

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
        items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
    }

    private class reverseSelector implements Selector {
        private int i = items.length - 1;

        public boolean end() { return i < 0; }
        public Object current() { return items[i]; }
        public void next() { if(i >= 0) i--; }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector rselector() {
            return new reverseSelector();
        }
}