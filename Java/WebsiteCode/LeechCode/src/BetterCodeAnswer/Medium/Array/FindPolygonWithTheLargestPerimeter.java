package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-polygon-with-the-largest-perimeter/">2971.Find Polygon With the Largest Perimeter</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array of <strong>positive</strong> integers <code>nums</code> of length <code>n</code>.</p>

<p>A <strong>polygon</strong> is a closed plane figure that has at least <code>3</code> sides. The <strong>longest side</strong> of a polygon is <strong>smaller</strong> than the sum of its other sides.</p>

<p>Conversely, if you have <code>k</code> (<code>k &gt;= 3</code>) <strong>positive</strong> real numbers <code>a<sub>1</sub></code>, <code>a<sub>2</sub></code>, <code>a<sub>3</sub></code>, ..., <code>a<sub>k</sub></code> where <code>a<sub>1</sub> &lt;= a<sub>2</sub> &lt;= a<sub>3</sub> &lt;= ... &lt;= a<sub>k</sub></code> <strong>and</strong> <code>a<sub>1</sub> + a<sub>2</sub> + a<sub>3</sub> + ... + a<sub>k-1</sub> &gt; a<sub>k</sub></code>, then there <strong>always</strong> exists a polygon with <code>k</code> sides whose lengths are <code>a<sub>1</sub></code>, <code>a<sub>2</sub></code>, <code>a<sub>3</sub></code>, ..., <code>a<sub>k</sub></code>.</p>

<p>The <strong>perimeter</strong> of a polygon is the sum of lengths of its sides.</p>

<p>Return <em>the <strong>largest</strong> possible <strong>perimeter</strong> of a <strong>polygon</strong> whose sides can be formed from</em> <code>nums</code>, <em>or</em> <code>-1</code> <em>if it is not possible to create a polygon</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [5,5,5]
<strong>Output:</strong> 15
<strong>Explanation:</strong> The only possible polygon that can be made from nums has 3 sides: 5, 5, and 5. The perimeter is 5 + 5 + 5 = 15.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,12,1,2,5,50,3]
<strong>Output:</strong> 12
<strong>Explanation:</strong> The polygon with the largest perimeter which can be made from nums has 5 sides: 1, 1, 2, 3, and 5. The perimeter is 1 + 1 + 2 + 3 + 5 = 12.
We cannot have a polygon with either 12 or 50 as the longest side because it is not possible to include 2 or more smaller sides that have a greater sum than either of them.
It can be shown that the largest possible perimeter is 12.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [5,5,50]
<strong>Output:</strong> -1
<strong>Explanation:</strong> There is no possible way to form a polygon from nums, as a polygon has at least 3 sides and 50 &gt; 5 + 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div>
 */
public class FindPolygonWithTheLargestPerimeter {
    public static void main(String[] args) {
        int[][] tests = {
            {5,5,5},
            {1,12,1,2,5,50,3},
            {5,5,50}
        };

        for (int[] nums : tests) {
            System.out.println(new FindPolygonWithTheLargestPerimeter_Solution().largestPerimeter(nums));
        }
    }
}

// 1ms 55.97 MB
class FindPolygonWithTheLargestPerimeter_Solution {
    public long largestPerimeter(int[] nums) {
        return f1(nums , nums.length);
    }
        
    long f1(int[] nums , int end){
        int maxIndex = 0;
        long sum = 0 ;
        for(int i=0 ; i< end ;i++){
            sum += nums[i];
                    
            if( nums[i]> nums[maxIndex])
                maxIndex= i;
        }
            
        if((sum-nums[maxIndex])> nums[maxIndex])
                return sum ;
        else{   
            int temp = nums[maxIndex];
            nums[maxIndex]=nums[end-1];
            nums[end-1]=temp;
            if(end < 3)
                return -1;
            return f1(nums, end-1);
        }
    }
}

// 2ms 55.97 MB
class FindPolygonWithTheLargestPerimeter_Solution2 {
    public long largestPerimeter(int[] nums) {
        long s=0;
        long g=great(nums);
        
        while(true)
        {
           for(int i=0;i<nums.length;i++)
           {  
               if(g==nums[i])
               {    nums[i]=0;break;}
           }
           s=sum(nums);
            if(g<s)
                return (s+g);
           g=great(nums);
            int c=0;
           for(int i=0;i<nums.length;i++)
           {  
               if(0==nums[i])
                   c++;
           } 
            if(c==nums.length)
                return -1;
        }
        //return s;
        
    }
    long sum(int nums[])
    {
        long s=0;
         for(int i=0;i<nums.length;i++)
        {
            s=s+nums[i];
            
        }
        return s;
    }
    long great(int nums[])
    {
        long g=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            
            if(g<nums[i])
                g=nums[i];
        }
        return g;
    }
}