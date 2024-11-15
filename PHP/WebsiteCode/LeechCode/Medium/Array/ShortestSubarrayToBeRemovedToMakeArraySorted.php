<?php  
// 4ms 28.08MB
class Solution {

    /**
     * @param int[] $arr
     * @return int
     */
    function findLengthOfShortestSubarray($arr) {
        
        $n = count($arr);
        $start = 0;
        $end = $n - 1;

        while ($start < $end && $arr[$start] <= $arr[$start + 1]) {
            $start++;
        }
        if ($start === $end) return 0;

        while ($end > $start && $arr[$end] >= $arr[$end - 1]) {
            $end--;
        }
        if ($end === 0) return $n - 1;

        $ans = min($n - $start - 1, $end);

        $i = 0;
        $j = $end;

        while ($i <= $start && $j < $n) {
            if ($arr[$i] <= $arr[$j]) {
                $ans = min($ans, $j - $i - 1);
                $i++;
            } else {
                $j++;
            }
        }

        return $ans;

    }
}