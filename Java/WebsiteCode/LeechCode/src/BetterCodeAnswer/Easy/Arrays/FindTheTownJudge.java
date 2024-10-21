package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-town-judge/">997.Find the Town Judge</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>In a town, there are <code>n</code> people labeled from <code>1</code> to <code>n</code>. There is a rumor that one of these people is secretly the town judge.</p>

<p>If the town judge exists, then:</p>

<ol>
	<li>The town judge trusts nobody.</li>
	<li>Everybody (except for the town judge) trusts the town judge.</li>
	<li>There is exactly one person that satisfies properties <strong>1</strong> and <strong>2</strong>.</li>
</ol>

<p>You are given an array <code>trust</code> where <code>trust[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> representing that the person labeled <code>a<sub>i</sub></code> trusts the person labeled <code>b<sub>i</sub></code>. If a trust relationship does not exist in <code>trust</code> array, then such a trust relationship does not exist.</p>

<p>Return <em>the label of the town judge if the town judge exists and can be identified, or return </em><code>-1</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2, trust = [[1,2]]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 3, trust = [[1,3],[2,3]]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 3, trust = [[1,3],[2,3],[3,1]]
<strong>Output:</strong> -1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>0 &lt;= trust.length &lt;= 10<sup>4</sup></code></li>
	<li><code>trust[i].length == 2</code></li>
	<li>All the pairs of <code>trust</code> are <strong>unique</strong>.</li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>1 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n</code></li>
</ul>
</div>
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        int[][][][] tests = {
            {{{2}},{{1,2}}},
            {{{3}},{{1,3},{2,3}}},
            {{{3}},{{1,3},{2,3},{3,1}}},
            {{{4}},{{1,3},{2,3},{1,4},{2,4},{3,4}}},
        };

        for (int[][][] test : tests) {
            int n = test[0][0][0];
            int[][] trust = test[1];

            System.out.println(new FindTheTownJudge_Solution().findJudge(n, trust));
        }
    }
}

// 2 ms 54.2 MB
class FindTheTownJudge_Solution {
    public int findJudge(int n, int[][] trust) {
        int m = trust.length;
        int indegree[] = new int[n + 1];
        for(int i = 0; i < m; i++){
            indegree[trust[i][1]]++;
        }

        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(indegree[i] == n - 1){
                answer = i;
            }
        }

        for(int i = 0; i < m; i++){
            if(trust[i][0] == answer){
                return -1;
            }
        }

        return answer == 0 ? -1 : answer;
        
    }
}