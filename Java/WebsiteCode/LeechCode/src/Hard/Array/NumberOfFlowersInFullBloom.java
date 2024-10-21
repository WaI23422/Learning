package Hard.Array;

import java.util.HashMap;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/number-of-flowers-in-full-bloom/">2251.Number of Flowers in Full Bloom</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> 2D integer array <code>flowers</code>, where <code>flowers[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> means the <code>i<sup>th</sup></code> flower will be in <strong>full bloom</strong> from <code>start<sub>i</sub></code> to <code>end<sub>i</sub></code> (<strong>inclusive</strong>). You are also given a <strong>0-indexed</strong> integer array <code>people</code> of size <code>n</code>, where <code>people[i]</code> is the time that the <code>i<sup>th</sup></code> person will arrive to see the flowers.</p>

<p>Return <em>an integer array </em><code>answer</code><em> of size </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the <strong>number</strong> of flowers that are in full bloom when the </em><code>i<sup>th</sup></code><em> person arrives.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/02/ex1new.jpg" style="width: 550px; height: 216px;">
<pre><strong>Input:</strong> flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11]
<strong>Output:</strong> [1,2,2,2]
<strong>Explanation: </strong>The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/02/ex2new.jpg" style="width: 450px; height: 195px;">
<pre><strong>Input:</strong> flowers = [[1,10],[3,3]], poeple = [3,3,2]
<strong>Output:</strong> [2,2,1]
<strong>Explanation:</strong> The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= flowers.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>flowers[i].length == 2</code></li>
	<li><code>1 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= people.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= people[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class NumberOfFlowersInFullBloom {
    public static void main(String[] args) {
        int[][] flowers = {{19,37},{19,38},{19,35}};
        int[] people = {6,7,21,1,13,37,5,37,46,43};

        NumberOfFlowersInFullBloom_Solution res = new NumberOfFlowersInFullBloom_Solution();

        for (int i : res.fullBloomFlowers(flowers, people)) {
            System.out.print(i + " , ");
        }
    }   
}

class NumberOfFlowersInFullBloom_Solution {
    // Time Limit Exceed for O(n.m)
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        int i = 0;

        for (int p : people) {
            for (int[] flower : flowers) {
                if (flower[0] <= p && p <= flower[1] ) {
                    res[i]++;
                }
            }

            i++;   
        }

        return res;
    }
}

class NumberOfFlowersInFullBloom_Solution2 {
    // Time Limit Exceed for O(n^2)
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        HashMap<Integer,Integer> FlowerNumbs = new HashMap<>();

        for (int[] flower : flowers) {
            for (int i = flower[0]-1; i < flower[1]; i++) {
                FlowerNumbs.put(i, FlowerNumbs.getOrDefault(i, 0)+1);
            }
        }

        int i = 0;
        for (int p : people) {
            if (FlowerNumbs.get(p-1) != null) {
                res[i] = FlowerNumbs.get(p-1);
            } else {
                res[i] = 0;
            }
            
            i++;
        }

        return res;
    }
}


