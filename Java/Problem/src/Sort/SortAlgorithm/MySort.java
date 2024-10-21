package Sort.SortAlgorithm;
import java.util.Arrays;

import Generated.Number.RandomIntArray;

/**
 * <table>
<tbody>
<tr>
<td>Name</td>
<td>Best Case &nbsp;</td>
<td>Average Case &nbsp;</td>
<td>Worst Case&nbsp;</td>
<td>Memory</td>
<td>Stable &nbsp;&nbsp;</td>
<td>Method Used</td>
</tr>
<tr>
<td><a href="http://www.geeksforgeeks.org/quick-sort/">Quick Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-ccc84d013faba839d19d0ec320d06442_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="log n" title="Rendered by QuickLaTeX.com" height="23" width="49" style="vertical-align: -5px;"></td>
<td>No</td>
<td>Partitioning</td>
</tr>
<tr>
<td><a href="http://www.geeksforgeeks.org/merge-sort/">Merge Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td>n</td>
<td>Yes</td>
<td>Merging</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/heap-sort/">Heap Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td>1</td>
<td>No</td>
<td>Selection</td>
</tr>
<tr>
<td><a href="http://www.geeksforgeeks.org/insertion-sort/">Insertion Sort</a></td>
<td>n</td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>Yes</td>
<td>Insertion</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/timsort/">Tim Sort</a></td>
<td>n</td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td>n</td>
<td>Yes</td>
<td>Insertion &amp; Merging</td>
</tr>
<tr>
<td><a href="http://www.geeksforgeeks.org/selection-sort/">Selection Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>No</td>
<td>Selection</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/shellsort/">Shell Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-8527b67c75dc6781dfc95028e577c2d5_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{4/3}" title="Rendered by QuickLaTeX.com" height="25" width="46" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-4496d830de34b88c4fe45e063b54ba8e_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{3/2}" title="Rendered by QuickLaTeX.com" height="25" width="46" style="vertical-align: 0px;"></td>
<td>1</td>
<td>No</td>
<td>Insertion</td>
</tr>
<tr>
<td><a href="http://www.geeksforgeeks.org/bubble-sort/">Bubble Sort</a></td>
<td>n</td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>Yes</td>
<td>Exchanging</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/tree-sort/">Tree Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td>n</td>
<td>Yes</td>
<td>Insertion</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/cycle-sort/">Cycle Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>No</td>
<td>Selection</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/strand-sort/">Strand Sort</a></td>
<td>n</td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>n</td>
<td>Yes</td>
<td>Selection</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/cocktail-sort/">Cocktail Shaker Sort</a></td>
<td>n</td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>Yes</td>
<td>Exchanging</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/comb-sort/">Comb Sort</a></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-57b736efe48d4e5e56fd32ce52bb2dfd_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n log n" title="Rendered by QuickLaTeX.com" height="24" width="66" style="vertical-align: -5px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>No</td>
<td>Exchanging</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/">Gnome Sort</a></td>
<td>n</td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>Yes</td>
<td>Exchanging</td>
</tr>
<tr>
<td><a href="https://www.geeksforgeeks.org/odd-even-sort-brick-sort/">Odd–even Sort</a></td>
<td>n</td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td><img src="https://www.geeksforgeeks.org/wp-content/ql-cache/quicklatex.com-7e4de21ca06ca511c64968b029fd13a9_l3.svg" class="ql-img-inline-formula quicklatex-auto-format" alt="n^{2}" title="Rendered by QuickLaTeX.com" height="24" width="26" style="vertical-align: 0px;"></td>
<td>1</td>
<td>Yes</td>
<td>Exchanging</td>
</tr>
</tbody>
</table>
 */
public class MySort {
    // Test run
    public static void main(String[] args) {

        int[][] test = {
            {}, // Empty List
            {0}, // Single List
            {0,0,0}, // Identical List
            {9,8,7,6,5,4,3,2,1}, // Reverse List
            {1,3,2,4,5,6,7}, // Chaos List
            RandomIntArray.Range(0, 2000, 2000) // Large List @see Generated\NumberRange\RandomIntArray.java
        };  

        for (int[] arr : test) {
            System.out.println(Arrays.toString(ascending(arr)));
        }
    }

    // Time complexity: O(n!)
    public static int[] ascending(int[] arr) {
        while (true) {
            int track = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1] > arr[i]) {
                    // Swap two numbers:
                    arr[i-1] = arr[i-1] + arr[i];
                    arr[i] = arr[i-1] - arr[i];
                    arr[i-1] = arr[i-1] - arr[i];
                    // Keep track of swapping:
                    track++;
                }
            }

            if (track == 0) {
                break;
            }
        }

        return arr;
    }

    public static int[] decreasing(int[] arr) {

        while (true) {
            int track = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1] < arr[i]) {
                    // Swap two numbers:
                    arr[i-1] = arr[i-1] + arr[i];
                    arr[i] = arr[i-1] - arr[i];
                    arr[i-1] = arr[i-1] - arr[i];
                    // Keep track of swapping:
                    track++;
                }
            }

            if (track == 0) {
                break;
            }
        }

        return arr;
    }
}

