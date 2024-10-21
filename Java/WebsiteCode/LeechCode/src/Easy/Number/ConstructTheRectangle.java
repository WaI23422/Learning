package Easy.Number;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/construct-the-rectangle/">492. Construct the Rectangle</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:</p>
 * 
 * <ol>
 * 	<li>The area of the rectangular web page you designed must equal to the given target area.</li>
 * 	<li>The width <code>W</code> should not be larger than the length <code>L</code>, which means <code>L &gt;= W</code>.</li>
 * 	<li>The difference between length <code>L</code> and width <code>W</code> should be as small as possible.</li>
 * </ol>
 * 
 * <p>Return <em>an array <code>[L, W]</code> where <code>L</code> and <code>W</code> are the length and width of the&nbsp;web page you designed in sequence.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> area = 4
 * <strong>Output:</strong> [2,2]
 * <strong>Explanation:</strong> The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
 * But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> area = 37
 * <strong>Output:</strong> [37,1]
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> area = 122122
 * <strong>Output:</strong> [427,286]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= area &lt;= 10<sup>7</sup></code></li>
 * </ul>
 * </div>
 */
public class ConstructTheRectangle {
    public static void main(String[] args) {
        int[] tests = {
            2,
            4,
            37,
            122122
        };

        for (int area : tests) {
            System.out.println(Arrays.toString(new ConstructTheRectangle_Solution().constructRectangle(area)));
        }
    }
}

// 2 ms 40.7 MB
class ConstructTheRectangle_Solution {
    public int[] constructRectangle(int area) {
        double limit = Math.sqrt(area)+1,
               L = area,
               W = 1;
        int[] rectangle = new int[]{(int) L,(int) W};
        
        for (int i = 2; i < limit; i++) {
            W = i;
            L = (double) area/i;
            if (L == area/i && L >= W) {
                rectangle[0] = (int) L;
                rectangle[1] = (int) W;
            }
        }

        return rectangle;
    }
}