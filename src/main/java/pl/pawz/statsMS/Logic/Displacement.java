package pl.pawz.statsMS.Logic;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Displacement {
    private RealMatrix displacementMatrix;
    private double q1;
    private double q2;
    private double q3;
    private double q4;
    private double q5;
    private double q6;

    public Displacement(double q1Data, double q2Data, double q3Data, double q4Data, double q5Data, double q6Data) {
        this.q1 = q1Data;
        this.q2 = q2Data;
        this.q3 = q3Data;
        this.q4 = q4Data;
        this.q5 = q5Data;
        this.q6 = q6Data;
    }

    private void displacementMatrix() {
        double[][] data = {{q1}, {q2}, {q3}, {q4}, {q5}, {q6}};
        displacementMatrix = MatrixUtils.createRealMatrix(data);
    }

    public RealMatrix getDisplacementMatrix() {
        return displacementMatrix;
    }
}
