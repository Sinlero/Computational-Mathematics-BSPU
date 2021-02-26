package Topic2.Task5;

public class Task5 {
    public static void main(String[] args) {
        sum(1_000_000_000);
    }

    public static void sum(int n) {
        float value = 0.1F;
        for (int i = 1; i <= n; i++) {
            value += 0.1F;
            System.out.printf("|%3s | %13s|\n", i, value);
        }
    }

    public static void secondSum(int n) {
        float value = 0.125F;
        for (int i = 1; i <= n; i++) {
            value += 0.125F;
            System.out.printf("|%3s | %13s|\n", i, value);
        }
    }
}
