package Easy.String;

import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/crawler-log-folder/">1598. Crawler Log Folder</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>The Leetcode file system keeps a log each time some user performs a <em>change folder</em> operation.</p>
 * 
 * <p>The operations are described below:</p>
 * 
 * <ul>
 * 	<li><code>"../"</code> : Move to the parent folder of the current folder. (If you are already in the main folder, <strong>remain in the same folder</strong>).</li>
 * 	<li><code>"./"</code> : Remain in the same folder.</li>
 * 	<li><code>"x/"</code> : Move to the child folder named <code>x</code> (This folder is <strong>guaranteed to always exist</strong>).</li>
 * </ul>
 * 
 * <p>You are given a list of strings <code>logs</code> where <code>logs[i]</code> is the operation performed by the user at the <code>i<sup>th</sup></code> step.</p>
 * 
 * <p>The file system starts in the main folder, then the operations in <code>logs</code> are performed.</p>
 * 
 * <p>Return <em>the minimum number of operations needed to go back to the main folder after the change folder operations.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/09/sample_11_1957.png" style="width: 775px; height: 151px;"></p>
 * 
 * <pre><strong>Input:</strong> logs = ["d1/","d2/","../","d21/","./"]
 * <strong>Output:</strong> 2
 * <strong>Explanation: </strong>Use this change folder operation "../" 2 times and go back to the main folder.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/09/sample_22_1957.png" style="width: 600px; height: 270px;"></p>
 * 
 * <pre><strong>Input:</strong> logs = ["d1/","d2/","./","d3/","../","d31/"]
 * <strong>Output:</strong> 3
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> logs = ["d1/","../","../","../"]
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= logs.length &lt;= 10<sup>3</sup></code></li>
 * 	<li><code>2 &lt;= logs[i].length &lt;= 10</code></li>
 * 	<li><code>logs[i]</code> contains lowercase English letters, digits, <code>'.'</code>, and <code>'/'</code>.</li>
 * 	<li><code>logs[i]</code> follows the format described in the statement.</li>
 * 	<li>Folder names consist of lowercase English letters and digits.</li>
 * </ul>
 * </div>
 */
public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[][] tests = {
            {"./","../","./"},
            {"d1/","d2/","../","d21/","./"},
        };

        for (String[] logs : tests) {
            System.out.println(new CrawlerLogFolder_Solution().minOperations(logs));
        }
    }   
}

// 1 ms 42.6 MB
class CrawlerLogFolder_Solution {
    public int minOperations(String[] logs) {
        Stack<String> operations = new Stack<>();

        for (String log : logs) {
            if (log.equals("../")) {
                if (!operations.empty()) {
                    operations.pop();   
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                operations.add(log);
            }
        }
        
        return operations.size();
    }
}

// 1 ms 42 MB
class CrawlerLogFolder_Solution2 {
    public int minOperations(String[] logs) {
        int count = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (count != 0) {count--;}
            } else if (log.equals("./")) {
                continue;
            } else {
                count++;
            }
        }
        
        return count;
    }
}