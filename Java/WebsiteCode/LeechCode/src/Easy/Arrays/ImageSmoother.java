package Easy.Arrays;


import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/image-smoother/">661.Image Smoother</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>An <strong>image smoother</strong> is a filter of the size <code>3 x 3</code> that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).</p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/03/smoother-grid.jpg" style="width: 493px; height: 493px;">
<p>Given an <code>m x n</code> integer matrix <code>img</code> representing the grayscale of an image, return <em>the image after applying the smoother on each cell of it</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/03/smooth-grid.jpg" style="width: 613px; height: 253px;">
<pre><strong>Input:</strong> img = [[1,1,1],[1,0,1],[1,1,1]]
<strong>Output:</strong> [[0,0,0],[0,0,0],[0,0,0]]
<strong>Explanation:</strong>
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/03/smooth2-grid.jpg" style="width: 613px; height: 253px;">
<pre><strong>Input:</strong> img = [[100,200,100],[200,50,200],[100,200,100]]
<strong>Output:</strong> [[137,141,137],[141,138,141],[137,141,137]]
<strong>Explanation:</strong>
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == img.length</code></li>
	<li><code>n == img[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>0 &lt;= img[i][j] &lt;= 255</code></li>
</ul>
</div></div>
 */
public class ImageSmoother{
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,1,1},{1,0,1},{1,1,1}},
            {{100,200,100},{200,50,200},{100,200,100}},
        };

        for (int[][] img : tests) {
            img = new ImageSmoother_Solution().imageSmoother(img);

            System.out.print("[");
            for (int[] row : img) {
                System.out.print(Arrays.toString(row));
            }
            System.out.println("]");
        }
    }
}

// 6 ms 45.3 MB
class ImageSmoother_Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int totalSum = 0;
                int count = 0;

                for (int x = Math.max(0, i-1); x < Math.min(rows, i+2); ++x) {
                    for (int y = Math.max(0, j-1); y < Math.min(cols, j+2); ++y) {
                        totalSum += img[x][y];
                        count += 1;
                    }
                }

                result[i][j] = totalSum / count;
            }
        }

        return result;
    }
}