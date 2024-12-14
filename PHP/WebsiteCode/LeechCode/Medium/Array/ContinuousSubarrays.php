<?php  

class Solution {

    /**
     * @param integer[] $nums
     * @return integer
     */
    function continuousSubarrays($nums) {
        $left = 0;
        // Stores indices of elements in increasing order
        $minDeque = [];
        // Stores indices of elements in decreasing order
        $maxDeque = [];
        $totalSubarrays = 0;
        
        for ($right = 0; $right < count($nums); $right++) {
            $num = $nums[$right];
            
            // Maintain the minDeque
            while (!empty($minDeque) && $nums[end($minDeque)] > $num) {
                array_pop($minDeque);
            }
            array_push($minDeque, $right);
            
            // Maintain the maxDeque
            while (!empty($maxDeque) && $nums[end($maxDeque)] < $num) {
                array_pop($maxDeque);
            }
            array_push($maxDeque, $right);
            
            // Shrink the window if the condition is violated
            while (!empty($maxDeque) && !empty($minDeque) && $nums[$maxDeque[0]] - $nums[$minDeque[0]] > 2) {
                $left += 1;
                if ($minDeque[0] < $left) {
                    array_shift($minDeque);
                }
                if ($maxDeque[0] < $left) {
                    array_shift($maxDeque);
                }
            }
            
            // All subarrays ending at 'right' and starting from any index between 
            // 'left' and 'right' are valid
            $totalSubarrays += $right - $left + 1;
        }
        
        return $totalSubarrays;
    }
}