<?php

// 151ms 27.70MB 
class Solution2 {

    /**
     * @param int[] $nums
     * @param int $k
     * @return int
     */
    function shortestSubarray($nums, $k) {
        $MAX_N = 100001;
        $st_s = array_fill(0, $MAX_N, 0);
        $pos = array_fill(0, $MAX_N, 0);

        $n = count($nums);
        $sp = 0;
        $res = $n + 1;

        $b = 0;
        $e = 0;
        $st_s[$e] = 0;
        $pos[$e++] = -1;

        for ($i = 0; $i < $n; $i++) {
            $sp += $nums[$i];

            while ($b < $e && $sp - $st_s[$b] >= $k) {
                $res = min($res, $i - $pos[$b]);
                $b++;
            }

            while ($b < $e && $sp <= $st_s[$e - 1]) {
                $e--;
            }
            $st_s[$e] = $sp;
            $pos[$e++] = $i;
        }

        if ($res == $n + 1) {
            return -1;
        }
        return $res;
    }
}

// 2907ms 36.87MB
class Solution
{

    /**
     * @param int[] $nums
     * @param int $k
     * @return int
     */
    function shortestSubarray($nums, $k)
    {
        $res = PHP_INT_MAX; // Equivalent to Integer.MAX_VALUE
        $curSum = 0;
        $deque = []; // Monotonic deque to store pairs (prefix_sum, end_idx)

        for ($r = 0; $r < count($nums); $r++) {
            $curSum += $nums[$r];

            // If the current sum is greater than or equal to k
            if ($curSum >= $k) {
                $res = min($res, $r + 1);
            }

            // Find the minimum valid window ending at r
            while (!empty($deque) && $curSum - $deque[0]['key'] >= $k) {
                $front = array_shift($deque);
                $res = min($res, $r - $front['value']);
            }

            // Validate the monotonic deque
            while (!empty($deque) && end($deque)['key'] > $curSum) {
                array_pop($deque);
            }

            // Add the current prefix sum and index to the deque
            $deque[] = ['key' => $curSum, 'value' => $r];
        }

        return $res === PHP_INT_MAX ? -1 : $res;
    }
}