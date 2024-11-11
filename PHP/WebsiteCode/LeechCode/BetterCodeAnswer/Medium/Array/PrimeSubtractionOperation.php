<?php  

// 1ms 20.07MB
class Solution {

    /**
     * @param int[] $nums
     * @return bool
     */
    function primeSubOperation($nums) {
        $n = count($nums);
        for ($i = $n - 2; $i >= 0; $i--) {
            if ($nums[$i] < $nums[$i + 1]) {
                continue;
            } else {
                $prime = $this->findPrime($nums[$i] - $nums[$i + 1], $nums[$i]);
                if ($prime === -1) {
                    return false;
                }
                $nums[$i] -= $prime;
            }
        }
        return true;
    }

    function findPrime($minVal, $maxVal) {
        for ($i = $minVal + 1; $i < $maxVal; $i++) {
            if ($this->isPrime($i)) {
                return $i;
            }
        }
        return -1;
    }

    function isPrime($num) {
        if ($num <= 1) return false;
        for ($i = 2, $sqrt = sqrt($num); $i <= $sqrt; $i++) {
            if ($num % $i === 0) return false;
        }
        return true;
    }
}