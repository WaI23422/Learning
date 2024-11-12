<?php  

// 238ms 100.6MB
class Solution {

    /**
     * @param int[][] $items
     * @param int[] $queries
     * @return int[]
     */
    function maximumBeauty($items, $queries) {
        $maxI = PHP_INT_MAX;
        $res = [[0, 0, $maxI]];

        // Sort items by price (first element in each sub-array)
        usort($items, function($a, $b) {
            return $a[0] <=> $b[0];
        });

        foreach ($items as $item) {
            $price = $item[0];
            $beauty = $item[1];
            $lastBracket = end($res);

            if ($beauty > $lastBracket[1]) {
                $res[count($res) - 1][2] = $price;
                $res[] = [$price, $beauty, $maxI];
            }
        }

        $ans = [];

        foreach ($queries as $x) {
            for ($i = count($res) - 1; $i >= 0; $i--) {
                if ($res[$i][0] <= $x) {
                    $ans[] = $res[$i][1];
                    break;
                }
            }
        }

        return $ans;
    }
}