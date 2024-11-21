<?php  
// 140ms 73.84MB
class Solution {

    /**
     * @param int $m
     * @param int $n
     * @param int[][] $guards
     * @param int[][] $walls
     * @return int
     */
    function countUnguarded($m, $n, $guards, $walls) {
        $res = array_fill(0, $m, array_fill(0, $n, 0));
        $count = 0;
        foreach ($guards as $g) {$res[$g[0]][$g[1]] = 2; $count++;}
        foreach ($walls as $w) {$res[$w[0]][$w[1]] = 2; $count++;}
        foreach ($guards as $g) {
            $row = $g[0]; $col = $g[1];
            if($row+1 < $m){for ($i = $row+1; $i < $m; $i++) {
                if ($res[$i][$col] === 2) break; if ($res[$i][$col] === 1) continue;
                $res[$i][$col] = 1; $count++;
            }}
            if($row-1 >= 0){for ($i = $row-1; $i >= 0; $i--) {
                if ($res[$i][$col] === 2) break; if($res[$i][$col]===1) continue;
                $res[$i][$col] = 1; $count++;
            }}
            if($col+1<$n){for ($i = $col+1; $i < $n; $i++) {
                if ($res[$row][$i] == 2) break; if($res[$row][$i] === 1) continue;
                $res[$row][$i] = 1; $count++;
            }}
            if($col-1>=0){for ($i = $col-1; $i >= 0; $i--) {
                if ($res[$row][$i] == 2) break; if($res[$row][$i]===1) continue;
                $res[$row][$i] = 1; $count++;
            }}
        }
        return $m * $n - $count;
    }

}