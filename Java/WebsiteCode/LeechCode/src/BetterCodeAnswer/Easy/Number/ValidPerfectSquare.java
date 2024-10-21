package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/valid-perfect-square/">367. Valid Perfect Square</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a positive integer num, return <code>true</code> <em>if</em> <code>num</code> <em>is a perfect square or</em> <code>false</code> <em>otherwise</em>.</p>

<p>A <strong>perfect square</strong> is an integer that is the square of an integer. In other words, it is the product of some integer with itself.</p>

<p>You must not use any built-in library function, such as <code>sqrt</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num = 16
<strong>Output:</strong> true
<strong>Explanation:</strong> We return true because 4 * 4 = 16 and 4 is an integer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num = 14
<strong>Output:</strong> false
<strong>Explanation:</strong> We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        int[] tests = {
            2147483647,
            3,
            4,
            1
        };

        for (int num : tests) {
            System.out.println(new ValidPerfectSquare_Solution().isPerfectSquare(num));
        }
    }
}

// 0 ms 40.1 MB
class ValidPerfectSquare_Solution {
    public boolean isPerfectSquare(int num) {
        int st=0;
        int end=num;

        while(st<=end){
            long mid=st+(end-st)/2;
            if(mid * mid==num){
                return true;
            }
            else if(mid*mid>num){
                end=(int) mid-1;
            }
            else{
                st=(int) mid+1;
            }
        }
        return false;
    }
}