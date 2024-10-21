package Medium.Array;

import java.util.ArrayList;
import java.util.List;

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

// Time Limit Exceeded
class CombinationSumII_Solution {
    List<List<Integer>> combinations;
    List<int[]> combExist;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinations = new ArrayList<>();
        combExist = new ArrayList<>();

        findCandidate(new ArrayList<>(), candidates, new int[51] , target, 0);

        return combinations;
    }

    private void findCandidate(List<Integer> comb,int[] candidates, int[] numUsed,int target, int idx) {
        if (target == 0) {
            if (isCombNotExist(numUsed)) {
                combinations.add(new ArrayList<>(comb)); 
                combExist.add(numUsed.clone());
            }
        } else {
            for (int i = idx; i < candidates.length; i++) {
                int candidate = candidates[i];

                if (candidate <= target) {
                    comb.add(candidate); numUsed[candidate]++;
                    findCandidate(comb, candidates, numUsed, target-candidate, i+1);
                    comb.removeLast(); numUsed[candidate]--;
                }
            }
        }
    }

    private boolean isCombNotExist(int[] l) {
        for (int[] combination : combExist) {
            if (isEquals(combination, l)) {
                return false;
            }
        }

        return true;
    }

    private boolean isEquals(int[] a, int[] b) {
        for (int i = 0; i < 51; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}