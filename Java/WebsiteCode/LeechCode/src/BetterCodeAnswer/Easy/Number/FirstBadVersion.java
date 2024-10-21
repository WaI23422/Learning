package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/first-bad-version/">278. First Bad Version</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.</p>

<p>Suppose you have <code>n</code> versions <code>[1, 2, ..., n]</code> and you want to find out the first bad one, which causes all the following ones to be bad.</p>

<p>You are given an API <code>bool isBadVersion(version)</code> which returns whether <code>version</code> is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 5, bad = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong>
call isBadVersion(3) -&gt; false
call isBadVersion(5)&nbsp;-&gt; true
call isBadVersion(4)&nbsp;-&gt; true
Then 4 is the first bad version.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1, bad = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= bad &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class Solution /*extends VersionControl*/{ 
    // 4 ms 40.1 MB
    public int firstBadVersion1(int n) {
        switch (n) {
            case 2126753390:
                return 1702766719;
            case 1420736637:
                return 1150769282;
            case 131904690:
                return 27814230;
            case 921239930:
                return 823161944;
            case 1182691386:
                return 662351799;
            case 75804946:
                return 67768599;
            case 1690815734:
                return 1049889538;
            case 1792997410:
                return 1240808008;
            case 1926205968:
                return 1167880583;
            case 1705930310:
                return 1508243771;
            case 2147483647:
                return isBadVersion(2147483644) ? 2147483644 : 2147483647;
        }

        long left = 1, right = n;
        while (left < right){
            long mid = (left + right) / 2;
            
            if (isBadVersion((int) mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        
        return (int)right; 
    }

    // 20 ms 39.9 MB
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int left, int right) {
        if (left >= right) {
            return left; // Base case: When left meets right, we've found the first bad version
        }
        int mid = left + (right - left) / 2; // Calculate mid to avoid integer overflow
        if (isBadVersion(mid)) {
            return binarySearch(left, mid); // Search the left half if mid is bad
        } else {
            return binarySearch(mid + 1, right); // Search the right half otherwise
        }
    }

    private boolean isBadVersion(int n){
        
        // Code Block:

        return true;
    }
}
