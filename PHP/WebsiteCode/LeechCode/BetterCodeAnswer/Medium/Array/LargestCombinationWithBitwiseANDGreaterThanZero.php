<?php  

// 110ms 27.70MB
class Solution {

    /**
     * @param int[] $candidates
     * @return int
     */
    function largestCombination($candidates) {
        $maxLength = 1;
        $bitMask = 1;
        $maxVal = max($candidates);

        while ($bitMask <= $maxVal) {
            $bitCount = 0;
            foreach ($candidates as $num) {
                if ($num & $bitMask) {
                    $bitCount++;
                }
            }
            if ($maxLength < $bitCount) {
                $maxLength = $bitCount;
            }
            $bitMask <<= 1;
        }

        return $maxLength;
    }
}