package Medium.Array;

import java.util.ArrayList;
import java.util.List;

public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}},
            {{2,3},{1,3},{5,4},{6,4}}
        };

        for (int[][] matches : tests) {
            List<List<Integer>> answer = new FindPlayersWithZeroOrOneLosses_Solution().findWinners(matches);

            System.out.print("[");
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i).toString());
            }
            System.out.println("]");
        }
    }
}

// @see BetterCodeAnswer.Medium.Array.FindPlayersWithZeroOrOneLosses.java
class FindPlayersWithZeroOrOneLosses_Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();

        return answer;
    }
}
