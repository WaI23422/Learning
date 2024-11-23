package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class='no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]' href='/problems/rotating-the-box/'>1861. Rotating the Box</a>
 * 
 * <div><div class='elfjS' data-track-load='description_content'><p>You are given an <code>m x n</code> matrix of characters <code>box</code> representing a side-view of a box. Each cell of the box is one of the following:</p>
 * 
 * <ul>
 * 	<li>A stone <code>'#'</code></li>
 * 	<li>A stationary obstacle <code>'*'</code></li>
 * 	<li>Empty <code>'.'</code></li>
 * </ul>
 * 
 * <p>The box is rotated <strong>90 degrees clockwise</strong>, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity <strong>does not</strong> affect the obstacles' positions, and the inertia from the box's rotation <strong>does not </strong>affect the stones' horizontal positions.</p>
 * 
 * <p>It is <strong>guaranteed</strong> that each stone in <code>box</code> rests on an obstacle, another stone, or the bottom of the box.</p>
 * 
 * <p>Return <em>an </em><code>n x m</code><em> matrix representing the box after the rotation described above</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class='example'>Example 1:</strong></p>
 * 
 * <p><img alt='' src='https://assets.leetcode.com/uploads/2021/04/08/rotatingtheboxleetcodewithstones.png' style='width: 300px; height: 150px;'></p>
 * 
 * <pre><strong>Input:</strong> box = [['#','.','#']]
 * <strong>Output:</strong> [['.'],
 * &nbsp;        ['#'],
 * &nbsp;        ['#']]
 * </pre>
 * 
 * <p><strong class='example'>Example 2:</strong></p>
 * 
 * <p><img alt='' src='https://assets.leetcode.com/uploads/2021/04/08/rotatingtheboxleetcode2withstones.png' style='width: 375px; height: 195px;'></p>
 * 
 * <pre><strong>Input:</strong> box = [['#','.','*','.'],
 * &nbsp;             ['#','#','*','.']]
 * <strong>Output:</strong> [['#','.'],
 * &nbsp;        ['#','#'],
 * &nbsp;        ['*','*'],
 * &nbsp;        ['.','.']]
 * </pre>
 * 
 * <p><strong class='example'>Example 3:</strong></p>
 * 
 * <p><img alt='' src='https://assets.leetcode.com/uploads/2021/04/08/rotatingtheboxleetcode3withstone.png' style='width: 400px; height: 218px;'></p>
 * 
 * <pre><strong>Input:</strong> box = [['#','#','*','.','*','.'],
 * &nbsp;             ['#','#','#','*','.','.'],
 * &nbsp;             ['#','#','#','.','#','.']]
 * <strong>Output:</strong> [['.','#','#'],
 * &nbsp;        ['.','#','#'],
 * &nbsp;        ['#','#','*'],
 * &nbsp;        ['#','*','.'],
 * &nbsp;        ['#','.','*'],
 * &nbsp;        ['#','.','.']]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == box.length</code></li>
 * 	<li><code>n == box[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 500</code></li>
 * 	<li><code>box[i][j]</code> is either <code>'#'</code>, <code>'*'</code>, or <code>'.'</code>.</li>
 * </ul></div></div>
 */
public class RotatingTheBox {
    public static void main(String[] args) {
        char[][][] tests = {
            {{'#','.','*','.'},{'#','#','*','.'}},
            {{'#','.','#'}}
        };

        for (char[][] box : tests) {
            System.out.println(Arrays.deepToString(new RotatingTheBox_Solution().rotateTheBox(box)));
        }
    }
}

// 5ms 79.76MB
class RotatingTheBox_Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
		char[][] res = new char[n][m];
		for (int i = 0; i < m; ++i) {
            for (int j = n - 1, k = n - 1; j >= 0; --j) {
				res[j][m - i - 1] = '.';
				if (box[i][j] != '.') {
					k = box[i][j] == '*' ? j : k;
					res[k--][m - i - 1] = box[i][j];
				}
			}
        }
		return res;
    }
}