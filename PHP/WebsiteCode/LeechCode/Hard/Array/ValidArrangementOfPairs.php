<?php  

// 191ms 151.84MB
class Solution {
    public function validArrangement($pairs) {
        $adj = [];
        $indegree = [];
        $ans = [];

        foreach ($pairs as $p) {
            $adj[$p[0]] ??= [];
            $adj[$p[0]][] = $p[1]; 
            $indegree[$p[0]] = ($indegree[$p[0]] ?? 0) + 1; 
            $indegree[$p[1]] = ($indegree[$p[1]] ?? 0) - 1; 
        }

        $start = -1;
        foreach ($indegree as $node => $degree) {
            if ($degree > 0) {
                $start = $node;
                break;
            }
        }
        if ($start === -1) {
            $start = $pairs[0][0];
        }

        $this->dfs($start, $adj, $ans);
        $ans = array_reverse($ans); 
        return $ans;
    }

    private function dfs($node, &$adj, &$ans) {
        while (!empty($adj[$node])) {
            $next = array_pop($adj[$node]);
            $this->dfs($next, $adj, $ans); 
            $ans[] = [$node, $next];
        }
    }
}