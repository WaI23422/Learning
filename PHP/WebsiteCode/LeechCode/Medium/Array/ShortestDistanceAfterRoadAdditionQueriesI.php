<?php  
// 75ms 21.00Mb
class Solution
{
    /**
     * @param int $n
     * @param int[][] $queries
     * @return int[]
     */
    public function shortestDistanceAfterQueries($n, $queries)
    {
        $children = $this->initialChildren($n, $queries);

        $distFromZero = [];
        for ($i = 1; $i < $n; ++$i) {
            $distFromZero[$i] = $i;
        }

        $bfsPad = [];
        $result = [];

        $len = count($queries);
        for ($q = 0; $q < $len ; ++$q) {
            $u = $queries[$q][0];
            $v = $queries[$q][1];
            for ($c = 0; ; ++$c) {
                if ($children[$u][$c] == 0) {
                    $children[$u][$c] = $v;
                    break;
                }
            }

            $bfsPad[0] = $u;
            for ($bfsNext = 0, $bfsEnd = 1; $bfsNext < $bfsEnd; ) {
                $currNode = $bfsPad[$bfsNext++];
                foreach ($children[$currNode] as $nextNode) {
                    if ($nextNode == 0) {
                        break;
                    }
                    if ($distFromZero[$nextNode] <= $distFromZero[$currNode] + 1) {
                        continue;
                    }
                    $distFromZero[$nextNode] = $distFromZero[$currNode] + 1;
                    $bfsPad[$bfsEnd++] = $nextNode;
                }
            }
            $result[$q] = $distFromZero[$n-1];
        }
        return $result;
    }

    private function initialChildren($n, $queries) {
        $children = [];
        for ($i = 0; $i < $n - 1; ++$i) {
            $children[$i][0] = $i + 1;
        }
        $children[$n-1] = [];
        
        return $children;
    }
}