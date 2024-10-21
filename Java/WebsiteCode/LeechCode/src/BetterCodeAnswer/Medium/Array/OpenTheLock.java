package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

// 10ms 
class OpenTheLock_Solution2 {
    public int openLock(String[] deadends, String target) {
        final int kMaxN = 10000;
        List<Integer> bases = Arrays.asList(1, 10, 100, 1000);
        int start = 0;
        int goal = Integer.parseInt(target);
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int[] v1 = new int[kMaxN];
        int[] v2 = new int[kMaxN];  
        Arrays.fill(v1, 0);
        Arrays.fill(v2, 0);
        
        for (String deadend : deadends) {
            int dead = Integer.parseInt(deadend);
            v1[dead] = -1;
            v2[dead] = -1;
        }
        
        if (v1[start] == -1) return -1;
        if (start == goal) return 0;
        
        v1[start] = 1;
        v2[goal] = 1;
        
        int s1 = 0;
        int s2 = 0;
        q1.offer(start);
        q2.offer(goal);
        
        while (!q1.isEmpty() && !q2.isEmpty()) {      
            if (!q1.isEmpty()) ++s1;
            int size = q1.size();
            for (int i = 0; i < size; ++i) {
                int curr = q1.poll(); 
                for (int j = 0; j < 4; ++j) {
                    int r = (curr / bases.get(j)) % 10;
                    for (int k = -1; k <= 1; k += 2) {
                        int next = curr + ((r + k + 10) % 10 - r) * bases.get(j);
                        if (v2[next] == 1) return s1 + s2;
                        if (v1[next] != 0) continue;            
                        q1.offer(next);
                        v1[next] = 1;
                    }
                }
            }
            // Swap queues and visited arrays
            Queue<Integer> tempQ = q1;
            q1 = q2;
            q2 = tempQ;
            
            int[] tempV = v1;
            v1 = v2;
            v2 = tempV;
            
            int tempS = s1;
            s1 = s2;
            s2 = tempS;
        }
        
        return -1;
    }
}

// 7ms
class OpenTheLock_Solution {
    public int openLock(String[] deadends, String target) {
        int[] pow10 = {1, 10, 100, 1000};
        int[] visit = new int[10000]; // 0: not visited, 1: visited through forward direction, -1: visited through backward direction, 2: deadends
        for(String dead: deadends) {
            visit[Integer.parseInt(dead)] = 2;
        }
        int src = 0, dest = Integer.parseInt(target), steps = 0, dir = 1;
        if(visit[src] == 2 || visit[dest] == 2) return -1;
        if(src == dest) return 0;
        Queue<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        forward.add(src);
        visit[src] = 1;
        backward.add(dest);
        visit[dest] = -1;
        while(!forward.isEmpty() && !backward.isEmpty()) {
            if(forward.size() > backward.size()) {
                Queue<Integer> tmp = forward; forward = backward; backward = tmp;
                dir = -dir;
            }
            steps++;
            int size = forward.size();
            while(size-- > 0) {
                int cur = forward.poll();
                for(int p: pow10) {
                    int d = (cur / p) % 10;
                    for(int i = -1; i <= 1; i += 2) {
                        int z = d + i;
                        z = z == -1 ? 9 : (z == 10 ? 0 : z);
                        int next = cur + (z - d) * p;
                        if(visit[next] == -dir) return steps;
                        if(visit[next] == 0) {
                            forward.add(next);
                            visit[next] = dir;
                        }
                    }
                }
            }
        }
        return -1;
    }
}