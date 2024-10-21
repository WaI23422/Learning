package String;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// Take note: two File in same Folder can't make an class twice. 
// /* */: error encountered.

// Abstraction Object to hold String and Integer:
class StringCharacters{ 
    private char character;
    private int Count;
    public StringCharacters(char character, int Count) {
        super(); /*Call constructor of Parent Class (StringCharacters) */
        this.character = character;
        this.Count = Count;
    }
    // Get-Set to return Character and Count:
    public char getCharacter() {
        return character;
    }
    public void setCharacter(char character) {
        this.character = character;
    }

    public int getCount() {
        return Count;
    }
    public void setCount(int Count) {
        this.Count = Count;
    }
}

class MergeString{
    private String string1;
    private String string2;
    private ArrayList<StringCharacters> MergeString_Characters;
    public MergeString(String string1, String string2, ArrayList<StringCharacters> MergeString_Characters){
        super();
        this.string1 = string1;
        this.string2 = string2;
        this.MergeString_Characters = MergeString_Characters;
    }
    public String getstring1() {
        return string1;
    }
    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getstring2() {
        return string2;
    }
    public void setString2(String string2) {
        this.string2 = string2;
    }

    public void setMergeString_Characters(ArrayList<StringCharacters> MergeString_Characters) {
        this.MergeString_Characters = MergeString_Characters;
    }
    public ArrayList<StringCharacters> getMergeString_Characters(){
        return MergeString_Characters;
    }
}

public class AnagramString {
    // Standardized a String.
    public static String StandardizedText(String text){
        String UpperText_NoWhiteSpace = text.toUpperCase().replaceAll("\\s","");
        return UpperText_NoWhiteSpace;
    }
    // Check if a String is Anagram
    public static boolean isAnagram(String text){
        // Declare Object:
        char[] TextChar = StandardizedText(text).toCharArray();
        boolean res = true;
        // Compare Fist Half and Second Half of text by characters: 
        for (int i = 0; i < TextChar.length/2; i++) {
            if (TextChar[i]!=TextChar[TextChar.length-1-i]) {
                res = false;
            }
        }

        return res;
    }
    // Check if a String have substrings are Anagram
    public static boolean isAnagram_SubString(String text){
        // Set Initial Value for result:
        boolean res = false;
        // Check for the same character:
        for (int i = 0; i < text.length(); i++) {
            char[] characters = text.toCharArray();
            char character = characters[i];
            for (int j = i+1; j < characters.length; j++) {
                if (character == characters[j]) {
                    if (isAnagram(text.substring(i, j+1))==true) {
                        res = true;
                    }
                }
            }
        }
        return res;
    }
    // If a String have substrings are Anagram pick from it the Longest Anagram SubString
    public static String[] LongestAnagram_SubString(String text){
        String[] res = {"NULL","0"};
        char[] CharText = text.toCharArray();
        if (isAnagram(text)){
            if (text.length() > 3) {
                res[0] = text.substring(1, CharText.length-1);
                res[1] = Integer.toString(CharText.length - 2);
            }
        } else if (isAnagram_SubString(text)) {
            String LongestAnagram = "NULL";
            for (int i = 0; i < CharText.length; i++) {
                for (int j = i+1; j < CharText.length; j++) {
                    if (CharText[i] == CharText[j] ) {
                        if (isAnagram(text.substring(i, j+1)) && text.substring(i, j+1).length() > LongestAnagram.length() ) {
                            LongestAnagram = text.substring(i, j+1);
                        }
                    }
                }
            }
            res[0] = LongestAnagram;
            res[1] = Integer.toString(LongestAnagram.length());
        }
        return res;
    }
    // Check if String have Anagram in it 
    public static String[] AnagramCheck(String text){
        String[] res = {"NOK",""};
        if (isAnagram(text)) {
            res[0] = "OK";
        } else if (isAnagram_SubString(text)){
            res = LongestAnagram_SubString(text);
        }
        return res;
    }
    // Same Character:
    public static char[] Characters(String string){
        int j =0;
        char[] chars = string.toCharArray();
        char[] res = Arrays.copyOf(new char[0],0);
        for (int i = 0; i < string.length(); i++) {
            if (Arrays.binarySearch(res,chars[i]) < 0) {
                res = Arrays.copyOf(res,res.length + 1);
                res[j] = chars[i];
                j++;
            }
        }
        return res;
    }
    // Character Count:
    public static ArrayList<StringCharacters> CharacterCounts(String string){
        ArrayList<StringCharacters> listCharacters = new ArrayList<StringCharacters>();
        // Declare variables, object:
        int count = 0;
        char[] characters = Characters(string);
        // Count the number each character appear 
        for (char c : characters) { 
            for (int i = 0; i < string.length(); i++) {
                if (c == string.charAt(i)) {
                    count+=1;
                }
            }
            listCharacters.add(new StringCharacters(c, count));
            count = 0;
        }
        
        return listCharacters;
    }
    // If two String is not Anagram mergeable:
    public static ArrayList<MergeString> mergeString(String[] stringArray){
        // Declare variable, Object:
        ArrayList<MergeString> mergeableArrayList = new ArrayList<MergeString>(); // Cointain pairs of string that mergeable
        ArrayList<MergeString> CopyMergeableArrayList = new ArrayList<MergeString>();
        ArrayList<StringCharacters> mergeStringCharacters = new ArrayList<StringCharacters>(); // Cointain two string characters and number of times they appear.
        int[] IndexList_i = new int[0];
        int[] IndexList_j = new int[0];
        int countOdd = 0;
        // Check if two string are mergeable
        for (int i = 0; i < stringArray.length; i++) {
            String string_i = stringArray[i];
            ArrayList<StringCharacters> stringCharacters_i = CharacterCounts(string_i); // Take character from a string, and how many time they appear
            
            for (int j = i+1; j < stringArray.length; j++) {
                String string_j = stringArray[j];
                ArrayList<StringCharacters> stringCharacters_j = CharacterCounts(string_j); // Take character from a string, and how many time they appear
                // Check for odd number of character if two string have the same character
                for (int k = 0; k < stringCharacters_i.size(); k++) {
                    char character_i = stringCharacters_i.get(k).getCharacter();
                    int appearCharacter_i = stringCharacters_i.get(k).getCount();
                    
                    for (int k2 = 0; k2 < stringCharacters_j.size(); k2++) {
                        char character_j = stringCharacters_j.get(k2).getCharacter();
                        int appearCharacter_j = stringCharacters_j.get(k2).getCount();
                        
                        if (character_i == character_j) {
                            int sum = appearCharacter_i + appearCharacter_j;
                            StringCharacters stringCharacters = new StringCharacters(character_i,sum);
                            mergeStringCharacters.add(stringCharacters);
                            IndexList_i = Arrays.copyOf(IndexList_i, IndexList_i.length + 1);
                            IndexList_i[IndexList_i.length-1] = k; 
                            IndexList_j = Arrays.copyOf(IndexList_j, IndexList_j.length + 1);
                            IndexList_j[IndexList_j.length-1] = k2;
                        }
                    }
                }
                // Remove the same character appear in two string:
                int track_i = 0;
                for (int index = 0; index < stringCharacters_i.size(); index++) {
                    for (int k = 0; k < IndexList_i.length; k++) {
                        if (index == IndexList_i[k]) {
                            track_i +=1;
                        }
                    }
                    if (track_i == 0) {
                        if (stringCharacters_i.get(index).getCount()%2 != 0) {
                        countOdd +=1;
                        }
                        StringCharacters stringCharactersi = new StringCharacters(stringCharacters_i.get(index).getCharacter(),stringCharacters_i.get(index).getCount());
                        mergeStringCharacters.add(stringCharactersi);
                    }
                    track_i = 0;
                }
                for (int index = 0; index < stringCharacters_j.size(); index++) {
                    for (int k = 0; k < IndexList_j.length; k++) {
                        if (index == IndexList_j[k]) {
                            track_i +=1;
                        }
                    }
                    if (track_i == 0) {
                        if (stringCharacters_j.get(index).getCount()%2 != 0) {
                        countOdd +=1;
                        }
                        StringCharacters stringCharactersj = new StringCharacters(stringCharacters_j.get(index).getCharacter(),stringCharacters_j.get(index).getCount());
                        mergeStringCharacters.add(stringCharactersj);
                    }
                    track_i = 0;
                }
                // Two string are mergeable if it has characters appear are odd is less than 1
                // E.g. "abc" and "abd": c and d are two characters appear odd times. Symmetrical Arrangement for c and d are impossible
                if (countOdd <= 1) {
                    MergeString mergeString = new MergeString(string_i, string_j, mergeStringCharacters);
                    mergeableArrayList.add(mergeString);
                    CopyMergeableArrayList = mergeableArrayList;
                    mergeableArrayList = new ArrayList<MergeString>();
                } else {
                    mergeStringCharacters.removeAll(mergeStringCharacters);
                }
            }
        }
        return CopyMergeableArrayList;
    }
    // Characters Concat:
    public static String CharConcat(ArrayList<MergeString> CharArrayList,int Index){
        String res;
        String FirstHalf = "";
        String SecondHalf = "";
        String OddChar = "";
        for (int i = 0; i < CharArrayList.get(0).getMergeString_Characters().size(); i++) {
            if (CharArrayList.get(Index).getMergeString_Characters().get(i).getCount()%2 ==0) {
                for (int j = 0; j < CharArrayList.get(Index).getMergeString_Characters().get(i).getCount()/2; j++) {
                    FirstHalf = FirstHalf + CharArrayList.get(Index).getMergeString_Characters().get(i).getCharacter();
                    SecondHalf = CharArrayList.get(Index).getMergeString_Characters().get(i).getCharacter() + SecondHalf;
                }
            } else {
                OddChar = Character.toString(CharArrayList.get(Index).getMergeString_Characters().get(i).getCharacter());
            }
        }
        res = FirstHalf + OddChar + SecondHalf;
        return res;
    }
    public static void main(String[] args) throws Exception {
        // Declare File, Scanner and Object:
        File myFile = new File("input.txt");
        File myFile2 = new File("bai2_4.out");
        FileWriter Write1 = new FileWriter("bai2_1.out",false);
        FileWriter Write2 = new FileWriter("bai2_2.out",false);
        FileWriter Write3 = new FileWriter("bai2_3.out",false);
        FileWriter Write4 = new FileWriter("bai2_4.out",false);
        Scanner myScanner = new Scanner(myFile);
        Scanner myScanner2 = new Scanner(myFile2);
        Scanner myScanner3 = new Scanner(myFile2);
        int i = 0;
        int j = 0;
        // Take input from File input.txt:
        while (myScanner.hasNext()) {
            // Write result to File bai2_1:
            String ScanText = myScanner.nextLine();
            Write1.write(StandardizedText(ScanText) + ";" + isAnagram(ScanText) + "\n");
            Write2.write(StandardizedText(ScanText) + ";" + LongestAnagram_SubString(ScanText)[0]+";" + LongestAnagram_SubString(ScanText)[1] + "\n");
            if (isAnagram_SubString(ScanText)) { 
                Write3.write(StandardizedText(ScanText) + ";" + AnagramCheck(ScanText)[0] + ";" + AnagramCheck(ScanText)[1] + "\n");
            } else {
                Write3.write(StandardizedText(ScanText) + ";" + AnagramCheck(ScanText)[0] + "\n");
            }
            if (isAnagram(ScanText)==false && isAnagram_SubString(ScanText) ==false) {
                Write4.write(StandardizedText(ScanText)+"\n");
            }
        }
        // Close Scanner and .write() to avoid resource leak
        Write1.close();
        Write2.close();
        Write3.close();
        Write4.close();
        myScanner.close(); 
        // Measure the number of line in file input ("bai2_4.out")
        while (myScanner2.hasNext()) { /* Scanner must not be declare with the same name twice or more */
            myScanner2.nextLine(); /* If don't have .nextLine Scanner while loop became an infinity loop because myScanner2.hasNext() == true */
            i++;
        }
        // Create an Array String to hold any string that aren't Anagram.
        String[] StringNotAnagram = new String[i]; 
        // Take string from File into Array String
        while (myScanner3.hasNext()){
            StringNotAnagram[j] = myScanner3.nextLine();
            j++;
        }
        // Close Scanner
        myScanner2.close();
        myScanner3.close();
        // Reset File
        myFile2.delete();
        myFile2.createNewFile();

        ArrayList<MergeString> NotAnagramMerge = mergeString(StringNotAnagram);
        FileWriter Write5 = new FileWriter("bai2_4.out",true); /*If Use declare a method FileWriter to make object over File.delete() then File.delete() will not working*/
        for (int k = 0; k < NotAnagramMerge.size(); k++) {
            Write5.write(NotAnagramMerge.get(k).getstring1() + "\n");
            Write5.write(NotAnagramMerge.get(k).getstring2() + "\n");
            Write5.write(CharConcat(NotAnagramMerge,k) + "\n");
        }
        Write5.close();
    }
}
