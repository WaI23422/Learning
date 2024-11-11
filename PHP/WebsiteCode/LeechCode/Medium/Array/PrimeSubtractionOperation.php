<?php  

// 10ms 20.07MB
class Solution {

    /**
     * @param int[] $nums
     * @return bool
     */
    function primeSubOperation($nums) {
        // Helper function to find the maximum element in the array
        $getMaxElement = function($nums) {
            $max = -1;
            foreach ($nums as $num) {
                if ($num > $max) {
                    $max = $num;
                }
            }
            return $max;
        };
        
        // Helper function to fill an array with a specific value
        $fill = function(&$arr, $value) {
            foreach ($arr as &$item) {
                $item = $value;
            }
        };

        $maxElement = $getMaxElement($nums);

        // Create Sieve of Eratosthenes array
        $sieve = array_fill(0, $maxElement + 1, true);
        $sieve[1] = false;

        for ($i = 2; $i <= sqrt($maxElement + 1); $i++) {
            if ($sieve[$i]) {
                for ($j = $i * $i; $j <= $maxElement; $j += $i) {
                    $sieve[$j] = false;
                }
            }
        }

        // Check if array can be made strictly increasing
        $currValue = 1;
        $i = 0;

        while ($i < count($nums)) {
            $difference = $nums[$i] - $currValue;

            if ($difference < 0) {
                return false;
            }

            if ($sieve[$difference] === true || $difference === 0) {
                $i++;
                $currValue++;
            } else {
                $currValue++;
            }
        }

        return true;
    }
}