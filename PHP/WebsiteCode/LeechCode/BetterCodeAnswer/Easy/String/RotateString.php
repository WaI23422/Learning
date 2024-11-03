<?php  

// 0ms 19.79MB
class Solution {
    function rotateString($s, $goal) {
        for($i=0;$i<strlen($s);$i++){
            $firstPart=substr($s,0,$i);
            $secondPart=substr($s,$i,strlen($s));
            if($secondPart.$firstPart===$goal)
            return true;
        }

        return false;
    }
}