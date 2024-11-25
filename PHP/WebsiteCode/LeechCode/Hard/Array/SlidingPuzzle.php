<?php  

// 857ms 21.53MB
class Solution {
    private $historyMap = [];
    private $moves = [[-1, 0], [1, 0], [0, -1], [0, 1]];

    /**
     * @param int[][] $board
     * @return int
     */
    function slidingPuzzle($board, $countMoves = 0, $history = []) {
        $key = '';
        $zeroI = 0;
        $zeroJ = 0;
        for ($i = 0; $i < count($board); ++$i) {
            for ($j = 0; $j < count($board[$i]); ++$j) {
                $key .= $val = $board[$i][$j];
                if ($val === 0) {
                    $zeroI = $i;
                    $zeroJ = $j;
                }
            }
        }
        
        if ($key == '123450') {
            return $countMoves;
        }
        $historyVal = $this->historyMap[$key] ?? PHP_INT_MAX;
        if ($historyVal < $countMoves) {
            return -1;
        }
        $this->historyMap[$key] = $countMoves;
       
        if (isset($history[$key])) {
            return -1;
        }
        $history[$key] = true;
        $resultData = [];
        foreach ($this->moves as [$i, $j]) {
            if (!isset($board[$zeroI + $i][$zeroJ + $j])) {
                continue;
            }
            $val = $board[$zeroI + $i][$zeroJ + $j];
            $boardNew = $board;
            $boardNew[$zeroI + $i][$zeroJ + $j] = 0;
            $boardNew[$zeroI][$zeroJ] = $val;
            $resultTemp = $this->slidingPuzzle($boardNew, $countMoves + 1, $history);
            if ($resultTemp !== -1) {
                $resultData[] = $resultTemp;
            }
        }

        return empty($resultData) ? -1 : min($resultData);

    }
}