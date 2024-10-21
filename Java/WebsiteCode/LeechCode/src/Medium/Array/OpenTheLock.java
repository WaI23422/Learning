package Medium.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/open-the-lock/">752. Open the Lock</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: <code>'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'</code>. The wheels can rotate freely and wrap around: for example we can turn <code>'9'</code> to be <code>'0'</code>, or <code>'0'</code> to be <code>'9'</code>. Each move consists of turning one wheel one slot.</p>

<p>The lock initially starts at <code>'0000'</code>, a string representing the state of the 4 wheels.</p>

<p>You are given a list of <code>deadends</code> dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.</p>

<p>Given a <code>target</code> representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> deadends = ["0201","0101","0102","1212","2002"], target = "0202"
<strong>Output:</strong> 6
<strong>Explanation:</strong> 
A sequence of valid moves would be "0000" -&gt; "1000" -&gt; "1100" -&gt; "1200" -&gt; "1201" -&gt; "1202" -&gt; "0202".
Note that a sequence like "0000" -&gt; "0001" -&gt; "0002" -&gt; "0102" -&gt; "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> deadends = ["8888"], target = "0009"
<strong>Output:</strong> 1
<strong>Explanation:</strong> We can turn the last wheel in reverse to move from "0000" -&gt; "0009".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
<strong>Output:</strong> -1
<strong>Explanation:</strong> We cannot reach the target without getting stuck.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= deadends.length &lt;= 500</code></li>
	<li><code>deadends[i].length == 4</code></li>
	<li><code>target.length == 4</code></li>
	<li>target <strong>will not be</strong> in the list <code>deadends</code>.</li>
	<li><code>target</code> and <code>deadends[i]</code> consist of digits only.</li>
</ul>
</div>
 */
public class OpenTheLock {
    public static void main(String[] args) {
        String[][][] tests = {
            {{"0201","0101","0102","1212","2002"},{"0202"}},
            {{"8888"},{"0009"}}
        };

        for (String[][] test : tests) {
            String[] deadends = test[0];
            String target = test[1][0];

            System.out.println(new OpenTheLock_Solution().openLock(deadends, target));
        }
    }
}

// 161ms 51.76MB
class OpenTheLock_Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add("0000");
        queue.add("0000");

        int level = 0;
        // BFS
        while (!queue.isEmpty()) {
            // iterate the nodes which are already in the queue
            int size = queue.size();
            while(size > 0) {
                String lockPos = queue.poll();
                if(deadEnds.contains(lockPos)){
                    size--;
                    continue;
                }
                if(Objects.equals(lockPos, target)) {
                    return level;
                }

                for (int i=0; i<4; i++) {
                    String[] strings = generateCombinations(lockPos, i);
                    for(String str : strings){
                        if(!visited.contains(str) && !deadEnds.contains(str)){
                            queue.offer(str);
                            visited.add(str);
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return -1;          // there is no path from root to target
    }

    private String[] generateCombinations(String lockPos, int i){
        StringBuilder stringBuilder = new StringBuilder(lockPos);
        char charAtCurrentPos = stringBuilder.charAt(i);
        String[] resultStrings = new String[2];
        resultStrings[0] =
                stringBuilder.substring(0,i)
                        + (((charAtCurrentPos-'0')+1) % 10)
                        + stringBuilder.substring(i+1);
        resultStrings[1] = stringBuilder.substring(0,i)
                + (((charAtCurrentPos-'0')+9) % 10)
                + stringBuilder.substring(i+1);
        return resultStrings;
    }
}