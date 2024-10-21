package BetterCodeAnswer.Medium.Array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-the-winner-of-an-array-game/">1535.Find the Winner of an Array Game</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer array <code>arr</code> of <strong>distinct</strong> integers and an integer <code>k</code>.</p>

<p>A game will be played between the first two elements of the array (i.e. <code>arr[0]</code> and <code>arr[1]</code>). In each round of the game, we compare <code>arr[0]</code> with <code>arr[1]</code>, the larger integer wins and remains at position <code>0</code>, and the smaller integer moves to the end of the array. The game ends when an integer wins <code>k</code> consecutive rounds.</p>

<p>Return <em>the integer which will win the game</em>.</p>

<p>It is <strong>guaranteed</strong> that there will be a winner of the game.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [2,1,3,5,4,6,7], k = 2
<strong>Output:</strong> 5
<strong>Explanation:</strong> Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [3,2,1], k = 10
<strong>Output:</strong> 3
<strong>Explanation:</strong> 3 will win the first 10 rounds consecutively.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>arr</code> contains <strong>distinct</strong> integers.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class FindTheWinnerOfAnArrayGame {
    public static void main(String[] args) {
        int[][][] tests  = {
            // {{3,2,1},{10}},
            // {{2,1,3,5,4,6,7},{2}}
            // {{1,3},{10}}
            // {{2,3,1},{2}}
        };

        FindTheWinnerOfAnArrayGame_Solution res = new FindTheWinnerOfAnArrayGame_Solution();

        for (int[][] test : tests) {
            int[] arr = test[0];
            int k = test[1][0];

            System.out.println(res.getWinner(arr, k));
        }
    }
}

class FindTheWinnerOfAnArrayGame_Solution {
    // 19 ms 54.6 MB
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
        }
        if(k>=n )
            return max;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int peek = arr[0];
        int cnt = 0;
        pq.add(arr[0]);

        for(int i=1;i<n;i++){
            pq.add(arr[i]);
            if(pq.peek() == peek){
                cnt++;
            }
            else{
                peek = pq.peek();
                cnt = 1;
            }
            if(cnt == k)
                break;
        }
        
        System.gc(); // 21 ms 51.2 MB
        return peek;
    }
}

class FindTheWinnerOfAnArrayGame_Solution2 {
    // 0 ms
    // 56.5 MB
    public int getWinner(int[] arr, int k) {
        int win=0;
        int ele=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>ele){
                win=0;
                ele=arr[i];
            }
            if(++win==k){
               break;
            }
        }

        System.gc(); // 3 ms 51.6 MB
        return ele;
    }
}

