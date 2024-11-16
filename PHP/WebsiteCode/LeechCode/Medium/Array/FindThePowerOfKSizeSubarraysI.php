<?php  

// 2ms 20.10MB
class Solution {

    /**
     * @param int[] $nums
     * @param int $k
     * @return int[]
     */
    function resultsArray($nums, $k) {
        $result = [];
        $lastAsc = 0;
        for ($i = 0; $i < count($nums); $i ++) {
            
            if ($nums[$i] - $nums[$i-1] !== 1) {
                $lastAsc = $i;
            }

            if (($i+1) >= $k) {
                $result[] = ($lastAsc <= ($i - $k + 1)) ? $nums[$i] : -1;
            }
        }
        return $result;
    }
}