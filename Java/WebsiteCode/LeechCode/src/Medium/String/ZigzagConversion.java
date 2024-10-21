package Medium.String;

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

// 14ms 45.90 MB -> 3ms 44.78MB
class ZigzagConversion_Solution {
    public String convert(String s, int numRows) {
        // String zigzagString = "";
        StringBuilder zigzagString = new StringBuilder();

        int stringLen = s.length(),
            digLen = numRows-2 > 0? numRows-2:0;
        for (int i = 0; i < numRows; i++) {
            // METHOD 1:
            // P |AYP| A |LIS| H |IRI| N |G|
            // PAHN : A |Y| P L|I|S I|R|I G
            // PAHN + APLSIIG + YIR
            
            // METHOD 2:
            // P |   | A |   | H |   | N
            // A / P / L / S / I / I / G
            // Y |   | I |   | R | 
            // Each character in odd column is x space away from the next at the same row: where x = number of Rows needed + length of diaginal 
            for (int j = i; j < stringLen; j+=numRows+digLen) {
                zigzagString.append(s.charAt(j));
                // Each character in even column is x space away:
                // pos -> lastRow: totalRows - idxRow
                // lastRow -> diagonalEnd : digLen - idxRow
                // posAtDiagonal = pos + totalRows + digLen - idxRow*2
                int change = j+numRows+digLen-2*i;
                if (i != 0 && i != numRows-1 && change < stringLen) {
                    zigzagString.append(s.charAt(change));
                }
            }
        }
        
        return zigzagString.toString();
    }
}