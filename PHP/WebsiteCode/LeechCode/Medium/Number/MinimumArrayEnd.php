<?php  

// 2ms 19.76MB
class Solution {
    function minEnd($n, $x) {
        $binary = str_split(strrev(str_pad(decbin($x),28,'0',STR_PAD_LEFT)));
        $out = str_split(strrev(str_pad(decbin($n-1),28,'0',STR_PAD_LEFT)));
        foreach($binary as $idx=>$bit){
            if ($bit=="1"){array_splice($out,$idx,0,"1");}
        }
        return bindec(implode("",array_reverse($out)));
    }
}