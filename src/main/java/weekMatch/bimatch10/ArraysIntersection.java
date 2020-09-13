package weekMatch.bimatch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysIntersection {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        int index2 = 0, index3 = 0;
        for (int i = 0; i < arr1.length; i++) {
            int index22 = Arrays.binarySearch(arr2, index2, arr2.length, arr1[i]);
            if (index22 >= 0) {
                int index33 = Arrays.binarySearch(arr3, index3, arr3.length, arr1[i]);
                if (index33 >= 0) {
                    res.add(arr1[i]);
                    index3 = index33;
                } else {
                    index33 = -index33 - 1;
                    if (index33 >= arr3.length) {
                        break;
                    }
                }
                index2 = index22;
            } else {
                index22 = -index22 - 1;
                if (index22 >= arr2.length) {
                    break;
                }
            }
        }
        return res;
    }
}
