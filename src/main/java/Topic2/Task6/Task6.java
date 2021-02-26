package Topic2.Task6;

import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) {
        int realI;
        for (int i = 1; i <= 101; i++) {
            realI = i;
            System.out.printf("|%3s|%10s|%10s|%10s|%10s|\n", --realI,
                    pointOne(oneArray(i)),
                    pointTwo(positiveArray(i), negativeArray(i)),
                    pointThree(oneArray(i)),
                    pointFour(positiveArray(i), negativeArray(i)));
        }
    }

    public static Float pointOne(ArrayList<Float> arrayList) {
        Float result = 0.0F;
        for (Float aFloat : arrayList) {
            result += aFloat;
        }
        return result;
    }

    public static Float pointTwo(ArrayList<Float> positiveArray, ArrayList<Float> negativeArray) {
        Float positiveResult = 0.0F;
        Float negativeResult = 0.0F;
        for (Float aFloat : positiveArray) {
            positiveResult += aFloat;
        }
        for (Float aFloat : negativeArray) {
            negativeResult += aFloat;
        }
        return positiveResult + negativeResult;
    }

    public static Float pointThree(ArrayList<Float> arrayList) {
        Float result = 0.0F;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            result += arrayList.get(i);
        }
        return result;
    }

    public static Float pointFour(ArrayList<Float> positiveArray, ArrayList<Float> negativeArray) {
        Float positiveResult = 0.0F;
        Float negativeResult = 0.0F;
        for (int i = positiveArray.size() - 1; i >= 0; i--) {
            positiveResult += positiveArray.get(i);
        }
        for (int i = negativeArray.size() - 1; i >= 0; i--) {
            negativeResult += negativeArray.get(i);
        }
        return positiveResult + negativeResult;
    }

    public static ArrayList<Float> oneArray(int n) {
        Float result;
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            result = function(i);
            arrayList.add(result);
        }
        return arrayList;
    }

    public static ArrayList<Float> positiveArray(int n) {
        Float result;
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            result = function(i);
            if (result > 0) {
                arrayList.add(result);
            }
        }
        return arrayList;
    }

    public static ArrayList<Float> negativeArray(int n) {
        Float result;
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            result = function(i);
            if (result < 0) {
                arrayList.add(result);
            }
        }
        return arrayList;
    }

    public static Float function(int value) {
        return (float) (-Math.pow(-1, value) * 1 / value);
    }
}
