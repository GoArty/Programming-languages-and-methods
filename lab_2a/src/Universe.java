import static java.lang.Math.*;
public class Universe {
    private static int number_universes;
    private final int particles;
    private int number_particles_this_universe = 0;
    private double x, y, z;
    Particles_universe[] univ;
    public Universe(int particles)
    {
        number_universes++;
        this.particles = particles;
        univ = new Particles_universe[this.particles];
    }
    private void centerUniverse()
    {
        double sup_x=0, sup_y=0, sup_z=0;
        for(int i = 0;i < number_particles_this_universe;i++)
        {
            sup_x += univ[i].getX();
            sup_y += univ[i].getY();
            sup_z += univ[i].getZ();
        }
        this.x = sup_x/number_particles_this_universe;
        this.y = sup_y/number_particles_this_universe;
        this.z = sup_z/number_particles_this_universe;
    }

    public void newParticlesUniverse(double x, double y, double z)
    {
        univ[number_particles_this_universe] = new Particles_universe(x, y, z);
        number_particles_this_universe++;
        centerUniverse();
    }

    public double distanceBetweenUniverses(Universe universal)
    {
        return sqrt(pow(universal.getX()-x,2)+pow(universal.getY()-y,2)+pow(universal.getZ()-z,2));
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
}
