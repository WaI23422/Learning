<?php  
// 110ms 27.70MB
class Solution2 {

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
// 195ms 27.70MB
class Solution {

    /**
     * @param int[] $candidates
     * @return int
     */
    function largestCombination($candidates) {
        $ans = 0;
        for ($i = 0; $i < 32; $i++) {
            $cnt = 0;
            foreach ($candidates as $candidate) {
                if ($candidate & (1 << $i)) {
                    $cnt++;
                }
            }
            $ans = max($ans, $cnt);
        }
        return $ans;
    }
}