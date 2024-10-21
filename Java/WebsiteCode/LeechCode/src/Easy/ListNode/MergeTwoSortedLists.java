package Easy.ListNode;

import Easy.ListNode.Class.ListNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/merge-two-sorted-lists/">21.Merge Two Sorted Lists</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists into one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;">
<pre><strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>
</div></div>
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,4},{1,3,4}},
            {{},{}},
            {{},{0}},
            {{1,1},{}},
            {{},{1,2}}
        };

        for (int[][] Lists : tests) {
            ListNode list1 , list2;

            if (Lists[0].length != 0 && Lists[1].length != 0) {
                list1 = ListNode.addNode(Lists[0]);
                list2 = ListNode.addNode(Lists[1]);
            } else {
                if (Lists[0].length == 0 && Lists[1].length == 0) {
                    list1 = null;
                    list2 = null;
                } else if (Lists[1].length == 0) {
                    list1 = ListNode.addNode(Lists[0]);
                    list2 = null;
                } else {
                    list1 = null;
                    list2 = ListNode.addNode(Lists[1]);
                }
            }

            if (new MergeTwoSortedLists_Solution().mergeTwoLists(list1, list2) == null) {
                System.out.println(new MergeTwoSortedLists_Solution().mergeTwoLists(list1, list2));
            } else {
                System.out.println(new MergeTwoSortedLists_Solution().mergeTwoLists(list1, list2).toString());
            }

        }
    }
}

class MergeTwoSortedLists_Solution {
    // 0 ms 40.9 MB
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
       if(list1 == null) return list2 ;
       if(list2 == null) return list1 ;

       ListNode ans = new ListNode(1) ;
       ListNode curr = ans ;

       while(list1 != null && list2 != null)
       {
           if(list1.val <= list2.val)
           {
               curr.next = list1 ;
               list1 = list1.next ;
               curr = curr.next ;
           }

           else{
               curr.next = list2 ;
               list2 = list2.next ;
               curr = curr.next ;

           }
       }

       if(list1 == null) curr.next = list2 ;

       if(list2 == null) curr.next = list1 ;

       return ans.next ;
    }
}


class MergeTwoSortedLists_Solution2 {
    // 0 ms 41.4 MB
    public ListNode addNode(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {return null;}
        else if (list1 == null) {return new ListNode(list2.val,addNode(null, list2.next));}
        else if (list2 == null) {return new ListNode(list1.val,addNode(list1.next, null));}

        if (list1.val < list2.val) {
            return new ListNode(list1.val,addNode(list1.next, list2));
        } else {
            return new ListNode(list2.val,addNode(list1, list2.next));
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {return list1;} 
        else if (list2 == null) {return list1;}
        else if (list1 == null) {return list2;}

        return addNode(list1, list2);
    }
}