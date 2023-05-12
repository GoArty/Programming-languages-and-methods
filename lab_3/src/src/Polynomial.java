public class Polynomial implements Comparable<Polynomial> {
    private final int[] a_n;
    public Polynomial(int[] a_n) {
        this.a_n = a_n;
    }
    public int getNumberOfIntegerRoots() {
        int count = 0;
        for (int i = 0; i <= 10; i++)
            if (evaluate(i) < 0.001)
                count++;
        return count;
    }
    public double evaluate(int x) {
        double result = 0;
        for (int i = 0; i < a_n.length; i++)
            result += a_n[i] * Math.pow(x, i);
        return result;
    }
    @Override
    public int compareTo(Polynomial other) {
        return Integer.compare(this.getNumberOfIntegerRoots(), other.getNumberOfIntegerRoots());
    }
    @Override
    public String toString() {
        String result = "";
        for (int i = a_n.length - 1; i >= 0; i--)
            if (i == 0)
                result += (a_n[i] > 0 && i < a_n.length-1? "+" : "") + a_n[i];
            else if (a_n[i] != 0)
                result += (a_n[i] > 0 && i < a_n.length-1? "+" : "") + a_n[i] + "*x^" + i;
        return result;
    }
}
