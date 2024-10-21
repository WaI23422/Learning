package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/largest-number/">179. Largest Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a list of non-negative integers <code>nums</code>, arrange them such that they form the largest number and return it.</p>
 * 
 * <p>Since the result may be very large, so you need to return a string instead of an integer.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [10,2]
 * <strong>Output:</strong> "210"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [3,30,34,5,9]
 * <strong>Output:</strong> "9534330"
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[][] tests = {
            {432,43243},
            {3,5,30,34,9,922,91,55,545},
            {10,2},
        };

        for (int[] nums : tests) {
            System.out.println(new LargestNumber_Solution().largestNumber(nums));
        }
    }
}

// 1ms 42.00MB
class LargestNumber_Solution {
    public void merge(int[]arr,int low,int mid,int high){
        int i = low, 
            j = mid+1,
            temp[] = new int[high-low+1],
            k = 0;

        while(i<=mid && j<=high){
            long n=10,m=10;
            while(arr[i]>=n){n*=10;}
            while(arr[j]>=m){m*=10;}

            long l=arr[i]*m+arr[j];
            long r=arr[j]*n+arr[i];
            if(l>r){
                temp[k++]=arr[i++];
            } else{
                temp[k++]=arr[j++];
            }
        }
        
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=high){
            temp[k++]=arr[j++];
        }

        k=0;
        int m = low;
        while(m<=high){
            arr[m++]=temp[k++];
        }
    }

    public void mergesort(int[]arr,int low,int high){
        if(low==high){
            return ;
        }

        int mid=low+(high-low)/2;

        mergesort(arr,low,mid);
        mergesort(arr,mid+1,high);

        merge(arr,low,mid,high);
    }

    public String largestNumber(int[] nums) {
        mergesort(nums,0,nums.length-1);
        StringBuilder str=new StringBuilder();
        
        for(int i=0;i<nums.length;i++){
            str.append(String.valueOf(nums[i]));
        }

        return (str.charAt(0)=='0')?"0":str.toString();
    }
}