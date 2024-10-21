package BetterCodeAnswer.Easy.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-array-by-increasing-frequency/">1636. Sort Array by Increasing Frequency</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code>, sort the array in <strong>increasing</strong> order based on the frequency of the values. If multiple values have the same frequency, sort them in <strong>decreasing</strong> order.</p>
 * 
 * <p>Return the <em>sorted array</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,2,2,2,3]
 * <strong>Output:</strong> [3,1,1,2,2,2]
 * <strong>Explanation:</strong> '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,3,1,3,2]
 * <strong>Output:</strong> [1,3,3,2,2]
 * <strong>Explanation:</strong> '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [-1,1,-6,4,5,-6,1,4,1]
 * <strong>Output:</strong> [5,-1,4,4,-6,-6,1,1,1]</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,2,2,2,3}
        };

        for (int[] nums : tests) {
            System.out.println(Arrays.toString(new SortArrayByIncreasingFrequency_Solution().frequencySort(nums)));
        }
    }
}

// 5ms 44.23MB
class SortArrayByIncreasingFrequency_Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Map<Integer ,Integer> map = new HashMap<>();

        for(int a : nums){
            map.put(a , map.getOrDefault(a , 0) + 1);
        }

        List<Map.Entry<Integer , Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort( list , new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer , Integer> m1 , Map.Entry<Integer,Integer> m2){
                if(m1.getValue() == m2.getValue()){
                    return m2.getKey() - m1.getKey();
                }else{
                    return m1.getValue() - m2.getValue();
                }
            }
        });

        int k = 0;

        for(Map.Entry<Integer , Integer> m : list){
            int val = m.getValue();

            while(val > 0){
                ans[k++] = m.getKey();
                val--;
            }
        }

        return ans;
    }
}

// 4ms 44.23MB
class SortArrayByIncreasingFrequency_Solution2 {
    public class Pair implements Comparable<Pair>{
        int data;
        int freq;

        public Pair(int data , int freq){
            this.data=data;
            this.freq=freq;
        }

        @Override
        public int compareTo(Pair p2){
            if(this.freq!=p2.freq){
                return this.freq-p2.freq;
            }
            else{
              return  p2.data-this.data;
            }
        }
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        int index=0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll(); // Poll once to get both data and freq
            int count = pair.freq;
            int element = pair.data;
            for(int i=0;i<count;i++){
                nums[index++]=element;
            }
        }
        return nums;
    }
}


// 2ms 44.23MB
class SortArrayByIncreasingFrequency_Solution3 {
    public int[] frequencySort(int[] nums) {
        int count[] = new int[201];
        for (int n : nums)  count[n + 100]++;
        for (int i = nums.length - 1; i >= 0;) {
            int m = 0, ind = -1;
            for (int j = 0; j < 201; j++) {
                if (count[j] > m) {
                    m = count[j];
                    ind = j;
                }
            }
            for (int j = 0; j < m; j++)  nums[i--] = ind - 100;
            count[ind] = 0;
        }
        return nums;
    }
}


// 1ms 44.23MB
class SortArrayByIncreasingFrequency_Solution4 {
    public int[] frequencySort(int[] nums) {
        int[] count=new int[202];
        for(int i=0;i<nums.length;i++){
            count[nums[i]+100]++;
        }
        quickSort(nums,count,0,nums.length-1);
        return nums;
    }
    void quickSort(int[] nums,int freq[],int low,int high){
        if(low<high){
            int pivot=partition(nums,freq,low,high);
            quickSort(nums,freq,low,pivot-1);
            quickSort(nums,freq,pivot+1,high);
        }
    }
    int partition(int[] nums,int freq[],int low,int high){
        int pivot=freq[nums[high]+100];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(pivot > freq[nums[j]+100]){
                i++;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }else if(freq[nums[j]+100]==pivot){
                if(nums[high]<=nums[j]){
                    i++;
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        int temp=nums[i+1];
        nums[i+1]=nums[high];
        nums[high]=temp;
        return i+1;
    }
}