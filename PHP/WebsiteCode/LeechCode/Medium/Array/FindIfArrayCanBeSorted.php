<?php 

// 9ms 19.4MB
class Solution2
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
// 111ms 19.70MB
class Solution {
    
    /**
     * @param integer[] $nums
     * @return bool
     */
    function canSortArray($nums):bool {
        $len = count($nums);
        
        for ($i = 0; $i < $len; $i++) {
            for ($j = 0; $j < $i; $j++) {
                if ($nums[$i] < $nums[$j]) {
                    if (
                        substr_count(decbin($nums[$i]),'1') ==
                        substr_count(decbin($nums[$j]),'1')
                    ) {
                        // Swap the elements
                        $temp = $nums[$i];
                        $nums[$i] = $nums[$j];
                        $nums[$j] = $temp;
                    } else {
                        return false;
                    }
                }
            }
        }

        var_dump($nums);
        return true;
    }
}