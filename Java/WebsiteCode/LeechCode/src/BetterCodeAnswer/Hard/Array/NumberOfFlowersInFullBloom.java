package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

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
        int[][] flowers = {{1,6},{3,7},{9,12},{4,13}};
        int[] people = {2,3,7,11};

        NumberOfFlowersInFullBloom_Solution res = new NumberOfFlowersInFullBloom_Solution();

        System.out.println(res.fullBloomFlowers(flowers, people));
    }   
}

/**
 * <h2 id="1-data-preparation">1. Data Preparation:</h2>
 * <ul>
<li>Extract the start and end times of each flower from the 'flowers' array.</li>
<li>Sort the start and end times separately. Sorting these times will help us efficiently determine how many flowers are in full bloom at a given time.</li>
</ul>
<h2 id="2-iterate-through-peoples-arrival-times">2. Iterate Through People's Arrival Times:</h2>
<ul>
<li>For each person's arrival time 't' in the 'people' array, perform the following steps:</li>
</ul>
<h2 id="3-use-binary-search-for-start-times">3. Use Binary Search for Start Times:</h2>
<ul>
<li>Use <strong>bisect_left</strong> to find the position in the sorted 'start' list where 't' would be inserted. This position represents the number of flowers that have started blooming before or at the time 't'.</li>
</ul>
<h2 id="4-use-binary-search-for-end-times">4. Use Binary Search for End Times:</h2>
<ul>
<li>Use <strong>bisect_right</strong> to find the position in the sorted 'end' list where 't' would be inserted. This position represents the number of flowers that have finished blooming before or at the time 't'.</li>
</ul>
<h2 id="5-calculate-the-count-of-full-bloom-flowers">5. Calculate the Count of Full Bloom Flowers:</h2>
<ul>
<li>The difference between the positions found in step 3 and step 4 gives the count of flowers that are in full bloom when the person arrives at time 't'.</li>
</ul>
<h2 id="6-collect-and-return-results">6. Collect and Return Results:</h2>
<ul>
<li>Collect the results for all people and store them in a list.</li>
</ul>
 */
class NumberOfFlowersInFullBloom_Solution {
    // 37 ms
    // 73.3 MB
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int[] res = new int[persons.length];
        
        for (int i = 0; i < persons.length; i++) {
            int t = persons[i];
            int started = binarySearchUpperBound(start, t);
            int ended = binarySearchLowerBound(end, t);
            res[i] = started - ended;
        }
        
        return res;
    }
    
    private int binarySearchUpperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int binarySearchLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
