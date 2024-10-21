package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sentence-similarity-iii/">1813. Sentence Similarity III</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given two strings <code>sentence1</code> and <code>sentence2</code>, each representing a <strong>sentence</strong> composed of words. A sentence is a list of <strong>words</strong> that are separated by a <strong>single</strong> space with no leading or trailing spaces. Each word consists of only uppercase and lowercase English characters.</p>
 * 
 * <p>Two sentences <code>s1</code> and <code>s2</code> are considered <strong>similar</strong> if it is possible to insert an arbitrary sentence (<em>possibly empty</em>) inside one of these sentences such that the two sentences become equal. <strong>Note</strong> that the inserted sentence must be separated from existing words by spaces.</p>
 * 
 * <p>For example,</p>
 * 
 * <ul>
 * 	<li><code>s1 = "Hello Jane"</code> and <code>s2 = "Hello my name is Jane"</code> can be made equal by inserting <code>"my name is"</code> between <code>"Hello"</code><font face="monospace"> </font>and <code>"Jane"</code><font face="monospace"> in s1.</font></li>
 * 	<li><font face="monospace"><code>s1 = "Frog cool"</code> </font>and<font face="monospace"> <code>s2 = "Frogs are cool"</code> </font>are <strong>not</strong> similar, since although there is a sentence <code>"s are"</code> inserted into <code>s1</code>, it is not separated from <code>"Frog"</code> by a space.</li>
 * </ul>
 * 
 * <p>Given two sentences <code>sentence1</code> and <code>sentence2</code>, return <strong>true</strong> if <code>sentence1</code> and <code>sentence2</code> are <strong>similar</strong>. Otherwise, return <strong>false</strong>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">sentence1 = "My name is Haley", sentence2 = "My Haley"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">true</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><code>sentence2</code> can be turned to <code>sentence1</code> by inserting "name is" between "My" and "Haley".</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">sentence1 = "of", sentence2 = "A lot of words"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">false</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>No single sentence can be inserted inside one of the sentences to make it equal to the other.</p>
 * </div>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">sentence1 = "Eating right now", sentence2 = "Eating"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">true</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><code>sentence2</code> can be turned to <code>sentence1</code> by inserting "right now" at the end of the sentence.</p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= sentence1.length, sentence2.length &lt;= 100</code></li>
 * 	<li><code>sentence1</code> and <code>sentence2</code> consist of lowercase and uppercase English letters and spaces.</li>
 * 	<li>The words in <code>sentence1</code> and <code>sentence2</code> are separated by a single space.</li>
 * </ul>
 * </div></div>
 */
public class SentenceSimilarityIII {
    public static void main(String[] args) {
        String[][] tests =  {
            {
                "My name is Haley",
                "My Haley"
            },
            {
                "a",
                "A"
            },
            {
                "Ogn WtWj HneS",
                "Ogn WtWj HneS"
            },
            {
                "of words",
                "A lot of words"
            },
            {
                "My name is Haley",
                "My name is"
            },
        };

        for (String[] test : tests) {
            String sentence1 = test[0],
                   sentence2 = test[1];

            System.out.println(new SentenceSimilarityIII_Solution().areSentencesSimilar(sentence1, sentence2));
        }
        
    }
}

// 0ms 41.61MB
class SentenceSimilarityIII_Solution {
    public boolean areSentencesSimilar(String sent1, String sent2) {
        String first = sent1;
        String sec = sent2;
        if(first.length()==sec.length()){
            return first.equals(sec);
        }
        if(sent2.length()<first.length()){
            first = sent2;
            sec = sent1;
        }
        int i = -1;
      while(i+1<first.length() && first.charAt(i+1)==sec.charAt(i+1)){
        i++;
      }
        int j = first.length();
        int last = sec.length();
      while(j-1>=0 && first.charAt(j-1)==sec.charAt(last-1)){
        j--;
        last--;
      }

      if(i==first.length()-1 && sec.charAt(i+1)==' '){
        return true;
      } 
      if(j==0 && sec.charAt(last-1)==' '){
        return true;
      }
       if(i+1>=j && sec.charAt(i)==' ' && sec.charAt(last)==' '){
            return true;
       }
       
      return false;
    }
}