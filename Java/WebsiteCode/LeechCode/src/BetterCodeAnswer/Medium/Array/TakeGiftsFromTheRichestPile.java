package BetterCodeAnswer.Medium.Array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/take-gifts-from-the-richest-pile/">2558. Take Gifts From the Richest Pile</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>gifts</code> denoting the number of gifts in various piles. Every second, you do the following:</p>
 * 
 * <ul>
 * 	<li>Choose the pile with the maximum number of gifts.</li>
 * 	<li>If there is more than one pile with the maximum number of gifts, choose any.</li>
 * 	<li>Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.</li>
 * </ul>
 * 
 * <p>Return <em>the number of gifts remaining after </em><code>k</code><em> seconds.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> gifts = [25,64,9,4,100], k = 4
 * <strong>Output:</strong> 29
 * <strong>Explanation:</strong> 
 * The gifts are taken in the following way:
 * - In the first second, the last pile is chosen and 10 gifts are left behind.
 * - Then the second pile is chosen and 8 gifts are left behind.
 * - After that the first pile is chosen and 5 gifts are left behind.
 * - Finally, the last pile is chosen again and 3 gifts are left behind.
 * The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> gifts = [1,1,1,1], k = 4
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> 
 * In this case, regardless which pile you choose, you have to leave behind 1 gift in each pile. 
 * That is, you can't take any pile with you. 
 * So, the total gifts remaining are 4.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= gifts.length &lt;= 10<sup>3</sup></code></li>
 * 	<li><code>1 &lt;= gifts[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>3</sup></code></li>
 * </ul>
 * </div></div>
 */
public class TakeGiftsFromTheRichestPile {
    public static void main(String[] args) {

    }
}

// 2ms 41.78MB
class Solution {
    public long pickGifts(int[] gifts, int k) {
        // return solution1(gifts, k);
        return solution2(gifts, k);
    }
    
    private long solution2(int[] gifts, int k) {
        int[] maxHeap = new int[gifts.length];
        long numGifts = 0;
        for (int i = 0; i < gifts.length; i++) {
            int gift = gifts[i];
            addToHeap(gift, maxHeap, i);
            numGifts += gift;
        }
        for (int i = 0; i < k; i++) {
            int num = removeFromHeap(maxHeap);
            int rem = (int) Math.sqrt(num);
            numGifts -= num - rem;
            addToHeap(rem, maxHeap);
        }
        return numGifts;
    }

    private void addToHeap(int num, int[] maxHeap, int pos) {
        maxHeap[pos] = num;
        while (pos > 0) {
            int parent = (pos - 1) / 2;
            if (maxHeap[parent] < maxHeap[pos]) {
                swap(maxHeap, parent, pos);
                pos = parent;
            } else {
                break;
            }
        }
    }

    private void addToHeap(int num, int[] maxHeap) {
        addToHeap(num, maxHeap, maxHeap.length - 1);
    }

    private void swap(int[] maxHeap, int a, int b) {
        int temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    private int removeFromHeap(int[] maxHeap) {
        int ret = maxHeap[0];
        maxHeap[0] = maxHeap[maxHeap.length - 1];
        heapify(maxHeap, maxHeap.length - 1);
        return ret;
    }

    private void heapify(int[] maxHeap, int heapSize) {
        int pos = 0;
        while (pos < heapSize) {
            int left = pos * 2 + 1;
            int right = pos * 2 + 2;
            if (left >= heapSize) {
                break;
            }
            if (right < heapSize && maxHeap[left] < maxHeap[right]) {
                if (maxHeap[right] > maxHeap[pos]) {
                    swap(maxHeap, pos, right);
                    pos = right;
                } else {
                    break;
                }
            } else {
                if (maxHeap[left] > maxHeap[pos]) {
                    swap(maxHeap, pos, left);
                    pos = left;
                } else {
                    break;
                }
            }
        }
    }
}