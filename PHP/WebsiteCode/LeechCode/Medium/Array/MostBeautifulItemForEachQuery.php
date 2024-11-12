<?php  

// 357ms 100.6MB
class Solution {

    /**
     * @param int[][] $items
     * @param int[] $queries
     * @return int[]
     */


    function maximumBeauty($items, $queries) {
    // Step 1: Sort items by price
    usort($items, function($a, $b) {
        return $a[0] <=> $b[0];
    });

    // Step 2: Precompute maximum beauty
    $maxBeauty = [];
    $currentMaxBeauty = 0;
    
    foreach ($items as $item) {
        $currentMaxBeauty = max($currentMaxBeauty, $item[1]);
        $maxBeauty[] = [$item[0], $currentMaxBeauty]; // store price and max beauty up to that price
    }

    // Step 3: Answer the queries
    $answer = [];
    foreach ($queries as $query) {
        // Binary search for the largest price <= query
        $left = 0;
        $right = count($maxBeauty) - 1;
        $bestBeauty = 0;

        while ($left <= $right) {
            $mid = (int)(($left + $right) / 2);
            if ($maxBeauty[$mid][0] <= $query) {
                $bestBeauty = $maxBeauty[$mid][1]; // update best beauty
                $left = $mid + 1; // search in the right half
            } else {
                $right = $mid - 1; // search in the left half
            }
        }

        $answer[] = $bestBeauty; // add the result for this query
    }

    return $answer;
} }