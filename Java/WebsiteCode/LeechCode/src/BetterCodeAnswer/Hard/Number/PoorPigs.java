package BetterCodeAnswer.Hard.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/poor-pigs/">458.Poor Pigs</a>
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>There are <code>buckets</code> buckets of liquid, where <strong>exactly one</strong> of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not. Unfortunately, you only have <code>minutesToTest</code> minutes to determine which bucket is poisonous.</p>

<p>You can feed the pigs according to these steps:</p>

<ol>
	<li>Choose some live pigs to feed.</li>
	<li>For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time. Each pig can feed from any number of buckets, and each bucket can be fed from by any number of pigs.</li>
	<li>Wait for <code>minutesToDie</code> minutes. You may <strong>not</strong> feed any other pigs during this time.</li>
	<li>After <code>minutesToDie</code> minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.</li>
	<li>Repeat this process until you run out of time.</li>
</ol>

<p>Given <code>buckets</code>, <code>minutesToDie</code>, and <code>minutesToTest</code>, return <em>the <strong>minimum</strong> number of pigs needed to figure out which bucket is poisonous within the allotted time</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> buckets = 4, minutesToDie = 15, minutesToTest = 15
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can determine the poisonous bucket as follows:
At time 0, feed the first pig buckets 1 and 2, and feed the second pig buckets 2 and 3.
At time 15, there are 4 possible outcomes:
- If only the first pig dies, then bucket 1 must be poisonous.
- If only the second pig dies, then bucket 3 must be poisonous.
- If both pigs die, then bucket 2 must be poisonous.
- If neither pig dies, then bucket 4 must be poisonous.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> buckets = 4, minutesToDie = 15, minutesToTest = 30
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can determine the poisonous bucket as follows:
At time 0, feed the first pig bucket 1, and feed the second pig bucket 2.
At time 15, there are 2 possible outcomes:
- If either pig dies, then the poisonous bucket is the one it was fed.
- If neither pig dies, then feed the first pig bucket 3, and feed the second pig bucket 4.
At time 30, one of the two pigs must die, and the poisonous bucket is the one it was fed.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= buckets &lt;= 1000</code></li>
	<li><code>1 &lt;=&nbsp;minutesToDie &lt;=&nbsp;minutesToTest &lt;= 100</code></li>
</ul>
</div></div>
 */
public class PoorPigs {
    public static void main(String[] args) {
        int[][] tests = {
            {4,15,15},
            {4,15,30}
        };

        PoorPigs_Solution res = new PoorPigs_Solution();

        for (int[] test : tests) {
            int buckets = test[0],
            minutesToDie = test[1],
            minutesToTest = test[2];

            System.err.println(res.poorPigs(buckets, minutesToDie, minutesToTest));
        }
    }
}

class PoorPigs_Solution {
    // 0 ms 
    // 38.8 MB
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Calculate the max time for a pig to test buckets...
        // Note that, max time will not be (minutesToTest / minutesToDie)...
        // Thinking about all pigs drinking all buckets at last, but no one died immediately, so the poison bucket is the last bucket...
        int max_time = minutesToTest / minutesToDie + 1;
        // Initialize the required minimum number of pigs...
        int req_pigs = 0;
        // To find the minimum number of pigs, find the minimum req_pigs such that Math.pow(max_time, req_pigs) >= buckets...
        while (Math.pow(max_time, req_pigs) < buckets)
            // Increment until it will be greater or equals to bucket...
            ++req_pigs;
        // Return the required minimum number of pigs...
        return req_pigs;
    }
}

class PoorPigs_Solution2 {
    public int poorPigs(int buckets, int timeToDie, int timeToTest) {
        int testsPerPig = timeToTest / timeToDie;
        int numPigs = 0;
        int states = 1; // Number of unique states a pig can represent   
        while (states < buckets) {
            states *= (testsPerPig + 1);
            numPigs++;
        }
        return numPigs;
    }
}


