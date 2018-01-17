
import java.util.*;

public class PSO {

    private Scanner scanner = new Scanner(System.in);
    private Swarm swarm;
    private Particle nBest;
    private Solution gBest;

    public PSO() {
        System.out.print("Enter 1 for random search, 2 for PSO: ");
        int c = scanner.nextInt();
        if (c == 1) {
            randomSearch();
        } else if (c == 2) {
            optimize();
        }
        scanner.close();
    }

    /**
     * Random search method. Searches by initializing a swarm and finding the
     * most fit particle from that swarm, for ITERATIONS number of swarms. The
     * result is the same number of evaluations is done as for PSO.
     */
    public void randomSearch() {
        swarm = new Swarm();
        double best = Double.MAX_VALUE;
        for (int i = 0; i < Problem.ITERATIONS; i++) {
            swarm.initialize();
            for (Particle p : swarm.getSwarm()) {
                if (p.fitness < best) {
                    best = p.fitness;
                }
            }
        }
        System.out.println("Overall best fitness: " + best);
    }

    /**
     * PSO method. This method executes the PSO algorithm and prints the results
     * to the console.
     */
    public void optimize() {
        //Initialize swarm and nBest        
        swarm = new Swarm();
        nBest = swarm.initNBest();
        gBest = new Solution(nBest.getPos(), Double.MAX_VALUE);
        nBest = swarm.initNBest();
        for (int i = 0; i < Problem.ITERATIONS; i++) {
            //Update pBest for all particles
            for (Particle p : swarm.getSwarm()) {
                //If current position is better than previous pBest
                if (i == 0 || p.getPBest().getFitness() > p.fitness) {
                    //Set new pBest
                    p.setPBest(new Solution(p.getPos(), p.fitness));
                }
            }
            //Updating neighbourhood best (when applicable)
            for (Particle p : swarm.particles) {
                if (p.fitness < nBest.fitness) {
                    nBest.setPos(p.getPos());
                    nBest.setVelocity(p.getVelocity());
                    nBest.evalFitness();
                }
            }
            //Updating global best (if applicable)
            if (nBest.fitness < gBest.getFitness()) {
                gBest.setPos(nBest.getPos());
                gBest.setFitness(nBest.fitness);
            }
            //Updating velocities and positions
            for (int j = 0; j < Problem.NUM_PARTICLES; j++) {
                //Calculate new velocity
                VelocityCalculator.calculate(swarm.getParticleAt(j),
                        new Solution(nBest));
                swarm.getParticleAt(j).updatePos(); //Update position
            }
        }
        System.out.println("Overall best fitness: " + gBest.getFitness());
    }

    public static void main(String[] args) {
        PSO pso = new PSO();
    }

}
