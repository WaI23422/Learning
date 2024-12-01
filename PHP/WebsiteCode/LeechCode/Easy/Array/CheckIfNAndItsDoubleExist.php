<?php  

// 0ms 20.28MB
class Solution {

    /**
     * @param int[] $arr
     * @return boolean
     */
    function checkIfExist($arr) {
        $exist_arr = []; 
        
        foreach ($arr as $num) {
            if (
                isset($exist_arr[$num*2]) ||
                ($num%2==0 && isset($exist_arr[$num/2]))
            ) {return true;}

            $exist_arr[$num] = true;
        }

        return false;
    }
}