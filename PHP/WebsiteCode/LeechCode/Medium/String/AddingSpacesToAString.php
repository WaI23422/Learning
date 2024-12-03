<?php  
// 45ms 36.4MB
class Solution {

    /**
     * @param string $s
     * @param integer[] $spaces
     * @return string
     */
    function addSpaces($s, $spaces) {
        $str = "";
        $pre_space = 0;
        $s_len = strlen($s);

        foreach ($spaces as $space) {
            for ($i=$pre_space; $i < $space; $i++) { 
                $str .= $s[$i];
            }
            $str .= " ";
            $pre_space = $space;
        }

        for ($i=$pre_space; $i < $s_len; $i++) { 
            $str .= $s[$i];
        }

        return $str;
    }
}