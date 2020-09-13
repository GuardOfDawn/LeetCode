package weekMatch.bimatch14;

import java.util.ArrayList;
import java.util.List;

public class TransformArray {
    public List<Integer> transformArray(int[] arr) {
        int[] change = new int[arr.length];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i=1;i<arr.length-1;i++) {
                if (arr[i]>arr[i-1] && arr[i]>arr[i+1]) {
                    change[i] = -1;
                    changed = true;
                }
                if (arr[i]<arr[i-1] && arr[i]<arr[i+1]) {
                    change[i] = 1;
                    changed = true;
                }
            }
            if (changed) {
                for (int i = 1; i < arr.length-1; i++) {
                    arr[i] += change[i];
                    change[i] = 0;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
