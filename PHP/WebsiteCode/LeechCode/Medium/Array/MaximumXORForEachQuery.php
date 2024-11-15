<?php

// 15ms 31.13MB
class Solution2
{

    /**
     * @param int[] $nums
     * @param int $maximumBit
     * @return int[]
     */
    function getMaximumXor($nums, $maximumBit)
    {
        $number = (2 ** $maximumBit) - 1;
        foreach ($nums as $k => $v) {
            $number ^= $v;
            $nums[count($nums) - 1 - $k] = $number;
        }
        return $nums;
    }
}
// 20ms 30.98MB
class Solution
{

    /**
     * @param int[] $nums
     * @param int $maximumBit
     * @return int[]
     */
    function getMaximumXor($nums, $maximumBit)
    {
        $n = count($nums);
        $xorr = $nums[0];
        $maxXor = (1 << $maximumBit) - 1;

        // Calculate the XOR of the entire array
        for ($i = 1; $i < $n; $i++) {
            $xorr ^= $nums[$i];
        }

        $ans = [];
        for ($i = 0; $i < $n; $i++) {
            // Append the current XOR result with maxXor to the result array
            $ans[] = $xorr ^ $maxXor;
            // Update xorr by XORing it with the element from the end of nums array
            $xorr ^= $nums[$n - 1 - $i];
        }

        return $ans;
    }
}