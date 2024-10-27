<?php 
    // 0ms 20.5MB
    class Solution {
        function twoSum($nums, $target) {
            $first=0;
            $second=1;
            $window=1;
            $len = count($nums)-1;
            while($window<=$len){
                if($nums[$first]+$nums[$second]==$target){
                    break;
                } else if($second==$len){
                    $first=0;
                    $window++;
                    $second= $window;
                }
                else{
                    $first++;
                    $second++;
                }
            }
            return [$first,$second];
        }
    }