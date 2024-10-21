package BetterCodeAnswer.Hard.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-atoms/">726. Number of Atoms</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>formula</code> representing a chemical formula, return <em>the count of each atom</em>.</p>
 * 
 * <p>The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.</p>
 * 
 * <p>One or more digits representing that element's count may follow if the count is greater than <code>1</code>. If the count is <code>1</code>, no digits will follow.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"H2O"</code> and <code>"H2O2"</code> are possible, but <code>"H1O2"</code> is impossible.</li>
 * </ul>
 * 
 * <p>Two formulas are concatenated together to produce another formula.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"H2O2He3Mg4"</code> is also a formula.</li>
 * </ul>
 * 
 * <p>A formula placed in parentheses, and a count (optionally added) is also a formula.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"(H2O2)"</code> and <code>"(H2O2)3"</code> are formulas.</li>
 * </ul>
 * 
 * <p>Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than <code>1</code>), followed by the second name (in sorted order), followed by its count (if that count is more than <code>1</code>), and so on.</p>
 * 
 * <p>The test cases are generated so that all the values in the output fit in a <strong>32-bit</strong> integer.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> formula = "H2O"
 * <strong>Output:</strong> "H2O"
 * <strong>Explanation:</strong> The count of elements are {'H': 2, 'O': 1}.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> formula = "Mg(OH)2"
 * <strong>Output:</strong> "H2MgO2"
 * <strong>Explanation:</strong> The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> formula = "K4(ON(SO3)2)2"
 * <strong>Output:</strong> "K4N2O14S4"
 * <strong>Explanation:</strong> The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= formula.length &lt;= 1000</code></li>
 * 	<li><code>formula</code> consists of English letters, digits, <code>'('</code>, and <code>')'</code>.</li>
 * 	<li><code>formula</code> is always valid.</li>
 * </ul>
 * </div>
 */
public class NumberOfAtoms {
    public static void main(String[] args) {
        String[] tests  = {
            "Be32",
            "K4(ON(SO3)2)2Ga4",
            "H2O",
            "Mg(OH)2"
        };

        for (String formula : tests) {
            System.out.println(new NumberOfAtoms_Solution().countOfAtoms(formula));
        }
    }
}

// 2 ms 41.7 MB
class NumberOfAtoms_Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        int[] stack = new int[1000];
        int top = 0, multiplier = 1, freq = 0;
        char[] c = formula.toCharArray();
        for(int i = c.length - 1; i >= 0; i--) {
            if(c[i] >= 'a' && c[i] <= 'z') {
                int end = i--;
                while(i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--;
                String key = new String(c, i, end - i + 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if(c[i] >= 'A' && c[i] <= 'Z') {
                String key = new String(c, i, 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if(c[i] >= '0' && c[i] <= '9') {
                freq = c[i] - '0';
                int p = 10;
                while(i-1 >= 0 && c[i-1] >= '0' && c[i-1] <= '9') {
                    freq += p * (c[--i] - '0');
                    p *= 10;
                }
            } else if(c[i] == ')') {
                stack[top++] = multiplier;
                multiplier *= Math.max(freq, 1);
                freq = 0;
            } else {
                multiplier = stack[--top];
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for(String key: keys) {
            sb.append(key);
            int f = map.get(key);
            if(f > 1) sb.append(f);
        }
        return sb.toString();
    }
}

// 3ms 41.6MB
class NumberOfAtoms_Solution2 {
    public static int where;
    
    public static String countOfAtoms(String str){
        where = 0;
        StringBuilder ans = new StringBuilder();
        TreeMap<String, Integer> map = f(str.toCharArray(), 0);
        for (String key : map.keySet()){
            ans.append(key);
            if (map.get(key) > 1){
                ans.append(map.get(key));
            }
        }
        return ans.toString();
    }

    public static void fill(TreeMap<String, Integer> ans, StringBuilder name, TreeMap<String, Integer> pre, int cnt){
        if (name.length() != 0 || pre != null){
            cnt = cnt == 0 ? 1 : cnt;
            if (name.length() > 0){
                String key = name.toString();
                ans.put(key, ans.getOrDefault(key, 0) + cnt);  // 修正此处，不再循环 cnt 次
            } else {
                for (String key: pre.keySet()){
                    ans.put(key, ans.getOrDefault(key, 0) + cnt * pre.get(key));
                }
            }
        }
    }

    public static TreeMap<String, Integer> f(char[] s, int i){
        int cur = 0;
        TreeMap<String, Integer> ans = new TreeMap<>();
        StringBuilder name = new StringBuilder();
        TreeMap<String, Integer> pre = null;

        while (i < s.length && s[i] != ')'){
            if (s[i] == '(' || (s[i] >= 'A' && s[i] <= 'Z')){
                fill(ans, name, pre, cur);
                cur = 0;
                pre = null;
                name.setLength(0);

                if (s[i] == '('){
                    pre = f(s, i + 1);
                    i = where + 1;
                } else {
                    name.append(s[i++]);
                }

            } else if (s[i] - '0' >= 0 && s[i] - '0' <= 9){
                cur = cur * 10 + s[i++] - '0';
            } else {
                name.append(s[i++]);
            }
        }
        where = i;
        fill(ans, name, pre, cur);
        return ans;
    }
}

// 4ms 42MB
class NumberOfAtoms_Solution3 {
    public String countOfAtoms(String formula) {
        List<Pair> list = new ArrayList<>();
        int i = 0;
        while (i < formula.length()) {
            char ch = formula.charAt(i);
            if (Character.isUpperCase(ch)) {
                StringBuilder elementToAdd = new StringBuilder();
                int count = 0;
                elementToAdd.append(ch + ""); i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    elementToAdd.append(formula.charAt(i));
                    i++;
                }
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + formula.charAt(i) - '0';
                    i++;
                }
                count = count == 0 ? 1 : count;
                list.add(new Pair(elementToAdd.toString(), count));
            } else if (ch == '(') {
                list.add(new Pair("(", 0));
                i++;
            } else if (ch == ')') {
                i++; int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + formula.charAt(i) - '0';
                    i++;
                }
                count = count == 0 ? 1 : count;
                int j = list.size()-1;
                while (j >= 0 && list.get(j).element != "(") {
                    list.get(j).count *= count;
                    j--;
                }
                list.remove(j);
            }
        }
        Map<String, Integer> countMap = new TreeMap<>();
        for (Pair pair : list) {
            if (pair.element == "(") continue;
            countMap.put(pair.element, countMap.getOrDefault(pair.element, 0) + pair.count);
        }
        StringBuilder res = new StringBuilder();
        for (String element : countMap.keySet()) {
            String count = countMap.get(element) == 1 ?  "" : String.valueOf(countMap.get(element));
            res.append(element);
            res.append(count);
        }
        return res.toString();
    }
}

class Pair {
    String element;
    int count;

    public Pair(String element, int count) {
        this.element = element;
        this.count = count;
    }

    public String toString() {
        return element + ":" + count;
    }
}