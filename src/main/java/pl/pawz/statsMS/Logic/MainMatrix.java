package pl.pawz.statsMS.Logic;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.HashMap;

public class MainMatrix {
    private int elements;

    public MainMatrix(int elementsData, HashMap<Object, String> test) {
        this.elements = elementsData;

        double[][]matTextData = {{0}};
        RealMatrix transformed1 = MatrixUtils.createRealMatrix(matTextData);

        RealMatrix podpory =MatrixUtils.createRealMatrix(matTextData);

        int countHashMap = test.size();
        System.out.println(countHashMap);

        for (int i1 = 0; i1 < countHashMap; i1++) {
            if (transformed1.getEntry(i1, i1) == 0) {
                transformed1.setEntry(i1, i1, 1);
            }
            if (podpory.getEntry(i1, i1) == 0) {

                double[] arrtest = new double[countHashMap];

                for (int iarr = 0; iarr < countHashMap; iarr++) {
                    arrtest[iarr] = 0;
                }
                transformed1.setRow(i1, arrtest);


            }
        }

    }
}
