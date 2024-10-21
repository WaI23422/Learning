package Easy.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/contains-duplicate/">217.Contains Duplicate</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <code>true</code> if any value appears <strong>at least twice</strong> in the array, and return <code>false</code> if every element is distinct.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,1,3,3,4,3,2,4,2]
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div>
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,0,1,1},{1}},
            {{0,1,2,3,4,5,0},{5}},
            {{3,4,5},{4}},
            {{1,2,3,1},{3}},
            {{1,2,3,1,2,3},{2}},
            {{2,2},{3}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];
            System.out.println(new ContainsDuplicateII_Solution().containsNearbyDuplicate(nums, k));
        }
        
    }   
}

// 813 ms 54.6 MB
class ContainsDuplicateII_Solution5 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        for (int i = 1; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i-1; j >= i-k && j > -1 ; j--) {
                int num2 = nums[j];

                if (num1 == num2) {return true;}
            }
        }

        return false;
    }
}

// Time Limit Exceeded
class ContainsDuplicateII_Solution4 {
    int LENGTH;
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        LENGTH = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int boo = isDuplicateRange(nums, i, i+k);
            if ( boo == 1) {
                return true;
            } else if (boo == -1) {
                return false;
            }
        }

        return false;
    }

    private int isDuplicateRange(int[] nums, int first, int last) {
        if (last > LENGTH && first !=0) {return -1;}
        if (last >= LENGTH) {last = LENGTH-1;}

        int[] numsNew = Arrays.copyOfRange(nums, first, last+1);
        Arrays.sort(numsNew);
        
        for (int i = 1; i < numsNew.length; i++) {
            if (numsNew[i-1] == numsNew[i]) {return 1;}
        }

        return 0;
    }
}

// 23 ms 63.5 MB
class ContainsDuplicateII_Solution3 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int index = 0;
        HashMap<Integer,List<Integer>> trackDup = new HashMap<>();

        for (int num : nums) {
            if (!trackDup.containsKey(num)) {
                List<Integer> posList = new ArrayList<>();
                posList.add(index);
                trackDup.put(num, posList);
            } else {
                if (validRange(trackDup.get(num),index,k)) {
                    return true;
                }
                trackDup.get(num).add(index);
            }
            
            index++;
        }

        return false;
    }

    private boolean validRange(List<Integer> list, int index, int validRange) {
        for (Integer index1 : list) {
            if (Math.abs(index1 - index) <= validRange) {
                return true;
            }
        }
        
        return false;
    }
}

// 19 ms 57.9 MB
class ContainsDuplicateII_Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int n =nums[i];
            if(map.containsKey(n)) {
                if(Math.abs(map.get(n) - i) <= k) {
                    return true;
                }
            } 
            map.put(n, i);
        }

        return false;
    }
}

// 15 ms 57.9 MB
class ContainsDuplicateII_Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}