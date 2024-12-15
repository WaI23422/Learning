<?php

// 703ms 93.55MB
class Solution
{
    public function maxAverageRatio($classes, $extraStudents)
    {
        $pq = new SplPriorityQueue();

        foreach ($classes as $class) {
            $n = $class[0];
            $d = $class[1];
            $change = ($n + 1) / ($d + 1) - $n / $d;
            $pq->insert([$change, [$n, $d]], $change);
        }

        for ($i = 0; $i < $extraStudents; $i++) {
            // Extract the class with the highest potential increase  
            $top = $pq->extract();
            $change = $top[0];
            $p = $top[1];
            $n = $p[0] + 1;
            $d = $p[1] + 1;

            $newChange = ($n + 1) / ($d + 1) - $n / $d;
            $pq->insert([$newChange, [$n, $d]], $newChange);
        }

        $passRatio = 0.0;
        while (!$pq->isEmpty()) {
            $top = $pq->extract();
            $b = $top[1];
            $n = $b[0];
            $d = $b[1];
            $passRatio += $n / $d;
        }

        return $passRatio / count($classes);
    }
}