package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/largest-combination-with-bitwise-and-greater-than-zero/">2275. Largest Combination With Bitwise AND Greater Than Zero</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>The <strong>bitwise AND</strong> of an array <code>nums</code> is the bitwise AND of all integers in <code>nums</code>.</p>
 * 
 * <ul>
 * 	<li>For example, for <code>nums = [1, 5, 3]</code>, the bitwise AND is equal to <code>1 &amp; 5 &amp; 3 = 1</code>.</li>
 * 	<li>Also, for <code>nums = [7]</code>, the bitwise AND is <code>7</code>.</li>
 * </ul>
 * 
 * <p>You are given an array of positive integers <code>candidates</code>. Evaluate the <strong>bitwise AND</strong> of every <strong>combination</strong> of numbers of <code>candidates</code>. Each number in <code>candidates</code> may only be used <strong>once</strong> in each combination.</p>
 * 
 * <p>Return <em>the size of the <strong>largest</strong> combination of </em><code>candidates</code><em> with a bitwise AND <strong>greater</strong> than </em><code>0</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> candidates = [16,17,71,62,12,24,14]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The combination [16,17,62,24] has a bitwise AND of 16 &amp; 17 &amp; 62 &amp; 24 = 16 &gt; 0.
 * The size of the combination is 4.
 * It can be shown that no combination with a size greater than 4 has a bitwise AND greater than 0.
 * Note that more than one combination may have the largest size.
 * For example, the combination [62,12,24,14] has a bitwise AND of 62 &amp; 12 &amp; 24 &amp; 14 = 8 &gt; 0.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> candidates = [8,8]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The largest combination [8,8] has a bitwise AND of 8 &amp; 8 = 8 &gt; 0.
 * The size of the combination is 2, so we return 2.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= candidates.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= candidates[i] &lt;= 10<sup>7</sup></code></li>
 * </ul>
 * </div></div>
 */
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public static void main(String[] args) {
        int[][] tests = {
            {16,17,71,62,12,24,14}
        };

        for (int[] candidates : tests) {
            System.out.println(new LargestCombinationWithBitwiseANDGreaterThanZero_Solution().largestCombination(candidates));
        }
    }
}


// 10ms 56.6MB
class LargestCombinationWithBitwiseANDGreaterThanZero_Solution {
    public int largestCombination(int[] candidates) {
       int[] ans=new int[32];
       for(int x:candidates){
           find(x,ans);
       } 
        int res=0;
       for(int i=0;i<32;i++){
           res=Math.max(res,ans[i]);//traverse the bit array and check the max value
       }
       return res;
    }
    public void find(int n,int[] ans){

        int j=31;//index for updating the values in bit array
        while(n>0){
            int a=(n&1);//for checking if bit is set or not
            ans[j]+=a;
            n>>=1;//left shift the given no
            j--;
        }
    }
}