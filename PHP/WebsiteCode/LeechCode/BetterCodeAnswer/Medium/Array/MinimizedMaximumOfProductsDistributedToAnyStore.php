<?php  

// 274ms 26.80MB
class Solution {

    /**
     * @param int $n
     * @param int[] $quantities
     * @return int
     */
    function minimizedMaximum($n, $quantities) {
        $low = 1;
        $high = max($quantities);

        while ($low < $high) {
            $mid = intdiv($low + $high, 2);
            $needed = 0;

            foreach ($quantities as $q) {
                $needed += intdiv($q + $mid - 1, $mid);
            }

            if ($needed <= $n) {
                $high = $mid;
            } else {
                $low = $mid + 1;
            }
        }

        return $low;
    }
}