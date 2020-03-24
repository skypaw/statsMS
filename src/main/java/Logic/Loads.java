package Logic;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Loads {
    private double p;
    private double l;
    private double x;

    private RealMatrix loadMatrix;

    public Loads() {

    }

    private void pointLoad() {
        double mi = p * x * Math.pow(l - x, 2) / Math.pow(l, 2);
        double mk = p * Math.pow(x, 2) * (l - x) / Math.pow(l, 2);
        double q2 = p * (l - x) * (Math.pow(l, 2) + x * (l - x) - Math.pow(x, 2)) / Math.pow(l, 3);
        double q5 = p * x * (Math.pow(l, 2) + x * (l - x) - Math.pow(l - x, 2));

        double[][] pMatrixData = {{0}, {-q2}, {-mi}, {0}, {-q5}, {mk}};
        loadMatrix = MatrixUtils.createRealMatrix(pMatrixData);
    }

    private void uniformlyDistributedLoad() {
    }

    private void triangularDistributedLoad() {
    }

    private void pointMoment() {
    }

    private void trapezoidalDistributedLoad() {

    }

    public RealMatrix getLoad() {
        return loadMatrix;
    }
}
