package BetterCodeAnswer.Medium.String;

/**
 * <div class="flex h-full items-center"><a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/"> 2038 Remove Colored Pieces if Both Neighbors are the Same Color</a><div class="inline-flex min-h-[20px] items-center space-x-2 align-top mt-1"><div class="inline-flex items-center space-x-2"></div></div></div>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>There are <code>n</code> pieces arranged in a line, and each piece is colored either by <code>'A'</code> or by <code>'B'</code>. You are given a string <code>colors</code> of length <code>n</code> where <code>colors[i]</code> is the color of the <code>i<sup>th</sup></code> piece.</p>

<p>Alice and Bob are playing a game where they take <strong>alternating turns</strong> removing pieces from the line. In this game, Alice moves<strong> first</strong>.</p>

<ul>
	<li>Alice is only allowed to remove a piece colored <code>'A'</code> if <strong>both its neighbors</strong> are also colored <code>'A'</code>. She is <strong>not allowed</strong> to remove pieces that are colored <code>'B'</code>.</li>
	<li>Bob is only allowed to remove a piece colored <code>'B'</code> if <strong>both its neighbors</strong> are also colored <code>'B'</code>. He is <strong>not allowed</strong> to remove pieces that are colored <code>'A'</code>.</li>
	<li>Alice and Bob <strong>cannot</strong> remove pieces from the edge of the line.</li>
	<li>If a player cannot make a move on their turn, that player <strong>loses</strong> and the other player <strong>wins</strong>.</li>
</ul>

<p>Assuming Alice and Bob play optimally, return <code>true</code><em> if Alice wins, or return </em><code>false</code><em> if Bob wins</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> colors = "AAABABB"
<strong>Output:</strong> true
<strong>Explanation:</strong>
A<u>A</u>ABABB -&gt; AABABB
Alice moves first.
She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.

Now it's Bob's turn.
Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
Thus, Alice wins, so return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> colors = "AA"
<strong>Output:</strong> false
<strong>Explanation:</strong>
Alice has her turn first.
There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
Thus, Bob wins, so return false.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> colors = "ABBBBBBBAAA"
<strong>Output:</strong> false
<strong>Explanation:</strong>
ABBBBBBBA<u>A</u>A -&gt; ABBBBBBBAA
Alice moves first.
Her only option is to remove the second to last 'A' from the right.

ABBBB<u>B</u>BBAA -&gt; ABBBBBBAA
Next is Bob's turn.
He has many options for which 'B' piece to remove. He can pick any.

On Alice's second turn, she has no more pieces that she can remove.
Thus, Bob wins, so return false.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;colors.length &lt;= 10<sup>5</sup></code></li>
	<li><code>colors</code>&nbsp;consists of only the letters&nbsp;<code>'A'</code>&nbsp;and&nbsp;<code>'B'</code></li>
</ul>
</div></div>
 */
public class RemoveColoredPiecesIfBothNeighborsAreTheSamColor {
    public static void main(String[] args) {
        String s = "AAAABBBB";

        RemoveColoredPiecesIfBothNeighborsAreTheSamColor_Solution removeColoredPiecesIfBothNeighborsAreTheSamColor_Solution = new RemoveColoredPiecesIfBothNeighborsAreTheSamColor_Solution();

        System.out.println(removeColoredPiecesIfBothNeighborsAreTheSamColor_Solution.winnerOfGame(s));
    }
}

/**
 * <h4 id="approach-count">Approach: Count</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>There are two very important things to notice about this game that will allow us to easily solve the problem:</p>
 * <ol>
<li>When one player removes a letter, it will <strong>never</strong> create a new removal opportunity for the other player. For example, let's say you had <code>"ABAA"</code>. If the <code>"B"</code> wasn't there, then Alice would have a new removal opportunity. However, the <code>"B"</code> can never be removed because of the rules of the game. This observation implies that at the start of the game, all moves are already available to both players.</li>
<li>The order in which the removals happen is irrelevant. This is a side effect of the previous observation. Let's say there was a section in the middle of the string <code>"BAAAAAB"</code>. Alice has three removal choices here, <code>"BA[A]AAAB"</code>, <code>"BAA[A]AAB"</code>, and <code>"BAAA[A]AB"</code>. However, her choice is irrelevant, because all three choices will result in <code>"BAAAAB"</code>.</li>
</ol>
<p>We can think of splitting the string into groups. A group consists of three or more of the same character. From observation 2, removals within a group can happen in any order. From observation 1, no two groups can ever "merge".</p>
<p><strong>Thus, the only thing that matters is the number of moves available to both players at the start of the game</strong>.</p>
<p>The number of moves available to Alice is the number of times the substring <code>"AAA"</code> appears. Similarly, the number of moves available to Bob is the number of times the substring <code>"BBB"</code> appears.</p>
<p>As shown below, in the string <code>"AAAAA"</code>, substring <code>"AAA"</code> appears 3 times, indicating 3 moves available for Alice.</p>
<p><img src="https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/Figures/2038/1.png" alt="example"><br>
<br></p>
<p>We can simply iterate over the string and for each index <code>i</code>, check if <code>colors[i - 1] == colors[i] == colors[i + 1]</code>. If so, then we can increment either Alice or Bob's available moves.</p>
<p>Because Alice moves first, she must make at least one move more than Bob to win. That is, Alice wins if <code>alice - bob &gt;= 1</code>. For example, let's say Alice has 3 moves and Bob has 2 moves.</p>
<ul>
<li>Turn 1: Alice</li>
<li>Turn 2: Bob</li>
<li>Turn 3: Alice</li>
<li>Turn 4: Bob</li>
<li>Turn 5: Alice</li>
<li>Turn 6: Bob has no moves left but it's his turn, Bob loses</li>
</ul>
<p><strong>Algorithm</strong></p>
<ol>
<li>Initialize <code>alice = bob = 0</code>.</li>
<li>Iterate <code>i</code> from <code>1</code> to <code>colors.length - 1</code>.
<ul>
<li>If <code>colors[i - 1] == colors[i] == colors[i + 1]</code>, increment <code>Alice</code> or <code>Bob</code> depending on what <code>colors[i]</code> is. If <code>colors[i]</code> is equal to <code>"A"</code>, increment <code>Alice</code>, otherwise, increment <code>Bob</code>.</li>
</ul>
</li>
<li>Return <code>alice - bob &gt;= 1</code></li>
</ol>
<p><strong>Complexity Analysis</strong></p>
<p>Given <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> as the length of <code>colors</code>,</p>
<ul>
<li>
<p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span></p>
<p>We iterate over the input once, performing <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span> work at each iteration step.</p>
</li>
<li>
<p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span></p>
<p>We don't use any extra space except for a few integers.</p>
</li>
</ul>
*/
class RemoveColoredPiecesIfBothNeighborsAreTheSamColor_Solution {
    // 17 ms
    // 44.1 MB 
    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }
        
        return alice - bob >= 1;
    }
}