<?php  

// 9ms 19.4MB
class Solution
{
    /**
     * @param int[] $nums
     * @return bool
     */
    function canSortArray($nums)
    {
        $currentMin = 1024;
        $currentMax = 0;
        $prevGroupMax = null;
        foreach($nums as $i => $num) {
            if (($i > 0 && !$this->isSameSetBits($nums[$i-1], $num))) {
                if ($prevGroupMax > $currentMin) return false;
                $prevGroupMax = $currentMax;
                $currentMin = 1024;
                $currentMax = 0;
            }
            $currentMin = min($currentMin, $num);
            $currentMax = max($currentMax, $num);
        }

        if ($prevGroupMax > $currentMin) return false;

        return true;
    }

    function isSameSetBits($a, $b)
    {
        return $this->countBits($a) === $this->countBits($b);
    }

    function countBits($a)
    {
        $countA = 0;
        while ($a > 0) {
            $countA += $a % 2;
            $a = $a >> 1;
        }
        return $countA;
    }
}