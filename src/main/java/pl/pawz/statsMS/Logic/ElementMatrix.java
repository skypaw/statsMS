package pl.pawz.statsMS.Logic;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class ElementMatrix {
    private double eYoungModule;
    private double aCrossSection;
    private double iMomentOfInertia;
    private double lLengthOfBeam;

    private RealMatrix matrix;

    public ElementMatrix(double eData, double aData, double iData, double lData) {
        this.eYoungModule = eData;
        this.aCrossSection = aData;
        this.iMomentOfInertia = iData;
        this.lLengthOfBeam = lData;
        System.out.println("Matrix Object Created");
        creatingMatrix();
    }

    private void creatingMatrix() {
        double ma = eYoungModule * aCrossSection * Math.pow(lLengthOfBeam, 2) / Math.pow(lLengthOfBeam, 3);
        double m12 = 12 * eYoungModule * iMomentOfInertia / Math.pow(lLengthOfBeam, 3);
        double m6 = 6 * eYoungModule * iMomentOfInertia * lLengthOfBeam / Math.pow(lLengthOfBeam, 3);
        double m4 = 4 * eYoungModule * iMomentOfInertia * Math.pow(lLengthOfBeam, 2) / Math.pow(lLengthOfBeam, 3);
        double m2 = 2 * eYoungModule * iMomentOfInertia * Math.pow(lLengthOfBeam, 2) / Math.pow(lLengthOfBeam, 3);

        double[][] matrixData = {{ma, 0, 0, -ma, 0, 0},
                {0, m12, m6, 0, -m12, m6},
                {0, m6, m4, 0, -m6, m2},
                {-ma, 0, 0, ma, 0, 0},
                {0, -m12, -m6, 0, m12, -m6},
                {0, m6, m2, 0, -m6, m4}};
        matrix = MatrixUtils.createRealMatrix(matrixData);

        System.out.println(matrix);
    }

    public RealMatrix getMatrix() {
        return matrix;
    }


}
