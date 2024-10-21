package Medium.String;

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

// 8 ms 42.2 MB
class ReverseSubstringsBetweenEachPairOfParentheses_Solution {
    int lenStr = 0,
        pos = 0,
        brackets = 0;
    String s;

    public String reverseParentheses(String s) {
        lenStr = s.length();
        this.s = s;

        return mergeStr();
    }

    public String mergeStr() {
        String Str = "";

        for (; pos < lenStr; pos++) {
            char c = s.charAt(pos);
            switch (brackets%2) {
                case 0:
                    switch (c) {
                        case '(':
                            pos++;
                            brackets++;
                            Str += mergeStr();
                            break;
                            
                        case ')':
                            brackets--;
                            return Str;
                    
                        default:
                            Str += c;
                            break;
                    }
                    break;
                    
                default:
                    switch (c) {
                        case '(':
                            pos++;
                            brackets++;
                            Str = mergeStr() + Str;
                            break;
                            
                        case ')':
                            brackets--;
                            return Str;
                    
                        default:
                            Str = c + Str;
                            break;
                    }
                    break;
            }
        }

        return Str;
    }
}