package BetterCodeAnswer.Medium.Array;

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

// 21 ms 91.8 MB
class FindPlayersWithZeroOrOneLosses_Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];

        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];

            if (losses[win] == 0) {
                losses[win] = -1;
            } 

            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }

        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}