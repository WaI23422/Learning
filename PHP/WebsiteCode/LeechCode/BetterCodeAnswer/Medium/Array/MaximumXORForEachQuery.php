<?php
// 15ms 31.13MB
class Solution {

    /**
     * @param int[] $nums
     * @param int $maximumBit
     * @return int[]
     */
    function getMaximumXor($nums, $maximumBit) {
        $number = (2**$maximumBit)-1;
        foreach($nums as $k=>$v){
            $number ^= $v;
            $nums[count($nums)-1-$k] = $number;
        }
        return $nums;
    }
}