<?php  
// 0ms 20.42MB
class Solution {

    /**
     * @param string $sentence
     * @param string $searchWord
     * @return integer
     */
    function isPrefixOfWord($sentence, $searchWord) {
        $sentence_split = explode(" ",$sentence);
        $sentence_split_len = count($sentence_split);
        $searchWord_len = strlen($searchWord);

        for ($i=0; $i < $sentence_split_len; $i++) { 
            if (strlen($sentence_split[$i]) < $searchWord_len) {continue;}
            $count = 0;
            $sentence_at = $sentence_split[$i];
            for ($j=0; $j < $searchWord_len; $j++) { 
                if ($searchWord[$j] != $sentence_at[$j]) {break;}
                $count++;
            }
            if ($count == $searchWord_len) return $i+1;
        }

        return -1;
    }
}