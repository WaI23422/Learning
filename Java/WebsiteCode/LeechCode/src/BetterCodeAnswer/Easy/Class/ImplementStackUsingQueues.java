package BetterCodeAnswer.Easy.Class;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/implement-stack-using-queues/">225.Implement Stack using Queues</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (<code>push</code>, <code>top</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyStack</code> class:</p>

<ul>
	<li><code>void push(int x)</code> Pushes element x to the top of the stack.</li>
	<li><code>int pop()</code> Removes the element on the top of the stack and returns it.</li>
	<li><code>int top()</code> Returns the element on the top of the stack.</li>
	<li><code>boolean empty()</code> Returns <code>true</code> if the stack is empty, <code>false</code> otherwise.</li>
</ul>

<p><b>Notes:</b></p>

<ul>
	<li>You must use <strong>only</strong> standard operations of a queue, which means that only <code>push to back</code>, <code>peek/pop from front</code>, <code>size</code> and <code>is empty</code> operations are valid.</li>
	<li>Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 2, 2, false]

<strong>Explanation</strong>
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x &lt;= 9</code></li>
	<li>At most <code>100</code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>empty</code>.</li>
	<li>All the calls to <code>pop</code> and <code>top</code> are valid.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you implement the stack using only one queue?</p>
</div>
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        Object[][][][] tests = {
            {
                {{"MyStack"},{"push"},{"push"},{"push"},{"top"},{"pop"},{"pop"},{"pop"},{"empty"}},
                {{},{1},{2},{3},{},{},{},{},{}}
            },
            {
                {{"MyStack"},{"push"},{"push"},{"top"},{"pop"},{"pop"},{"empty"}},
                {{},{1},{2},{},{},{},{}}
            },
            {
                {{"MyStack"},{"push"},{"pop"},{"empty"}},
                {{},{1},{},{}}
            },
            {
                {{"MyStack"},{"push"},{"push"},{"top"},{"pop"},{"empty"}},
                {{},{1},{2},{},{},{}}
            },
        };
        
        for (Object[][][] test : tests) {
            MyStack myStack = new MyStack();
            StringBuffer answer = new StringBuffer();
            Object[][] actions = test[0],
                       value = test[1];
            
            for (int i = 0; i < actions.length; i++) {
                String action = (String) actions[i][0];
                switch (action) {
                    case "push":
                        answer.append("null");
                        myStack.push((int) value[i][0]);
                        break;
    
                    case "top":
                        answer.append(String.valueOf(myStack.top()));
                        break;
                        
                    case "pop":
                        answer.append(String.valueOf(myStack.pop()));
                        break;
    
                    case "empty":
                        answer.append(String.valueOf(myStack.empty()));
                        break;
                    default:
                        answer.append("null");
                        break;
                }

                if (i != actions.length-1) {answer.append(",");}
            }

            System.out.println("["+ answer +"]");
        }
    }
}

//  0ms 40.8 MB
class MyStack {
    // 1,2,3,4,5
    Queue<Integer> queue = new LinkedList<>();
    int top = -1;
    // <-- 1, 2, 3, 4 <-- 
    // 
    public MyStack() {}
    
    public void push(int x) {
        top = x; // top要单独记录一下
        queue.offer(x);
    }
    
    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int number = queue.poll();
            queue.offer(number);
            // update top
            if (i == size - 2) {
                top = number;
            }
        }

        return queue.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}