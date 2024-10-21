package BetterCodeAnswer.Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/ugly-number-ii/">264. Ugly Number II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>An <strong>ugly number</strong> is a positive integer whose prime factors are limited to <code>2</code>, <code>3</code>, and <code>5</code>.</p>
 * 
 * <p>Given an integer <code>n</code>, return <em>the</em> <code>n<sup>th</sup></code> <em><strong>ugly number</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 10
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 1690</code></li>
 * </ul>
 * </div>
 */
public class UglyNumberII {
    public static void main(String[] args) {
        int[] tests = {
            3,
            5,
            10
        };

        for (int n : tests) {
            System.out.println(new UglyNumberII_Solution().nthUglyNumber(n));
        }
    }
}

// 1ms
class Ugly{
    public int[] nums = new int[1690];
    Ugly(){
        nums[0] = 1;
        int ugly,i2 = 0,i3=0,i5=0;
    
        for(int i=1;i<1690;i++){
            ugly = Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
            nums[i] = ugly;
    
            if(ugly == nums[i2]*2) ++i2;
            if(ugly == nums[i3]*3) ++i3;
            if(ugly == nums[i5]*5) ++i5;
            
        }
    }
}

class UglyNumberII_Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n-1];
    }
}