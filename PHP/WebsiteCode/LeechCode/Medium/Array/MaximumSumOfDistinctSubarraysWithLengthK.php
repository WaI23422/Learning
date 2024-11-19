<?php  

// 55ms 26.88MB
class Solution {

    /**
     * @param int[] $nums
     * @param int $k
     * @return int
     */
    function maximumSubarraySum($nums, $k) {
        $n = count($nums);
        $maxSum = 0;
        $currentSum = 0;
        $window = [];
        
        for ($i = 0; $i < $n; $i++) {
            // Add the current element to the sliding window
            $window[$nums[$i]] = isset($window[$nums[$i]]) ? $window[$nums[$i]] + 1 : 1;
            $currentSum += $nums[$i];
            
            // If the window exceeds size k, shrink it
            if ($i >= $k) {
                $elementToRemove = $nums[$i - $k];
                $currentSum -= $elementToRemove;
                $window[$elementToRemove]--;
                if ($window[$elementToRemove] == 0) {
                    unset($window[$elementToRemove]);
                }
            }
            
            // Check if the current window is valid and update the max sum
            if (count($window) === $k) {
                $maxSum = max($maxSum, $currentSum);
            }
        }
        
        return $maxSum;
    }
}