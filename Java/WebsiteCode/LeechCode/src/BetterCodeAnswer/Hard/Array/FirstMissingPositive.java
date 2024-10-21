package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/first-missing-positive/">41.First Missing Positive</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an unsorted integer array <code>nums</code>. Return the <em>smallest positive integer</em> that is <em>not present</em> in <code>nums</code>.</p>

<p>You must implement an algorithm that runs in <code>O(n)</code> time and uses <code>O(1)</code> auxiliary space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,0]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The numbers in the range [1,2] are all in the array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,4,-1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 1 is in the array but 2 is missing.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [7,8,9,11,12]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The smallest positive integer 1 is missing.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,0},
            {3,4,-1,1},
            {7,8,9,11,12}
        };

        for (int[] nums : tests) {
            System.out.println(new FirstMissingPositive_Solution().firstMissingPositive(nums));
        }
    }
}

// 1 ms 55 MB
class FirstMissingPositive_Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] found = new boolean[n+1];
        for(int i = 0;i< n; i++){
            if (nums[i]>0 && nums[i]<= n){
                found[nums[i]]=true;

            }
        }
        for(int i= 1;i<=n;i++){
            if(!found[i]){
                return i;
            }
        }
        return n+1;
    }
}

// 1 ms 54.6 MB
class FirstMissingPositive_Solution2 {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(correct!=i && nums[i]>0 && nums[i]<nums.length){
                if(nums[i]!=nums[nums[i]-1]){
                    swap(nums,i,correct);
                } else{
                    i++;
                }
            } else{
                    i++;
                }
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }

       return nums.length+1;
    }

    static void swap(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}