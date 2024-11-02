<?php

// 0ms 20.13MB
class Solution {
    function isCircularSentence($sentence) {
        $arr = explode(' ', $sentence);
        $n = count($arr);
        if ($arr[0][0] != $arr[$n-1][strlen($arr[$n-1]) - 1]) return false;
        for ($i = 0; $i < $n - 1; $i++) {
            $first = $arr[$i];
            $next = $arr[$i + 1];
            if ($first[strlen($first)-1] != $next[0]) return false;
        }
        return true;
    }
}