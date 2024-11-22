<?php  

// 43ms 26.12MB
class Solution {

    /**
     * @param int[][] $matrix
     * @return int
     */
    function maxEqualRowsAfterFlips($matrix) {
        $h = [];
        foreach($matrix as $r) {
            $f = $r[0];
            $x = "";
            foreach($r as $b) {
                $b === $f ? ($x .= 'T') : ($x .= 'F');
            }
            if (array_key_exists($x, $h)) {
                $h[$x]++;
            } else $h[$x] = 1;
        }
        $res = -1;
        foreach ($h as $k => $v) {
            $res = max($res, $v);
        }
        return $res;
    }
}