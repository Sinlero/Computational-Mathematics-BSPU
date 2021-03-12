package Topic3.Task13;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealMatrixFormat;

public class Task13 {
    public static void main(String[] args) {
        double[][] firstData = {
                {3, -5, 4},
                {1, 5, -6}};
        int number = 8;
        RealMatrix firstMatrix = MatrixUtils.createRealMatrix(firstData);
        RealMatrixFormat output = new RealMatrixFormat("", "", "", "", "\n", "     ");
        System.out.printf("Исходная матрица:\n%s\n", output.format(firstMatrix));
        System.out.printf("Транспонированая матрица:\n%s\n", output.format(firstMatrix.transpose()));
        System.out.printf("Матрица умноженная на число %d:\n%s\n", number, output.format(firstMatrix.scalarMultiply(number)));
        double[][] secondData = {
                {7, 4, 9},
                {4, -3, -8}};
        RealMatrix secondMatrix = MatrixUtils.createRealMatrix(secondData);
        double[][] thirdData = {
                {1, 2},
                {6, 3},
                {7, 1}};
        RealMatrix thirdMatrix = MatrixUtils.createRealMatrix(thirdData);
        System.out.printf("Вторая матрица:\n%s\n", output.format(secondMatrix));
        System.out.printf("Результат сложения матриц:\n%s\n", output.format(firstMatrix.add(secondMatrix)));
        System.out.printf("Результат вычитания матриц:\n%s\n", output.format(firstMatrix.subtract(secondMatrix)));
        System.out.printf("Третья матрица:\n%s\n", output.format(thirdMatrix));
        System.out.printf("Результат перемножения матриц:\n%s\n", output.format(firstMatrix.multiply(thirdMatrix)));
    }
}
