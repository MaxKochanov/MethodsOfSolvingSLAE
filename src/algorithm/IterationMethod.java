package algorithm;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

abstract class IterationMethod {

    int iterationCounter;

    static double eps = 0.001;

    public static double getEps() {
        return eps;
    }

    void incIterationCounter() {
        iterationCounter++;
    }

    public int getIterationCounter() {
        return iterationCounter;
    }

    abstract protected RealVector solve(RealMatrix A, RealVector constants, RealVector initData);
    abstract protected double findParameter(RealMatrix A, RealVector constants, RealVector initData);

}
