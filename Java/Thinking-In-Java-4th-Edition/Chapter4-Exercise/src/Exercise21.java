/**
 * <html>
 *      <head>
 *          <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *      </head>
 *      <body>
 *          <ol>
 *              <li>Exercise 21: Create an enum of the least-valuable six types of paper currency. Loop through the values( ) and print each value and its ordinal( ).
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise21 {
    public static void main(String[] args) {
        System.out.println("Exercise 21 Result: ");
        
        for (PaperCurrencyToVND paperCurrency: PaperCurrencyToVND.values()) {
            System.out.println("Currency of "+ paperCurrency+" to VND : " + paperCurrency.getValue());
        }

        System.out.println("----------------------------------------------------");
    }
}
