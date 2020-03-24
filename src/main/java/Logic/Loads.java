package Logic;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Loads {
    private double p;
    private double l;
    private double x;
    private double q;
    private double m;

    private RealMatrix loadMatrix;

    public Loads(double pData, double lData, double xData, double qData, double mData) {
        this.p = pData;
        this.l = lData;
        this.x = xData;
        this.q = qData;
        this.m = mData;
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
        double mi = q * Math.pow(l, 2) / 12;
        double mk = q * Math.pow(l, 2) / 12; //Doubled, because there is a chance to add another solution for trapezoidal load
        double q2 = q * l / 2;
        double q5 = q * l / 2;

        double[][] pMatrixData = {{0}, {-q2}, {-mi}, {0}, {-q5}, {mk}};
        loadMatrix = MatrixUtils.createRealMatrix(pMatrixData);
    }

    private void triangularDistributedLoad() {
        double mi = q * Math.pow(l, 2) / 30;
        double mk = q * Math.pow(l, 2) / 20;
        double q2 = 3 * q * l / 20;
        double q5 = 7 * q * l / 20;

        double[][] pMatrixData = {{0}, {-q2}, {-mi}, {0}, {-q5}, {mk}};
        loadMatrix = MatrixUtils.createRealMatrix(pMatrixData);
    }

    private void pointMoment() {
        double mi = m * (l - x) * (3 * (l - x) - 2 * l) / Math.pow(l, 2); // Todo - Check when Moment is clockwise - -/+ mi/mk
        double mk = m * x * (2 * l - 3 * x) / Math.pow(l, 2);
        double q2 = 3 * m / l * (1 - (Math.pow(x, 2) + Math.pow(l - x, 2)) / Math.pow(l, 2));
        double q5 = 3 * m / l * (1 - (Math.pow(x, 2) + Math.pow(l - x, 2)) / Math.pow(l, 2));

        double[][] pMatrixData = {{0}, {q2}, {-mi}, {0}, {-q5}, {mk}};
        loadMatrix = MatrixUtils.createRealMatrix(pMatrixData);
    }

    private void trapezoidalDistributedLoad() {
        // Todo - triangular + uniformly = trapezoidal
    }


    public RealMatrix getLoad() {
        return loadMatrix;
    }


}
