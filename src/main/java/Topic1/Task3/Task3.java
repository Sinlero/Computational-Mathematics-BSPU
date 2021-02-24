package Topic1.Task3;

public class Task3 {

    public static void main(String[] args) {
        double p = 2 * Math.sqrt(2);
        System.out.println("Неустойчивый алгоритм");
        for (int i = 2; i <= 60; i++) {
            p = Math.pow(2, i) * Math.sqrt(2 * (1 - Math.sqrt(1 - Math.pow(p / Math.pow(2, i), 2))));
            System.out.printf("n = %2s | Pn = %s | inaccuracy = %s\n", i, p, relativeInaccuracy(p, Math.PI));
        }
        System.out.println("Устойчивый алгоритм");
        p = 2 * Math.sqrt(2);
        for (int i = 2; i <= 60; i++) {
            p = p * Math.sqrt(2 / (1 + Math.sqrt(1 - Math.pow(p / Math.pow(2, i), 2))));
            System.out.printf("n = %2s | Pn = %s | inaccuracy = %s\n", i, p, relativeInaccuracy(p, Math.PI));
        }
    }

    public static double relativeInaccuracy(double algorithm, double embedded) {
        return Math.abs(algorithm - embedded) / embedded;
    }
}
