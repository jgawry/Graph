/**
 * Created by Jakub on 2017-11-24.
 */
public class MaxSumBitonic {
    public static int maxSumBitonicSequence(int[] arr) {
        int length = arr.length;
        int[] inc = new int[length];
        int[] dec = new int[length];

        for (int i = 0; i < length; i++) {
            inc[i] = 0;
            dec[i] = 0;
        }

        inc[0] = arr[0];
        for (int i = 1; i < length; i++) {
            int arrVal = arr[i];

            for (int j = 0; j < i; j++) {
                if (inc[i] < inc[j] + arrVal) {
                    if (arrVal >= arr[j]) {
                        inc[i] = inc[j] + arrVal;
                    } else {
                        inc[i] = arr[i];
                    }
                }
            }
        } //[80, 60, 30, 70, 20, 10]

        dec[length-1] = arr[length-1];

        for (int i = length - 2; i >=0; i--) {
            int arrVal = arr[i];

            for (int j = i + 1; j < length; j++) {
                if (dec[i] < dec[j] + arrVal) {
                    if (arrVal >= arr[j]) {
                        dec[i] = dec[j] + arrVal;
                    } else {
                        dec[i] = arr[i];
                    }
                }
            }
        } //80, 60, 30, 40, 20, 10 [210, 130, 60, 70, 30, 10]

        int max = 0;

        for (int i = 0; i < length; i++) {
            int curMax = inc[i] + dec[i] - arr[i];

            if (max < curMax) {
                max = curMax;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 15, 51, 45, 33, 100, 12, 18, 9};

        System.out.println(maxSumBitonicSequence(arr));
    }

}
