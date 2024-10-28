<?php 

    // 2ms 20.28MB
    class Solution {
        function isPalindrome($x):bool    {
            return $x == strrev($x);
        }
    }