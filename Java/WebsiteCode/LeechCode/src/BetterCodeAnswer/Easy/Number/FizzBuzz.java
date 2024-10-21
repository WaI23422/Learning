package BetterCodeAnswer.Easy.Number;

import java.util.Arrays;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/fizz-buzz/">412. Fizz Buzz</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>n</code>, return <em>a string array </em><code>answer</code><em> (<strong>1-indexed</strong>) where</em>:</p>

<ul>
	<li><code>answer[i] == "FizzBuzz"</code> if <code>i</code> is divisible by <code>3</code> and <code>5</code>.</li>
	<li><code>answer[i] == "Fizz"</code> if <code>i</code> is divisible by <code>3</code>.</li>
	<li><code>answer[i] == "Buzz"</code> if <code>i</code> is divisible by <code>5</code>.</li>
	<li><code>answer[i] == i</code> (as a string) if none of the above conditions are true.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["1","2","Fizz"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> ["1","2","Fizz","4","Buzz"]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> n = 15
<strong>Output:</strong> ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
 */
public class FizzBuzz {
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
            System.out.println(Arrays.toString(new FizzBuzz_Solution().fizzBuzz(n).toArray()));
        }
    }
}

// 0 ms 44.9 MB
class FizzBuzz_Solution {
    public List<String> fizzBuzz(int n) {
        return new java.util.AbstractList<>() {

            public String get(int i) {
                i++;
                if (i % 15 ==0) return "FizzBuzz";
                else if (i % 3 == 0) return "Fizz";
                else if (i % 5 == 0) return "Buzz";
                else return String.valueOf(i);
            }

            public int size() {
                return n;
            }
        };
    }
}