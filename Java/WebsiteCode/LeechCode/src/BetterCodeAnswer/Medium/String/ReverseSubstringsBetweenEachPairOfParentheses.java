package BetterCodeAnswer.Medium.String;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        String[] tests = {
            "(u(love)i)",
            "ta()usw((((a))))",
            "(ed(et(oc))el)",
            "a(bcdefghijkl(mno)p)q",
            "d",
        };

        for (String s : tests) {
            System.out.println(new ReverseSubstringsBetweenEachPairOfParentheses_Solution().reverseParentheses(s));
        }
    }
}

// 0 ms 41.9 MB
class ReverseSubstringsBetweenEachPairOfParentheses_Solution {
    int i = 0;
    public String reverseParentheses(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public String helper(char[] s){
        StringBuilder sb = new StringBuilder();

        while(i < s.length){
            if(s[i] == ')'){
                i++;
                return sb.reverse().toString();
            }else if(s[i] == '('){
                i++;
                String st  = helper(s);
                sb.append(st);
            }else{
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }
}

// 1 ms 41.4 MB
class ReverseSubstringsBetweenEachPairOfParentheses_Solution2 {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(str);
                str=new StringBuilder();
            }
            else if(ch==')'){
                str.reverse();
                if(!stack.isEmpty()){
                    stack.peek().append(str);
                    str=stack.pop();
                }
            }
            else str.append(ch);
        }
        return str.toString();
    }
}