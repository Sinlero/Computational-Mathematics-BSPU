package Topic1.Task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        Float[] inputData = {25.0F, 20.0F, 15.0F, 10.0F, 5.0F, 1.0F, 0.0F, -1.0F, -5.0F, -10.0F, -15.0F, -20.0F, -25.0F};
        List<Float> algorithmList = new ArrayList<>();
        List<Float> embeddedFunctionList = new ArrayList<>();
        List<Float> fixedAlgorithm = new ArrayList<>();
        for (Float x : inputData) {
            algorithmList.add(algorithmTaylor(x));
            embeddedFunctionList.add((float) Math.exp((x)));
            if (x < 0) {
                fixedAlgorithm.add(1 / algorithmTaylor(x * -1));
            } else {
                fixedAlgorithm.add(algorithmTaylor(x));
            }
        }
        System.out.println("Неустойчивый алгоритм");
        print(algorithmList, embeddedFunctionList, inputData);
        System.out.println();
        System.out.println("Устойчивый алгоритм");
        print(fixedAlgorithm, embeddedFunctionList, inputData);
    }

    public static Float algorithmTaylor(float x) {
        Float s = 1.0F;
        Float a = x;
        Float n = 1.0F;
        while (s + a != s) {
            s += a;
            n += 1;
            a = a * x / n;
        }
        return s;
    }

    static void print(List<Float> list1, List<Float> list2, Float[] inputData) {
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("x = %5s | algorithm = %15s | embedded = %15s | relative inaccuracy =%14s\n",
                               inputData[i], list1.get(i), list2.get(i), relativeInaccuracy(list1.get(i), list2.get(i)));
        }
    }

    public static Float relativeInaccuracy(float algorithm, float embedded) {
        return Math.abs(algorithm - embedded) / embedded;
    }
}
