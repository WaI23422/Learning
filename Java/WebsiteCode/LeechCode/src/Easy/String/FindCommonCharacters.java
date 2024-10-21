package Easy.String;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[][] tests= {
            {"bella","label","roller"}
        };

        for (String[] words : tests) {
            System.out.println(new FindCommonCharacters_Solution().commonChars(words));
        }
    }
}

// 1 ms 42.8 MB
class FindCommonCharacters_Solution {
    int[] arrChar = new int[26];

    public List<String> commonChars(String[] words) {
        for (int i = 0; i < 26; i++) {
            arrChar[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {
            minValWord(word.toCharArray());
        }
        
        return returnAsList();
    }

    private void minValWord(char[] wordChars) {
        int[] alphabet = new int[26];

        for (char c : wordChars) {
            alphabet[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            arrChar[i] = Math.min(arrChar[i], alphabet[i]);
        }
    }

    private List<String> returnAsList() {
        List<String> store = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arrChar[i]; j++) {
                store.add(String.valueOf((char) (97+i)));
            }
        }

        return store;
    }
}