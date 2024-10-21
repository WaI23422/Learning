package BetterCodeAnswer.Easy.String;

/**
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "Let's take LeetCode contest"
<strong>Output:</strong> "s'teL ekat edoCteeL tsetnoc"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "God Ding"
<strong>Output:</strong> "doG gniD"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> contains printable <strong>ASCII</strong> characters.</li>
	<li><code>s</code> does not contain any leading or trailing spaces.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
	<li>All the words in <code>s</code> are separated by a single space.</li>
</ul>
</div></div>
 */
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {

        ReverseWordsInAStringIII_Solution reverseWordsInAStringIII_Solution = new ReverseWordsInAStringIII_Solution();

        System.out.println(reverseWordsInAStringIII_Solution.reverseWords("Let's take LeetCode contest"));
    }    
}

/**
 * <h4 id="approach-2-using-two-pointers">Approach 2: Using Two Pointers</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>In the previous approach, the words were reversed by copying every character into another string one by one in reverse order. This operation takes <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(N)\mathcal{O}(N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathcal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span> time, where <code>N</code> is the length of the word.</p>
 * <p>However, there is another optimal approach to reverse the string in <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(N/2)\mathcal{O}(N/2)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathcal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mord">/2</span><span class="mclose">)</span></span></span></span></span> time in place using two pointer approach.</p>
 * <p>In this solution, we will traverse the string and find every word's start and end index. Then, we will reverse each word using the two-pointer approach.</p>
 * <p><em>Approach to reverse a string using a two-pointer approach</em></p>
 * <ol>
<li>
<p>Find the start and end index of every word given by <code>startIndex</code> and <code>endIndex</code>.</p>
</li>
<li>
<p>Swap the characters in the word pointed by <code>startIndex</code> and <code>endIndex</code>.</p>
</li>
<li>
<p>Increment <code>startIndex</code> by 1 and decrement <code>endIndex</code> by 1.</p>
</li>
<li>
<p>Repeat steps 2 and 3 until <code>startIndex &lt; endIndex</code>.</p>
<p><img src="https://leetcode.com/problems/reverse-words-in-a-string-iii/Figures/557/2_pointer_approach.png" alt="Two Pointer Approach To Reverse String"></p>
</li>
</ol>
<p>Here's the code snippet for reversing the string stored in character array <code>chArray</code> using two pointer approach.</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-java" style="text-shadow: none; white-space: pre;"><span><span class="token" style="color: rgb(0, 119, 170);">while</span><span> </span><span class="token" style="color: rgb(153, 153, 153);">(</span><span>startIndex </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">&lt;</span><span> endIndex</span><span class="token" style="color: rgb(153, 153, 153);">)</span><span> </span><span class="token" style="color: rgb(153, 153, 153);">{</span><span>
</span></span><span><span>        </span><span class="token" style="color: rgb(0, 119, 170);">char</span><span> temp </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> chArray</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>startIndex</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span><span>        chArray</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>startIndex</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span> </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> chArray</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>endIndex</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span><span>        chArray</span><span class="token" style="color: rgb(153, 153, 153);">[</span><span>endIndex</span><span class="token" style="color: rgb(153, 153, 153);">]</span><span> </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> temp</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span><span>        startIndex</span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">++</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span><span>        endIndex</span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">--</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span><span></span><span class="token" style="color: rgb(153, 153, 153);">}</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div>
<p><strong>Algorithm</strong></p>
<ul>
<li>
<p>The variable <code>lastSpaceIndex</code> stores the index of space character last found. Initialize its value to <code>-1</code>.</p>
</li>
<li>
<p>Traverse over each character of the string from <span class="math math-inline"><span class="katex"><span class="katex-mathml">0th0^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord">0</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> index to <span class="math math-inline"><span class="katex"><span class="katex-mathml">nthn^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> index using pointer <code>strIndex</code>.</p>
</li>
<li>
<p>As <code>strIndex</code> points to a space character, mark the start and end index of the current word in the variables <code>startIndex</code> and <code>endIndex</code> as,</p>
<ul>
<li>The <code>startIndex</code> of the current word is the value of <code>lastSpaceIndex + 1</code>.</li>
<li>The <code>endIndex</code> of the current word is the value of <code>strIndex - 1</code>.</li>
</ul>
</li>
<li>
<p>Reverse the characters in the current word using two pointer approach.</p>
</li>
<li>
<p>Update the <code>lastSpaceIndex</code> to the value of <code>strIndex</code> i.e the index of current space character. The next iteration will refer to this variable to identify the start position of the next word.</p>
</li>
<li>
<p>Repeat the process for all the words in the string.</p>
</li>
</ul>
<p><strong>Complexity Analysis</strong></p>
<p>Let <span class="math math-inline"><span class="katex"><span class="katex-mathml">NN</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span></span></span></span></span> be the length of string <code>s</code>.</p>
<ul>
<li>
<p>Time Complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(N)\mathcal{O}(N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathcal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span> The outer loop iterates over <span class="math math-inline"><span class="katex"><span class="katex-mathml">N\text{N}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord text"><span class="mord">N</span></span></span></span></span></span> characters to find the <code>start</code> and <code>end</code> index of every word. The algorithm to reverse the word also iterates <span class="math math-inline"><span class="katex"><span class="katex-mathml">N\text{N}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord text"><span class="mord">N</span></span></span></span></span></span> times to perform <span class="math math-inline"><span class="katex"><span class="katex-mathml">N/2\text{N/2}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord text"><span class="mord">N/2</span></span></span></span></span></span> swaps. Thus, the time complexity is <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(N+N)=O(N)\mathcal{O}(N + N) = {O}(N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathcal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord"><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span></span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span>.</p>
</li>
<li>
<p>Space Complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)\mathcal{O}(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathcal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span> We use constant extra space to track the last space index. You could also argue that we are using <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> space to build the output string (we normally don't count the output as part of the space complexity, but in this case we are temporarily using some space to build it).</p>
</li>
</ul>
 */
class ReverseWordsInAStringIII_Solution {
    // 3 ms
    // 44.5 MB
    public String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }

}
/**
 * <h4 id="approach-1-traverse-and-reverse-each-character-one-by-one">Approach 1: Traverse and Reverse each character one by one</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>To solve the problem let's look at the example carefully,</p>
 * <div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-python" style="text-shadow: none; white-space: pre;"><span><span>Input</span><span class="token" style="color: rgb(153, 153, 153);">:</span><span> </span><span class="token" style="color: rgb(102, 153, 0);">"Let's take LeetCode contest"</span><span>`
</span></span><span>
</span><span><span>Output</span><span class="token" style="color: rgb(153, 153, 153);">:</span><span> </span><span class="token" style="color: rgb(102, 153, 0);">"s'teL ekat edoCteeL tsetnoc"</span></span></code></pre><div class="h-4 w-4 cursor-pointer fill-gray-6 hover:fill-gray-7 dark:fill-dark-gray-6 dark:hover:fill-dark-gray-7 absolute right-0 top-0"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-4 w-4 text-gray-6 hover:text-gray-7 dark:text-dark-gray-6 dark:hover:text-dark-gray-7 hidden group-hover:block"><path fill-rule="evenodd" d="M11.3 8.3H19a3 3 0 013 3V19a3 3 0 01-3 3h-7.7a3 3 0 01-3-3v-7.7a3 3 0 013-3zm0 2a1 1 0 00-1 1V19a1 1 0 001 1H19a1 1 0 001-1v-7.7a1 1 0 00-1-1h-7.7zm-5.6 3.4a1 1 0 110 2h-.9A2.8 2.8 0 012 12.9V4.8A2.8 2.8 0 014.8 2h8.1a2.8 2.8 0 012.8 2.8v.9a1 1 0 11-2 0v-.9a.8.8 0 00-.8-.8H4.8a.8.8 0 00-.8.8v8.1a.8.8 0 00.8.8h.9z" clip-rule="evenodd"></path></svg></div></div></div>
<p>There are a few observations here,</p>
<ul>
<li>
<p>The characters of each word in the string are reversed, but the order of words remains the same.</p>
<p>For example, in the input, the word <code>Let's</code> is the first word in the string. In the output, the characters in the word <code>Let's</code> are reversed to <code>s'teL</code>. But it is still at the first position in the string.<br>
Similarly the second word <code>take</code> is reversed as <code>ekat</code> and placed at the same second position in the output string.</p>
</li>
<li>
<p>The words in the string are separated by a space character. So we can say that to build the output string, we must extract and reverse the substring between 2 consecutive space characters.</p>
<p><img src="https://leetcode.com/problems/reverse-words-in-a-string-iii/Figures/557/second_observation.png" alt="Second Observation Illustration"></p>
</li>
</ul>
<p>Using this intuition, let's understand how to implement this problem.</p>
<p><strong>Algorithm</strong></p>
<p>By analyzing the above two key observations, we can derive the following algorithm,</p>
<ul>
<li>
<p>Find the starting and ending position of each word in the string.</p>
<p>As a space character is a separator for each word, we are finding the substrings having a space character before its first character and after its last character.</p>
<blockquote>
<p>Note: Take care of 2 edge cases here, the first word does not have a space before its first character. Similarly, the last word does not have a space after its last character.</p>
</blockquote>
</li>
<li>
<p>For each identified word, reverse the characters of the word one by one.</p>
</li>
</ul>
<p><em>Steps</em></p>
<p>Traverse the string from left to right, starting from <span class="math math-inline"><span class="katex"><span class="katex-mathml">0th0^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord">0</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> to <span class="math math-inline"><span class="katex"><span class="katex-mathml">nthn^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> index. As we traverse, the pointer <code>strIndex</code> tracks each character.<br>
The implementation can be divided into 2 steps,</p>
<ol>
<li>
<p>Find the start and end index of every word</p>
<ul>
<li>
<p>Traverse over the string until the current pointer <code>strIndex</code> points to a space character.</p>
</li>
<li>
<p>As <code>strIndex</code> points to the space character, the index <code>strIndex - 1</code> points to the last character of the current word.</p>
<p><img src="https://leetcode.com/problems/reverse-words-in-a-string-iii/Figures/557/current_pointer_traversal.png" alt="Current Pointer Traversal"></p>
</li>
<li>
<p>Let's understand how to find the first character of the word,</p>
<ul>
<li>
<p>For the first word, its first character is always the first character of the string.</p>
</li>
<li>
<p>For the remaining words, the first character would be the character after the last space character.</p>
<p>Thus, to mark the start of the current character, we must keep track of the last found space character. Let's use a variable <code>lastSpaceIndex</code>. The variable will be initialized to <code>-1</code>  and updated every time we find the next space character.</p>
<p><img src="https://leetcode.com/problems/reverse-words-in-a-string-iii/Figures/557/start_and_end_index.png"></p>
<p>The first character of the current word is thus <code>lastSpaceIndex + 1</code>.</p>
</li>
</ul>
</li>
</ul>
</li>
<li>
<p>Reverse the characters within the word</p>
<ul>
<li>
<p>Now that we have the first and last index of the current word, we have to reverse the current word and append it to the result string.</p>
</li>
<li>
<p>To reverse the current word, we can traverse it in reverse order i.e start from the end index <code>strIndex - 1</code> to the first index i.e <code>lastSpaceIndex + 1</code>, appending each character one by one to the result string.</p>
</li>
<li>
<p>To separate the current word from the next, append a space character (" ") at the end after the reverse operation. However, for the last word, this step is skipped.</p>
</li>
</ul>
</li>
</ol>
<p>Repeat 1 and 2 for all the words in the string.</p>
 */
class ReverseWordsInAStringIII_Solution2{
    // 7 ms
    // 44 MB
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int lastSpaceIndex = -1;
        for (int strIndex = 0; strIndex < s.length(); strIndex++) {
            if ((strIndex == s.length() - 1) || s.charAt(strIndex) == ' ') {
                int reverseStrIndex = (strIndex == s.length() - 1) ? strIndex : strIndex - 1;
                for (; reverseStrIndex > lastSpaceIndex; reverseStrIndex--) {
                    result.append(s.charAt(reverseStrIndex));
                }
                if (strIndex != s.length() - 1) {
                    result.append(' ');
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(result);
    }
}

/**
 * <h4 id="ssplit-the-input-string-s-is-first-split-into-words-using-the-default-whitespace-delimiter-this-creates-a-list-of-words-from-the-input-string">1. s.split(): The input string s is first split into words using the default whitespace delimiter. This creates a list of words from the input string.</h4>
 */
class ReverseWordsInAStringIII_Solution3 {
    // 11 ms
    // 44 Mb
    public String reverseWords(String s) {
        String[] words = s.split("\\s+"); 
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse(); 
            reversed.append(reversedWord).append(" "); 
        }
        return reversed.toString().trim();
    }
}