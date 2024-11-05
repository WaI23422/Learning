<?php  


class Solution {

    /**
     * @param string $s
     * @return int
     */
    function minChanges($s) {
        $len = strlen($s);
        $min = 0;

        for ($i = 0; $i < $len; $i+=2) {
            $pre = $s[$i];
            if ($pre != $s[$i+1]){$min++;} 
        }

        return $min;
    }
}