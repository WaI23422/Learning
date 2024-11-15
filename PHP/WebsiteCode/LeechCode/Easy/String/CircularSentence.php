<?php

// 0ms 20.13MB
class Solution2 {
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
// 0ms 19.86MB
class Solution
{
    function isCircularSentence($sentence)
    {
        $len = strlen($sentence);
        if ($sentence[0] != $sentence[$len - 1])
            return false;
            
        for ($i = 0; $i < $len; $i++) {
            if ($sentence[$i] !== ' ')
                continue;
            
            if ($sentence[$i - 1] !== $sentence[$i + 1])
                return false;
        }

        return true;
    }
}