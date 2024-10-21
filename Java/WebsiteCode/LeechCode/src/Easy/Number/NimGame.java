package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/nim-game/">292. Nim Game</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are playing the following Nim Game with your friend:</p>

<ul>
	<li>Initially, there is a heap of stones on the table.</li>
	<li>You and your friend will alternate taking turns, and <strong>you go first</strong>.</li>
	<li>On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.</li>
	<li>The one who removes the last stone is the winner.</li>
</ul>

<p>Given <code>n</code>, the number of stones in the heap, return <code>true</code><em> if you can win the game assuming both you and your friend play optimally, otherwise return </em><code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 4
<strong>Output:</strong> false
<strong>Explanation:</strong> These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
In all outcomes, your friend wins.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class NimGame {
    public static void main(String[] args) {
        int[] tests = {
            8,
            6,
            4,
            1,
            2,
            // 2147483647,
        };

        for (int n : tests) {
            System.out.println(new NimGame_Solution().canWinNim(n));
        }
    }
}

// Memory Limit Exceed 
class NimGame_Solution1 {
    public boolean canWinNim(int n) {
        if (n <= 3) {return true;}

        boolean[] firstMoveWin = new boolean[n];

        firstMoveWin[0] = true; 
        firstMoveWin[1] = true;
        firstMoveWin[2] = true;

        for (int i = 3; i < n; i++) {
            firstMoveWin[i] = !firstMoveWin[i-1] || !firstMoveWin[i-2] || !firstMoveWin[i-3];
        }

        return firstMoveWin[n-1];
    }
}


// Time Limit Exceeded
class NimGame_Solution2 {
    public boolean canWinNim(int n) {
        if (n <= 3) {return true;}

        boolean first = true, 
                second = true,
                third = true,
                move = true;
        int change = 0;

        for (int i = 3; i < n; i++) {
            move = !first || !second || !third;
            // if (change%3 == 0) {
            //     first = move;
            // } else if (change%2 == 1) {
            //     second = move;
            // } else {
            //     third = move;
            // }
            // change++;
            if (change== 0) {
                first = move;
            } else if (change == 1) {
                second = move;
            } else {
                third = move;
                change = -1;
            }
            change++;
        }

        return move;
    }
}

// Time Limit Exceeded
class NimGame_Solution3 {
    public boolean canWinNim(int n) {
        if (n <= 3) {return true;}

        int first = 1, 
            second = 1,
            third = 1,
            move = 1;

        for (int i = 3; i < n; i++) {
            move = (first^1)|(second^1)|(third^1);

            first = second;
            second = third;
            third = move;
        }

        // boolean first = true, 
        //         second = true,
        //         third = true,
        //         move = true;

        // for (int i = 3; i < n; i++) {
        //     move = !first || !second || !third;

        //     first = second;
        //     second = third;
        //     third = move;
        // }

        return move == 1 ? true : false;
    }
}

// 0 ms 40.2 MB
class NimGame_Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}