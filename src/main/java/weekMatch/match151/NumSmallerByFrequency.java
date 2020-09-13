package weekMatch.match151;

public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] a = new int[queries.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = numOfMin(queries[i]);
        }
        int[] b = new int[words.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = numOfMin(words[i]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i]<b[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public int numOfMin(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        char occur = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]<occur) {
                occur = chars[i];
                num = 1;
            } else if (chars[i] == occur) {
                num++;
            }
        }
        return num;
    }

}
