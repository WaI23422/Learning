<?php  

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