package QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jakub on 2017-11-17.
 */
public class QuickSortRunner {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{2, 54,5,24,-2,3,-6543,4}));
        QuickSort qs = new QuickSort();

        int[] array = qs.quickSort(new int[]{2, 54,5,24,-2,3,-6543,4});

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}
