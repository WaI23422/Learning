package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,2,3,4},
                {4},
                {3},
                {4}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                n = test[1][0],
                left = test[2][0],
                right = test[3][0];

            System.out.println(new RangeSumOfSortedSubarraySums_Solution().rangeSum(nums, n, left, right));
        }
    }
}

// 5ms 41.26MB
class RangeSumOfSortedSubarraySums_Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] prefSum = new int[n + 1];
        prefSum[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
        }
        prefSum[n] = prefSum[n - 1];

        int l = 0, r = prefSum[n - 1];
        while (l < r) {
            int m = (l + r) / 2;
            if (sumsLessThanNum(nums, m, prefSum) < right) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int rightSum = getSumOfSumsLessThanNum(nums, l, prefSum, right);

        l = 0;
        r = prefSum[n - 1];
        while (l < r) {
            int m = (l + r) / 2;
            if (sumsLessThanNum(nums, m, prefSum) < left - 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int leftSum = getSumOfSumsLessThanNum(nums, l, prefSum, left - 1);

        return rightSum - leftSum;
    }
    private int sumsLessThanNum(int[] nums, int num, int[] prefSum) {
        int cnt = 0;
        int l = 0, r = 0, n = nums.length;

        while (l < n) {
            if (r < n && (l != 0 ? prefSum[r] - prefSum[l - 1] : prefSum[r]) <= num) {
                r ++;
                continue;
            }

            cnt += r - l;

            l ++;
            if (r < l) {
                r = l;
            }
        }

        return cnt;
    }

    private int getSumOfSumsLessThanNum(int[] nums, int num, int[] prefSum, int limitOfCnt) {
        int sum = 0, cnt = 0;
        int l = 0, r = 0, n = nums.length;
        int M = 1_000_000_007, max = 0;

        while (l < n) {
            if (r < n && (l != 0 ? prefSum[r] - prefSum[l - 1] : prefSum[r]) <= num) {
                r ++;
                continue;
            }

            for (int i = l; i < r; i ++) {
                int toAdd = prefSum[i];

                if (l > 0) {
                    toAdd -= prefSum[l - 1];
                }

                if (toAdd > max) {
                    max = toAdd;
                }

                sum += toAdd;
                sum %= M;
            }
            cnt += r - l;

            l ++;
            if (r < l) {
                r = l;
            }
        }

        return sum - ((cnt - limitOfCnt) * max);
    }
}

// 64ms 41.28MB
class RangeSumOfSortedSubarraySums_Solution2 {

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            }
        );
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        int ans = 0, mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            int[] p = pq.poll();
            if (i >= left) ans = (ans + p[0]) % mod;
            if (p[1] < n - 1) {
                p[0] += nums[++p[1]];
                pq.offer(p);
            }
        }
        return ans;
    }
}

// 3ms 41.96MB
class RangeSumOfSortedSubarraySums_Solution3 {
    private static final int mod = 1000000007;

    private static class Pair {
        int count;
        long total;

        Pair(int count, long total) {
            this.count = count;
            this.total = total;
        }
    }

    private static Pair fSumOfK(int[] nums, int n, int target) {
        long currSum = 0, window = 0, total = 0;
        int count = 0;
        for (int i = 0, j = 0; j < n; j++) {
            currSum += nums[j];
            window += nums[j] * (j - i + 1);
            while (target < currSum) {
                window -= currSum;
                currSum -= nums[i++];
            }
            total += window;
            count += j - i + 1;
        }
        return new Pair(count, total % mod);
    }

    private static int findSum(int[] nums, int n, int k) {
        long right = Arrays.stream(nums).sum();
        int left = Arrays.stream(nums).min().getAsInt();
        while (left <= right) {
            int mid = (left + (int) right) / 2;
            if (fSumOfK(nums, n, mid).count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        Pair result = fSumOfK(nums, n, left);
        return (int) ((result.total - left * (result.count - k)) % mod);
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int res = (findSum(nums, n, right) - findSum(nums, n, left - 1)) % mod;
        return res;
    }
}