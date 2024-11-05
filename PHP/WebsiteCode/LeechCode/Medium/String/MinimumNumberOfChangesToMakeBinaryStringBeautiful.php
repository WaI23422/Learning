<?php  


// 19ms 20.2MB
class Solution {

    /**
     * @param string $s
     * @return int
     */
    function minChanges($s):int {
        $len = strlen($s);
        $min = 0;

        for ($i = 0; $i < $len; $i+=2) {
            $pre = substr( $s, $i,1);
            if ($pre != substr( $s, $i+1,1)){$min++;} 
        }

        return $min;
    }
}