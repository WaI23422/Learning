package Hard.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/greatest-common-divisor-traversal/">2709.Greatest Common Divisor Traversal</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>, and you are allowed to <strong>traverse</strong> between its indices. You can traverse between index <code>i</code> and index <code>j</code>, <code>i != j</code>, if and only if <code>gcd(nums[i], nums[j]) &gt; 1</code>, where <code>gcd</code> is the <strong>greatest common divisor</strong>.</p>

<p>Your task is to determine if for <strong>every pair</strong> of indices <code>i</code> and <code>j</code> in nums, where <code>i &lt; j</code>, there exists a <strong>sequence of traversals</strong> that can take us from <code>i</code> to <code>j</code>.</p>

<p>Return <code>true</code><em> if it is possible to traverse between all such pairs of indices,</em><em> or </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,6]
<strong>Output:</strong> true
<strong>Explanation:</strong> In this example, there are 3 possible pairs of indices: (0, 1), (0, 2), and (1, 2).
To go from index 0 to index 1, we can use the sequence of traversals 0 -&gt; 2 -&gt; 1, where we move from index 0 to index 2 because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 &gt; 1, and then move from index 2 to index 1 because gcd(nums[2], nums[1]) = gcd(6, 3) = 3 &gt; 1.
To go from index 0 to index 2, we can just go directly because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 &gt; 1. Likewise, to go from index 1 to index 2, we can just go directly because gcd(nums[1], nums[2]) = gcd(3, 6) = 3 &gt; 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,9,5]
<strong>Output:</strong> false
<strong>Explanation:</strong> No sequence of traversals can take us from index 0 to index 2 in this example. So, we return false.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [4,3,12,8]
<strong>Output:</strong> true
<strong>Explanation:</strong> There are 6 possible pairs of indices to traverse between: (0, 1), (0, 2), (0, 3), (1, 2), (1, 3), and (2, 3). A valid sequence of traversals exists for each pair, so we return true.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
public class GreatestCommonDivisorTraversal {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,6},
            {3,9,5},
            {4,3,12,8},
            {30,30},
            {2,2,4,4},
            {49,39,20,30,28,35,26,16,10,44}
        };

        for (int[] nums : tests) {
            System.out.println(new GreatestCommonDivisorTraversal_Solution().canTraverseAllPairs(nums));
        }
    }
}

// Wrong
class GreatestCommonDivisorTraversal_Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        nums = Arrays.stream(nums).distinct().toArray();
        int pair = 0, sum = 0;
        HashMap<Integer,Set<Integer>> pathContain = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                pair++;

                if (gcd(nums[i], nums[j]) > 1) {
                    addMap(pathContain, nums[i], nums[j]);
                    addMap(pathContain, nums[j], nums[i]);
                }
            }
        }

        for (int pathTo : pathContain.keySet()) {
            sum += pathContain.get(pathTo).size();
        }

        return pair*2 == sum;
    }

    private int gcd(int a, int b){
        while (a > 0 && b > 0) {
            if (a > b) {a %= b;} 
            else {b %= a;}
        }

        if (a == 0) {return b;}
        else {return a;}
    }

    private void addMap(HashMap<Integer,Set<Integer>> map, int numKey, int numAdd) {
        if(numAdd == numKey) {return;}
        
        if (map.get(numKey)!= null) {
            addToSubMap(map, numKey, numAdd);
        }

        if (map.get(numKey) == null) {
            Set<Integer> subList = new HashSet<>(); subList.add(numAdd);
            map.put(numKey, subList);
        } else {
            map.get(numKey).add(numAdd);
        }
    }

    private void addToSubMap(HashMap<Integer,Set<Integer>> map, int numKey, int numAdd) {
        for (int key : map.get(numKey).stream().mapToInt(t->t).toArray()) {
            if (key == numAdd) {continue;}

            if (!map.get(key).contains(numAdd)) {;
                map.get(key).add(numAdd);
            }

            if (map.get(numAdd) == null) {
                Set<Integer> subList = new HashSet<>(); subList.add(key);
                map.put(numAdd, subList);
            } else {
                map.get(numAdd).add(key);
            }
        }
    }
}

//285 ms 89.2 MB
class Solution {
    public void dfs(ArrayList<ArrayList<Integer>>adj,int []vis,int st){
        vis[st]=1;
        for(int i:adj.get(st)){
            if(vis[i]==0){
                dfs(adj,vis,i);
            }
        }
    }

    public static void allprime(int n,HashMap<Integer,ArrayList<Integer>>map,int st){
        while(n%2==0){
            map.put(2,map.getOrDefault(2,new ArrayList<>()));
            ArrayList<Integer>temp=map.get(2);
            temp.add(st);
            map.put(2,temp);
            n/=2;
        }
        for(int i=3; i<=Math.sqrt(n); i+=2){
            while(n%i==0){
                map.put(i,map.getOrDefault(i,new ArrayList<>()));
                ArrayList<Integer>temp=map.get(i);
                temp.add(st);
                map.put(i,temp);
                n/=i;
            }
        }
        if(n>2){
            map.put(n,map.getOrDefault(n,new ArrayList<>()));
            ArrayList<Integer>temp=map.get(n);
            temp.add(st);
            map.put(n,temp);
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        
        int n=nums.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }    
        for(int i=0;i<n;i++){
            allprime(nums[i],map,i);
        }
        
        for(ArrayList<Integer>temp:map.values()){
            for(int i=1;i<temp.size();i++){
                adj.get(temp.get(i-1)).add(temp.get(i));
                adj.get(temp.get(i)).add(temp.get(i-1));
            }
        }
        int []vis=new int[n];
        dfs(adj,vis,0);
        for(int i=0;i<n;i++){
            if(vis[i]==0)return false;
        }
        return true;
    }
}