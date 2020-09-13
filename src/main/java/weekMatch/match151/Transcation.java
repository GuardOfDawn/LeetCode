package weekMatch.match151;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Transcation {
    public List<String> invalidTransactions(String[] transactions) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < transactions.length; i++) {
            int duration = 0;
            String tran = transactions[i];
            String[] parts = tran.split(",");
            if (Integer.parseInt(parts[2])>1000) {
                integers.add(i);
            }
            for (int j = i+1; j < transactions.length; j++) {
                String[] parts2 = transactions[j].split(",");
                if (parts[0].equals(parts2[0]) && !parts[3].equals(parts2[3]) && duration<=60) {
                    integers.add(i);
                    integers.add(j);
                }
                duration += Integer.parseInt(parts2[1]);
            }
        }
        List<String> res = new ArrayList<>();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            res.add(transactions[iterator.next()]);
        }
        return res;
    }
}
