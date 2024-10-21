package Easy.Number.GuessNumberHigherOrLower;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/guess-number-higher-or-lower/">374. Guess Number Higher or Lower</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>We are playing the Guess Game. The game is as follows:</p>

<p>I pick a number from <code>1</code> to <code>n</code>. You have to guess which number I picked.</p>

<p>Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.</p>

<p>You call a pre-defined API <code>int guess(int num)</code>, which returns three possible results:</p>

<ul>
	<li><code>-1</code>: Your guess is higher than the number I picked (i.e. <code>num &gt; pick</code>).</li>
	<li><code>1</code>: Your guess is lower than the number I picked (i.e. <code>num &lt; pick</code>).</li>
	<li><code>0</code>: your guess is equal to the number I picked (i.e. <code>num == pick</code>).</li>
</ul>

<p>Return <em>the number that I picked</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 10, pick = 6
<strong>Output:</strong> 6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1, pick = 1
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 2, pick = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>1 &lt;= pick &lt;= n</code></li>
</ul>
</div>
*/
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        int[][] tests = {
			{10,6},
			{1,1},
			{2,1},
			{1000,50},
		};

		for (int[] test : tests) {
			int n = test[0];

			GuessGame.setNumber(test[1]);

			System.out.println(new GuessNumberHigherOrLower_Solution().guessNumber(n));
		}
    }
}

// 0 ms 39.93 MB
class GuessNumberHigherOrLower_Solution extends GuessGame {
    public int guessNumber(int n) {
		
		// Time Limit Exceeded
		// Brute-Force:
		// for (int i = 1; i < n; i++) {
        //     if (guess(i) == 0){
        //         return i;
        //     }
        // }
			
		// Time Limit Exceeded
		// Loop-Recursion:
		// int guessing = guess(n);
		// while (guessing != 0) {
		// 	if (guessing > 0) {
		// 		n = (n+1)*2;
		// 	} else {
		// 		n = n/2;
		// 	}

		// 	guessing = guess(n);
		// }

		// Time Limit Exceeded
		// int left = 1,
		// 	right = n,
		// 	mid = (left+right)/2,
		// 	guessing = guess(mid);
		// while (guessing != 0) {
		// 	if (guessing < 0) {
		// 		right = mid;
		// 	} else {
		// 		left = mid;
		// 	}
			
		// 	mid = (left+right)/2;
		// 	guessing = guess(mid);
		// }

		
		int start=1,
			end=n,
			mid=start+(end-start)/2,
			guessing=guess(mid);
        while(start<=end && guessing != 0){
			if(guessing < 0){
                end=mid-1; 
			}  else if(guessing > 0){
				start=mid+1;
			}
            mid=start+(end-start)/2; 
			guessing=guess(mid);
        }

        return mid;
    }
}