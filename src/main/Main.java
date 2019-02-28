package main;

import algorithm.*;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import systemOfEquations.Matrix;
import systemOfEquations.Vector;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        Matrix matrixOfSystem = new Matrix();
        matrixOfSystem.set();
        RealMatrix A = matrixOfSystem.getMatrix(); // преобразование матрицы в "библиотечную" матрицу

        Vector vec1 = new Vector();
        System.out.println("Right side of SLAE. ");
        vec1.set();
        RealVector b = vec1.get(); // преобразование вектора в "библиотечный" вектор

        Vector vec2 = new Vector();
        System.out.println("Initial data. ");
        vec2.set();
        RealVector x = vec2.get(); // преобразование вектора в "библиотечный" вектор

        GradientDescent system1 = new GradientDescent();
        RealVector solutionGD = system1.solve(A, b, x);
        int iterationCounterGD = system1.getIterationCounter();

        Richardson system2 = new Richardson();
        RealVector solutionR = system2.solve(A, b, x);
        int iterationCounterR = system2.getIterationCounter();

        Thomas system3 = new Thomas();
        RealVector solutionT = system3.solve(A, b);
        final int iterationCounterT = 1;

        GaussJordan system4 = new GaussJordan();
        double[][] inverseMatrix = system4.getInverseMatrix(A);

        try {
            FileWriter fileGD = new FileWriter("E:\\Java_projects\\gradient_descent\\src\\algorithm\\infoGradientDescent");
            DataWriter writerGD = new DataWriter();
            writerGD.infoSolution(fileGD, A, b, x, solutionGD, iterationCounterGD);

            FileWriter fileR = new FileWriter("E:\\Java_projects\\gradient_descent\\src\\algorithm\\infoRichardson");
            DataWriter writerR = new DataWriter();
            writerR.infoSolution(fileR, A, b, x, solutionR, iterationCounterR);

            FileWriter fileT = new FileWriter("E:\\Java_projects\\gradient_descent\\src\\algorithm\\infoThomas");
            DataWriter writerT = new DataWriter();
            writerT.infoSolution(fileT, A, b, x, solutionT, iterationCounterT);

            FileWriter fileGJ = new FileWriter("E:\\Java_projects\\gradient_descent\\src\\algorithm\\infoGaussJordan");
            DataWriter writerGJ = new DataWriter();
            writerGJ.infoMatrix(fileGJ, inverseMatrix, A);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
