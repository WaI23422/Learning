package Easy.Class;

import java.util.Arrays;
import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{"MyQueue", "push", "push", "peek", "pop", "empty"},{null,1,2,null,null,null}},
        };

        for (Object[][] test : tests) {
            Object[] res = new Object[test[0].length];
            
            String[] actions = Arrays.copyOf(test[0], test[0].length,String[].class);
            Object[] nums = test[1];
            
            int i = 0; MyQueue q = new MyQueue();
            for (String action : actions) {
                switch (action) {
                    case "push":
                        q.push((int) nums[i]);
                        res[i] = null; 
                        break;

                    case "peek":
                        res[i] = q.peek(); 
                        break;

                    case "pop":
                        res[i] = q.pop(); 
                        break;
                    
                    case "empty":
                        res[i] = q.empty();
                        break;
                
                    default:
                        q = new MyQueue();
                        break;
                }

                i++;
            }

            System.out.println(Arrays.toString(res));
        }
    }
}

// 0 ms 41.1 MB
class MyQueue {
    Stack<Integer> s;

    public MyQueue() { s= new Stack<Integer>();}
    
    public void push(int x) {s.addFirst(x);}
    
    public int pop() {
        return s.pop();
    }
    
    public int peek() {
        return s.peek();
    }
    
    public boolean empty() {
        return s.empty();
    }
}
