package Medium.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-the-original-array-of-prefix-xor/">2433.Find The Original Array of Prefix Xor</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an <strong>integer</strong> array <code>pref</code> of size <code>n</code>. Find and return <em>the array </em><code>arr</code><em> of size </em><code>n</code><em> that satisfies</em>:</p>

<ul>
	<li><code>pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]</code>.</li>
</ul>

<p>Note that <code>^</code> denotes the <strong>bitwise-xor</strong> operation.</p>

<p>It can be proven that the answer is <strong>unique</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> pref = [5,2,0,3,1]
<strong>Output:</strong> [5,7,2,3,2]
<strong>Explanation:</strong> From the array [5,7,2,3,2] we have the following:
- pref[0] = 5.
- pref[1] = 5 ^ 7 = 2.
- pref[2] = 5 ^ 7 ^ 2 = 0.
- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> pref = [13]
<strong>Output:</strong> [13]
<strong>Explanation:</strong> We have pref[0] = arr[0] = 13.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= pref.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= pref[i] &lt;= 10<sup>6</sup></code></li>
</ul>
</div></div>
 */
public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        int[][] tests = {
            {5,2,0,3,1},
            {13},
            {1,2},
            {706832,199138,351457,328002}
        };
        
        FindTheOriginalArrayOfPrefixXor_Solution res = new FindTheOriginalArrayOfPrefixXor_Solution();

        for (int[] pref : tests) {
            System.out.println(Arrays.toString(res.findArray(pref)));
        }
    }
}

class FindTheOriginalArrayOfPrefixXor_Solution {
    // 319 ms 
    // 56.3 MB
    public int nAND(int num1,int num2) {
        if (num1 == 0) {return num2;}
        if (num2 == 0) {return num1;}
        
        String Bits = "", num1Bit = Integer.toBinaryString(num1), num2Bit = Integer.toBinaryString(num2);
        int diff = num1Bit.length() - num2Bit.length();

        if (diff < 0) {
            for (int i = 0; i < Math.abs(diff); i++) {
                num1Bit = "0" + num1Bit;
            }
        } else if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                num2Bit = "0" + num2Bit;
            }
        }

        char[] num1Bits = num1Bit.toCharArray(),num2Bits = num2Bit.toCharArray();

        for (int i = 0; i < num2Bits.length; i++) {
            if (num1Bits[i] != num2Bits[i]) {
                Bits += "1";
            } else {
                Bits += "0";
            }
        }

        return Integer.parseInt(Bits,2);    
    }

    public int[] findArray(int[] pref) {
        if (pref.length == 1) {
            return pref;
        }
        
        int[] answer = new int[pref.length];
        
        // First Value:
        answer[0] = pref[0];

        for (int i = 1; i < answer.length; i++) {
            answer[i] = nAND(pref[i-1],pref[i]);
        }

        return answer;
    }
}



