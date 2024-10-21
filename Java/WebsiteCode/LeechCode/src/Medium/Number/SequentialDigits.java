package Medium.Number;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sequential-digits/">1291.Sequential Digits</a>
 * <div class="elfjS" data-track-load="description_content"><p>An&nbsp;integer has <em>sequential digits</em> if and only if each digit in the number is one more than the previous digit.</p>

<p>Return a <strong>sorted</strong> list of all the integers&nbsp;in the range <code>[low, high]</code>&nbsp;inclusive that have sequential digits.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> low = 100, high = 300
<strong>Output:</strong> [123,234]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> low = 1000, high = 13000
<strong>Output:</strong> [1234,2345,3456,4567,5678,6789,12345]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>10 &lt;= low &lt;= high &lt;= 10^9</code></li>
</ul>
</div>
 */
public class SequentialDigits {
    public static void main(String[] args) {
        int[][] tests = {
            {58,155},
            {100,300},
            {1000,13000}
        };

        for (int[] test : tests) {
            int high = test[1], low = test[0];
            
            System.out.println(new SequentialDigits_Solution().sequentialDigits(low, high).toString());
        }
    }
}

// 7 ms 40.9 MB
class SequentialDigits_Solution {
    int lowBound, upperBound;

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        lowBound = low; upperBound = high;

        addNumber(ans,lengthNumber(low),lengthNumber(high));
        
        return ans;
    }

    void addNumber(List<Integer> ans, int lowRange, int highRange) {
        for (int i = lowRange; i < highRange+1; i++) {
            for (int j = i; j < 10; j++) {
                int numberAdd = makeNumber(j,i);
                if (!(numberAdd < lowBound || numberAdd > upperBound)) {
                    ans.add(numberAdd);
                } 
            }
        }
    }

    int makeNumber(int start, int len){
        if (len == 1) {return start;}

        return Integer.parseInt(makeNumber(start-1,len-1) + String.valueOf(start));
    }

    int lengthNumber(int number) {
        int len = 0;

        while (number > 0) {
            number/=10;
            len++;
        }
        return len;
    }
}