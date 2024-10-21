package BetterCodeAnswer.Easy.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/sort-integers-by-the-number-of-1-bits/">1356.Sort Integers by The Number of 1 Bits</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an integer array <code>arr</code>. Sort the integers in the array&nbsp;in ascending order by the number of <code>1</code>'s&nbsp;in their binary representation and in case of two or more integers have the same number of <code>1</code>'s you have to sort them in ascending order.</p>

<p>Return <em>the array after sorting it</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [0,1,2,3,4,5,6,7,8]
<strong>Output:</strong> [0,1,2,4,8,3,5,6,7]
<strong>Explantion:</strong> [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [1024,512,256,128,64,32,16,8,4,2,1]
<strong>Output:</strong> [1,2,4,8,16,32,64,128,256,512,1024]
<strong>Explantion:</strong> All integers have 1 bit in the binary representation, you should just sort them in ascending order.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 500</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>4</sup></code></li>
</ul>
</div></div>
 */
public class SortIntegersByTheNumberOfOneBits {
    public static void main(String[] args) {
        int[][] tests = {
            {0,1,2,3,4,5,6,7,8},
            {1024,512,256,128,64,32,16,8,4,2,1}
        };

        SortIntegersByTheNumberOfOneBits_Solution res = new SortIntegersByTheNumberOfOneBits_Solution();

        for (int[] arr : tests) {
            System.out.println(res.sortByBits(arr));
        }
    }
}

/**Algorithm:
 *For eg: just take a arra like [0,1,2,3,4,5,6,7,8]
 *step 1: After the first for loop...
 *it will look like [0,10001,10003,20004,10005,20006,20007,30008,10009] (don't forget to add the number also)
 *Step 2:sort the array...
 *It, will look like [0,10001,10003,10005,10009,20004,20006,20007,30008]
 *step 3: divide the same as 10001
 *You, will get the result array...
 * Pls,upvote it helps!
*/
class SortIntegersByTheNumberOfOneBits_Solution {
    // 3 ms 
    // 44.4 MB
    public int[] sortByBits(int[] arr) {
        //ok so for this enginner rule is applied where each number is updated by a the number itself + number of bits in number*(10001) and then we will sort it and then we will take the modulo.
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]+=Integer.bitCount(arr[i])*10001;
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=arr[i]%10001;
        }
        return arr;
    }
}

class SortIntegersByTheNumberOfOneBits_Solution2 {
    // 8 ms 
    // 43.5 MB
    public static int[] sortByBits(final int[] arr) {
        // Create a custom comparator.
        Comparator<Integer> comparator = (a, b) -> {
            Integer aBits = Integer.bitCount(a);
            Integer bBits = Integer.bitCount(b);

            if (aBits < bBits) {
                return -1;
            } else if (aBits > bBits) {
                return 1;
            } else {
                // If the number of 1's is the same, compare the integers themselves.
                return a - b;
            }
        };
        List<Integer> objArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) objArr.add((Integer) arr[i]);
        objArr.sort(comparator);
        for (int i = 0; i < arr.length; i++) arr[i] = (int) objArr.get(i);
        return arr;
    }
}

/**
 * <h4 id="approach-1-sort-by-custom-comparator-built-in">Approach 1: Sort By Custom Comparator: Built-in</h4>
 * <p><strong>Intuition</strong></p>
 * <p>The number of <code>1's</code> in a number's binary representation is also known as the number of <strong>set</strong> bits, or the <a href="https://en.wikipedia.org/wiki/Hamming_weight" target="_blank">hamming weight</a> of the number.</p>
 * <p>In this problem, we need to sort the numbers according to their hamming weight. We can sort arrays by any criteria using a custom comparator, which is a function that we pass into a language's sort function to specify how elements should be sorted.</p>
 * <p>There are a number of ways to find the hamming weight of a number, but the easiest way is by using built-in methods.</p>
 * <blockquote>
<p>Note: we have included this approach for completeness. It is likely that in an interview, you will be expected to use bit manipulation to find the hamming weight, and simply using built-in methods may be considered "cheating".</p>
</blockquote>
<p>Most major programming languages have a built-in method for finding the hamming weight of a number. We simply define a custom comparator using these methods, then sort the input with it, and return the answer. Remember to handle the tiebreak: when two numbers have equal hamming weight, the one with a lower value should come first.</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>Use built-in methods to define a custom comparator that uses the hamming weight of a number.</li>
<li>Sort <code>arr</code> with the custom comparator.</li>
<li>Return <code>arr</code>.</li>
</ol>
 */
class SortIntegersByTheNumberOfOneBits_Solution3 {
    // 11 ms
    // 43.6 MB
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a - b;
        }
        
        return Integer.bitCount(a) - Integer.bitCount(b);
    }
}