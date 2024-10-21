package Medium.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-amount-of-time-to-collect-garbage/">2391.Minimum Amount of Time to Collect Garbage</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> array of strings <code>garbage</code> where <code>garbage[i]</code> represents the assortment of garbage at the <code>i<sup>th</sup></code> house. <code>garbage[i]</code> consists only of the characters <code>'M'</code>, <code>'P'</code> and <code>'G'</code> representing one unit of metal, paper and glass garbage respectively. Picking up <strong>one</strong> unit of any type of garbage takes <code>1</code> minute.</p>

<p>You are also given a <strong>0-indexed</strong> integer array <code>travel</code> where <code>travel[i]</code> is the number of minutes needed to go from house <code>i</code> to house <code>i + 1</code>.</p>

<p>There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house <code>0</code> and must visit each house <strong>in order</strong>; however, they do <strong>not</strong> need to visit every house.</p>

<p>Only <strong>one</strong> garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks <strong>cannot</strong> do anything.</p>

<p>Return<em> the <strong>minimum</strong> number of minutes needed to pick up all the garbage.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> garbage = ["G","P","GP","GG"], travel = [2,4,3]
<strong>Output:</strong> 21
<strong>Explanation:</strong>
The paper garbage truck:
1. Travels from house 0 to house 1
2. Collects the paper garbage at house 1
3. Travels from house 1 to house 2
4. Collects the paper garbage at house 2
Altogether, it takes 8 minutes to pick up all the paper garbage.
The glass garbage truck:
1. Collects the glass garbage at house 0
2. Travels from house 0 to house 1
3. Travels from house 1 to house 2
4. Collects the glass garbage at house 2
5. Travels from house 2 to house 3
6. Collects the glass garbage at house 3
Altogether, it takes 13 minutes to pick up all the glass garbage.
Since there is no metal garbage, we do not need to consider the metal garbage truck.
Therefore, it takes a total of 8 + 13 = 21 minutes to collect all the garbage.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> garbage = ["MMM","PGM","GP"], travel = [3,10]
<strong>Output:</strong> 37
<strong>Explanation:</strong>
The metal garbage truck takes 7 minutes to pick up all the metal garbage.
The paper garbage truck takes 15 minutes to pick up all the paper garbage.
The glass garbage truck takes 15 minutes to pick up all the glass garbage.
It takes a total of 7 + 15 + 15 = 37 minutes to collect all the garbage.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= garbage.length &lt;= 10<sup>5</sup></code></li>
	<li><code>garbage[i]</code> consists of only the letters <code>'M'</code>, <code>'P'</code>, and <code>'G'</code>.</li>
	<li><code>1 &lt;= garbage[i].length &lt;= 10</code></li>
	<li><code>travel.length == garbage.length - 1</code></li>
	<li><code>1 &lt;= travel[i] &lt;= 100</code></li>
</ul>
</div></div>
 * 
 */
public class MinimumAmountOfTimeToCollectGarbage {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{"G","P","GP","GG"},{2,4,3}},
            {{"MMM","PGM","GP"},{3,10}}
        };

        for (Object[][] objects : tests) {
            String[] garbage = Arrays.stream(objects[0]).map(Object::toString).toArray(String[]::new);
            int[] travel = Arrays.stream(objects[1]).filter(Number.class::isInstance).map(Number.class::cast).mapToInt(Number::intValue).toArray();
        
            System.out.println(new MinimumAmountOfTimeToCollectGarbage_Solution().garbageCollection(garbage, travel));
        }
    }    
}

// @see BetterCodeAnswer.Medium.Array
class MinimumAmountOfTimeToCollectGarbage_Solution {
    // 65 ms 58.8 MB
    public int garbageCollection(String[] garbage, int[] travel) {
        int pEnd = -1;
        int gEnd = -1;
        int mEnd = -1;

        for (int i=garbage.length - 1; i>=0; i--) {
            String temp = garbage[i];
            for (char c : temp.toCharArray()) {
                if (c == 'G') {
                    gEnd = Math.max(gEnd, i);
                } else if (c == 'P') {
                    pEnd = Math.max(pEnd, i);
                } else {
                    mEnd = Math.max(mEnd, i);
                }
            }
        }

        int total = 0;
        for (int i=0; i<garbage.length; i++) {
            String temp = garbage[i];
            if (i <= pEnd) {
                for (char c : temp.toCharArray()) {
                    if (c == 'P') {
                        total++;
                    }
                }
            }

            if (i <= gEnd) {
                for (char c : temp.toCharArray()) {
                    if (c == 'G') {
                        total++;
                    }
                }
            }

            if (i <= mEnd) {
                for (char c : temp.toCharArray()) {
                    if (c == 'M') {
                        total++;
                    }
                }
            }

            if (i < pEnd) {
                total += travel[i];
            }

            if (i < gEnd) {
                total += travel[i];
            }

            if (i < mEnd) {
                total += travel[i];
            }
        }

        return total;
    }
}