package BetterCodeAnswer.Hard.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/freedom-trail/">514. Freedom Trail</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>In the video game Fallout 4, the quest <strong>"Road to Freedom"</strong> requires players to reach a metal dial called the <strong>"Freedom Trail Ring"</strong> and use the dial to spell a specific keyword to open the door.</p>

<p>Given a string <code>ring</code> that represents the code engraved on the outer ring and another string <code>key</code> that represents the keyword that needs to be spelled, return <em>the minimum number of steps to spell all the characters in the keyword</em>.</p>

<p>Initially, the first character of the ring is aligned at the <code>"12:00"</code> direction. You should spell all the characters in <code>key</code> one by one by rotating <code>ring</code> clockwise or anticlockwise to make each character of the string key aligned at the <code>"12:00"</code> direction and then by pressing the center button.</p>

<p>At the stage of rotating the ring to spell the key character <code>key[i]</code>:</p>

<ol>
	<li>You can rotate the ring clockwise or anticlockwise by one place, which counts as <strong>one step</strong>. The final purpose of the rotation is to align one of <code>ring</code>'s characters at the <code>"12:00"</code> direction, where this character must equal <code>key[i]</code>.</li>
	<li>If the character <code>key[i]</code> has been aligned at the <code>"12:00"</code> direction, press the center button to spell, which also counts as <strong>one step</strong>. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/22/ring.jpg" style="width: 450px; height: 450px;">
<pre><strong>Input:</strong> ring = "godding", key = "gd"
<strong>Output:</strong> 4
<strong>Explanation:</strong>
For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
Also, we need 1 more step for spelling.
So the final output is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> ring = "godding", key = "godding"
<strong>Output:</strong> 13
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= ring.length, key.length &lt;= 100</code></li>
	<li><code>ring</code> and <code>key</code> consist of only lower case English letters.</li>
	<li>It is guaranteed that <code>key</code> could always be spelled by rotating <code>ring</code>.</li>
</ul>
</div>
 */
public class FreedomTrail {
    public static void main(String[] args) {
        
    }
}

// TimeLimitExceed
class FreedomTrail_Solution {
    private static final int MAX = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        return tryLock(0, 0, ring, key, MAX);
    }

    // Find the minimum steps between two indexes of ring
    private int countSteps(int curr, int next, int ringLength) {
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLength - stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }

    // Find the minimum number of steps to spell the keyword
    public int tryLock(int ringIndex, int keyIndex, String ring, String key, int minSteps) {
        // If we reach the end of the key, it has been spelled
        if (keyIndex == key.length()) {
            return 0;
        }
        // For each occurrence of the character at key_index of key in ring
        // Calculate the minimum steps to that character from the ringIndex of ring
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int totalSteps = countSteps(ringIndex, i, ring.length()) + 1 + 
                                            tryLock(i, keyIndex + 1, ring, key, MAX);
                minSteps = Math.min(minSteps, totalSteps);
            }
        }
        return minSteps;
    }
}

// 196 ms 45 MB
class FreedomTrail_Solution2 {
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();
        int keyLen = key.length();
        int[][] bestSteps = new int[ringLen][keyLen + 1];
        // Initialize values of best_steps to largest integer
        for (int[] row : bestSteps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Initialize last column to zero to represent the word has been spelled 
        for (int i = 0; i < ring.length(); i++) {
            bestSteps[i][keyLen] = 0;
        }
        // For each occurrence of the character at keyIndex of key in ring
        // Stores minimum steps to the character from ringIndex of ring
        for (int keyIndex = keyLen - 1; keyIndex >= 0; keyIndex--) {
            for (int ringIndex = 0; ringIndex < ringLen; ringIndex++) {
                for (int charIndex = 0; charIndex < ringLen; charIndex++) {
                    if (ring.charAt(charIndex) == key.charAt(keyIndex)) {
                        bestSteps[ringIndex][keyIndex] = Math.min(bestSteps[ringIndex][keyIndex],
                                1 + countSteps(ringIndex, charIndex, ringLen)
                                + bestSteps[charIndex][keyIndex + 1]);
                    }
                }
            }
        }
        return bestSteps[0][0];
    }

    // Find the minimum steps between two indexes of ring
    private int countSteps(int curr, int next, int ringLength) {
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLength - stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }
}

// 5 ms 44.8 MB
class FreedomTrail_Solution3 {
    @SuppressWarnings("unchecked")
    public int findRotateSteps(String ring, String key) {
          char[] r=ring.toCharArray();
        List<Integer>[] p= new List[26];
        for(int i=0;i<r.length;i++) {
            int c=r[i]-'a';
            List<Integer> l=p[c];
            if(l==null) p[c]=l=new ArrayList<>();
            l.add(i);
        }
        return helper(0,0,p,key.toCharArray(),ring,new int[key.length()][r.length]);
    }
    int helper(int in, int pos, List<Integer>[] p, char[] k, String r, int[][] memo) {
        if(in==k.length) return 0;
        if(memo[in][pos]>0) return memo[in][pos]-1;
        int min=Integer.MAX_VALUE;
        for(int i: p[k[in]-'a']) {
            int m;
            if(i>=pos) m=Math.min(i-pos,pos+r.length()-i);
            else m=Math.min(pos-i,i+r.length()-pos);
            min=Math.min(min,m+helper(in+1,i,p,k,r,memo));
        }
        return (memo[in][pos]=min+2)-1;
    }
}