package algorithm;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import systemOfEquations.Matrix;

public class Thomas extends StraightMethod {

    @Override
    public RealVector solve(RealMatrix A, RealVector constants) { // works when matrix is three-diagonal

        int size = Matrix.getSize();
        double[][] matrix = A.getData();
        double[] vector = constants.toArray();
        double[] csi = new double[size + 1];
        double[] eta = new double[size + 1];
        double[] x = new double[size + 1];
        double[] a = new double[size];
        double[] b = new double[size];
        double[] c = new double[size];

        for (int i = 1; i < size; i++) {
            a[i] = matrix[i][i - 1];
        }

        for (int i = 0; i < size; i++) {
            b[i] = matrix[i][i];
        }

        for (int i = 0; i < size - 1; i++) {
            c[i] = matrix[i][i + 1];
        }

        for (int i = 1; i < size + 1; i++) {
            csi[i] = -c[i - 1] / (a[i - 1] * csi[i - 1] + b[i - 1]);
        }
        for (int i = 1; i < size + 1; i++) {
            eta[i] = (vector[i - 1] - a[i - 1] * eta[i - 1]) / (a[i - 1] * csi[i - 1] + b[i - 1]);
        }
        for (int i = size - 1; i >= 0; i--) {
            x[i] = csi[i + 1] * x[i + 1] + eta[i + 1];
        }
        return MatrixUtils.createRealVector(x);
    }

}
