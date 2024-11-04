<?php  

// 78ms 21.48MB
class Solution {

    /**
     * @param string $word
     * @return string
     */
    function compressedString($word) {
        $ans = "";
        $prev = $word[0];
        $count = 1;

        for ($i = 1; $i < strlen($word); $i++) {
            if ($word[$i] !== $prev) {
                $ans .= $count . $prev;
                $prev = $word[$i];
                $count = 1;
            } else {
                if ($count == 9) {
                    $ans .= $count . $prev;
                    $count = 1;
                } else {
                    $count++;
                }
            }
        }

        // Append the last group
        $ans .= $count . $prev;
        return $ans;
    }
}