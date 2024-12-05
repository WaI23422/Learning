<?php  

// 44ms 20.98MB
class Solution {

    /**
     * @param string $start
     * @param string $target
     * @return boolean
     */
    function canChange($start, $target) {
        if ($start === $target) {
            return true;
        }

        $waitL = 0;
        $waitR = 0;

        $length = strlen($start);
        for ($i = 0; $i < $length; $i++) {
            $curr = $start[$i];
            $goal = $target[$i];

            if ($curr === 'R') {
                if ($waitL > 0) {
                    return false;
                }
                $waitR++;
            }
            if ($goal === 'L') {
                if ($waitR > 0) {
                    return false;
                }
                $waitL++;
            }
            if ($goal === 'R') {
                if ($waitR === 0) {
                    return false;
                }
                $waitR--;
            }
            if ($curr === 'L') {
                if ($waitL === 0) {
                    return false;
                }
                $waitL--;
            }
        }

        return $waitL === 0 && $waitR === 0;
    }
}