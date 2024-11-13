<?php

// 93ms 29.87MB
class Solution {

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





