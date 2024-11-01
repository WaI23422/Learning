<?php
class Solution
{
    function makeFancyString($s)
    {
        $n = strlen($s);
        if ($n == 0)
            return "";

        $ans = $s[0];
        $count = 1;

        for ($i = 1; $i < $n; $i++) {
            if ($s[$i] == $s[$i - 1]) {
                $count++;
            } else {
                $count = 1;
            }

            if ($count < 3) {
                $ans .= $s[$i];
            }
        }

        return $ans;
    }
}