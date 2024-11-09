<?php 

// 0ms 19.74MB
class Solution {

    /**
     * @param int $n
     * @param int $x
     * @return int
     */
    function minEnd($n, $x) {
        $result = $x;
        $remaining = $n - 1;
        $position = 1;

        while ($remaining != 0) {
            if (($x & $position) == 0) {
                $result |= ($remaining & 1) * $position;
                $remaining >>= 1;
            }
            $position <<= 1;
        }

        return $result;
    }
}