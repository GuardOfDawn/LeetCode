package weekMatch.bimatch10;

import java.util.HashMap;
import java.util.Map;

public class IsValidPalindrome {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean isValidPalindrome(String s, int k) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length/2;i++) {
            if (chars[i]==chars[chars.length-1-i]) {
                continue;
            } else {
                if (k<=0) {
                    map.put(s, false);
                    return false;
                }
                return isValidPalindrome(s.substring(i+1, chars.length-i), k-1) ||
                        isValidPalindrome(s.substring(i, chars.length-1-i), k-1);
            }
        }
        map.put(s, true);
        return true;
    }
}
