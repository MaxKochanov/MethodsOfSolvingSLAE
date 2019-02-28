package algorithm;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

abstract class StraightMethod {

    public abstract RealVector solve(RealMatrix A, RealVector constants);

}

