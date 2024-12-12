package Medium.Array;

import java.util.Arrays;

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

class TakeGiftsFromTheRichestPile_Solution {
    public long pickGifts(int[] gifts, int k) {
        while (k-- > 0) {
            Arrays.sort(gifts);
            int pile = gifts[gifts.length - 1];
            gifts[gifts.length - 1] = (int) Math.sqrt(pile);
        }
        long ans = 0;
        for (int gift : gifts) {
            ans += gift;
        }
        return ans;
    }
}