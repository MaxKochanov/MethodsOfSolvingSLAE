package algorithm;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class GradientDescent extends IterationMethod { // works when matrix is symmetric and positively defined

    @Override
    protected double findParameter(RealMatrix A, RealVector x, RealVector b) {
        RealVector Ax = A.operate(x);
        RealVector r = Ax.subtract(b);
        RealVector Ar = A.operate(r);
        return r.dotProduct(r) / Ar.dotProduct(r);
    }

    @Override
    public RealVector solve(RealMatrix A, RealVector b, RealVector x) {
        RealVector r;
        iterationCounter = 0;
        do {
            RealVector Ax = A.operate(x);
            r = Ax.subtract(b);
            double parameter = findParameter(A, x, b);
            RealVector temp = r.mapMultiply(parameter);
            x = x.subtract(temp);
            incIterationCounter();
        } while (eps < r.getNorm());
        return x;
    }
}
