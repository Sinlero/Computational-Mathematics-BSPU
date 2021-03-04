package Topic2.Task5;

import Topic1.Task2.Task2;

public class Task5 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 8;
        for (int i = 1; i <= 8; i++) {
            n1 *= 10;
            sum(n1);
        }
        System.out.println();
        for (int i = 1; i <= 8; i++) {
            n2 *= 10;
            secondSum(n2);
        }
    }

    public static void sum(int n) {
        float value = 0.1F;
        float exactValue = value * n;
        int i;
        for (i = 1; i < n; i++) {
            value += 0.1F;
        }
        System.out.printf("|%10s | %13s| %10s | %13s |\n", i, value, exactValue,
                                                         Task2.relativeInaccuracy(value, exactValue) * 100);
    }

    public static void secondSum(int n) {
        float value = 0.125F;
        float exactValue = value * n;
        int i;
        for (i = 1; i < n; i++) {
            value += 0.125F;
        }
        System.out.printf("|%10s | %13s| %10s | %13s |\n", i, value, exactValue,
                                                         Task2.relativeInaccuracy(value, exactValue) * 100);
    }
}
