import java.util.Scanner;
public class Main {
    static int n = 4;
    public static void main(String[] args) {
        double[] arr_1 = new double[n];
        arr_1[0] = 5; arr_1[1] =3; arr_1[2]=1;
        Vector vec_1 = new Vector(n, arr_1);
        Vector vec_2 = new Vector(n, arr_1);
        System.out.println("vec_1:");
        vec_1.printVector();
        System.out.println("vec_2:");
        vec_2.printVector();
        Vector vec_new_1 = vec_1.sum(vec_2);
        System.out.println("vec_new_1 = vec_1.sum(vec_2):");
        vec_new_1.printVector();
        System.out.println("vec_1:");
        vec_1.printVector();
        System.out.println("vec_2:");
        vec_2.printVector();

        Vector vec_new_2 = vec_1.subtraction(vec_2);
        System.out.println("vec_new_2 = vec_1.subtraction(vec_2):");
        vec_new_2.printVector();
        System.out.println("vec_1:");
        vec_1.printVector();
        System.out.println("vec_2:");
        vec_2.printVector();

        Vector vec_new_3 = vec_new_1.normalization();
        System.out.println("vec_new_3 = vec_new_1.normalization() :");
        vec_new_3.printVector();
        System.out.println("vec_new_1:");
        vec_new_1.printVector();
        /////////////////////////////////////////////////
        Scanner scan = new Scanner(System.in);
        double[] arr_2 = new double[n];
        double[] arr_3 = new double[n];

        for(int i = 0; i < n; i++)
        {
            if(scan.hasNextDouble())
                arr_2[i] = scan.nextDouble();
            else
            {
                System.out.println("Error");
                break;
            }
        }
        Vector vec_3 = new Vector(n, arr_2);

        for(int i = 0; i < n; i++)
        {
            if(scan.hasNextDouble())
                arr_3[i] = scan.nextDouble();
            else
            {
                System.out.println("Error");
                break;
            }
        }
        Vector vec_4 = new Vector(n, arr_3);
        System.out.println("vec_3:");
        vec_3.printVector();
        System.out.println("vec_4:");
        vec_4.printVector();
        Vector vec_sum_vec_1__vec_3 = vec_3.sum(vec_4);
        System.out.println("vec_sum_vec_1__vec_3:");
        vec_sum_vec_1__vec_3.printVector();

    }
}
