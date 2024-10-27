<?php 
    // 0ms 20.5MB
    class Solution {
        // 0ms 20.4MB
        function twoSum($nums, $target) {
            $hashMap = [];
            $count = count($nums);
            for($i=0;$i<$count;$i++){
                $secondIndex = $target-$nums[$i];
                if(isset($hashMap[$secondIndex])){
                    return array($i,$hashMap[$secondIndex]);
                }else{
                    $hashMap[$nums[$i]]=$i;
                }
            }
            return [];
        }
    }