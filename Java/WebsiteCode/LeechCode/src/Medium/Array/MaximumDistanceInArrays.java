package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        Integer[][][] tests = {
            {
                {-2},
                {-3,-2,1}
            },
            {
                {1,2,6},
                {4,5},
                {3,4,5}
            },
            {
                {1},
                {1}
            },
            {
                {1,2,3},
                {4,5},
                {1,2,3}
            },
        };

        for (Integer[][] test : tests) {
            List<List<Integer>> arrays = new ArrayList<>();
            for (Integer[] arr : test) {
                arrays.add(Arrays.asList(arr));
            }

            System.out.println(new MaximumDistanceInArrays_Solution().maxDistance(arrays));
        }

    }
}

// Brute-Force: Time Limit Exceeded
class MaximumDistanceInArrays_Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int len = arrays.size(),
            abs_max = Integer.MIN_VALUE;
        
        for (int i = 0; i < len; i++) {
            int min = arrays.get(i).getFirst();

            for (int j = 0; j < len; j++) {
                if (j != i) {
                    int max = Math.abs(min - arrays.get(j).getLast());

                    abs_max = Math.max(max, abs_max);
                }
            }
        }
        
        return abs_max;
    }
}

// 12ms 64.76MB -> 9ms 64.41MB
class MaximumDistanceInArrays_Solution2 {
    public int maxDistance(List<List<Integer>> arrays) {
        int smallest = arrays.get(0).getFirst();
        int biggest = arrays.get(0).getLast();
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            maxDistance = Math.max(maxDistance, Math.abs(arrays.get(i).getLast() - smallest));
            maxDistance = Math.max(maxDistance, Math.abs(biggest - arrays.get(i).getFirst()));
            smallest = Math.min(smallest, arrays.get(i).getFirst());
            biggest = Math.max(biggest, arrays.get(i).getLast());
        }

        return maxDistance;
    }
}