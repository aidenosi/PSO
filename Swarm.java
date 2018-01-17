import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Swarm {

    public ArrayList<Particle> particles;
    private VelocityCalculator VC;
    private Problem problem;
    private static Vector<Double> zeroVector;

    public Swarm() {
        initialize();
    }

    public Particle getParticleAt(int index) {
        return particles.get(index);
    }
    
    public ArrayList<Particle> getSwarm(){
        return particles;
    }

    /**
     * Method that initializes Swarm by randomly placing particles in search
     * space and setting velocities to 0.
     */
    public void initialize() {
        //Init particle collection, gBest particle, and zeroVector Vector.
        particles = new ArrayList();
        zeroVector = new Vector<>();
        for (int i = 0; i < Problem.DIMENSION; i++) {
            zeroVector.add(0.0);
        }
        //Using a random to generate particle positions
        Random rand = new Random();
        //Initializing particles
        for (int i = 0; i < Problem.NUM_PARTICLES; i++) {
            //Getting random x and y coordinates of particle
            Vector pos = new Vector();
            for (int j = 0; j < Problem.DIMENSION; j++) {
                pos.add(Problem.LOWER + rand.nextDouble() * (Problem.UPPER
                        - Problem.LOWER));
            }
            //Adding particle to swarm
            particles.add(new Particle(zeroVector, pos));
        }
    }
    
    /**
     * Initializes nBest particle to position vector with all coordinates at
     * -5.12, which results in this particle having the lowest possible fitness.
     */
    public Particle initNBest(){
        Vector<Double> gBestInitPos = new Vector<>();
        //Setting all coordinates to lower bound
        for(int i = 1; i <= Problem.DIMENSION; i++){
            gBestInitPos.add(Problem.LOWER);
        }
        return new Particle(zeroVector, gBestInitPos);
    }
}
