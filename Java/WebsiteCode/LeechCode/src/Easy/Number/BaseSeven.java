package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/base-7/">504. Base 7</a>
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>num</code>, return <em>a string of its <strong>base 7</strong> representation</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> num = 100
 * <strong>Output:</strong> "202"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> num = -7
 * <strong>Output:</strong> "-10"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>-10<sup>7</sup> &lt;= num &lt;= 10<sup>7</sup></code></li>
 * </ul>
 * </div>
 */
public class BaseSeven {
    public static void main(String[] args) {
        int[] tests = {
            1002,
            100,
            -7
        };

        for (int num : tests) {
            System.out.println(new BaseSeven_Solution().convertToBase7(num));
        }
    }
}

// 1 ms 40.6 MB
class BaseSeven_Solution {
    // 0 ms 40.6 MB
    // public String convertToBase7(int num) {
        // return Integer.toString(num, 7);
    // }

    StringBuffer base_7 = new StringBuffer();
    
    public String convertToBase7(int num) {
        if (num < 0) {
            num = -num;
            base_7.append("-");
        }

        timesDivivedBy7(num, 0);

        return base_7.toString();
    }

    private void timesDivivedBy7(int num, int prev) {
        int copNum = num,
            total = 0;
        while (copNum > 6) {
            copNum /= 7;
            total++;
        }

        addZero(total,prev);
        base_7.append(copNum);

        num -= copNum*Math.pow(7, total);

        if (num != 0) {
            timesDivivedBy7(num, total);
        } else {
            if (total > 0) {
                addZero(0, total+1);
            }
        }
    }

    private void addZero(int start, int end) {
        for (int i = start; i < end-1; i++) {
            base_7.append("0");
        }
    }
}