package Easy.Arrays;


import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/summary-ranges/">228.Summary Ranges</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>sorted unique</strong> integer array <code>nums</code>.</p>

<p>A <strong>range</strong> <code>[a,b]</code> is the set of all integers from <code>a</code> to <code>b</code> (inclusive).</p>

<p>Return <em>the <strong>smallest sorted</strong> list of ranges that <strong>cover all the numbers in the array exactly</strong></em>. That is, each element of <code>nums</code> is covered by exactly one of the ranges, and there is no integer <code>x</code> such that <code>x</code> is in one of the ranges but not in <code>nums</code>.</p>

<p>Each range <code>[a,b]</code> in the list should be output as:</p>

<ul>
	<li><code>"a-&gt;b"</code> if <code>a != b</code></li>
	<li><code>"a"</code> if <code>a == b</code></li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,2,4,5,7]
<strong>Output:</strong> ["0-&gt;2","4-&gt;5","7"]
<strong>Explanation:</strong> The ranges are:
[0,2] --&gt; "0-&gt;2"
[4,5] --&gt; "4-&gt;5"
[7,7] --&gt; "7"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,2,3,4,6,8,9]
<strong>Output:</strong> ["0","2-&gt;4","6","8-&gt;9"]
<strong>Explanation:</strong> The ranges are:
[0,0] --&gt; "0"
[2,4] --&gt; "2-&gt;4"
[6,6] --&gt; "6"
[8,9] --&gt; "8-&gt;9"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 20</code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li>All the values of <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is sorted in ascending order.</li>
</ul>
</div>
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[][] tests = {
            {0,1,2,4,5,7},
            {0,2,3,4,6,8,9}
        };

        for (int[] nums : tests) {
            System.out.println(new SummaryRanges_Solution().summaryRanges(nums).toString());
        }
    }
}

// 6 ms 41.9 MB
class SummaryRanges_Solution1 {
    final List<String> range = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {return range;}
        
        int numStart = nums[0], numEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (numEnd+1 != nums[i] ) {
                if (numStart == numEnd) {
                    range.add(String.valueOf(numStart));
                } else {
                    range.add(String.valueOf(numStart) + "->" + String.valueOf(numEnd));
                }
                numStart = nums[i];
                numEnd = nums[i];
            } else {
                numEnd = nums[i];
            }
        }

        if (numStart == numEnd) {range.add(String.valueOf(numStart));} 
        else {range.add(String.valueOf(numStart) + "->" + String.valueOf(numEnd));}
        
        return range;
    }
}

// 6 ms 41.5 MB
class SummaryRanges_Solution2 {
    final List<String> ranges = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {return ranges;}
        
        int numStart = nums[0]; 
        String range = String.valueOf(numStart);
        for (int i = 1; i < nums.length; i++) {
            if (numStart+1 != nums[i] ) {
                if (Integer.parseInt(range) != numStart) {
                    range +=  "->" + String.valueOf(numStart);
                }
                ranges.add(range);

                numStart = nums[i];
                range = String.valueOf(numStart);
            } else {
                numStart = nums[i];
            }
        }
        
        if (Integer.parseInt(range) != numStart) {
            range +=  "->" + String.valueOf(numStart);
        }
        ranges.add(range);

        return ranges;
    }
}

// 6 ms 41 MB
class SummaryRanges_Solution3 {
    final List<String> ranges = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {return ranges;}
        
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != 1) {
                addToRanges(nums, index, i);
                index = i;
            }
        }
        addToRanges(nums, index, nums.length);

        return ranges;
    }

    private void addToRanges(int[] nums, int from, int to) {
        if (from+1 == to) {
            ranges.add(String.valueOf(nums[from]));
        } else {
            ranges.add(String.valueOf(nums[from])+"->"+String.valueOf(nums[to-1]));
        }
    }
}

// 0 ms 41.7 MB
class SummaryRanges_Solution {
    final List<String> ranges = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {return ranges;}
        
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != 1) {
                addToRanges(nums, index, i);
                index = i;
            }
        }
        addToRanges(nums, index, nums.length);

        return ranges;
    }

    private void addToRanges(int[] nums, int from, int to) {
        StringBuilder range = new StringBuilder();
        if (from+1 == to) {
            ranges.add(range.append(nums[from]).toString());
        } else {
            range.append(nums[from]);
            range.append("->");
            range.append(nums[to-1]);
            ranges.add(range.toString());
        }
    }
}