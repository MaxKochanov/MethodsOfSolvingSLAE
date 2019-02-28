package algorithm;

import org.apache.commons.math3.linear.RealMatrix;
import systemOfEquations.Matrix;

public class GaussJordan {

    public double[][] getInverseMatrix(RealMatrix A) {

        int size = Matrix.getSize();
        double[][] matrix = A.getData();
        double[][] inverseMatrix = Matrix.getUnitMatrix();

        for (int i = 0; i < size - 1; i++) { // top-triangular view
            for (int j = i + 1; j < size; j++) {
                double koef = matrix[j][i] / matrix[i][i];
                for (int k = 0; k < size; k++) {
                    inverseMatrix[j][k] -= inverseMatrix[i][k] * koef;
                    if (k >= i) matrix[j][k] -= matrix[i][k] * koef;
                }
            }
        }

        for (int i = size - 1; i >= 0; i--) { // bot-triangular view
            for (int j = i - 1; j >= 0; j--) {
                double koef = matrix[j][i] / matrix[i][i];
                for (int k = size - 1; k >= 0; k--) {
                    inverseMatrix[j][k] -= inverseMatrix[i][k] * koef;
                    if (k <= i) matrix[j][k] -= matrix[i][k] * koef;
                }
            }
        }

        for (int i = 0; i < size; i++) { // get ones on the diagonal
            double koef = matrix[i][i];
            for (int j = 0; j < size; j++) {
                inverseMatrix[i][j] /= koef;
            }
        }

        return inverseMatrix;
    }
}
