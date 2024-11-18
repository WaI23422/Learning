<?php  
// 0ms 20.2MB
class Solution {

    /**
     * @param int[] $code
     * @param int $k
     * @return int[]
     */
        function decrypt($code, $k) {
        $n = count($code);
        $result = array_fill(0, $n, 0);
        if ($k == 0)
            // get this case out of the way
            return $result;
        // where to put current sum:
        $offset = $n - 1;
        if ($k < 0) {
            $k = -$k;
            $offset = $k;
        }
        // sum first k elements
        $sum = 0;
        for ($i = 0; $i < $k; $i++)
            $sum += $code[$i];
        for ($i = 0; $i < $n; $i++) {
            $result[(($offset + $i) % $n)] = $sum;
            $sum += $code[(($k + $i) % $n)] - $code[$i];
        }
        return $result;
    }
}