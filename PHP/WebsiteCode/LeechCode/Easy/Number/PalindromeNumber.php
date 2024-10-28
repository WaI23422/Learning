<?php 

    // 2ms 20.28MB
    class Solution {
        function isPalindrome($x):bool    {
            if($x < 0){
                return false;
            }

            if($x < 10){
                return true;
            }

            $str = (string) $x;
            $fullLen = strlen($str);
            $len = floor($fullLen / 2);     

            return strrev(substr($str, 0, $len)) === substr($str, $fullLen - $len, $len);
        }
    }