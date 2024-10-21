package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-the-jumbled-numbers/">2191. Sort the Jumbled Numbers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>mapping</code> which represents the mapping rule of a shuffled decimal system. <code>mapping[i] = j</code> means digit <code>i</code> should be mapped to digit <code>j</code> in this system.</p>
 * 
 * <p>The <strong>mapped value</strong> of an integer is the new integer obtained by replacing each occurrence of digit <code>i</code> in the integer with <code>mapping[i]</code> for all <code>0 &lt;= i &lt;= 9</code>.</p>
 * 
 * <p>You are also given another integer array <code>nums</code>. Return <em>the array </em><code>nums</code><em> sorted in <strong>non-decreasing</strong> order based on the <strong>mapped values</strong> of its elements.</em></p>
 * 
 * <p><strong>Notes:</strong></p>
 * 
 * <ul>
 * 	<li>Elements with the same mapped values should appear in the <strong>same relative order</strong> as in the input.</li>
 * 	<li>The elements of <code>nums</code> should only be sorted based on their mapped values and <strong>not be replaced</strong> by them.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
 * <strong>Output:</strong> [338,38,991]
 * <strong>Explanation:</strong> 
 * Map the number 991 as follows:
 * 1. mapping[9] = 6, so all occurrences of the digit 9 will become 6.
 * 2. mapping[1] = 9, so all occurrences of the digit 1 will become 9.
 * Therefore, the mapped value of 991 is 669.
 * 338 maps to 007, or 7 after removing the leading zeros.
 * 38 maps to 07, which is also 7 after removing leading zeros.
 * Since 338 and 38 share the same mapped value, they should remain in the same relative order, so 338 comes before 38.
 * Thus, the sorted array is [338,38,991].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> mapping = [0,1,2,3,4,5,6,7,8,9], nums = [789,456,123]
 * <strong>Output:</strong> [123,456,789]
 * <strong>Explanation:</strong> 789 maps to 789, 456 maps to 456, and 123 maps to 123. Thus, the sorted array is [123,456,789].
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>mapping.length == 10</code></li>
 * 	<li><code>0 &lt;= mapping[i] &lt;= 9</code></li>
 * 	<li>All the values of <code>mapping[i]</code> are <strong>unique</strong>.</li>
 * 	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt; 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class SortTheJumbledNumbers {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {8,9,4,0,2,1,3,5,7,6},
                {991,338,38}
            },
            {
                {9,8,7,6,5,4,3,2,1,0},
                {0,1,2,3,4,5,6,7,8,9}
            },
        };

        for (int[][] test : tests) {
            int[] mapping = test[0],
                  nums = test[1];

            System.out.println(Arrays.toString(new SortTheJumbledNumbers_Solution().sortJumbled(mapping, nums)));
        }
    }
}

// 28ms 55.49MB  
class SortTheJumbledNumbers_Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
     
        // this problem can be solved using the concept of Radix Sort;

        int max = -1 ;
    
        for(int x : nums){
            if(x > max) max = x ;
        }  

        int [] ans = nums;

        for(int place = 1 ; max/place > 0 ; place *= 10 )   {
        ans = CountSort( ans, place , mapping);
        }
        
        return ans;
    }

    static int[] CountSort(int [] arr , int place, int[] mapping){
        int n = arr.length;

        if( n <= 1 )return arr;

        int[] ans = new int[n];

        int[] freqArr = new int[10];

        for(int x : arr){                   // making frequency array;    
            if(x/place != 0 || x==0){ 
                int val = (x/place) % 10 ;
            
                freqArr[ mapping[val] ]++;        
            } else {
                freqArr[ 0 ]++;        
            }
        }


        for(int i = 1 ; i<10 ; i++){       // converting frequency array into prefix sum array;
            freqArr[i] += freqArr[i-1];
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            if( arr[i]/place != 0 || arr[i]== 0){
                int val = ( arr[i]/place )%10;

                ans[ freqArr[mapping[val]] - 1 ] = arr[i] ;
            
                freqArr[mapping[val]]--;
            } else {
                ans[ freqArr[0] - 1] = arr[i];
                freqArr[0]--;
            }
        }

        return ans;
    }
}

// 63ms 55.6MB
class SortTheJumbledNumbers_Solution2 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int nums_mapped_value[] = new int [nums.length];
        
        for (int i = 0; i < nums.length; i++)
        {
            int temp = nums[i];
            
            if (temp > 0)
            {
                int f = 1;
                int mapped_val = 0;
                while (temp > 0)
                {
                    mapped_val = mapped_val + mapping[temp%10]*f;
                    f = f*10;
                    temp = temp/10;
                }
                
                nums_mapped_value[i] = mapped_val;
            }
            else // for only zeros
            {
                nums_mapped_value[i] = mapping[temp];
            }
            
        }
    

        mergeSort(nums, nums_mapped_value, 0, nums.length - 1);
        
        return nums;
    }

    public void mergeSort(int[] nums, int[] nums_mapped_value, int left, int right)
    {
        if (left < right)
        {
            int middle = left + (right - left) / 2;

            mergeSort(nums, nums_mapped_value, left, middle);
            mergeSort(nums, nums_mapped_value, middle + 1, right);

            merge(nums, nums_mapped_value, left, middle, right);
        }
    }

    public void merge(int[] nums, int[] nums_mapped_value, int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftNums = new int[n1];
        int[] rightNums = new int[n2];
        int[] leftMapped = new int[n1];
        int[] rightMapped = new int[n2];

        for (int i = 0; i < n1; ++i)
        {
            leftNums[i] = nums[left + i];
            leftMapped[i] = nums_mapped_value[left + i];
        }
        for (int j = 0; j < n2; ++j)
        {
            rightNums[j] = nums[middle + 1 + j];
            rightMapped[j] = nums_mapped_value[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2)
        {
            if (leftMapped[i] <= rightMapped[j])
            {
                nums[k] = leftNums[i];
                nums_mapped_value[k] = leftMapped[i];
                i++;
            }
            else
            {
                nums[k] = rightNums[j];
                nums_mapped_value[k] = rightMapped[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            nums[k] = leftNums[i];
            nums_mapped_value[k] = leftMapped[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            nums[k] = rightNums[j];
            nums_mapped_value[k] = rightMapped[j];
            j++;
            k++;
        }
    }
}