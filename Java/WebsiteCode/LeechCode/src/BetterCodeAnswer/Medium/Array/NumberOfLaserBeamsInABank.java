package BetterCodeAnswer.Medium.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/number-of-laser-beams-in-a-bank/">2125.Number of Laser Beams in a Bank</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Anti-theft security devices are activated inside a bank. You are given a <strong>0-indexed</strong> binary string array <code>bank</code> representing the floor plan of the bank, which is an <code>m x n</code> 2D matrix. <code>bank[i]</code> represents the <code>i<sup>th</sup></code> row, consisting of <code>'0'</code>s and <code>'1'</code>s. <code>'0'</code> means the cell is empty, while<code>'1'</code> means the cell has a security device.</p>

<p>There is <strong>one</strong> laser beam between any <strong>two</strong> security devices <strong>if both</strong> conditions are met:</p>

<ul>
	<li>The two devices are located on two <strong>different rows</strong>: <code>r<sub>1</sub></code> and <code>r<sub>2</sub></code>, where <code>r<sub>1</sub> &lt; r<sub>2</sub></code>.</li>
	<li>For <strong>each</strong> row <code>i</code> where <code>r<sub>1</sub> &lt; i &lt; r<sub>2</sub></code>, there are <strong>no security devices</strong> in the <code>i<sup>th</sup></code> row.</li>
</ul>

<p>Laser beams are independent, i.e., one beam does not interfere nor join with another.</p>

<p>Return <em>the total number of laser beams in the bank</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser1.jpg" style="width: 400px; height: 368px;">
<pre><strong>Input:</strong> bank = ["011001","000000","010100","001000"]
<strong>Output:</strong> 8
<strong>Explanation:</strong> Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0<sup>th</sup> row with any on the 3<sup>rd</sup> row.
This is because the 2<sup>nd</sup> row contains security devices, which breaks the second condition.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser2.jpg" style="width: 244px; height: 325px;">
<pre><strong>Input:</strong> bank = ["000","111","000"]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There does not exist two devices located on two different rows.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == bank.length</code></li>
	<li><code>n == bank[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 500</code></li>
	<li><code>bank[i][j]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
</ul>
</div></div>
 */
public class NumberOfLaserBeamsInABank {
    public static void main(String[] args) {
        String[][] tests = {
            {"011001","000000","010100","001000"},
            {"000","111","000"},
        };

        for (String[] bank : tests) {
            System.out.println(new NumberOfLaserBeamsInABank_Solution().numberOfBeams(bank));
        }
    }
}

// 16 ms 45 MB
class NumberOfLaserBeamsInABank_Solution {
    public int numberOfBeams(String[] bank) {
        int prevRowCount = 0;
        int total=0;

        for(String row : bank) {
            int curRowCount = calc(row);
            if(curRowCount==0) 
                continue;

            total += curRowCount * prevRowCount;
            prevRowCount = curRowCount;
        }
        return total;
    }

    private int calc(String s) {
        int count = 0;
        for(char c : s.toCharArray()) 
            count += c - '0';

        return count;
    }    
}