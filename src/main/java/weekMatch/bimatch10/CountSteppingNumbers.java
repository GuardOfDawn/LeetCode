package weekMatch.bimatch10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountSteppingNumbers {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if (low<=0&&high>=0) {
            res.add(0);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;i<10;i++) {
            queue.add(i);
            if (low<=i&&high>=i) {
                res.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            String str = String.valueOf(cur);
            int tmp = str.charAt(str.length()-1) - '0' -1;
            int val = 0;
            if (tmp>-1) {
                val = cur*10+tmp;
                if (high >= val) {
                    queue.add(val);
                }
                if (low <= val && high >= val) {
                    res.add(val);
                } else {
                    if (high <= val) {
                        break;
                    }
                }
            }
            tmp = tmp+2;
            if (tmp<10) {
                val = cur*10+tmp;
                if (high>=val) {
                    queue.add(val);
                }
                if (low<=val&&high>=val) {
                    res.add(val);
                } else {
                    if (high<=val) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
