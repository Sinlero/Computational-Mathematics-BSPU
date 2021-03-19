package Topic3.Task13;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealMatrixFormat;

import java.util.ArrayList;
import java.util.Arrays;

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

        System.out.println("||.||1 = " + firstMatrix.getNorm());
        System.out.println("||.||1 = " + secondMatrix.getNorm());
        System.out.println("||.||1 = " + thirdMatrix.getNorm());

        System.out.println("||.||e = " + firstMatrix.getFrobeniusNorm());
        System.out.println("||.||e = " + secondMatrix.getFrobeniusNorm());
        System.out.println("||.||e = " + thirdMatrix.getFrobeniusNorm());

//        System.out.println("||.||e = " + getEuclidNorm(firstMatrix));
//        System.out.println("||.||e = " + getEuclidNorm(secondMatrix));
//        System.out.println("||.||e = " + getEuclidNorm(thirdMatrix));

        System.out.println("||.||infinity = " + getMaxNorm(firstMatrix));
        System.out.println("||.||infinity = " + getMaxNorm(secondMatrix));
        System.out.println("||.||infinity = " + getMaxNorm(thirdMatrix));

    }

    public static Double getMaxNorm(RealMatrix matrix) {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < matrix.getData().length; i++) {
            list.add(Arrays.stream(matrix.getRow(i))
                    .map(Math::abs)
                    .sum());
        }
        return list.stream().max(Double::compareTo).get();
    }

    public static Double getEuclidNorm(RealMatrix matrix) {
        double[][] data = matrix.getData();
        Double sum = Arrays.stream(data)
                .map(s -> Arrays.stream(s)
                        .map(x -> Math.pow(x, 2))
                        .sum())
                .mapToDouble(Double::doubleValue)
                .sum();
        return Math.sqrt(sum);
    }
}
