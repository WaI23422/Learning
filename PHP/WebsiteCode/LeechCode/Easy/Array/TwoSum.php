<?php
// 0ms 20.5MB
class Solution2
{
    // 0ms 20.4MB
    function twoSum($nums, $target)
    {
        $hashMap = [];
        $count = count($nums);
        for ($i = 0; $i < $count; $i++) {
            $secondIndex = $target - $nums[$i];
            if (isset($hashMap[$secondIndex])) {
                return array($i, $hashMap[$secondIndex]);
            } else {
                $hashMap[$nums[$i]] = $i;
            }
        }
        return [];
    }
}
// 0ms 20.5MB
class Solution
{
    function twoSum($nums, $target)
    {
        $first = 0;
        $second = 1;
        $window = 1;
        $len = count($nums) - 1;
        while ($window <= $len) {
            if ($nums[$first] + $nums[$second] == $target) {
                break;
            } else if ($second == $len) {
                $first = 0;
                $window++;
                $second = $window;
            } else {
                $first++;
                $second++;
            }
        }
        return [$first, $second];
    }
}