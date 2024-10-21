package BetterCodeAnswer.Medium.String;

public class ZigzagConversion {
    public static void main(String[] args) {
        Object[][] tests = {
            {
                "A",
                1
            },
            {
                "PAYPALISHIRING",
                3
            }
        };
        
        for (Object[] test : tests) {
            String s = (String) test[0];
            int numRows = (int) test[1];

            System.out.println(new ZigzagConversion_Solution().convert(s, numRows));
        }
    }
}

// 1ms 44.78MB
class ZigzagConversion_Solution {
    public String convert(String s, int numRows) {
      int length = s.length();
        if (numRows == 1 || numRows == length) return s;
        char[] ans = new char[length];
        int count = 0;
        int inc = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) { //fill one row at a time
            int j = i;
            while (j < length) {
                ans[count++] = s.charAt(j);
                if (i == 0 || i == numRows - 1) j += inc; //first and last rows don't have diagonal elements, so do full increments without worrying
                else {
                    j += (inc - (2 * i)); //if there is/are diagonal element(/s) in the row, then use this formula to get the next diagonal element
                    if (j < length) { //if index is in the bounds, then put that element in the answer array, andincrement j for the next diagonal element
                        ans[count++] = s.charAt(j);
                        j += (2 * i);
                    }
                }
            }
        }

        return String.valueOf(ans);   
    }
}

// 2ms 44.78MB
class ZigzagConversion_Solution2 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder r = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int step1 = (numRows * 2) - 2;
            int step2 = i * 2;
            for (int j = i; j < s.length(); j += step1) {
                r.append(s.charAt(j));
                if (step2 > 0 && step2 < step1 && j + step1 - step2 < s.length()) {
                    r.append(s.charAt(j + step1 - step2));
                }
            }
        }
        return r.toString();
    }
}