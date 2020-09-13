package weekMatch.bimatch14;

import javafx.collections.transformation.SortedList;

import java.util.Map;
import java.util.TreeMap;

public class Leaderboard {

    public static void main(String[] args) {
        Leaderboard obj = new Leaderboard();
        obj.addScore(1,73);
        obj.addScore(2,56);
        obj.addScore(3,39);
        obj.addScore(4,51);
        obj.addScore(5,4);
        obj.reset(1);
        obj.reset(2);
        int param_2 = obj.top(3);
        System.out.println(param_2);
    }

    private TreeMap<Player, Integer> board;

    public Leaderboard() {
        board = new TreeMap<>((a,b)->b.score-a.score);

    }

    public void addScore(int playerId, int score) {
        Player p = new Player();
        p.playerId = playerId;
        p.score = score;
        if (board.containsKey(p)) {
            int last = board.remove(p);
            p.score += last;
            board.put(p, p.score);
        } else {
            board.put(p, p.score);
        }
    }

    public int top(int K) {
        int res = 0;
        for (Map.Entry<Player, Integer> entry:board.entrySet()) {
            if (K>0) {
                res += entry.getValue();
                K--;
            } else {
                break;
            }
        }
        return res;
    }

    public void reset(int playerId) {
        Player p = new Player();
        p.playerId = playerId;
        board.remove(p);
    }

    class Player {
        int playerId;
        int score;

        @Override
        public int hashCode() {
            return playerId;
        }

        @Override
        public boolean equals(Object p) {
            if (p instanceof Player) {
                if (p==null) {
                    return false;
                }
                return playerId == ((Player) p).playerId;
            } else {
                return false;
            }
        }
    }

}
