package Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/pass-the-pillow/">2582. Pass the Pillow</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> people standing in a line labeled from <code>1</code> to <code>n</code>. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.</p>
 * 
 * <ul>
 * 	<li>For example, once the pillow reaches the <code>n<sup>th</sup></code> person they pass it to the <code>n - 1<sup>th</sup></code> person, then to the <code>n - 2<sup>th</sup></code> person and so on.</li>
 * </ul>
 * 
 * <p>Given the two positive integers <code>n</code> and <code>time</code>, return <em>the index of the person holding the pillow after </em><code>time</code><em> seconds</em>.</p>
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 4, time = 5
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> People pass the pillow in the following way: 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 3 -&gt; 2.
 * After five seconds, the 2<sup>nd</sup> person is holding the pillow.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 3, time = 2
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> People pass the pillow in the following way: 1 -&gt; 2 -&gt; 3.
 * After two seconds, the 3<sup>r</sup><sup>d</sup> person is holding the pillow.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= time &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class PassThePillow {
    public static void main(String[] args) {
        int[][] tests = {
            {3,2},
            {18,38},
            {4,5},
        };

        for (int[] test : tests) {
            int n = test[0],
                time = test[1];

            System.out.println(new PassThePillow_Solution().passThePillow(n, time));
        }
    }
}

class PassThePillow_Solution {
    public int passThePillow(int n, int time) {
        // if (time < n) {return time + 1;}
        int round = time / (n - 1);
        
        if (round % 2 == 0) {
            return time%(n-1) + 1;
        } else {
            return n-(time%(n-1));
        }
    }
}