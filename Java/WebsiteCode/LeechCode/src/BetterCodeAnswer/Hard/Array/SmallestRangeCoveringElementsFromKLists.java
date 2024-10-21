package BetterCodeAnswer.Hard.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

// 35ms 48.56MB
class SmallestRangeCoveringElementsFromKLists_Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        // Priority queue to store (value, list index, element index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        int maxVal = Integer.MIN_VALUE, rangeStart = 0, rangeEnd =
            Integer.MAX_VALUE;

        // Insert the first element from each list into the min-heap
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[] { nums.get(i).get(0), i, 0 });
            maxVal = Math.max(maxVal, nums.get(i).get(0));
        }

        // Continue until we can't proceed further
        while (pq.size() == nums.size()) {
            int[] data = pq.poll();
            int minVal = data[0], row = data[1], col = data[2];

            // Update the smallest range
            if (maxVal - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = maxVal;
            }

            // If possible, add the next element from the same row to the heap
            if (col + 1 < nums.get(row).size()) {
                int nextVal = nums.get(row).get(col + 1);
                pq.offer(new int[] { nextVal, row, col + 1 });
                maxVal = Math.max(maxVal, nextVal);
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }
}

// 35ms 54.52MB
class SmallestRangeCoveringElementsFromKLists_Solution2 {

    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> merged = new ArrayList<>();

        // Merge all lists with their list index
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                merged.add(new int[] { num, i });
            }
        }

        // Sort the merged list
        merged.sort(Comparator.comparingInt(a -> a[0]));

        // Two pointers to track the smallest range
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        for (int right = 0; right < merged.size(); right++) {
            freq.put(
                merged.get(right)[1],
                freq.getOrDefault(merged.get(right)[1], 0) + 1
            );
            if (freq.get(merged.get(right)[1]) == 1) count++;

            // When all lists are represented, try to shrink the window
            while (count == nums.size()) {
                int curRange = merged.get(right)[0] - merged.get(left)[0];
                if (curRange < rangeEnd - rangeStart) {
                    rangeStart = merged.get(left)[0];
                    rangeEnd = merged.get(right)[0];
                }

                freq.put(
                    merged.get(left)[1],
                    freq.get(merged.get(left)[1]) - 1
                );
                if (freq.get(merged.get(left)[1]) == 0) count--;
                left++;
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }
}

// 10ms 49MB
class SmallestRangeCoveringElementsFromKLists_Solution3 {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) {
            return new int[] { nums.get(0).get(0), nums.get(0).get(0) };
        }
        int k = nums.size();
        int minK = nums.get(0).get(0), minArr = 0;
        int maxK = nums.get(0).get(0);
        for (int i = 1; i < k; ++i) {
            List<Integer> list = nums.get(i);
            int val = list.get(0);
            if (val > maxK) {
                maxK = val;
            }
            if (val < minK) {
                minK = val;
                minArr = i;
            }
        }
        int[] ret = new int[] { minK, maxK };
        int[] pos = new int[k];
        boolean done = false;
        int curListLen;
        while (!done) {
            List<Integer> curMinList = nums.get(minArr);
            pos[minArr]++;
            if (curMinList.size() == pos[minArr]) {
                done = true;
                continue;
            }
            int next = curMinList.get(pos[minArr]);
            minK = next;
            for (int i = 0; i < k; ++i) {
                curMinList = nums.get(i);
                curListLen = curMinList.size();
                for (int curIdx = pos[i]; curIdx < curListLen && curMinList.get(curIdx) <= next; curIdx++) {
                    pos[i] = curIdx;
                }
                int curVal = curMinList.get(pos[i]);
                if (curVal < minK) {
                    minK = curVal;
                    minArr = i;
                }
                if (curVal > maxK) {
                    maxK = curVal;
                }
            }
            if (maxK - minK < ret[1] - ret[0]) {
                ret[1] = maxK;
                ret[0] = minK;
            }
        }
        return ret;
    }
}