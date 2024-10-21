package AbstractFactoryPattern.CandyShop.Factory;

import java.util.Scanner;

import AbstractFactoryPattern.CandyShop.Candy.Interface.Candy;
import AbstractFactoryPattern.CandyShop.Factory.Generator.FactoryProducer;
import AbstractFactoryPattern.CandyShop.ToolCheck.CandyCheck;

public class CandyShop {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Type of Candy: Gummies, Lolipop, Surprise");
        String[] calTypeArr = {"Gummies", "Lolipop", "Surprise"}; 
        String calType = myScanner.nextLine();  

        if (!CandyCheck.Check(calTypeArr, calType)) {
            System.out.println("That candy is not currently available in stores.");
        } else {
            boolean gummies = (calType.equalsIgnoreCase("Gummies"));
            boolean lolipop = (calType.equalsIgnoreCase("Lolipop"));
            AbstractCandy candyFactory = FactoryProducer.getFactory(gummies,lolipop);

            if (gummies) {
                System.out.println("Type Available: Gummy Bear");
                String[] typeGummiesArr = {"Gummy Bear"};
                String typeGummies = myScanner.nextLine();
                
                if (!CandyCheck.Check(typeGummiesArr, typeGummies)) {
                    System.out.println("That candy is not currently available in stores.");
                } else {
                    Candy candyType = candyFactory.getCandy(typeGummies);
                    candyType.Amount();
                    System.out.println("How many do you wanna buy ?: ");
                    int totalBuyGummies = myScanner.nextInt();
                    candyType.Buy(totalBuyGummies);

                    System.out.println("How many do you wanna sell ?: ");
                    int totalSellGummies = myScanner.nextInt();
                    candyType.Sell(totalSellGummies);
                }
            } else if (lolipop) {
                System.out.println("Type Available: Normal Lolipop, Salty Lolipop");
                String[] typeLolipopArr = {"Normal Lolipop", "Salty Lolipop"};
                String typeLolipop = myScanner.nextLine();
                
                if (!CandyCheck.Check(typeLolipopArr, typeLolipop)) {
                    System.out.println("That candy is not currently available in stores.");
                } else {
                    Candy candyType = candyFactory.getCandy(typeLolipop);
                    candyType.Amount();
                    System.out.println("How many do you wanna buy ?: ");
                    int totalBuyLolipopCandy = myScanner.nextInt();
                    candyType.Buy(totalBuyLolipopCandy);

                    System.out.println("How many do you wanna sell ?: ");
                    int totalSellLolipopCandy = myScanner.nextInt();
                    candyType.Sell(totalSellLolipopCandy);
                }
            } else {
                System.out.println("Type Available: Poping Candy");
                String[] typeSurpriseArr = {"Poping Candy"};
                String typeSurprise = myScanner.nextLine();
                
                if (!CandyCheck.Check(typeSurpriseArr, typeSurprise)) {
                    System.out.println("That candy is not currently available in stores.");
                } else {
                    Candy candyType = candyFactory.getCandy(typeSurprise);
                    candyType.Amount();
                    System.out.println("How many do you wanna buy ?: ");
                    int totalBuyPopingCandy = myScanner.nextInt();
                    candyType.Buy(totalBuyPopingCandy);

                    System.out.println("How many do you wanna sell ?: ");
                    int totalSellPopingCandy = myScanner.nextInt();
                    candyType.Sell(totalSellPopingCandy);
                }
            }
        }

        myScanner.close();
    }
}
