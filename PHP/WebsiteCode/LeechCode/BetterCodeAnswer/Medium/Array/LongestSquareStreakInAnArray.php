<?php 
    // 61ms 27.90MB
    class Solution {
        function longestSquareStreak($nums) {
            // Initialize the longest square streak to -1
            $longestStreak = -1;
    
            // Create a dictionary to store all elements in the array
            $elements = array_fill_keys($nums, true);
    
            // Iterate through all elements in the array
            foreach ($nums as $num) {
                // Initialize the current square streak to 0
                $currentStreak = 0;
    
                // Initialize the previous element to the current element
                $prev = $num;
    
                // Iterate through all elements in the square streak
                while (isset($elements[$prev])) {
                // Increase the current square streak by 1 and update the previous element
                $currentStreak += 1;
                $prev = $prev ** 2;
                }
    
                // Update the longest square streak if the current square streak is longer
                $longestStreak = max($longestStreak, $currentStreak);
            }
    
            // If the longest square streak is 1, it means that there is no square streak in the array, so return -1
            if ($longestStreak == 1) {
                return -1;
            }
    
            // Otherwise, return the longest square streak
            return $longestStreak;
        }
    }