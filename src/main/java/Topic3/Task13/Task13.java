package Topic3.Task13;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealMatrixFormat;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("||.||1 = " + thirdMatrix.getNorm()); // ||.||1 по столбцам
        getMaxNorm(secondMatrix);
        getMaxNorm(thirdMatrix);
    }

    public static void getMaxNorm(RealMatrix matrix) {  //  ||.||infinity по строкам
        List<Double> rowValues = new ArrayList<>();
        Double sum = new Double(0);
        double[][] data = matrix.getData();
        for (int i = 0; i < data.length; i++) {
            double[] row = matrix.getRow(i);
            for (int j = 0; j < row.length; j++) {
                sum += Math.abs(row[j]);
            }
            System.out.println(sum);
            sum = 0.0;
        }
    }
}
