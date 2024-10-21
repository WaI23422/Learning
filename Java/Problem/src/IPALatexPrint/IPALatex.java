package IPALatexPrint;

public class IPALatex { 
    /**
     * For first 100 Ordinal Numbers
     */
    public void printOrdinalNumbers(int from, int to) {
        if (from > 0) {
            for (int i = from; i < to + 1; i+=2) {
                LatexOrdinalNumbers.at(i);
            }
        } else {
            System.out.println("Ordinal Numbers can't start from below 1");
        }
    }
}

class LatexOrdinalNumbers {
    public static void at(int i) {
        System.out.println("\\\\ \\hline");
        System.out.printf("%s & %s & /\\textipa{%s}/ & %s & %s & /\\textipa{%s}/\n",
                          ordinalNumbersSign(i),
                          ordinalNumbers(i),
                          latexReference(i),
                          ordinalNumbersSign(i+1),
                          ordinalNumbers(i+1),
                          latexReference(i+1));
    }    
    private static String ordinalNumbersSign(int i) {
        if (i > 9 && i < 20) {
            return i+"th";
        } else{
            switch (i%10) {
                case 1:
                    return i+"st";
                case 2:
                    return i+"nd";
                case 3:
                    return i+"rd";
                default:
                    return i+"th";
            }
        }

    }

    private static String ordinalNumbers(int i){
        if (i > 9) {
            if (i % 10 == 0) {
                switch (i/10) {
                    case 1:
                        return "Tenth";
                    case 2:
                        return "Twentieth";
                    case 3:
                        return "Thirtieth";
                    case 4:
                        return "Fortieth";
                    case 5:
                        return "Fiftieth";
                    case 6:
                        return "Sixtieth";
                    case 7:
                        return "Seventieth";
                    case 8:
                        return "Eightieth";
                    case 9:
                        return "Ninetieth";
                    default:
                        return "Hundredth";
                }
            } else {
                if (i/10 == 1 ) {
                    switch (i%10) {
                        case 1:
                            return "Eleventh";
                        case 2:
                            return "Twelfth";
                        case 3:
                            return "Thirteenth";
                        case 4:
                            return "Fourteenth";
                        case 5:
                            return "Fifteenth";
                        case 6:
                            return "Sixteenth";
                        case 7:
                            return "Seventeenth";
                        case 8:
                            return "Eighteenth";
                        default:
                            return "Nineteenth";
                    }
                } else {
                    switch (i/10) {
                        case 2:
                            return "Twenty-"+ordinalNumbers(i%10);
                        case 3:
                            return "Thirty-"+ordinalNumbers(i%10);
                        case 4:
                            return "Forty-"+ordinalNumbers(i%10);
                        case 5:
                            return "Fifty-"+ordinalNumbers(i%10);
                        case 6:
                            return "Sixty-"+ordinalNumbers(i%10);
                        case 7:
                            return "Seventy-"+ordinalNumbers(i%10);
                        case 8:
                            return "Eighty-"+ordinalNumbers(i%10);
                        default:
                            return "Ninety-"+ordinalNumbers(i%10);
                    }
                }
            }
        } else {
            switch (i) {
                case 1:
                    return "First";
            
                case 2:
                    return "Second";
                    
                case 3:
                    return "Third";
                    
                case 4:
                    return "Fourth";
                    
                case 5:
                    return "Fifth";
                    
                case 6:
                    return "Sixth";
                    
                case 7:
                    return "Seventh";

                case 8:
                    return "Eighth";

                default:
                    return "Ninth";
            }
        }
    }

    private static String latexReference(int i){
        if (i > 9) {
            if (i % 10 == 0) {
                switch (i/10) {
                    case 1:
                        return "tenT";
                    case 2:
                        return "'twenti@T";
                    case 3:
                        return "'T3:ti@T";
                    case 4:
                        return "'fO:rti@T";
                    case 5:
                        return "'fifti@T";
                    case 6:
                        return "'sIksti@T";
                    case 7:
                        return "'sevnti@T";
                    case 8:
                        return "'eIti@T";
                    case 9:
                        return "naInti@T";
                    default:
                        return "'h2ndr@dT";
                }
            } else {
                if (i/10 == 1 ) {
                    switch (i%10) {
                        case 1:
                            return "I'levnT";
                        case 2:
                            return "twelfT";
                        case 3:
                            return ",T3:r'ti:nT";
                        case 4:
                            return ",fO:r'ti:nT";
                        case 5:
                            return ",fif'ti:nT";
                        case 6:
                            return ",siks'ti:nT";
                        case 7:
                            return ",sevn'ti:nT";
                        case 8:
                            return ",eI'tin:T";
                        default:
                            return ",naIn'ti:nT";
                    }
                } else {
                    switch (i/10) {
                        case 2:
                            return "'twenti'-"+latexReference(i%10);
                        case 3:
                            return "'T3:ti-"+latexReference(i%10);
                        case 4:
                            return "'fO:ti-"+latexReference(i%10);
                        case 5:
                            return "'fifti'-"+latexReference(i%10);
                        case 6:
                            return "'siksti'-"+latexReference(i%10);
                        case 7:
                            return "'sevnti'-"+latexReference(i%10);
                        case 8:
                            return "'eIti-"+latexReference(i%10);
                        default:
                            return "'naInti-"+latexReference(i%10);
                    }
                }
            }
        } else {
            switch (i) {
                case 1:
                    return "f3:st";
            
                case 2:
                    return "'sek@nd";
                    
                case 3:
                    return "T3:d";
                    
                case 4:
                    return "fO:T";
                    
                case 5:
                    return "fifT";
                    
                case 6:
                    return "sIksT";
                    
                case 7:
                    return "'sevnT";

                case 8:
                    return "eItT";

                default:
                    return "naInT";
            }
        }
    }
}