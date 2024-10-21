package BetterCodeAnswer.Medium.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/flatten-nested-list-iterator/">341.Flatten Nested List Iterator</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a nested list of integers <code>nestedList</code>. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.</p>

<p>Implement the <code>NestedIterator</code> class:</p>

<ul>
	<li><code>NestedIterator(List&lt;NestedInteger&gt; nestedList)</code> Initializes the iterator with the nested list <code>nestedList</code>.</li>
	<li><code>int next()</code> Returns the next integer in the nested list.</li>
	<li><code>boolean hasNext()</code> Returns <code>true</code> if there are still some integers in the nested list and <code>false</code> otherwise.</li>
</ul>

<p>Your code will be tested with the following pseudocode:</p>

<pre>initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
</pre>

<p>If <code>res</code> matches the expected flattened list, then your code will be judged as correct.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nestedList = [[1,1],2,[1,1]]
<strong>Output:</strong> [1,1,2,1,1]
<strong>Explanation:</strong> By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nestedList = [1,[4,[6]]]
<strong>Output:</strong> [1,4,6]
<strong>Explanation:</strong> By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nestedList.length &lt;= 500</code></li>
	<li>The values of the integers in the nested list is in the range <code>[-10<sup>6</sup>, 10<sup>6</sup>]</code>.</li>
</ul>
</div></div>
 */
public class FlattenNestedListIterator {
    public static void main(String[] args) {
        // @see 
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// public class NestedIterator {
	   // 3 ms
	   // 44.5 MB
//     private List<Integer> flattened;
//     private int index;

//     public NestedIterator(List<NestedInteger> nestedList) {
//         flattened = new ArrayList<>();
//         index = 0;
//         flattened = flatten(nestedList);
//     }

//     private List<Integer> flatten(List<NestedInteger> nested) {
//         List<Integer> result = new ArrayList<>();
//         for (NestedInteger ni : nested) {
//             if (ni.isInteger()) {
//                 result.add(ni.getInteger());
//             } else {
//                 result.addAll(flatten(ni.getList()));
//             }
//         }
//         return result;
//     }

//     public int next() {
//         return flattened.get(index++);
//     }

//     public boolean hasNext() {
//         return index < flattened.size();
//     }
// }


// public class NestedIterator implements Iterator<Integer> {
	   // 2 ms 44.8 MB
//     private Deque<ListIterator<NestedInteger>> itStack;
//     private Integer currInt;

//     public NestedIterator(List<NestedInteger> nestedList) {
//         itStack = new ArrayDeque<>();
//         itStack.push(nestedList.listIterator());
//     }

//     @Override
//     public Integer next() {
//         if (!hasNext()) {
//             return null;
//         }

//         Integer nextVal = currInt;
//         currInt = null;
//         return nextVal;
//     }

//     @Override
//     public boolean hasNext() {
//         getNextInt();
//         return currInt != null;
//     }

//     private void getNextInt() {
//         if (currInt != null) {
//             return;
//         }

//         while (!itStack.isEmpty()) {
//             if (!itStack.peek().hasNext()) {
//                 itStack.pop();
//                 continue;
//             }

//             NestedInteger nextNested = itStack.peek().next();
//             if (nextNested.isInteger()) {
//                 currInt = nextNested.getInteger();
//                 return;
//             }

//             itStack.push(nextNested.getList().listIterator());
//         }
//     }
// }
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
