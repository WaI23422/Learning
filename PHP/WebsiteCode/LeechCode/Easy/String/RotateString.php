<?php  

// 0ms 19.79MB
class Solution2 {
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
// 0ms 19.91MB
class Solution {
    function rotateString($s, $goal) {
        if (strlen($s) != strlen($goal)) {return false;}
        
        $s = $s.$s;

        return str_contains($s, $goal);
    }
}