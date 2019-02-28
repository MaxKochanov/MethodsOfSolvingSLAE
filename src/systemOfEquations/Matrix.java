package systemOfEquations;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.Scanner;

public class Matrix {


    static int size = 3;
    private RealMatrix matrix;

    public static int getSize() {
        return size;
    }

    public void set() {
        double[][] m = new double[size][size];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix of SLAE: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[i][j] = in.nextDouble();
            }
        }
        matrix = MatrixUtils.createRealMatrix(m);
    }

    public static double[][] getUnitMatrix() {
        double[][] m = new double[size][size];
        for (int i = 0; i < size; i++) {
            m[i][i] = 1;
        }
        return m;
    }

    public RealMatrix getMatrix() {
        return matrix;
    }
}
