
import java.util.Vector;

public class VelocityCalculator {

    private static final double W = -1;
    private static final double C1 = 2;
    private static final double C2 = 2;

    /**
     * Calculates new velocity by applying vanilla PSO velocity update algorithm
     * on a particle's previous velocity vector.
     *
     * @param p The particle whose new velocity vector is being calculated.
     * @param gBest Global best solution.
     */
    public static void calculate(Particle p, Solution gBest) {
        Vector newVel = new Vector();
        for (int i = 0; i < p.getVelocity().size(); i++) {
            double r1 = Math.random();
            double r2 = Math.random();
            double v1 = p.getVelocity().get(i);
            double v2 = (W * v1)
                    + (C1 * r1 * (p.getPBest().getPos().get(i)
                    - p.getPos().get(i)))
                    + (C2 * r2 * (gBest.getPos().get(i)
                    - p.getPos().get(i)));
            newVel.add(v2);
        }
        p.setVelocity(newVel);
    }
}
