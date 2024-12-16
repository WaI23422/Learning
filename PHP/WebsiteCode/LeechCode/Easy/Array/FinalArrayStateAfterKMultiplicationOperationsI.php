<?php  

// 13ms 20.62MB
class MapQueue extends SplPriorityQueue{
    function compare(mixed $priority1, mixed $priority2) {

        if ($priority1[0] == $priority2[0]) {
            return $priority1[1] < $priority2[1] ? 1 : -1;
        }

        return $priority1[0] < $priority2[0] ? 1 : -1;
    }
}
class Solution {

    /**
     * @param integer[] $nums
     * @param integer $k
     * @param integer $multiplier
     * @return integer[]
     */
    function getFinalState($nums, $k, $multiplier) {
        $nums_len = count($nums);
        $queue = new MapQueue();
        
        for ($i=0; $i < $nums_len; $i++) { 
            $arr = [$nums[$i],$i];
            $queue->insert($arr,$arr);
        }

        for ($i=0; $i < $k; $i++) { 
            $arr= $queue->extract();
            $arr[0] *= $multiplier;
            $queue->insert($arr,$arr);
        }

        while (!$queue->isEmpty()) {
            $arr = $queue->extract();
        
            $nums[$arr[1]] = $arr[0];
        }


        return $nums;
    }
}

// 1ms 20.26MB
class Solution2 {

    /**
     * @param integer[] $nums
     * @param integer $k
     * @param integer $multiplier
     * @return integer[]
     */
    function getFinalState($nums, $k, $multiplier) {
        for($i=0; $i<$k; $i++){
            $element= array_search(min($nums),$nums);
            $nums[$element] *= $multiplier;
        }
        return $nums;
    }
}