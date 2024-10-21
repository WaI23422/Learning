package BetterCodeAnswer.Hard.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/parallel-courses-iii/">2050.Parallel Courses III</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an integer <code>n</code>, which indicates that there are <code>n</code> courses labeled from <code>1</code> to <code>n</code>. You are also given a 2D integer array <code>relations</code> where <code>relations[j] = [prevCourse<sub>j</sub>, nextCourse<sub>j</sub>]</code> denotes that course <code>prevCourse<sub>j</sub></code> has to be completed <strong>before</strong> course <code>nextCourse<sub>j</sub></code> (prerequisite relationship). Furthermore, you are given a <strong>0-indexed</strong> integer array <code>time</code> where <code>time[i]</code> denotes how many <strong>months</strong> it takes to complete the <code>(i+1)<sup>th</sup></code> course.</p>

<p>You must find the <strong>minimum</strong> number of months needed to complete all the courses following these rules:</p>

<ul>
	<li>You may start taking a course at <strong>any time</strong> if the prerequisites are met.</li>
	<li><strong>Any number of courses</strong> can be taken at the <strong>same time</strong>.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of months needed to complete all the courses</em>.</p>

<p><strong>Note:</strong> The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<strong><img alt="" src="https://assets.leetcode.com/uploads/2021/10/07/ex1.png" style="width: 392px; height: 232px;"></strong>

<pre><strong>Input:</strong> n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
<strong>Output:</strong> 8
<strong>Explanation:</strong> The figure above represents the given graph and the time required to complete each course. 
We start course 1 and course 2 simultaneously at month 0.
Course 1 takes 3 months and course 2 takes 2 months to complete respectively.
Thus, the earliest time we can start course 3 is at month 3, and the total time required is 3 + 5 = 8 months.
</pre>

<p><strong class="example">Example 2:</strong></p>
<strong><img alt="" src="https://assets.leetcode.com/uploads/2021/10/07/ex2.png" style="width: 500px; height: 365px;"></strong>

<pre><strong>Input:</strong> n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
<strong>Output:</strong> 12
<strong>Explanation:</strong> The figure above represents the given graph and the time required to complete each course.
You can start courses 1, 2, and 3 at month 0.
You can complete them after 1, 2, and 3 months respectively.
Course 4 can be taken only after course 3 is completed, i.e., after 3 months. It is completed after 3 + 4 = 7 months.
Course 5 can be taken only after courses 1, 2, 3, and 4 have been completed, i.e., after max(1,2,3,7) = 7 months.
Thus, the minimum time needed to complete all the courses is 7 + 5 = 12 months.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= relations.length &lt;= min(n * (n - 1) / 2, 5 * 10<sup>4</sup>)</code></li>
	<li><code>relations[j].length == 2</code></li>
	<li><code>1 &lt;= prevCourse<sub>j</sub>, nextCourse<sub>j</sub> &lt;= n</code></li>
	<li><code>prevCourse<sub>j</sub> != nextCourse<sub>j</sub></code></li>
	<li>All the pairs <code>[prevCourse<sub>j</sub>, nextCourse<sub>j</sub>]</code> are <strong>unique</strong>.</li>
	<li><code>time.length == n</code></li>
	<li><code>1 &lt;= time[i] &lt;= 10<sup>4</sup></code></li>
	<li>The given graph is a directed acyclic graph.</li>
</ul>
</div></div>
 */
public class ParallelCoursesIII {
    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1,3},{2,3}};
        int[] time = {3,2,5};

        ParallelCoursesIII_Solution res = new ParallelCoursesIII_Solution();
        System.out.println(res.minimumTime(n, relations, time));
    }
}

/**
 * <h1 id="dfs--memoization-top-down-dp-">DFS + Memoization (Top-Down DP): 🚀</h1>
 * <h5 id="1-create-a-graph-to-represent-the-prerequisites-using-an-adjacency-list">1. Create a graph to represent the prerequisites using an adjacency list.</h5>
 * <h5 id="2-create-a-memoization-table-an-array-to-store-the-minimum-time-needed-to-complete-each-course">2. Create a memoization table (an array) to store the minimum time needed to complete each course.</h5>
 * <h5 id="3-define-a-recursive-function-to-calculate-the-minimum-time-to-complete-a-course">3. Define a recursive function to calculate the minimum time to complete a course:</h5>
 * <ul>
<li>a. If the course has already been calculated, return its value from the memoization table.</li>
<li>b. If the course has no prerequisites, its time is simply its own duration.</li>
<li>c. Otherwise, calculate the time to complete this course as the maximum time among its prerequisites plus its own duration.</li>
<li>d. Store this calculated time in the memoization table and return it.</li>
</ul>
<h5 id="4-initialize-a-variable-to-keep-track-of-the-overall-minimum-time">4. Initialize a variable to keep track of the overall minimum time.</h5>
<h5 id="5-for-each-course-calculate-its-minimum-time-using-the-recursive-function-and-update-the-overall-minimum-time-if-necessary">5. For each course, calculate its minimum time using the recursive function and update the overall minimum time if necessary.</h5>
<h5 id="6-the-overall-minimum-time-is-the-answer">6. The overall minimum time is the answer.</h5>
<h1 id="time-and-space-complexity-analysis-️">Time and Space Complexity Analysis: ⏲️</h1>
<ul>
<li><strong>Time Complexity:</strong> <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(V+E)O(V + E)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.22222em;">V</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.05764em;">E</span><span class="mclose">)</span></span></span></span></span>, where V is the number of courses and E is the number of prerequisite relations. The memoization table ensures that each course's time is calculated only once.</li>
<li><strong>Space Complexity:</strong> <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(V)O(V)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.22222em;">V</span><span class="mclose">)</span></span></span></span></span> for the memoization table and <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(E)O(E)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.05764em;">E</span><span class="mclose">)</span></span></span></span></span> for the graph.</li>
</ul>
 */
class ParallelCoursesIII_Solution {
	// 16 ms 
	// 68 MB
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.get(next).add(prev);
        }

        int[] memo = new int[n];
        int overallMinTime = 0;

        for (int i = 0; i < n; i++) {
            overallMinTime = Math.max(overallMinTime, calculateTime(i, graph, time, memo));
        }

        return overallMinTime;
    }

    private int calculateTime(int course, List<List<Integer> > graph, int[] time, int[] memo) {
        if (memo[course] != 0) {
            return memo[course];
        }

        int maxPrerequisiteTime = 0;
        for (int prereq : graph.get(course)) {
            maxPrerequisiteTime = Math.max(maxPrerequisiteTime, calculateTime(prereq, graph, time, memo));
        }

        memo[course] = maxPrerequisiteTime + time[course];
        return memo[course];
    }
}