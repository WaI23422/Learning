package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/hand-of-straights/">846. Hand of Straights</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size <code>groupSize</code>, and consists of <code>groupSize</code> consecutive cards.</p>
 * 
 * <p>Given an integer array <code>hand</code> where <code>hand[i]</code> is the value written on the <code>i<sup>th</sup></code> card and an integer <code>groupSize</code>, return <code>true</code> if she can rearrange the cards, or <code>false</code> otherwise.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> hand = [1,2,3,4,5], groupSize = 4
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> Alice's hand can not be rearranged into groups of 4.
 * 
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= hand.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= hand[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>1 &lt;= groupSize &lt;= hand.length</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Note:</strong> This question is the same as 1296: <a href="https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/" target="_blank">https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/</a></p>
 * </div>
 */
public class HandOfStraights {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,2,3,6,2,3,4,7,8},
                {3}
            }
        };

        for (int[][] test : tests) {
            int hand[] = test[0],
                groupSize = test[1][0];
        
            System.out.println(new HandOfStraights_Solution().isNStraightHand(hand, groupSize));    
        }
    }   
}

// 8 ms 44.5 MB
class HandOfStraights_Solution {
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int i = 0;
        for (; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }
}

// 9ms 45.3MB
class HandOfStraights_Solution2 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        int[] handCopy = new int[hand.length];
        System.arraycopy(hand, 0, handCopy, 0, handCopy.length);
        Arrays.sort(handCopy);
        for(int i = 0; i < handCopy.length; i++) {
            if(handCopy[i] == -1) {
                continue;
            }
            int last = handCopy[i];
            int count = 1;
            for(int j = i + 1; j < handCopy.length && count < groupSize; j++) {
                if(handCopy[j] == last || handCopy[j] == -1) {
                    continue;
                }
                if(handCopy[j] - last == 1) {
                    last = handCopy[j];
                    handCopy[j] = -1;
                    count++;
                } else {
                    break;
                }
                
            }
            if(count != groupSize) {
                return false;
            }
        }
        return true;
    }
}