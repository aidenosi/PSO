
import java.util.Vector;

public class Solution {

    private Vector<Double> pos; //Position vector
    private double fitness;

    /**
     * Constructor using position vector and fitness value.
     *
     * @param p Position vector.
     * @param f Fitness value.
     */
    public Solution(Vector<Double> p, double f) {
        this.pos = p;
        this.fitness = f;
    }

    /**
     * Constructor using a particle.
     *
     * @param p Particle used to fill position vector and fitness value.
     */
    public Solution(Particle p) {
        this.pos = p.getPos();
        this.fitness = p.fitness;
    }
    
    public void setPos(Vector<Double> pos){
        this.pos = pos;
    }
    
    public void setFitness(double fitness){
        this.fitness = fitness;
    }

    public Vector<Double> getPos() {
        return pos;
    }

    public double getFitness() {
        return fitness;
    }

}
