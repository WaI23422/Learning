<?php  

// 73ms 22.18MB
class Solution2 {
    function maxCount($banned, $n, $maxSum) {
        $validNumbers = array_diff(range(1, $n), $banned);
        $sum = $count = 0;
        foreach ($validNumbers as $number) {
            if (($sum += $number) > $maxSum) {
                break;
            }
            $count++;
        }
        
        return $count;
    }
}

// 2151ms 21.96MB
class Solution {
    function find($i,$arr) {
        while(in_array($i,$arr)) {
            $i++;
        }

        return $i;
    }

    function maxCount($banned, $n, $maxSum) {
        $count = 0;
        $sum = 0;
        $i = 0;
        $i = $this->find(++$i,$banned);;

        while($i <= $n) {
            var_dump($i);
            $sum += $i;
            if ($sum > $maxSum) {break;}    
            $count++;
            $i = $this->find(++$i,$banned);
        }

        return $count;
    }
}