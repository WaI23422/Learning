package Medium.String;

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

class RemoveColoredPiecesIfBothNeighborsAreTheSamColor_Solution {
    // 15 ms
    // 44.5 MB
    public boolean winnerOfGame(String colors) {
        int stepA = 0;
        int stepB = 0;

        for (int i = 1; i < colors.length()-1; i++) {
            if (colors.charAt(i) == 'A') {
                if (colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A') {
                    stepA++;
                }                
            } else {
                if (colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B') {
                    stepB++;
                }  
            }
        }

        if (stepA > stepB){
            return true;
        } else {
            return false;
        }
    }
}