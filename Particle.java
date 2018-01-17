
import java.util.Vector;

public class Particle {

    private Vector<Double> pos; //Position vector
    private Vector<Double> VVector; //Velcity vector
    public double fitness = -1;
    private Solution pBest; //Personal best solution

    /**
     * Constructor
     *
     * @param v Vector<Double> containing velocity vector.
     * @param p Vector<Double> containing coordinate vector.
     */
    public Particle(Vector<Double> v, Vector<Double> p) {
        this.VVector = v;
        this.pos = p;
        evalFitness();
        pBest = new Solution(pos, fitness);
    }

    /**
     * Updates the position of the particle by applying velocity to coordinates.
     */
    public void updatePos() {
        for (int i = 0; i < VVector.size(); i++) {
            //If applying velocity would put the particle above the upper bound  
            //of the search space
            if (pos.get(i) + VVector.get(i) > Problem.UPPER) {
                pos.set(i, Problem.UPPER); //Place particle on the upper bound
                VVector.set(i, 0.0); //Set the velocity component to 0
            //Repeat for lower bound
            } else if (pos.get(i) + VVector.get(i) < Problem.LOWER) {
                pos.set(i, Problem.LOWER);
                VVector.set(i, 0.0);
            } else {
                pos.set(i, pos.get(i) + VVector.get(i));
            }
        }
        evalFitness();
    }

    public void setPos(Vector<Double> p) {
        this.pos = p;
    }

    public void setVelocity(Vector v) {
        this.VVector = v;
    }

    public void setPBest(Solution s) {
        this.pBest = s;
    }

    public Vector<Double> getPos() {
        return pos;
    }

    public Vector<Double> getVelocity() {
        return VVector;
    }

    public Solution getPBest() {
        return pBest;
    }

    public void evalFitness() {
        fitness = Problem.evaluate(pos);
    }

}
