<?php  

// 95ms 21.48MB
class Solution2 {

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