package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/median-of-two-sorted-arrays/">4. Median of Two Sorted Arrays</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>

<p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,3], nums2 = [2]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 2.50000
<strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>
</div>
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,3},{2}},
            {{},{1}},
            {{1,2},{3,4}}
        };

        for (int[][] test : tests) {
            int[] nums1 = test[0],
                  nums2 = test[1];

            System.out.println(new MedianOfTwoSortedArrays_Solution().findMedianSortedArrays(nums1, nums2));
        }
    }
}

// 2 ms 45.7 MB
class MedianOfTwoSortedArrays_Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int low =0, high = m;
        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = (m+n+1)/2-mid1;
            int max1=(mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
            int max2=(mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
            int min1=(mid1==m)?Integer.MAX_VALUE:nums1[mid1];
            int min2=(mid2==n)?Integer.MAX_VALUE:nums2[mid2];
            if(max1<=min2 && max2<=min1){
                if((m+n)%2==0){
                    return (Math.max(max1,max2)+Math.min(min1,min2))/2.0;
                }else
                    return Math.max(max1,max2);
            }else if (max1>min2){
                high=mid1-1;
            }else  
                low=mid1+1;
        }
        
        return 0;
        
    }
}