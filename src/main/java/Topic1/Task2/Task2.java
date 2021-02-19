package Topic1.Task2;

import java.util.ArrayList;

public class Task2 {

    public static void main(String[] args) {
        float[] inputData = {25, 20, 15, 10, 5, 1, 0, -1, -5, -10, -15, -20, -25};
        ArrayList<Float> algorithmList = new ArrayList<>();
        ArrayList<Float> embeddedFunctionList = new ArrayList<>();
        for (float inputdatum : inputData) {
            algorithmList.add(algorithmTaylor(inputdatum));
            embeddedFunctionList.add((float) Math.exp((inputdatum)));
        }
        print(algorithmList, embeddedFunctionList, inputData);
    }

    public static float algorithmTaylor(float x) {
        float s = 1.0F;
        float a = x;
        float n = 1.0F;
        while (s + a != s) {
            s += a;
            n += 1;
            a = a * x / n;
        }
        return s;
    }

    static void print(ArrayList<Float> list1, ArrayList<Float> list2, float[] indputData) {
        for (int i = 0; i < list1.size(); i++) {
            System.out.printf("x = %5s | algorithm = %15s | embedded = %15s | relative inaccuracy =%14s\n",
                               indputData[i], list1.get(i), list2.get(i), relativeInaccuracy(list1.get(i), list2.get(i)));
        }
    }

    public static Float relativeInaccuracy(float algorithm, float embedded) {
        return Math.abs(algorithm - embedded) / embedded;
    }
}
