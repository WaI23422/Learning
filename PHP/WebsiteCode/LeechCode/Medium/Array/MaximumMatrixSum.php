<?php  

// 43ms 25.78MB
class Solution {

    /**
     * @param int[][] $matrix
     * @return int
     */
    function maxMatrixSum($matrix):int  {
        $sum = 0;
        $row_len = count($matrix);
        $col_len = count($matrix[0]);
        $nev_total = 0;
        $min = INF;

        for ($row = 0; $row < $row_len; $row++) {
            for ($col=0; $col < $col_len; $col++) { 
                $num = $matrix[$row][$col];

                if ($num <= 0) {
                    $num = abs($num);
                    $nev_total++;
                }

                $min = min($min,$num);
                $sum += $num;
            }
        }

        return $nev_total%2==0 ? $sum : $sum - $min*2;;
    }
}