<?php

class Solution {

    /**
     * @param integer[] $nums
     * @param integer $maxOperations
     * @return integer
     */
    function minimumSize($nums, $maxOperations) {
        $left = 1;
        $right = max($nums);

        while ($left < $right) {
            $mid = intdiv(($left + $right), 2);

            $canAchive = function() use ($nums, $mid, $maxOperations) {
                $operations = 0;
                foreach ($nums as $num) {
                    if ($num <= $mid) {
                        continue;
                    }
                    $operations += intdiv(($num - 1), $mid);

                    if ($operations > $maxOperations) {
                        return false;
                    }
                }
                return $operations <= $maxOperations;
            };

            if ($canAchive()) {
                $right = $mid;
            } else {
                $left = $mid + 1;
            }
        }

        return $left;
    }
}