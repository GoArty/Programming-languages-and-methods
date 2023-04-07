public class Particles_universe {
    private static long number_particles_universe;
    private double x, y, z;
    public Particles_universe(double x, double y, double z)
    {
        number_particles_universe++;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
    public double getZ()
    {
        return this.z;
    }
    public long getN()
    {
        return number_particles_universe;
    }
}
