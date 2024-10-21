package Medium.String;

import java.util.Map;
import java.util.Objects;

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

// 20ms 45.18MB
class HTMLEntityParser_Solution1 {
    public String entityParser(String text) {
        text = text.replace("&quot;", "\"");
        text = text.replace("&apos;", "\'");
        text = text.replace("&gt;", ">");
        text = text.replace("&lt;", "<");
        text = text.replace("&frasl;", "/");
        text = text.replace("&amp;", "&");
        
        return text;
    }
}

// 18ms 42.12MB
class HTMLEntityParser_Solution {
    
    private static final Map<String, String> SPECIAL =
            Map.of(
                    "&quot;", "\"",
                    "&apos;", "'",
                    "&amp;", "&",
                    "&gt;", ">",
                    "&lt;", "<",
                    "&frasl;", "/");

    private static final int MAX_SPECIAL_CHAR_LENGTH =
            SPECIAL.keySet().stream().mapToInt(String::length).max().getAsInt();

    private static final char SPECIAL_CHAR_START = '&';
    private static final char SPECIAL_CHAR_END = ';';

    /** Time: O(N) Space: O(N) */
    public String entityParser(String text) {

        Objects.requireNonNull(text);

        char[] arr = text.toCharArray();

        StringBuilder res = new StringBuilder(arr.length);

        int idx = 0;

        MAIN:
        while (idx < arr.length) {
            char ch = arr[idx];

            if (ch == SPECIAL_CHAR_START) {
                for (int cnt = 0, to = idx + 1;
                        cnt < MAX_SPECIAL_CHAR_LENGTH - 1 && to < arr.length;
                        ++cnt, ++to) {
                    if (arr[to] == SPECIAL_CHAR_END) {
                        String possibleSpecialSymbolKey = new String(arr, idx, (to - idx + 1));

                        String replacementSymbol = SPECIAL.get(possibleSpecialSymbolKey);

                        if (replacementSymbol == null) {
                            break;
                        } else {
                            res.append(replacementSymbol);
                            idx = to + 1;
                            continue MAIN;
                        }
                    }
                }
                res.append(ch);
            } else {
                res.append(ch);
            }

            ++idx;
        }

        return res.toString();
    }
}