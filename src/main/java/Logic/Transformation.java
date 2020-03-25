package Logic;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Transformation {
    private RealMatrix matrixStiffness;
    private RealMatrix transformationMatrix;
    private RealMatrix transformedMatrix;
    private RealMatrix transformedReactions;
    private RealMatrix vectorReactions;
    private double alphaAngle;

    public Transformation(RealMatrix matrixData, double alphaAngleData, RealMatrix vectorReactionsData) {
        this.matrixStiffness = matrixData;
        this.alphaAngle = alphaAngleData;
        this.vectorReactions = vectorReactionsData;
    }

    private void creatingTransformationMatrix() {
        double[][] dataTransformation = {{Math.cos(alphaAngle), Math.sin(alphaAngle), 0, 0, 0, 0},
                {-Math.sin(alphaAngle), Math.cos(alphaAngle), 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, Math.cos(alphaAngle), Math.sin(alphaAngle), 0},
                {0, 0, 0, -Math.sin(alphaAngle), Math.cos(alphaAngle)},
                {0, 0, 0, 0, 0, 1}};

        transformationMatrix = MatrixUtils.createRealMatrix(dataTransformation);
    }

    private void transformMatrix(){
        transformedMatrix = (transformationMatrix.transpose()).multiply(matrixStiffness).multiply(transformationMatrix);
    }

    private void transformReactions(){
        transformedReactions = (transformationMatrix.transpose()).multiply(vectorReactions);
    }

    public RealMatrix getTransformedMatrix(){
        return transformedMatrix;
    }
    public RealMatrix getTransformedReactions(){
        return transformedReactions;
    }

}
