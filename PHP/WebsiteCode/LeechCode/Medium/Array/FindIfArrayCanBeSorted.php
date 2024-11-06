<?php 

// 111ms 19.70MB
class Solution {
    
    /**
     * @param integer[] $nums
     * @return bool
     */
    function canSortArray($nums):bool {
        $len = count($nums);
        
        for ($i = 0; $i < $len; $i++) {
            for ($j = 0; $j < $i; $j++) {
                if ($nums[$i] < $nums[$j]) {
                    if (
                        substr_count(decbin($nums[$i]),'1') ==
                        substr_count(decbin($nums[$j]),'1')
                    ) {
                        // Swap the elements
                        $temp = $nums[$i];
                        $nums[$i] = $nums[$j];
                        $nums[$j] = $temp;
                    } else {
                        return false;
                    }
                }
            }
        }

        var_dump($nums);
        return true;
    }
}