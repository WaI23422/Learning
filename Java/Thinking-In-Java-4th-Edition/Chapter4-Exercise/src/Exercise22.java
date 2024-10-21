/**
 * <html>
 *      <head>
 *          <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *      </head>
 *      <body>
 *          <ol>
 *              <li>Exercise 22:  Write a switch statement for the enum in the previous example. For each case, output a description of that particular currency. 
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise22 {
    public static void main(String[] args) {
        System.out.println("Exercise 22 Result: ");
        
        for (PaperCurrencyToVND paperCurrency: PaperCurrencyToVND.values()) {
            switch (paperCurrency) {
                case Dollar:
                    System.out.println("Dollar is 24.380 VND");
                    break;
                case Won:
                    System.out.println("Won is 18.23 VND");
                    break;
                case Krone:
                    System.out.println("Krone is 2195.63 VND");
                    break;
                case Franc:
                    System.out.println("Franc is 9.85 VND");
                    break;
                case Euro:
                    System.out.println("Euro is 25935.57 VND");
                    break;
                case Pound:
                    System.out.println("Pound is 29839.41 VND");
                    break;
                default:
                    break;
            }
        }

        System.out.println("----------------------------------------------------");
    }
}
