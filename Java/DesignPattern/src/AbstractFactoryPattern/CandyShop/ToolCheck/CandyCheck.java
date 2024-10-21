package AbstractFactoryPattern.CandyShop.ToolCheck;

public class CandyCheck {
    public static boolean Check(String[] candyType, String input){
        for (String string : candyType) {
            if (input.equalsIgnoreCase(string)) {
                return true;
            }
        }

        return false;
    }
}
