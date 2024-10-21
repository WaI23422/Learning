package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/largest-perimeter-triangle/">976.Largest Perimeter Triangle</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>the largest perimeter of a triangle with a non-zero area, formed from three of these lengths</em>. If it is impossible to form any triangle of a non-zero area, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,1,2]
<strong>Output:</strong> 5
<strong>Explanation:</strong> You can form a triangle with three side lengths: 1, 2, and 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1,10]
<strong>Output:</strong> 0
<strong>Explanation:</strong> 
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>
</div>
 */
public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[][] tests = {
            {2,1,2},
            {1,2,1,10}
        };

        for (int[] nums : tests) {
            System.out.println(new LargestPerimeterTriangle_Solution().largestPerimeter(nums));
        }
    }
}

// 1 ms 44.68 MB
class LargestPerimeterTriangle_Solution {
    public int largestPerimeter(int[] nums) {
        int len = nums.length;
        int s1=0,s2=0,s3=0,n=len-1;
        for(int i=0; i<len; i++){
            int maxIndex = findMax(nums,n);
            swap(nums,maxIndex,n);
            //System.out.println(Arrays.toString(nums));
            if(len-n>=3){
                s1=nums[n];
                s2=nums[n+1];
                s3=nums[n+2];
               // System.out.println(
                if(s1+s2>s3 && s2+s3>s1 && s1+s3>s2)    return s1+s2+s3;
            }
            
            n--;
        }
        
        return 0;
    }
    public int findMax(int[] nums,int end){
        int max = 0;
        for(int i=0; i<=end; i++)
            if(nums[i]>nums[max]) max=i;
        
        return max;
    }
    public void swap(int[] nums,int j,int i){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}