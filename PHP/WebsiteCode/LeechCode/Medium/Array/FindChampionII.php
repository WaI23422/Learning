<?php  
// 5ms 23.31MB
class Solution {

    /**
     * @param int $n
     * @param int[][] $edges
     * @return int
     */
    function findChampion($n, $edges) {
        // Initialize an array to store in-degrees for each team
        $inDegree = array_fill(0, $n, 0);

        // Calculate the in-degree for each team
        foreach ($edges as $edge) {
            $inDegree[$edge[1]]++;
        }

        // Find all teams with in-degree 0
        $candidates = [];
        for ($i = 0; $i < $n; $i++) {
            if ($inDegree[$i] === 0) {
                $candidates[] = $i;
            }
        }

        // If there is exactly one candidate, return it; otherwise, return -1
        return count($candidates) === 1 ? $candidates[0] : -1;
    }
}

// 318ms 23.28MB
class Solution2 {

    /**
     * @param int $n
     * @param int[][] $edges
     * @return int
     */
    function findChampion($n, $edges) {
        $map = [];
        for ($i = 0; $i < $n; ++$i) {
            $map[$i] = true;
        }
        while(!empty($edges)) {
            [$win, $lose] = array_shift($edges);
            unset($map[$lose]);
        }
        if (count($map) !== 1) {
            return -1;
        }
        foreach ($map as $team => $_) {
            return $team;
        }
        return -1;
    }
}