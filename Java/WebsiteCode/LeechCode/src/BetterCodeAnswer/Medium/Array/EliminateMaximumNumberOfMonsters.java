package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/eliminate-maximum-number-of-monsters/">1921.Eliminate Maximum Number of Monsters</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are playing a video game where you are defending your city from a group of <code>n</code> monsters. You are given a <strong>0-indexed</strong> integer array <code>dist</code> of size <code>n</code>, where <code>dist[i]</code> is the <strong>initial distance</strong> in kilometers of the <code>i<sup>th</sup></code> monster from the city.</p>

<p>The monsters walk toward the city at a <strong>constant</strong> speed. The speed of each monster is given to you in an integer array <code>speed</code> of size <code>n</code>, where <code>speed[i]</code> is the speed of the <code>i<sup>th</sup></code> monster in kilometers per minute.</p>

<p>You have a weapon that, once fully charged, can eliminate a <strong>single</strong> monster. However, the weapon takes <strong>one minute</strong> to charge. The weapon is fully charged at the very start.</p>

<p>You lose when any monster reaches your city. If a monster reaches the city at the exact moment the weapon is fully charged, it counts as a <strong>loss</strong>, and the game ends before you can use your weapon.</p>

<p>Return <em>the <strong>maximum</strong> number of monsters that you can eliminate before you lose, or </em><code>n</code><em> if you can eliminate all the monsters before they reach the city.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> dist = [1,3,4], speed = [1,1,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
In the beginning, the distances of the monsters are [1,3,4]. You eliminate the first monster.
After a minute, the distances of the monsters are [X,2,3]. You eliminate the second monster.
After a minute, the distances of the monsters are [X,X,2]. You eliminate the thrid monster.
All 3 monsters can be eliminated.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> dist = [1,1,2,3], speed = [1,1,1,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
In the beginning, the distances of the monsters are [1,1,2,3]. You eliminate the first monster.
After a minute, the distances of the monsters are [X,0,1,2], so you lose.
You can only eliminate 1 monster.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> dist = [3,2,4], speed = [5,3,2]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
In the beginning, the distances of the monsters are [3,2,4]. You eliminate the first monster.
After a minute, the distances of the monsters are [X,0,2], so you lose.
You can only eliminate 1 monster.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == dist.length == speed.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= dist[i], speed[i] &lt;= 10<sup>5</sup></code></li>
</ul>
</div></div>
 */
public class EliminateMaximumNumberOfMonsters {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,3,4},{1,1,1}}, // 3
            {{1,1,2,3},{1,1,1,1}}, // 1 
            {{3,2,4},{5,3,2}}, // 1
            {{3,2,1},{2,1,1}}, // 2
            {{3,3,3},{3,2,1}} // 3
        };

        EliminateMaximumNumberOfMonsters_Solution res = new EliminateMaximumNumberOfMonsters_Solution();

        for (int[][] test : tests) {
            int[] dist = test[0];
            int[] speed = test[1];

            System.out.println(res.eliminateMaximum(dist, speed));
        }
    }
}

class EliminateMaximumNumberOfMonsters_Solution {
    // 16 ms 
    // 55.2 MB
    public int eliminateMaximum(int[] dist, int[] speed) {
        for (int i = 0; i < dist.length; ++i)
            dist[i] = (dist[i] - 1) / speed[i];

        Arrays.sort(dist);

        for (int i = 0; i < dist.length; ++i)
            if (i > dist[i])
                return i;
        return dist.length;
    }
}