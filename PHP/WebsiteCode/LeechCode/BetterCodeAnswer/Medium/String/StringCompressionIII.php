<?php  

// 95ms 21.48MB
class Solution {

    /**
     * @param string $word
     * @return string
     */
    function compressedString($word) {
        $i = 0;
        $n = strlen($word);
        $comp = "";

        while ($i < $n) {
            $cnt = 1;
            $c = $word[$i];
            $i++;

            while ($cnt < 9 && $i < $n && $word[$i] == $c) {
                $i++;
                $cnt++;
            }

            $comp .= $cnt . $c;
        }

        return $comp;
    }
}