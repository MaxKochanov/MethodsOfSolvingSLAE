package algorithm;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import systemOfEquations.Matrix;

import java.io.FileWriter;

public class DataWriter {

    public void infoSolution(FileWriter file, RealMatrix matrixOfSystem, RealVector constants, RealVector initData,
                             RealVector solution, int iterationCounter) {
        try {
            double eps = IterationMethod.getEps();
            int size = Matrix.getSize();
            double[][] matr = matrixOfSystem.getData();
            file.write("The matrix of SLAE:\n");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    file.write(matr[i][j] + " ");
                }
                file.write("\n");

            }

            double[] vec1 = constants.toArray();
            file.write("\nThe vector of right side of SLAE:\n");
            for (int i = 0; i < size; i++) {
                file.write(vec1[i] + "\n");
            }

            double[] vec2 = initData.toArray();
            file.write("\nThe vector of initial data:\n");
            for (int i = 0; i < size; i++) {
                file.write(vec2[i] + "\n");
            }

            double[] vec3 = solution.toArray();
            file.write("\nThe vector of solution accurate to " + eps + " of SLAE:\n");
            for (int i = 0; i < size; i++) {
                file.write(vec3[i] + "\n");
            }
            file.write("\nThe number of iterations: " + iterationCounter + "\n");

            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void infoMatrix(FileWriter file, double[][] matrix, RealMatrix initMatr) {
        try {
            int size = Matrix.getSize();
            double[][] initMatrix = initMatr.getData();
            file.write("The initial matrix: \n");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    file.write(initMatrix[i][j] + " ");
                }
                file.write("\n");
            }
            file.write("The inverse matrix:\n");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    file.write(matrix[i][j] + " ");
                }
                file.write("\n");

            }
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
