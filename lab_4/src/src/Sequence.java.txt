import java.util.Iterator;
public class Sequence implements Iterable<Integer> {
    private int[] sequence;
    public Sequence(int... sequence) {
        this.sequence = sequence;
    }
    public void set(int index, int value) {
        sequence[index] = value;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new NeighborIterator();
    }
    private class NeighborIterator implements Iterator<Integer> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < sequence.length - 1;
        }
        @Override
        public Integer next() {
            int next = sequence[index] + sequence[index + 1];
            index++;
            return next;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
