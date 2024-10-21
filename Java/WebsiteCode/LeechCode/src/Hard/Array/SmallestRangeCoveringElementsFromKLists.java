package Hard.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    public static void main(String[] args) {
        Integer[][][] tests = {
            {{1}},
            {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}}
            // 0-4-5-9-10-12-15-18-20-22-24-26-30
            // 0-4 : Have 0,4 not 5 -> 0-5 (Update len, range: 5, (0,5))
            // 4-5 : Have 4,5 not 9 -> 4-9 (len == old_len but 4 > 0 -> not update)
            // 5-9 : Have 5,9 not 10 -> 5-10 (len == old_len, skip)
            // 9-10 : 9-18 (len > old_len, skip)
            // 10-12: 10-22 (len > old_len, skip) 
            // 12-15: 12-18 (len > old_len, skip)
            // 15-18: 15-20 (len == old_len, skip)
            // 18-20: 18-24 (len > old_len, skip)
            // 20-22: 20-24 (Update)
            // 24 > min-limit (End).
        };

        for (Integer[][] test : tests) {
            List<List<Integer>> nums_list = new ArrayList<>();
            for (Integer[] nums : test) {
                nums_list.add(List.of(nums));
            }

            System.out.println(Arrays.toString(new SmallestRangeCoveringElementsFromKLists_Solution().smallestRange(nums_list)));
        }
    }   
}

// Time Limit Exceeded
class SmallestRangeCoveringElementsFromKLists_Solution1 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int nums_len = nums.size(),
            range[] = new int[2],
            min_limit = Integer.MAX_VALUE;
        if (nums_len == 1) {return new int[]{nums.get(0).get(0),nums.get(0).get(0)};}
        PriorityQueue<Integer> nums_order = new PriorityQueue<>();

        for (List<Integer> nums_list : nums) {
            min_limit = Math.min(nums_list.getLast(), min_limit);
            nums_order.addAll(nums_list);
        }

        int limit = nums_order.size()-1,
            range_min = Integer.MAX_VALUE;
        for (int i = 0; i < limit; i++) {
            int min = nums_order.poll(),
                max = nums_order.peek();
            if (min > min_limit) { break; }

            for (int j = 0; j < nums_len; j++) {
                List<Integer> list = nums.get(j);

                int num = Integer.MIN_VALUE,
                    k = 0;
                while (num < min && num < max) {
                    num = list.get(k++);
                }
                max = Math.max(max, num);
            }

            if (max - min < range_min) {
                range[0] = min; range[1] = max;
                range_min = max - min;
            }
        }

        return range;
    }
}

// 1852ms 48.91MB
class SmallestRangeCoveringElementsFromKLists_Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        // Stores the current index of each list
        int[] indices = new int[k];
        // To track the smallest range
        int[] range = new int[] { 0, Integer.MAX_VALUE };

        while (true) {
            int curMin = Integer.MAX_VALUE, curMax =
                Integer.MIN_VALUE, minListIndex = 0;

            // Find the current minimum and maximum values across the lists
            for (int i = 0; i < k; i++) {
                int currentElement = nums.get(i).get(indices[i]);

                // Update the current minimum
                if (currentElement < curMin) {
                    curMin = currentElement;
                    minListIndex = i;
                }

                // Update the current maximum
                if (currentElement > curMax) {
                    curMax = currentElement;
                }
            }

            // Update the range if a smaller one is found
            if (curMax - curMin < range[1] - range[0]) {
                range[0] = curMin;
                range[1] = curMax;
            }

            // Move to the next element in the list that had the minimum value
            if (++indices[minListIndex] == nums.get(minListIndex).size()) break;
        }

        return range;
    }
}