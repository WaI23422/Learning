package BetterCodeAnswer.Easy.LinkedList;

import BetterCodeAnswer.Easy.LinkedList.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/palindrome-linked-list/">234.Palindrome Linked List</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div><em>palindrome</em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(423px, 183px);"></div></div></div></span><em> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;">
<pre><strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;">
<pre><strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?</div>
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3,4,5},
            {1,2,2,1},
            {1,2},
            {1},
        }; 

        for (int[] test : tests) {
            ListNode head = ListNode.addNode(test, 0);
            System.out.println(new PalindromeLinkedList_Solution().isPalindrome(head));
        }
    }   
}

// 2 ms 65.56 MB
class PalindromeLinkedList_Solution {
    private static final int[] array = new int[100_000];
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
       ListNode h= head;
       final int[] array1 = array;
       int size =0;

       while(h!=null){
           array1[size++] = h.val;
           h=h.next;
       }

       int m = size/2;
       for(int i=0;i<m;i++){
           if(array[i] != array1[--size]){
               return false;
           }
       }
       return true;
    }
}