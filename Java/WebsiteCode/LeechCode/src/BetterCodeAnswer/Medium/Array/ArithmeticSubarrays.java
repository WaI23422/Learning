package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/arithmetic-subarrays/">1630.Arithmetic Subarrays</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>A sequence of numbers is called <strong>arithmetic</strong> if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence <code>s</code> is arithmetic if and only if <code>s[i+1] - s[i] == s[1] - s[0] </code>for all valid <code>i</code>.</p>

<p>For example, these are <strong>arithmetic</strong> sequences:</p>

<pre>1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9</pre>

<p>The following sequence is not <strong>arithmetic</strong>:</p>

<pre>1, 1, 2, 5, 7</pre>

<p>You are given an array of <code>n</code> integers, <code>nums</code>, and two arrays of <code>m</code> integers each, <code>l</code> and <code>r</code>, representing the <code>m</code> range queries, where the <code>i<sup>th</sup></code> query is the range <code>[l[i], r[i]]</code>. All the arrays are <strong>0-indexed</strong>.</p>

<p>Return <em>a list of </em><code>boolean</code> <em>elements</em> <code>answer</code><em>, where</em> <code>answer[i]</code> <em>is</em> <code>true</code> <em>if the subarray</em> <code>nums[l[i]], nums[l[i]+1], ... , nums[r[i]]</code><em> can be <strong>rearranged</strong> to form an <strong>arithmetic</strong> sequence, and</em> <code>false</code> <em>otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = <code>[4,6,5,9,3,7]</code>, l = <code>[0,0,2]</code>, r = <code>[2,3,5]</code>
<strong>Output:</strong> <code>[true,false,true]</code>
<strong>Explanation:</strong>
In the 0<sup>th</sup> query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
In the 1<sup>st</sup> query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
In the 2<sup>nd</sup> query, the subarray is <code>[5,9,3,7]. This</code> can be rearranged as <code>[3,5,7,9]</code>, which is an arithmetic sequence.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
<strong>Output:</strong> [false,true,false,false,true,true]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>m == l.length</code></li>
	<li><code>m == r.length</code></li>
	<li><code>2 &lt;= n &lt;= 500</code></li>
	<li><code>1 &lt;= m &lt;= 500</code></li>
	<li><code>0 &lt;= l[i] &lt; r[i] &lt; n</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>
</div></div>
 */
public class ArithmeticSubarrays {
    public static void main(String[] args) {
        int[][][] tests = {
            {{4,6,5,9,3,7},{0,0,2},{2,3,5}},
            {{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10},{0,1,6,4,8,7},{4,4,9,7,9,10}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0],
            l = test[1],
            r = test[2];

            System.out.println(new ArithmeticSubarrays_Solution().checkArithmeticSubarrays(nums, l, r));
        }
    }
}

class ArithmeticSubarrays_Solution {
    // 9 ms 42.1 MB
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            if(r[i]-l[i]<2) res.add(true);
            else{
                int minNum=minNum(nums,l[i],r[i]);
                int maxNum=maxNum(nums,l[i],r[i]);
                int diff=maxNum-minNum;
                int countDiff=r[i]-l[i];
                
                if(minNum==maxNum) res.add(true);
                else if(diff%countDiff!=0) res.add(false);
                else{
                    int d=diff/countDiff;
                    boolean[] mark=new boolean[r[i]-l[i]+1];
                    boolean flag=true;
                    for(int p=l[i];p<=r[i];p++){
                        if((nums[p]-minNum)%d!=0) {
                            flag=false;
                            break;
                        }
                        if(mark[(nums[p]-minNum)/d]){
                            flag=false;
                            break;
                        }
                        else {
                            mark[(nums[p]-minNum)/d]=true;
                        }

                    }
                    res.add(flag);
                }
            }
        }
        
        System.gc();
        return res;
    }
        
    public int minNum(int[] nums,int left,int right){
        int ans=nums[left];
        for(int i=left;i<=right;i++){
            ans=Math.min(ans,nums[i]);
        }
        return ans;
    }

    public int maxNum(int[] nums,int left,int right){
        int ans=nums[left];
        for(int i=left;i<=right;i++){
            ans=Math.max(ans,nums[i]);
        }
        return ans;
    }
}

class ArithmeticSubarrays_Solution2 {
    // 3 ms 44.6 MB
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
           result.add(isArithmetic(nums, l[i], r[i]));
        }
        return result;
    }


   public boolean isArithmetic(int [] nums, int l, int r){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = l; i <= r; i++) {
            max = Math.max(nums[i],max);        // max of nums
            min = Math.min(nums[i],min);        // min of nums
        }

        int len = r -l +1;
        // if (max-min)/(length-1) yields remainder = 0 => AP
        // else                                         => Not an AP

        if((max-min)%(len-1) !=0)               
            return false;

        int diff = (max-min)/(len-1);
        if(diff == 0)
            return true;

        boolean [] visited = new boolean[len];

        for (int i = l; i <= r; i++) {
            int val = nums[i];
            if((val - min)% diff != 0)          // checking remainder wrt min
                return false;
            else {
                int pos = (val - min) / diff;
                if(visited[pos])                // If node is visited, then it means repeatition of numbers 
                    return false;
                visited[pos] = true;            // If node isn't visited yet, marked it visited
            }
        }
        return true;
    }

}