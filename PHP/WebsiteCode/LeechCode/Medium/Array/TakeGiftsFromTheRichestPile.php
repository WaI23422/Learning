<?php  

// 3ms 20.82MB
class Solution {

    /**
     * @param integer[] $gifts
     * @param integer $k
     * @return integer
     */
    function pickGifts($gifts, $k) {
        $queue = new SplPriorityQueue();

        foreach ($gifts as $gift){
            $queue->insert($gift,$gift);
        }

        for ($i = 0; $i < $k; $i++){
            $half = (int) sqrt($queue->extract());
            $queue->insert($half,$half);
        }

        $len = count($gifts);
        for ($i = 0; $i < $len; $i++){
            $sum += $queue->extract();
        }

        return $sum;
    }
}