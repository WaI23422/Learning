package BetterCodeAnswer.Easy.Class;

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

// 0 ms 40.7 MB
class MyQueue {
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();


    public void push(int x) {
        if (s1.isEmpty()){
            front = x;
        }
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }

        return front;
    }
    
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }
}