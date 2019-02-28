package algorithm;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import systemOfEquations.Matrix;

public class Richardson extends IterationMethod { // works when matrix is symmetric and positively defined

    @Override
    protected double findParameter(RealMatrix A, RealVector constants, RealVector initData) {  // Gershgorin`s circles theorem
        double[][] matrix = A.getData();
        int size = Matrix.getSize();
        double lambdaMax = matrix[0][0];
        for (int i = 1; i < size; i++) {
            lambdaMax += Math.abs(matrix[0][i]);
        }
        double lambdaMin = matrix[0][0];
        for (int i = 1; i < size; i++) {
            lambdaMin -= Math.abs(matrix[0][i]);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    double temp = matrix[i][j];
                    for (int k = 0; k < size; k++) {
                        if (k != i) temp += Math.abs(matrix[i][k]);
                    }
                    if (temp > lambdaMax) lambdaMax = temp;
                    if (temp < lambdaMin) lambdaMin = temp;
                }
            }
        }
        return 2 / (lambdaMin + lambdaMax + 0.000001);
    }

    @Override
    public RealVector solve(RealMatrix A, RealVector b, RealVector x) {
        double parameter = findParameter(A, b, x);
        iterationCounter = 0;
        RealVector AxMinusB;
        do {
            RealVector Ax = A.operate(x);
            AxMinusB = Ax.subtract(b);
            RealVector temp = AxMinusB.mapMultiply(parameter);
            x = x.subtract(temp);
            incIterationCounter();
        } while (eps < AxMinusB.getNorm());
        return x;
    }
}
