import static java.lang.Math.*;
public class Vector {

    static private int n;
    private double[] coordinates;

    public Vector(int n, double[] coordinates)
    {
        this.n = n;
        this.coordinates = new double[this.n];
        for(int i = 0; i < n;i++)
            this.coordinates[i] = 0;
        for(int i = 0; i < coordinates.length;i++)
            this.coordinates[i] = coordinates[i];
    }
    public Vector sum(Vector vec_2)
    {
        double[] sup_coordinates = new double[this.n];
        for(int i = 0; i < n; i++)
            sup_coordinates[i] = coordinates[i] + vec_2.coordinates[i];

        Vector new_vec = new Vector(sup_coordinates.length, sup_coordinates);
        return new_vec;
    }
    public Vector subtraction(Vector vec_2)
    {
        double[] sup_coordinates = new double[this.n];
        for(int i = 0; i < n; i++)
            sup_coordinates[i] = coordinates[i] - vec_2.coordinates[i];

        Vector new_vec = new Vector(sup_coordinates.length, sup_coordinates);
        return new_vec;
    }


    public Vector normalization()
    {
        double[] sup_coordinates = new double[this.n];
        double size = size();
        for(int i = 0; i < n; i++)
            sup_coordinates[i] = coordinates[i]/size;

        Vector new_vec = new Vector(sup_coordinates.length, sup_coordinates);
        return new_vec;
    }

    public double size()
    {
        double sum = 0;
        for(int i = 0; i < n; i++)
            sum += this.coordinates[i] * this.coordinates[i];
        return sqrt(sum);
    }
    public void printVector()
    {
        for(int i = 0; i < n; i++)
            System.out.println(i + 1 +". " + coordinates[i]);
        System.out.println();
    }

}
