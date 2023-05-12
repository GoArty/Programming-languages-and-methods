import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        Polynomial[] polynomials = new Polynomial[5];
        polynomials[0] = new Polynomial(new int[]{1, 0, -1});
        polynomials[1] = new Polynomial(new int[]{1, 0, 0, -1});
        polynomials[2] = new Polynomial(new int[]{1, 0, 1, 0, -1});
        polynomials[3] = new Polynomial(new int[]{1, 1, 1});
        polynomials[4] = new Polynomial(new int[]{1, -1});
        Arrays.sort(polynomials);
        for (Polynomial p : polynomials) {
            System.out.println(p);
        }
    }
}
