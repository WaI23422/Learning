<?php  

// 31ms 21.32MB
class Solution {

    /**
     * @param string $str1
     * @param string $str2
     * @return boolean
     */
    function canMakeSubsequence($str1, $str2) {
        $cyc_map = [
            'a' => 0,'b' => 1,'c' => 2,'d' => 3,'e' => 4,
            'f' => 5,'g' => 6,'h' => 7,'i' => 8,'j' => 9,
            'k' => 10,'l' => 11,'m' => 12,'n' => 13,'o' => 14,
            'p' => 15,'q' => 16,'r' => 17,'s' => 18,'t' => 19,
            'u' => 20,'v' => 21,'w' => 22,'x' => 23,'y' => 24,
            'z' => 25,
        ];

        $str2_len = strlen($str2);
        $str1_len = strlen($str1);
        if($str1_len < $str2_len){return false;}

        $track1 = 0;
        $track2 = 0;
        while ($track2 < $str2_len) { 
            $val_char_str2 = $cyc_map[$str2[$track2]];
            while ($track1 < $str1_len){
                $diff = $val_char_str2 - $cyc_map[$str1[$track1]];
                if ($diff != -25 && $diff != 0 && $diff != 1) {$track1++;continue;}
                break;
            };
            if ($track1 == $str1_len) {return false;}
            $track1++;
            $track2++;
        }

        return true;
    }
}