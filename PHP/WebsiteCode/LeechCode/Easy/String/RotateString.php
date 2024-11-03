<?php  

// 0ms 19.91MB
class Solution {
    function rotateString($s, $goal) {
        if (strlen($s) != strlen($goal)) {return false;}
        
        $s = $s.$s;

        return str_contains($s, $goal);
    }
}