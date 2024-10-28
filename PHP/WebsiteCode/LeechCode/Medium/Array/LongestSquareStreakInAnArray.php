<?php 
    // 58ms 27.84MB
    class Solution {
        function longestSquareStreak($nums):int {
            $nums_arr = [];
        
            foreach ($nums as $num) {
                $nums_arr[$num] = true;
            }
            
            $max = -1;
            foreach ($nums as $num) {
                $pow_num = pow($num, 2);
                if ($pow_num < 100_001 && $nums_arr[$pow_num]) {
                    $count = 1;
                    do {
                        $count++;
                        $max = max($max, $count);
                        $pow_num = pow($pow_num, 2);
                    } while ($pow_num < 100_001 && $nums_arr[$pow_num]);
                }
            }

            return $max;
        }
    }