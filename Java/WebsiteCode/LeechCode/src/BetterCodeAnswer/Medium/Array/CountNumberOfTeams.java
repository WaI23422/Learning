package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-number-of-teams/">1395. Count Number of Teams</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> soldiers standing in a line. Each soldier is assigned a <strong>unique</strong> <code>rating</code> value.</p>
 * 
 * <p>You have to form a team of 3 soldiers amongst them under the following rules:</p>
 * 
 * <ul>
 * 	<li>Choose 3 soldiers with index (<code>i</code>, <code>j</code>, <code>k</code>) with rating (<code>rating[i]</code>, <code>rating[j]</code>, <code>rating[k]</code>).</li>
 * 	<li>A team is valid if: (<code>rating[i] &lt; rating[j] &lt; rating[k]</code>) or (<code>rating[i] &gt; rating[j] &gt; rating[k]</code>) where (<code>0 &lt;= i &lt; j &lt; k &lt; n</code>).</li>
 * </ul>
 * 
 * <p>Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> rating = [2,5,3,4,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> rating = [2,1,3]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> We can't form any team given the conditions.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> rating = [1,2,3,4]
 * <strong>Output:</strong> 4
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == rating.length</code></li>
 * 	<li><code>3 &lt;= n &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= rating[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li>All the integers in <code>rating</code> are <strong>unique</strong>.</li>
 * </ul>
 * </div>
 */
public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[][] tests = {
            {2,5,3,4,1}
        };

        for (int[] rating : tests) {
            System.out.println(new CountNumberOfTeams_Solution().numTeams(rating));
        }
    }
}

// 5ms 44.78MB
/**
 * <h3 id="approach-4-binary-indexed-tree-fenwick-tree" level="3" class="group/heading relative"><a href="#approach-4-binary-indexed-tree-fenwick-tree" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 4: Binary Indexed Tree (Fenwick Tree)</h3>
 * <p>In our previous approach, we performed a linear scan of elements to the left and right of each middle soldier, which contributed an <span class="math math-inline"><span class="katex"><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> factor to our overall complexity. To enhance efficiency, we need to explore a more advanced approach.</p>
 * <p>One such optimization involves querying the total count of smaller soldiers on either side of each soldier. This type of query can be optimized to <span class="math math-inline"><span class="katex"><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mop">lo<span style="margin-right: 0.01389em;">g</span></span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> time using a data structure known as a Binary Indexed Tree (BIT) or Fenwick Tree. While a comprehensive explanation of how a BIT operates is beyond the scope of this article, interested readers can refer to <a href="https://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a" target="_blank">this discussion</a> for a deeper understanding. For hands-on practice, consider tackling these problems:</p>
 * <ol>
 * <li><a href="https://leetcode.com/problems/range-sum-query-mutable/description/" target="_blank">Range Sum Query - Mutable</a></li>
 * <li><a href="https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/" target="_blank">Count of Smaller Numbers After Self</a></li>
 * </ol>
 * <p>Our improved solution utilizes two BITs: one to manage the left side and another for the right side of the current soldier. Each <code>BIT</code> stores frequency counts of ratings within a specific range. For instance, <code>BIT[5]</code> keeps track of the number of soldiers with a rating of <code>5</code>, while <code>BIT[6]</code> aggregates counts for ratings of <code>5</code> and <code>6</code>.</p>
 * <p>Here is an example to get a better understanding of how the BIT stores the frequency counts of ratings:</p>
 * <p><div class="relative mx-auto mb-6 flex flex-col overflow-hidden rounded-lg border-[1px] border-label-1" style="max-width: 1402px;"><div class="rounded-lg" style="max-height: 922px;"><img alt="Current" class="object-fit-contain !mb-0 max-h-full max-w-full" src="blob:https://leetcode.com/30c385db-eaaa-4bae-9f53-89891e99a7a0"></div><div class="absolute top-[50%] left-[50%] flex h-12 w-12 translate-x-[-50%] translate-y-[-50%] items-center justify-center rounded-full bg-black/30"><div class="flex h-4 w-4 cursor-pointer items-center justify-center text-[35px]"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-full w-full text-white"><path fill-rule="evenodd" d="M18.97 12.871l-12.96 7.29a1 1 0 01-1.49-.87V4.71a1 1 0 011.49-.872l12.96 7.29a1 1 0 010 1.743z" clip-rule="evenodd"></path></svg></div></div><div class="relative flex h-8 select-none items-center justify-around bg-black"><div class="flex items-center space-x-7"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M16.091 4.929l-7.057 7.078 7.057 7.064a1 1 0 01-1.414 1.414l-7.764-7.77a1 1 0 010-1.415l7.764-7.785a1 1 0 111.415 1.414z" clip-rule="evenodd"></path></svg><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M18.97 12.871l-12.96 7.29a1 1 0 01-1.49-.87V4.71a1 1 0 011.49-.872l12.96 7.29a1 1 0 010 1.743z" clip-rule="evenodd"></path></svg><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M7.913 19.071l7.057-7.078-7.057-7.064a1 1 0 011.414-1.414l7.764 7.77a1 1 0 010 1.415l-7.764 7.785a1 1 0 01-1.414-1.414z" clip-rule="evenodd"></path></svg></div><div class="absolute right-0 mr-5 text-xs font-medium text-white">1 / 3</div></div></div></p>
 * <p>To implement our algorithm, we start by populating the right <code>BIT</code> with all the soldier ratings. As we process each soldier, we remove their rating from the right <code>BIT</code> and consider them the middle soldier. To count increasing sequences, we query the number of soldiers with lower ratings in the left <code>BIT</code> and the number of soldiers with higher ratings in the right <code>BIT</code>. The product of these two counts gives the total number of increasing teams with the current soldier positioned in the middle. Similarly, we perform this process to calculate the number of decreasing sequence teams. After processing, the current soldier's rating is added to the left <code>BIT</code>, and we continue with the next iteration.</p>
 * <h4 id="algorithm-3">Algorithm</h4>
 * <p>Main method <code>numTeams</code>:</p>
 * <ul>
 * <li>Set <code>maxRating</code> to the maximum rating in the <code>rating</code> array.</li>
 * <li>Initialize two binary indexed trees <code>leftBIT</code> and <code>rightBIT</code>, each of size <code>maxRating + 1</code>.</li>
 * <li>Populate <code>rightBIT</code> with all ratings initially using the <code>updateBIT</code> method.</li>
 * <li>Initialize <code>teams</code> to <code>0</code> to store the count of valid teams.</li>
 * <li>Iterate through each <code>rating</code> in the input array:
 * <ul>
 * <li>Remove the current <code>rating</code> from <code>rightBIT</code>.</li>
 * <li>Count <code>smallerRatingsLeft</code> using <code>getPrefixSum</code> on <code>leftBIT</code>.</li>
 * <li>Count <code>smallerRatingsRight</code> using <code>getPrefixSum</code> on <code>rightBIT</code>.</li>
 * <li>Set <code>largerRatingsLeft</code> as (all ratings) - (the ratings at and below the current <code>rating</code>) on <code>leftBIT</code>.</li>
 * <li>Set <code>largerRatingsRight</code> as (all ratings) - (the ratings at or below the current <code>rating</code>) on <code>rightBIT</code>.</li>
 * <li>Add to <code>teams</code>:
 * <ul>
 * <li>Product of <code>smallerRatingsLeft</code> and <code>largerRatingsRight</code> (increasing sequences).</li>
 * <li>Product of <code>largerRatingsLeft</code> and <code>smallerRatingsRight</code> (decreasing sequences).</li>
 * </ul>
 * </li>
 * <li>Add the current <code>rating</code> to the <code>leftBIT</code>.</li>
 * </ul>
 * </li>
 * <li>Returns <code>teams</code> as the total number of teams possible.</li>
 * </ul>
 * <p>Helper method <code>updateBIT</code>:</p>
 * <ul>
 * <li>Define a method <code>updateBIT</code> with parameters: <code>BIT</code>, <code>index</code> and <code>value</code>.</li>
 * <li>While <code>index</code> is within the bounds of <code>BIT</code>:
 * <ul>
 * <li>Add the given <code>value</code> to the current <code>index</code>.</li>
 * <li>Move to the next node in the <code>BIT</code> by adding <code>index &amp; (-index)</code> to <code>index</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * <p>Helper method <code>getPrefixSum</code>:</p>
 * <ul>
 * <li>Define a method <code>getPrefixSum</code> with parameters: <code>BIT</code> and <code>index</code>.</li>
 * <li>Initialize a variable <code>sum</code> to <code>0</code>.</li>
 * <li>While <code>index</code> is greater than <code>0</code>:
 * <ul>
 * <li>Add the value at the current <code>index</code> in the <code>BIT</code> to <code>sum</code>.</li>
 * <li>Move to the parent node in the <code>BIT</code> by subtracting <code>index &amp; (-index)</code> from <code>index</code>.</li>
 * </ul>
 * </li>
 * <li>Return <code>sum</code>.</li>
 * </ul>
 */
class CountNumberOfTeams_Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        if (n < 3) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : rating) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int[] leftTree = new int[max - min + 2];
        int[] rightTree = new int[max - min + 2];
        
        for (int num : rating) {
            update(rightTree, num - min, 1);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            update(rightTree, rating[i] - min, -1);
            
            int lessLeft = query(leftTree, rating[i] - min - 1);
            int greaterLeft = i - lessLeft;
            
            int lessRight = query(rightTree, rating[i] - min - 1);
            int greaterRight = (n - i - 1) - lessRight;
            
            count += lessLeft * greaterRight + greaterLeft * lessRight;
            
            update(leftTree, rating[i] - min, 1);
        }
        
        return count;
    }

    private void update(int[] tree, int index, int value) {
        index++;
        while (index < tree.length) {
            tree[index] += value;
            index += index & (-index);
        }
    }

    private int query(int[] tree, int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }
}

// 33ms 42.27MB
class CountNumberOfTeams_Solution2 {
    public int numTeams(int[] rating) {
        int n = rating.length, l;
        int pre[] = new int[n], post[] = new int[n];
        for(int i = 1; i < n; i++){
            l = 0;
            for(int j = 0; j < i; j++) if(rating[i] > rating[j]) l++;
            pre[i] = l;
        }

        for(int i = n - 2; i >= 0; i--){
            l = 0;
            for(int j = i + 1; j < n; j++) if(rating[i] > rating[j]) l++;
            post[i] = l;
        }

        l = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < n-1; j++){
                if(j < i && rating[j] < rating[i]) l += pre[j];
                else if(j > i && rating[j] < rating[i]) l += post[j];
            }
        }

        return l;
    }
}