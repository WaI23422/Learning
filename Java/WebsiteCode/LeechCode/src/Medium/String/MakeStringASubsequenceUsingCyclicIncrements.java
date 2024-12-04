package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/make-string-a-subsequence-using-cyclic-increments/">2825. Make String a Subsequence Using Cyclic Increments</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given two <strong>0-indexed</strong> strings <code>str1</code> and <code>str2</code>.</p>
 * 
 * <p>In an operation, you select a <strong>set</strong> of indices in <code>str1</code>, and for each index <code>i</code> in the set, increment <code>str1[i]</code> to the next character <strong>cyclically</strong>. That is <code>'a'</code> becomes <code>'b'</code>, <code>'b'</code> becomes <code>'c'</code>, and so on, and <code>'z'</code> becomes <code>'a'</code>.</p>
 * 
 * <p>Return <code>true</code> <em>if it is possible to make </em><code>str2</code> <em>a subsequence of </em><code>str1</code> <em>by performing the operation <strong>at most once</strong></em>, <em>and</em> <code>false</code> <em>otherwise</em>.</p>
 * 
 * <p><strong>Note:</strong> A subsequence of a string is a new string that is formed from the original string by deleting some (possibly none) of the characters without disturbing the relative positions of the remaining characters.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> str1 = "abc", str2 = "ad"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Select index 2 in str1.
 * Increment str1[2] to become 'd'. 
 * Hence, str1 becomes "abd" and str2 is now a subsequence. Therefore, true is returned.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> str1 = "zc", str2 = "ad"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Select indices 0 and 1 in str1. 
 * Increment str1[0] to become 'a'. 
 * Increment str1[1] to become 'd'. 
 * Hence, str1 becomes "ad" and str2 is now a subsequence. Therefore, true is returned.</pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> str1 = "ab", str2 = "d"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> In this example, it can be shown that it is impossible to make str2 a subsequence of str1 using the operation at most once. 
 * Therefore, false is returned.</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= str1.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= str2.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>str1</code> and <code>str2</code> consist of only lowercase English letters.</li>
 * </ul>
 * </div></div>
 */
public class MakeStringASubsequenceUsingCyclicIncrements {
    public static void main(String[] args) {
        
    }
}

// 5ms 46.09MB
class MakeStringASubsequenceUsingCyclicIncrements_Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length() ;
        int n2 = str2.length() ;
        int ptr1 = 0 ;
        int ptr2 = 0 ;
        while(ptr1 < n1 && ptr2 < n2){
            char sch = str1.charAt(ptr1) ;
            char tch = str2.charAt(ptr2) ;
            if(sch != tch){
                if( sch +1 == tch   ||  sch - 25 == tch){
                 ptr1 ++ ;
                 ptr2 ++ ;
                }
                else{
                ptr1 ++ ;
                }
            }

            else{
            ptr1 ++ ;
            ptr2 ++ ;
            }

            if(ptr1 == n1  && ptr2 != n2)
            return false ;       
                
        }
        return true ;
        
    }
}