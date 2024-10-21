package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/detect-capital/">520. Detect Capital</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>We define the usage of capitals in a word to be right when one of the following cases holds:</p>
 * 
 * <ul>
 * 	<li>All letters in this word are capitals, like <code>"USA"</code>.</li>
 * 	<li>All letters in this word are not capitals, like <code>"leetcode"</code>.</li>
 * 	<li>Only the first letter in this word is capital, like <code>"Google"</code>.</li>
 * </ul>
 * 
 * <p>Given a string <code>word</code>, return <code>true</code> if the usage of capitals in it is right.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> word = "USA"
 * <strong>Output:</strong> true
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> word = "FlaG"
 * <strong>Output:</strong> false
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= word.length &lt;= 100</code></li>
 * 	<li><code>word</code> consists of lowercase and uppercase English letters.</li>
 * </ul>
 * </div>
 */
public class DetectCapital {
    public static void main(String[] args) {
        String[] tests = {
            "USA",
            "FlaG"
        };

        for (String word : tests) {
            System.out.println(new DetectCapital_Solution().detectCapitalUse(word));
        }
    }
}

class DetectCapital_Solution {
    // 1 ms 41.8 MB
    public boolean detectCapitalUse(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                if (!Character.isUpperCase(word.charAt(i - 1))) {
                    return false;
                }
            } else {
                if (Character.isUpperCase(word.charAt(i - 1))) {
                    if (i != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // 0ms 42.1 MB
    public boolean detectCapitalUse2(String word) {
        char firstChar = word.charAt(0);
        int wordLen = word.length();
        int smallCount =0; 
        int capitalCount = 0;
        //First Get the Count of small letters and capital Letters

        for(int i=0;i<wordLen;i++){
            firstChar = word.charAt(i);
            if(firstChar>='a' && firstChar<='z') smallCount ++;
            else capitalCount ++;
        }
        //Check here if Case1 or Case2 is met (See the approach section)
        if(capitalCount ==wordLen || smallCount==wordLen) return true;
        firstChar = word.charAt(0);

        //Check for the case3
        if(capitalCount==1 && (firstChar>='A' && firstChar<='Z')) return true;

        //Coming here means, none of 3 cases met, so return false
        return false;
    }
}