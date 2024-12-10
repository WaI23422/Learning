<?php  
// 2ms 20.47MB
class Solution
{
    public $max = 0;
    public $counter = [];

    function check($letter, $count)
    {
        if (!isset($this->counter[$letter]))
            $this->counter[$letter] = [];

        for ($i = $count; $i > $this->max; $i--) {

            $sum = 1 + $count - $i;

            if (!isset($this->counter[$letter][$i])) {
                $this->counter[$letter][$i] = 0;
            }

            $this->counter[$letter][$i] += $sum;

            if ($this->counter[$letter][$i] >= 3) {
                $this->max = $i;
            }
        }

    }

    /**
     * @param string $s
     * @return integer
     */
    function maximumLength($s)
    {
        $len = strlen($s);
        $last = $s[0];
        $count = 1;

        for ($i = 1; $i < $len; $i++) {

            if ($s[$i] == $last) {
                $count++;
                continue;
            }

            $this->check($last, $count);
            $last = $s[$i];
            $count = 1;
        }
        $this->check($last, $count);

        if($this->max == 0)
            return -1;

        return $this->max;
    }
}