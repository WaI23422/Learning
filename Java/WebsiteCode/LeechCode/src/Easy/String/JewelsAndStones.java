package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/jewels-and-stones/">771. Jewels and Stones</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You're given strings <code>jewels</code> representing the types of stones that are jewels, and <code>stones</code> representing the stones you have. Each character in <code>stones</code> is a type of stone you have. You want to know how many of the stones you have are also jewels.</p>
 * 
 * <p>Letters are case sensitive, so <code>"a"</code> is considered a different type of stone from <code>"A"</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> jewels = "aA", stones = "aAAbbbb"
 * <strong>Output:</strong> 3
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> jewels = "z", stones = "ZZ"
 * <strong>Output:</strong> 0
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;=&nbsp;jewels.length, stones.length &lt;= 50</code></li>
 * 	<li><code>jewels</code> and <code>stones</code> consist of only English letters.</li>
 * 	<li>All the characters of&nbsp;<code>jewels</code> are <strong>unique</strong>.</li>
 * </ul>
 * </div>
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        String[][] tests = {
            {
                "aA",
                "aAAbbbb"
            }
        };

        for (String[] test : tests) {
            String jewels = test[0],
                   stones = test[1];

            System.out.println(new JewelsAndStones_Solution().numJewelsInStones(jewels, stones));
        }
    }
}

// 0ms 41.64MB
class JewelsAndStones_Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] jewelExists = new boolean[58];
        char[] jewelsChar = jewels.toCharArray(),
               stonesChar = stones.toCharArray();

        for (char jewelChar : jewelsChar) {
            jewelExists[jewelChar-'A'] = true;
        }
        
        int count = 0;
        for (char stoneChar : stonesChar) {
            if (jewelExists[stoneChar-'A']) {count++;}
        }

        return count;
    }   
}