package systemOfEquations;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

import java.util.Scanner;

public class Vector extends Matrix {

    private RealVector constants;

    @Override
    public void set() {
        Scanner in = new Scanner(System.in);
        double[] vector = new double[size];
        System.out.println("Enter the components of vector: ");
        for (int i = 0; i < size; i++) {
            vector[i] = in.nextDouble();
        }
        constants = MatrixUtils.createRealVector(vector);
    }

    public RealVector get() {
        return constants;
    }
}
