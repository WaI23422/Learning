<?php

// 93ms 29.87MB
class Solution2 {

    /**
     * @param int[] $nums
     * @param int $lower
     * @param int $upper
     * @return int
     */
    function countFairPairs($nums, $lower, $upper) {
        sort($nums);
        return $this->countLess($nums, $upper) - $this->countLess($nums, $lower - 1);
    }

    private function countLess($nums, $sum) {
        $res = 0;
        $j = count($nums) - 1;

        for ($i = 0; $i < $j; ++$i) {
            while ($i < $j && $nums[$i] + $nums[$j] > $sum) {
                --$j;
            }
            $res += $j - $i;
        }

        return $res;

    }
}


// 599ms 303MB
class Solution
{

    /**
     * @param int[] $nums
     * @param int $lower
     * @param int $upper
     * @return int
     */
    function countFairPairs($nums, $lower, $upper)
    {
        sort($nums);
        $count = 0;
        $n = count($nums);

        for ($i = 0; $i < $n - 1; $i++) {
            $left = $i + 1;
            $right = $n - 1;

            // Use binary search to find the lower bound
            while ($left <= $right) {
                $mid = intdiv($left + $right, 2);
                if ($nums[$i] + $nums[$mid] >= $lower) {
                    $right = $mid - 1;
                } else {
                    $left = $mid + 1;
                }
            }
            $lowerBound = $left;

            // Reset the pointers for upper bound search
            $left = $i + 1;
            $right = $n - 1;

            // Use binary search to find the upper bound
            while ($left <= $right) {
                $mid = intdiv($left + $right, 2);
                if ($nums[$i] + $nums[$mid] <= $upper) {
                    $left = $mid + 1;
                } else {
                    $right = $mid - 1;
                }
            }
            $upperBound = $right;

            // Count pairs between lowerBound and upperBound
            if ($lowerBound <= $upperBound) {
                $count += ($upperBound - $lowerBound + 1);
            }
        }

        return $count;
    }
}






