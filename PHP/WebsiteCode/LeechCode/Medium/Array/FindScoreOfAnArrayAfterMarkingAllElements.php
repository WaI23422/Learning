<?php
// 17ms 27.91MB
class Solution
{

    /**
     * @param integer[] $nums
     * @return integer
     */
    function findScore($nums)
    {
        $res = 0;
        $len = count($nums);
        for ($i = 0; $i < $len; $i += 2) {
            $start = $i;
            while ($i + 1 < $len && $nums[$i + 1] < $nums[$i]) {
                $i++;
            }
            for ($j = $i; $j >= $start; $j -= 2) {
                $res += $nums[$j];
            }
        }
        return $res;
    }
}