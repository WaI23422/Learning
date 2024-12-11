<?php  

// 160ms 30.86MB
class Solution {

    /**
     * @param integer[] $nums
     * @param integer $k
     * @return integer
     */
    function maximumBeauty($nums, $k) {
        // Sort the array
        sort($nums);
        
        $n = count($nums);
        $maxBeauty = 1;
        
        // Two-pointer approach
        $left = 0;
        
        // Iterate through the array using the right pointer
        for ($right = 0; $right < $n; $right++) {
            // Keep expanding the window by moving right pointer
            while ($nums[$right] - $nums[$left] > 2 * $k) {
                // If the difference is too large, shrink the window by moving left pointer
                $left++;
            }
            // The number of elements in the current window is (right - left + 1)
            $maxBeauty = max($maxBeauty, $right - $left + 1);
        }
        
        return $maxBeauty;
    }
}