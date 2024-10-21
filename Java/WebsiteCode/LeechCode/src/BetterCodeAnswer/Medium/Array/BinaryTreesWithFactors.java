package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/binary-trees-with-factors/">823.Binary Trees With Factors</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an array of unique integers, <code>arr</code>, where each integer <code>arr[i]</code> is strictly greater than <code>1</code>.</p>

<p>We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.</p>

<p>Return <em>the number of binary trees we can make</em>. The answer may be too large so return the answer <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [2,4]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can make these trees: <code>[2], [4], [4, 2, 2]</code></pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [2,4,5,10]
<strong>Output:</strong> 7
<strong>Explanation:</strong> We can make these trees: <code>[2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]</code>.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>2 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
	<li>All the values of <code>arr</code> are <strong>unique</strong>.</li>
</ul>
</div></div>
 */
public class BinaryTreesWithFactors {
    public static void main(String[] args) {
        int[][] tests = {
            {2,4},
            {2,4,5,10},
            {18,3,6,2}
        };

        BinaryTreesWithFactors_Solution res = new BinaryTreesWithFactors_Solution();

        for (int[] test : tests) {
            System.out.println(res.numFactoredBinaryTrees(test));;
        }
    }    
}

class BinaryTreesWithFactors_Solution {
    // 14 ms
    // 43.2 MB
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long [] dp = new long[arr.length];
        Arrays.fill(dp,1);
        long MOD=(int)1e9+7,ans=1;
        dp[0]=1;
        Map<Integer,Integer> index = new HashMap<Integer,Integer>();
        index.put(arr[0],0);

        for(int i=1;i<dp.length;i++){
            index.put(arr[i],i);

            for(int j=0;arr[j]<=Math.sqrt(arr[i]);j++){
                if(arr[j]*(long )arr[j]==arr[i]){
                    dp[i]+=dp[j] *(long ) dp[j]%MOD;
                    dp[i]%=MOD;
                }
                else if(arr[i]%arr[j]==0&&index.containsKey(arr[i]/arr[j])){
                    dp[i]+=dp[j]*dp[index.get(arr[i]/arr[j])]*2%MOD;
                }
            }
            ans=(ans+dp[i])%MOD;
        }
        return (int)ans;
     }

    @Override
    public String toString() {
        return "BinaryTreesWithFactors_Solution []";
    }
}