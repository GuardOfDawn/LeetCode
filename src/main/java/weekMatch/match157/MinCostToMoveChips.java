package weekMatch.match157;

public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] chips) {
        int res0 = 0;
        int res1 = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i]%2==0) {
                res0 ++;
            } else {
                res1 ++;
            }
        }
        return Math.min(res0, res1);
    }

}
