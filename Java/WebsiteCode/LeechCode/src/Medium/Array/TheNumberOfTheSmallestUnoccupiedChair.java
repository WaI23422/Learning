package Medium.Array;

import java.util.Arrays;

public class TheNumberOfTheSmallestUnoccupiedChair {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {{33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063},{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821},{48548,48656},{87396,94825},{55273,81868},{75629,91467}},
                {{6}}
            },
            {
                {{3,10},{1,5},{2,6}},
                {{0}}
            },
            {
                {{1,4},{2,3},{4,6}},
                {{1}}
            }
        };

        for (int[][][] test : tests) {
            int times[][] = test[0],
                targetFriend = test[1][0][0];

            System.out.println(new TheNumberOfTheSmallestUnoccupiedChair_Solution().smallestChair(times, targetFriend));
        }
    }
}

// 113ms 49.76MB
class TheNumberOfTheSmallestUnoccupiedChair_Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        int n = times.length;
        int[] chairTime = new int[n];

        for (int[] time : times) {
            for (int i = 0; i < n; i++) {
                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, targetTime)) return i;
                    break;
                }
            }
        }
        return 0;
    }
}