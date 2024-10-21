package Easy.Number;

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
    // Time Limit Exceed
    public int firstBadVersion1(int n) {
        int start = 0;
        while (!isBadVersion(start)) {
            start++;
        }

        return start;
    }

    // 50 ms 40.3 MB
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isBadVersion(mid)==true && isBadVersion(mid-1)==false) {return mid;}
            else if(isBadVersion(mid)==false) {low = mid+1;}
            else {high = mid;}
        }     

        return -1;
    }

    private boolean isBadVersion(int n){
        
        // Code Block:

        return true;
    }
}
