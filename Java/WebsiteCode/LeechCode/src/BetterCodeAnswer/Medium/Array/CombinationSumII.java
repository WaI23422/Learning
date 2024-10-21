package BetterCodeAnswer.Medium.Array;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/combination-sum-ii/">40. Combination Sum II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a collection of candidate numbers (<code>candidates</code>) and a target number (<code>target</code>), find all unique combinations in <code>candidates</code>&nbsp;where the candidate numbers sum to <code>target</code>.</p>
 * 
 * <p>Each number in <code>candidates</code>&nbsp;may only be used <strong>once</strong> in the combination.</p>
 * 
 * <p><strong>Note:</strong>&nbsp;The solution set must not contain duplicate combinations.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> candidates = [10,1,2,7,6,1,5], target = 8
 * <strong>Output:</strong> 
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
 * <strong>Output:</strong> 
 * [
 * [1,2,2],
 * [5]
 * ]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
 * 	<li><code>1 &lt;= target &lt;= 30</code></li>
 * </ul>
 * </div>
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {10,1,2,7,6,1,5},
                {8}
            }
        };
        
        for (int[][] test : tests) {
            int candidates[] = test[0],
                target = test[1][0];

            System.out.println(new CombinationSumII_Solution().combinationSum2(candidates, target).toString());
        }
    }
}

// 3ms 42.06
class CombinationSumII_Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(
        List<List<Integer>> answer,
        List<Integer> tempList,
        int[] candidates,
        int totalLeft,
        int index
    ) {
        if (totalLeft < 0) return;
        else if (totalLeft == 0) { // Add to the answer array, if the sum is equal to target.
            answer.add(new ArrayList<>(tempList));
        } else {
            for (
                int i = index;
                i < candidates.length && totalLeft >= candidates[i];
                i++
            ) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                // Add it to tempList.
                tempList.add(candidates[i]);
                // Check for all possible scenarios.
                backtrack(
                    answer,
                    tempList,
                    candidates,
                    totalLeft - candidates[i],
                    i + 1
                );
                // Backtrack the tempList.
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

// 0ms 43.74MB
class CombinationSumII_Solution2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> result = null;

            public List<Integer> get(int i) {
                init();
                return result.get(i);
            }

            public int size() {
                init();
                return result.size();
            }

            private void init() {
                if (result != null) return;

                Arrays.sort(candidates);

                // Create a frequency map to count occurrences of each element
                Map<Integer, Integer> freqMap = new HashMap<>();
                for (int i : candidates) {
                    freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
                }

                // Convert frequency map to a list of arrays [element, frequency]
                List<int[]> freq = new ArrayList<>();
                freqMap.forEach((k, v) -> freq.add(new int[] { k, v }));

                Set<List<Integer>> set = new HashSet<>();
                impl(freq, 0, target, new ArrayList<>(), 0, set);
                result = new ArrayList<>(set);
            }
        };
    }

    private void impl(List<int[]> candidates, int start, int target, List<Integer> list, int sum, Set<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            int[] c = candidates.get(i);
            if (c[1] == 0) continue; // Skip if no occurrences left
            if (sum + c[0] > target) continue; // Skip if sum exceeds target

            // Choose the current element
            list.add(c[0]);
            c[1]--; // Decrease the count

            // Recurse with updated parameters
            impl(candidates, i, target, list, sum + c[0], result);

            // Backtrack: remove the current element and restore count
            list.remove(list.size() - 1);
            c[1]++;
        }
    }
}

// 1ms 43.22MB
class CombinationSumII_Solution3 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans=new ArrayList<>();
        int[] f =new int[51];
        int size=0;
        for(int g:candidates){
            f[g]++;
            if(f[g]==1)size++;
        }
        int[] h=new int[size];
        size=0;
        for(int g=1;g<=50;g++){
            if(f[g]>0)h[size++]=g;
        }
        get(ans,new ArrayList<>(),0,size,0,target,h,f,0);
        return ans;
    }
    static void get(List<List<Integer>> ans, List<Integer> a, int k ,int n, int sum, int t, int[] arr,int[] f, int s){
        if(k==n || arr[k]==0 || sum+arr[k]>t){
            return;
        }
        if(sum+arr[k]<t){
            if(f[arr[k]]>0){
            a.add(arr[k]);
            f[arr[k]]--;
            get(ans,a,k,n,sum+arr[k],t,arr,f,s+1);
            a.remove(s);
            f[arr[k]]++;
            }
            get(ans,a,k+1,n,sum,t,arr,f,s);
        }else if(f[arr[k]]>0){
            a.add(arr[k]);
            ans.add(new ArrayList<>(a));
            a.remove(s);
            return;
        }
    }

}