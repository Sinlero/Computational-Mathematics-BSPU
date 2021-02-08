package Topic1;

public class Task2 {
    public static void main(String[] args) {
        for (float i = -25; i <= 25; i = i + 5) {
            System.out.printf("x = %f, taylor = %f\n", i, taylor(i));
        }
        System.out.printf("x = %f, taylor = %f\n", 1.0, taylor(1.0F));
        System.out.printf("x = %f, taylor = %f\n", -1.0, taylor(-1.0F));
    }

    public static float taylor(float x) {
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
}
