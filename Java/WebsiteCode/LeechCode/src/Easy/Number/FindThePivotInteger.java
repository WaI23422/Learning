package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-pivot-integer/">2485.Find the Pivot Integer</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a positive integer <code>n</code>, find the <strong>pivot integer</strong> <code>x</code> such that:</p>

<ul>
	<li>The sum of all elements between <code>1</code> and <code>x</code> inclusively equals the sum of all elements between <code>x</code> and <code>n</code> inclusively.</li>
</ul>

<p>Return <em>the pivot integer </em><code>x</code>. If no such integer exists, return <code>-1</code>. It is guaranteed that there will be at most one pivot index for the given input.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 8
<strong>Output:</strong> 6
<strong>Explanation:</strong> 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> 1
<strong>Explanation:</strong> 1 is the pivot integer since: 1 = 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 4
<strong>Output:</strong> -1
<strong>Explanation:</strong> It can be proved that no such integer exist.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>
</div>
 */
public class FindThePivotInteger {
    public static void main(String[] args) {
        int[] tests = {
            14,
            15,
            16,
            8,
            1,
            4,
            3
        };

        for (int n : tests) {
            System.out.println(new FindThePivotInteger_Solution().pivotInteger(n));
        }
    }
}

// 1 ms 40.4 MB
class FindThePivotInteger_Solution {
    public int pivotInteger(int n) {
        if (n == 1) {return 1;}

        int leftSum = 1, rightSum = n, left = 2, right =n-1;

        while (left < right) {
            if (leftSum < rightSum) {
                leftSum += left++;
            } else {
                rightSum += right--;
            }
        }

        if (leftSum == rightSum) {return left;}

        return -1;
    }
}

// 0 ms 41 MB
class FindThePivotInteger_Solution2 {
    public int pivotInteger(int n) {
        if (n == 1) {return 1;}

        int half = n/2+1,
            leftSum = sum(1, half),
            rightSum = sum(half, n+1);
        

        while (leftSum < rightSum) {
            leftSum += half;
            rightSum-= half++;
        }
        half--;
        
        if (leftSum == rightSum+half) {return half;}

        return -1;
    }

    public int sum(int range, int rangeEnd) {
        int sum = 0;

        for (int i = range; i < rangeEnd; i++) {
            sum+= i;
        }

        return sum;
    }
}
