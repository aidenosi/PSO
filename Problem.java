
import java.util.Vector;

public class Problem {

    static final int DIMENSION = 25;
    static final int NUM_PARTICLES = 30;
    static final double LOWER = -5.12;
    static final double UPPER = 5.12;
    static final int ITERATIONS = 5000;

    /**
     * Finds the fitness of a position by applying the fitness function
     * (Rastrigin function) to the given position.
     *
     * @param pos The position to find the fitness of.
     * @return double Fitness of the position.
     */
    public static double evaluate(Vector<Double> pos) {
        double fitness = 10 * DIMENSION;

        for (double x : pos) {
            fitness += Math.pow(x, 2) - (10 * Math.cos(2 * Math.PI * x));
        }
        return fitness;
    }
}
