package BetterCodeAnswer.Medium.Array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,2,2},{1}},
            {{1,2,3,1,2,3,1,2},{2}},
            {{1,2,1,2,1,2,1,2},{1}},
            {{5,5,5,5,5,5,5},{4}},
            {{1},{1}},
            {{1,2},{1}},
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new LengthOfLongestSubarrayWithAtMostKFrequency_Solution().maxSubarrayLength(nums, k));
        }
    }
}

// 42 ms 65.5 MB
class LengthOfLongestSubarrayWithAtMostKFrequency_Solution {
    class Node {
        LinkedList<Integer> list = new LinkedList<>();
    }

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Node> cache = new HashMap<>();
        int start = 0;
        int end = 1;

        Node n = new Node();
        n.list.add(start);
        cache.put(nums[start], n);

        int max = 1;

        while (end < nums.length) {
            n = cache.get(nums[end]);
            if (n == null) {
                n = new Node();
                cache.put(nums[end], n);
            } else if (n.list.size() >= k) {
                int idx = n.list.peek();
                while (start <= idx) {
                    Node rn = cache.get(nums[start]);
                    rn.list.poll();
                    start++;
                }
            }

            n.list.add(end);

            if (end-start+1 > max) {
                max = end-start+1;
            }

            end++;
        } 
        return max;   
    }
}

// 30 ms 168.3 MB - Could get Memory Limit Exceed
class LengthOfLongestSubarrayWithAtMostKFrequency_Solution2 {
    public int maxSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] frequencies = new int[max - min + 1];

        int left = 0;
        
        int maxWindow = 0;

        for (int right = 0; right < nums.length; right++) {
            frequencies[nums[right] - min]++;

            while (frequencies[nums[right] - min] > k) {
                frequencies[nums[left] - min]--;

                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}