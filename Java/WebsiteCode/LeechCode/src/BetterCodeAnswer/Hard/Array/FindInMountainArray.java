package BetterCodeAnswer.Hard.Array;

interface MountainArray {
    /**
     * @return returns the element of the array at index.
     */
    public int get(int index); 
    /**
     * @return returns the length of the array.
     */
    public int length();
}

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-in-mountain-array/">1095.Find in Mountain Array</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p><em>(This problem is an <strong>interactive problem</strong>.)</em></p>

<p>You may recall that an array <code>arr</code> is a <strong>mountain array</strong> if and only if:</p>

<ul>
	<li><code>arr.length &gt;= 3</code></li>
	<li>There exists some <code>i</code> with <code>0 &lt; i &lt; arr.length - 1</code> such that:
	<ul>
		<li><code>arr[0] &lt; arr[1] &lt; ... &lt; arr[i - 1] &lt; arr[i]</code></li>
		<li><code>arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code></li>
	</ul>
	</li>
</ul>

<p>Given a mountain array <code>mountainArr</code>, return the <strong>minimum</strong> <code>index</code> such that <code>mountainArr.get(index) == target</code>. If such an <code>index</code> does not exist, return <code>-1</code>.</p>

<p><strong>You cannot access the mountain array directly.</strong> You may only access the array using a <code>MountainArray</code> interface:</p>

<ul>
	<li><code>MountainArray.get(k)</code> returns the element of the array at index <code>k</code> (0-indexed).</li>
	<li><code>MountainArray.length()</code> returns the length of the array.</li>
</ul>

<p>Submissions making more than <code>100</code> calls to <code>MountainArray.get</code> will be judged <em>Wrong Answer</em>. Also, any solutions that attempt to circumvent the judge will result in disqualification.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> array = [1,2,3,4,5,3,1], target = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> array = [0,1,2,4,2,1], target = 3
<strong>Output:</strong> -1
<strong>Explanation:</strong> 3 does not exist in <code>the array,</code> so we return -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= mountain_arr.length() &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= target &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= mountain_arr.get(index) &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class FindInMountainArray {
    public static void main(String[] args) {
        
    }
}

class FindInMountainArray_Solution {
    // 0 ms
    // 43.2 MB
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Save the length of the mountain array
        int length = mountainArr.length();

        // 1. Find the index of the peak element
        int low = 1;
        int high = length - 2;
        while (low != high) {
            int testIndex = (low + high) >> 1;
            int curr = mountainArr.get(testIndex);
            int next = mountainArr.get(testIndex + 1);
            
            if (curr < next) {
                if (curr == target) {
                    return testIndex;
                }
                if (next == target) {
                    return testIndex + 1;
                }
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        int peakIndex = low;

        // 2. Search in the strictly increasing part of the array
        // If found, will be returned in the loop itself.
        low = 0;
        high = peakIndex;
        while (low <= high) {
            int testIndex = (low + high) >> 1;
            int curr = mountainArr.get(testIndex);
                
            if (curr == target) {
                return testIndex;
            } else if (curr < target) {
                low = testIndex + 1;
            } else {
                high = testIndex - 1;
            }
        }

        // 3. Search in the strictly decreasing part of the array
        // If found, will be returned in the loop itself.
        low = peakIndex + 1;
        high = length - 1;
        while (low <= high) {
            int testIndex = (low + high) >> 1;
            int curr = mountainArr.get(testIndex);
                
            if (curr == target) {
                return testIndex;
            } else if (curr > target) {
                low = testIndex + 1;
            } else {
                high = testIndex - 1;
            }
        }

        // Target is not present in the mountain array
        return -1;
    }
}

class FindInMountainArray_Solution2 {
    // 1 ms
    // 41.1 
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int firstTry= binarySearch(mountainArr, target, 0, Peak(mountainArr));
        if(firstTry != -1){
            return firstTry;
        }
        System.gc();
        return binarySearch(mountainArr, target, Peak(mountainArr)+1, mountainArr.length()-1);
    }
    int Peak(MountainArray mountainArr){
        int start = 0;
        int end = mountainArr.length()-1;
        while(start < end){
            int mid =start+(end-start)/2;
            int middle= mountainArr.get(mid);
            int middleone= mountainArr.get(mid+1);
            if(middle>middleone){
                end = mid;
            }
            else {
                start=mid+1;
            }
        }
        return start;
    }
    int binarySearch(MountainArray mountainArr, int target, int start, int end){
        boolean isAsc= mountainArr.get(start) < mountainArr.get(end);
        while(start <= end){
            int mid = start+(end-start)/2;
            int middle= mountainArr.get(mid);
            if(target==middle){
                    return mid;
                }
            if(isAsc){
                if(target>middle){
                    start=mid+1;
                }
                else{
                    end= mid-1;
                }
            }
            else{
                if(target>middle){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}

