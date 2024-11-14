<?php  

// 310ms 26.80MB
class Solution {

    /**
     * @param int $n
     * @param int[] $quantities
     * @return int
     */
    function minimizedMaximum($n, $quantities) {
        $min = 1;
        $max = max($quantities);

        while ($min < $max) {
            $mid = floor(($min + $max) / 2);
            if ($this->canDistribute($mid, $quantities, $n)) {
                $max = $mid;
            } else {
                $min = $mid + 1;
            }
        }
        return $min;
    }

    function canDistribute($mid, $quantities, $n) {
        $storesCount = 0;
        foreach ($quantities as $value) {
            $storesCount += ceil($value / $mid);
        }
        return $storesCount <= $n;
    }
}