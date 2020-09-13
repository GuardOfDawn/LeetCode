package weekMatch.match157;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i]-difference;
            if (map.containsKey(key)) {
                map.put(arr[i], map.get(key)+1);
                if (difference!=0) {
                    map.remove(key);
                }
            } else {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                }
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue()>res) {
                res = entry.getValue();
            }
        }
        return res;
    }
}
