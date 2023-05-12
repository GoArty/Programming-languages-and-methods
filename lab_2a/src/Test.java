import java.util.Scanner;
public class Test {
    private static final int n = 10;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Universe univ1 = new Universe(n);
        univ1.newParticlesUniverse(1,1,1);
        univ1.newParticlesUniverse(2,2,2);
        System.out.println(univ1.getX() +" "+univ1.getY() +" "+univ1.getZ());
        Universe univ2 = new Universe(n);
        univ2.newParticlesUniverse(0,0,0);
        univ2.newParticlesUniverse(-1,-1,-1);
        System.out.println(univ2.getX() +" "+univ2.getY() +" "+univ2.getZ());
        double result = univ1.distanceBetweenUniverses(univ2);
        System.out.println(result);
/////////////////////
        Universe univ3 = new Universe(n);
        univ3.newParticlesUniverse(scan.nextInt(),scan.nextInt(),scan.nextInt());
        univ3.newParticlesUniverse(scan.nextInt(),scan.nextInt(),scan.nextInt());
        System.out.println(univ3.getX() +" "+univ3.getY() +" "+univ3.getZ());

        Universe univ4 = new Universe(n);
        univ4.newParticlesUniverse(scan.nextInt(),scan.nextInt(),scan.nextInt());
        univ4.newParticlesUniverse(scan.nextInt(),scan.nextInt(),scan.nextInt());
        System.out.println(univ4.getX() +" "+univ4.getY() +" "+univ4.getZ());

        System.out.println(result);

    }


}
