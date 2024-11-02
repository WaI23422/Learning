<?php

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