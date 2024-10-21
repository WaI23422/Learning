package Easy.Arrays;


import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/plus-one/">66.Plus One</a>
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a <strong>large integer</strong> represented as an integer array <code>digits</code>, where each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading <code>0</code>'s.</p>

<p>Increment the large integer by one and return <em>the resulting array of digits</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> digits = [1,2,3]
<strong>Output:</strong> [1,2,4]
<strong>Explanation:</strong> The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> digits = [4,3,2,1]
<strong>Output:</strong> [4,3,2,2]
<strong>Explanation:</strong> The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> digits = [9]
<strong>Output:</strong> [1,0]
<strong>Explanation:</strong> The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= digits.length &lt;= 100</code></li>
	<li><code>0 &lt;= digits[i] &lt;= 9</code></li>
	<li><code>digits</code> does not contain any leading <code>0</code>'s.</li>
</ul>
</div></div>
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] đigits = {9,9,9};

        PlusOne_Solution answer = new PlusOne_Solution();

        System.out.println(Arrays.toString(answer.plusOne(đigits)));
    }
}

class PlusOne_Solution {
    // 0 ms
    // 40.8 MB
    public int[] plusExtra(int[] digits,int index){
        if (index == digits.length && digits[0] == 9) {
            digits[0] = 0;
            return digits;
        }

        digits[digits.length-index] +=1;

        if (digits[digits.length-index] == 10) {
            digits[digits.length-index] = 0;
            plusExtra(digits, index +1);
            
        }

        return digits;
    }

    public int[] plusOne(int[] digits) {
        digits = plusExtra(digits, 1);
        
        if (digits[0] == 0 ) {
            int[] digitsCopy = new int[digits.length+1];
            digitsCopy[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                digitsCopy[i+1] = digits[i];
            }

            digits = digitsCopy;
        }
        
        return digits;
    }
}
