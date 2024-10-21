package BetterCodeAnswer.Medium.String;

import java.util.HashMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/html-entity-parser/">1410. HTML Entity Parser</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p><strong>HTML entity parser</strong> is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.</p>
 * 
 * <p>The special characters and their entities for HTML are:</p>
 * 
 * <ul>
 * 	<li><strong>Quotation Mark:</strong> the entity is <code>&amp;quot;</code> and symbol character is <code>"</code>.</li>
 * 	<li><strong>Single Quote Mark:</strong> the entity is <code>&amp;apos;</code> and symbol character is <code>'</code>.</li>
 * 	<li><strong>Ampersand:</strong> the entity is <code>&amp;amp;</code> and symbol character is <code>&amp;</code>.</li>
 * 	<li><strong>Greater Than Sign:</strong> the entity is <code>&amp;gt;</code> and symbol character is <code>&gt;</code>.</li>
 * 	<li><strong>Less Than Sign:</strong> the entity is <code>&amp;lt;</code> and symbol character is <code>&lt;</code>.</li>
 * 	<li><strong>Slash:</strong> the entity is <code>&amp;frasl;</code> and symbol character is <code>/</code>.</li>
 * </ul>
 * 
 * <p>Given the input <code>text</code> string to the HTML parser, you have to implement the entity parser.</p>
 * 
 * <p>Return <em>the text after replacing the entities by the special characters</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> text = "&amp;amp; is an HTML entity but &amp;ambassador; is not."
 * <strong>Output:</strong> "&amp; is an HTML entity but &amp;ambassador; is not."
 * <strong>Explanation:</strong> The parser will replace the &amp;amp; entity by &amp;
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> text = "and I quote: &amp;quot;...&amp;quot;"
 * <strong>Output:</strong> "and I quote: \"...\""
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= text.length &lt;= 10<sup>5</sup></code></li>
 * 	<li>The string may contain any possible characters out of all the 256 ASCII characters.</li>
 * </ul>
 * </div>
 */
public class HTMLEntityParser {
    public static void main(String[] args) {
        String[] tests = {
            "&amp; is an HTML entity but &ambassador; is not.",
            "and I quote: &quot;...&quot;"
        };

        for (String text : tests) {
            System.out.println(new HTMLEntityParser_Solution().entityParser(text));
        }
    }
}

// 15ms 45.18MB
class HTMLEntityParser_Solution {
    char[] chars;
    int n;
    public String entityParser(String text) {
        chars = text.toCharArray();
        n = chars.length;
        
        var sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (chars[i] == '&') {
                char sym = match(i+1);
                if (sym != '#') {
                    sb.append(sym);
                    i+=skipMap.get(sym);
                    continue;
                }
            }

            sb.append(chars[i]);
            i++;
        }

        return sb.toString();
    }

    static HashMap<Character, byte[]> map = new HashMap<>();
    static HashMap<Character, Character> symMap = new HashMap<>();
    static HashMap<Character, Integer> skipMap = new HashMap<>();
    static byte[] a1 = new byte[]{'m', 'p', ';'};
    static byte[] a2 = new byte[]{'p', 'o', 's', ';'};
    static {
        map.put('q', new byte[]{'u', 'o', 't', ';'});
        map.put('g', new byte[]{'t', ';'});
        map.put('l', new byte[]{'t', ';'});
        map.put('f', new byte[]{'r', 'a', 's', 'l', ';'});

        symMap.put('q', '"');
        symMap.put('g', '>');
        symMap.put('l', '<');
        symMap.put('f', '/');

        skipMap.put('"', 6);
        skipMap.put('&', 5);
        skipMap.put('\'', 6);
        skipMap.put('>', 4);
        skipMap.put('<', 4);
        skipMap.put('/', 7);
    }

    char match(int pos) {
        if (pos >= n) return '#';

        char c = chars[pos];

        if (c == 'a') {
            if (match(pos+1, a1)) {
                return '&';
            }
            if (match(pos+1, a2)) {
                return '\'';
            }
            return '#';
        }

        byte[] pattern = map.get(c);
        if (pattern != null && match(pos+1, pattern)) {
            return symMap.get(c);
        }

        return '#';
    }

    boolean match(int pos, byte[] pattern) {
        int m = 0;
        while (pos < n && m < pattern.length) {
            if (chars[pos] != pattern[m]) return false;
            m++;
            pos++;
        }
        return true;
    }
}