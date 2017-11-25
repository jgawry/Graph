package QuickSort;

import java.util.ArrayList;

/**
 * Created by Jakub on 2017-11-17.
 */
public class QuickSort {
    public ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        if (arr == null) {
            return null;
        }

        int arrLength = arr.size();

        if (arrLength > 1) {
            int pivot = arr.get(0);

            ArrayList<Integer> smaller = new ArrayList<>();
            ArrayList<Integer> bigger = new ArrayList<>();

            for (int i = 1; i < arrLength; i++) {
                Integer val = arr.get(i);

                if (val < pivot) {
                    smaller.add(val);
                } else {
                    bigger.add(val);
                }
            }

            smaller = quickSort(smaller);
            bigger = quickSort(bigger);

            ArrayList<Integer> result = new ArrayList(smaller.size() + bigger.size());

            result.addAll(smaller);
            result.add(pivot);
            result.addAll(bigger);

            return result;
        }

        return arr;
    }

    public int[] quickSort(int[] arr) {
        if (arr == null) {
            return null;
        }

        int arrLength = arr.length;

        if (arrLength > 1) {
            int pivot = arr[0];

            ArrayList<Integer> smaller = new ArrayList<>();
            ArrayList<Integer> bigger = new ArrayList<>();

            for (int i = 1; i < arrLength; i++) {
                Integer val = arr[i];

                if (val < pivot) {
                    smaller.add(val);
                } else {
                    bigger.add(val);
                }
            }

            int smallerSize = smaller.size();
            int biggerSize = bigger.size();
            int[] smArr = new int[smallerSize];
            int[] bgArr = new int[biggerSize];

            for (int i = 0; i < smallerSize; i++) {
                smArr[i] = smaller.get(i);
            }

            for (int i = 0; i < biggerSize; i++) {
                bgArr[i] = bigger.get(i);
            }

            smArr = quickSort(smArr);
            bgArr = quickSort(bgArr);

            int totalSize = smallerSize + biggerSize;
            int[] result = new int[totalSize + 1];

            int i;
            for (i = 0; i < smallerSize; i++) {
                result[i] = smArr[i];
            }

            result[i] = pivot;
            i++;

            for (int j = 0; j < biggerSize; j++, i++) {
                result[i] = bgArr[j];
            }

            return result;
        }

        return arr;
    }
}
