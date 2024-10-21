package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/height-checker/">1051. Height Checker</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in <strong>non-decreasing order</strong> by height. Let this ordering be represented by the integer array <code>expected</code> where <code>expected[i]</code> is the expected height of the <code>i<sup>th</sup></code> student in line.</p>
 * 
 * <p>You are given an integer array <code>heights</code> representing the <strong>current order</strong> that the students are standing in. Each <code>heights[i]</code> is the height of the <code>i<sup>th</sup></code> student in line (<strong>0-indexed</strong>).</p>
 * 
 * <p>Return <em>the <strong>number of indices</strong> where </em><code>heights[i] != expected[i]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> heights = [1,1,4,2,1,3]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 
 * heights:  [1,1,<u>4</u>,2,<u>1</u>,<u>3</u>]
 * expected: [1,1,<u>1</u>,2,<u>3</u>,<u>4</u>]
 * Indices 2, 4, and 5 do not match.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> heights = [5,1,2,3,4]
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong>
 * heights:  [<u>5</u>,<u>1</u>,<u>2</u>,<u>3</u>,<u>4</u>]
 * expected: [<u>1</u>,<u>2</u>,<u>3</u>,<u>4</u>,<u>5</u>]
 * All indices do not match.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> heights = [1,2,3,4,5]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong>
 * heights:  [1,2,3,4,5]
 * expected: [1,2,3,4,5]
 * All indices match.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= heights.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;= heights[i] &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class HeightChecker {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,4,2,1,3}
        };

        for (int[] heights : tests) {
            System.out.println(new HeightChecker_Solution().heightChecker(heights));
        }
    }
}

// 0 ms 41.6 MB
class HeightChecker_Solution {
    public int heightChecker(int[] heights) {
     int heightsFreq[] = new int[101];
      int expected[] = new int[heights.length];
      for (int index =0; index < heights.length; index++) {
        heightsFreq[heights[index]]++;
      }
      int count =0, diffCount =0;
      for (int index =0; index < heightsFreq.length && count < heights.length;index++) {
        while (heightsFreq[index] > 0) {
          expected[count++] = index;
          heightsFreq[index]--;
        }
      }
      for (int index =0; index < heights.length; index++) {
        if(heights[index] != expected[index]) {
          diffCount++;
        }
      }
      return diffCount;   
    }
}

// 1 ms 41.6 MB
class HeightChecker_Solution2 {
    public int heightChecker(int[] heights) {
        int largest=Integer.MIN_VALUE;
     
        for(int i=0;i<heights.length;i++){
            largest=Math.max(largest,heights[i]);
        }

        int count[]=new int[largest+1];
        for(int i=0;i<heights.length;i++){
            count[heights[i]]++;
        }

        int j=0;
        int sort[]=new int[heights.length];
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                sort[j]=i;
                j++;
                count[i]--; 
            }
        }
            int k=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=sort[i]){
                k++;

            }
        }
        return k;
    }
}