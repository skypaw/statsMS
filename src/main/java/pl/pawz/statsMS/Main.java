package pl.pawz.statsMS;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import pl.pawz.statsMS.Logic.ElementMatrix;
import pl.pawz.statsMS.Logic.Loads;
import pl.pawz.statsMS.Logic.Transformation;

public class Main {
    public static void main(String[] args) {

        //Try to calculate the element from matrix
        RealMatrix localMatrix;

        double i = 3060 * Math.pow(10, -8);
        double a = 0.00396;
        double e = 210000000;
        double q = -5;
        double l = 5;

        ElementMatrix test1 = new ElementMatrix(e, a, i, l);

        localMatrix = test1.getMatrix();

        Loads test2 = new Loads(0, l, l, q, 0, "uniformlyLoad");
        RealMatrix uniformly = test2.getLoad();

        System.out.println(localMatrix);
        System.out.println(uniformly);

        //transformation to global
        Transformation test3 = new Transformation(localMatrix, 90, uniformly);
        RealMatrix transformed1 = test3.getTransformedMatrix();
        RealMatrix transformed2 = test3.getTransformedReactions();

        System.out.println(transformed1);
        System.out.println(transformed2);

        //global matrix
        for (int i1 = 0; i1 < 6; i1++) {
            if (transformed1.getEntry(i1, i1) == 0) {
                transformed1.setEntry(i1, i1, 1);
            }
            transformed1.setRow(3, new double[]{0, 0, 0, 0, 0, 0});
            transformed1.setRow(4, new double[]{0, 0, 0, 0, 0, 0});
            transformed1.setRow(5, new double[]{0, 0, 0, 0, 0, 0});
            transformed1.setColumn(3, new double[]{0, 0, 0, 0, 0, 0});
            transformed1.setColumn(4, new double[]{0, 0, 0, 0, 0, 0});
            transformed1.setColumn(5, new double[]{0, 0, 0, 0, 0, 0});
            transformed1.setEntry(3, 3, 1);
            transformed1.setEntry(4, 4, 1);
            transformed1.setEntry(5, 5, 1);
        }
        System.out.println(transformed1);

        RealMatrix p = transformed2.scalarMultiply(-1);
        p.setEntry(3,0,0);
        p.setEntry(4,0,0);
        p.setEntry(5,0,0);
        System.out.println(p);

        RealMatrix transformed1T = MatrixUtils.inverse(transformed1);
        System.out.println(transformed1T);
        RealMatrix qMatrix = transformed1T.multiply(p);
        System.out.println(qMatrix);

        // end of global matrix


        // local result
        RealMatrix qSmall = test3.getTransformationMatrix().multiply(qMatrix);
        System.out.println(qSmall);

        RealMatrix rR = localMatrix.multiply(qSmall).add(uniformly);
        System.out.println(rR);



    }
}
