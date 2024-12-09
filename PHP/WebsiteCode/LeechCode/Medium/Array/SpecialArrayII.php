<?php  

// 23ms 77.69MB
class Solution {

    /**
     * @param integer[] $nums
     * @param integer[][] $queries
     * @return boolean[]
     */
    function isArraySpecial($nums, $queries) {
        $count = count($nums);
        $queryCount = count($queries);

        $answer = array_fill(0, $queryCount, false);        
        $hashMap = array_fill(0, $count, 0);

        $isPreviousEven = $nums[0] % 2 === 0;

        for ($i = 1; $i < $count; $i++) {
            $isCurrentEven = $nums[$i] % 2 === 0;

            $hashMap[$i] = $hashMap[$i - 1] + ($isPreviousEven === $isCurrentEven ? 1 : 0);

            $isPreviousEven = $isCurrentEven;
        }
    

        for ($i = 0; $i < $queryCount; $i++) {
            $answer[$i] = $hashMap[$queries[$i][0]] === $hashMap[$queries[$i][1]];
        }

        return $answer;        
    }
}

// Time Limit Exceeded
class Solution1 {

    /**
     * @param integer[] $nums
     * @param integer[][] $queries
     * @return boolean[]
     */
    function isArraySpecial($nums, $queries) {
        $queued = [];
        $len = count($nums);
        $states = [];
        for ($i=1; $i < $len; $i++) { 
            $states[] = ($nums[$i-1]+$nums[$i])%2 != 0;
        }

        
        foreach ($queries as $querie) {
            $queued[] = $this->isSpecial($states,$querie[0],$querie[1]);
        }

        return $queued;
    }

    function isSpecial($arr, $start, $end) {
        $state = true;

        for ($i=$start; $i < $end; $i++) {$state &= $arr[$i];}

        return $state;
    }
}