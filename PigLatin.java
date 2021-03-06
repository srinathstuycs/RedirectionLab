import java.util.*;
public class PigLatin{
  public static boolean testDigraph(String s){
    String[] digraphs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh",
    "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn",
    "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
    int length = digraphs.length;
    for (int i = 0; i < length; i++) {
      if (digraphs[i].equals(s)) {
        return true;
      }
    }
    return false;
  }
  public static boolean testVowel(char a){
    return (a =='a'||a =='e'||a =='i'||a =='o'||a =='u');
  }
  public static boolean testLetter(String s){
    String[] letters = {"q","w","e","r","t","y","u","i","o","p",
    "a","s","d","f","g","h","j","k","l",
    "z","x","c","v","b","n","m"};
    int length = letters.length;
    for (int i = 0; i < length; i++) {
      if (letters[i].equals(s)) {
        return true;
      }
    }
    return false;
  }
  public static boolean testNumber(String s){
    String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
    int length = numbers.length;
    for (int i = 0; i < length; i++) {
      if (numbers[i].equals(s)) {
        return true;
      }
    }
    return false;
  }
  public static String pigLatinSimple(String s){
    s = s.toLowerCase();
    int length = s.length();
    if (testVowel(s.charAt(0))) {
      return (s + "hay");
    }
    if (length == 1) {
      return (s + "ay");
    }
    return s.substring(1,length) + s.charAt(0) + "ay";
  }
  public static String pigLatin(String s){
    s = s.toLowerCase();
    int length = s.length();
    //testing digraph condition
    if (length >= 2) {
      if (testDigraph(s.substring(0,2))) {
        if (length == 2) {
          return s + "ay";
        }
        return s.substring(2,length) + s.substring(0,2) + "ay";
      }
    }
    //code from pigLatinSimple
    if (testVowel(s.charAt(0))) {
      return (s + "hay");
    }
    if (length == 1) {
      return (s + "ay");
    }
    return s.substring(1,length) + s.charAt(0) + "ay";
  }
  public static String pigLatinBest(String s){
    s = s.toLowerCase();
    int length = s.length();
    //checking if first character is letter
    if (!testLetter(s.substring(0,1))) {
      return s;
    }
    //checking for punctuation
    String toAddAtEnd = "";
    String lastChar = s.substring(length - 1, length);
    if(!testLetter(lastChar) && !testNumber(lastChar)) {
      toAddAtEnd = lastChar;
    }
    length = length - toAddAtEnd.length();
    s = s.substring(0, length);//Add toAddAtEnd everywhere
    //testing digraph condition
    if (length >= 2) {
      if (testDigraph(s.substring(0,2))) {
        if (length == 2) {
          return s + "ay" + toAddAtEnd;
        }
        return s.substring(2,length) + s.substring(0,2) + "ay" + toAddAtEnd;
      }
    }
    //code from pigLatinSimple
    if (testVowel(s.charAt(0))) {
      return (s + "hay" + toAddAtEnd);
    }
    if (length == 1) {
      return (s + "ay" + toAddAtEnd);
    }
    return s.substring(1,length) + s.charAt(0) + "ay" + toAddAtEnd;
  }
  public static void main(String[] args){
    //use the standard input (terminal input)
    //as the string that you read from
    Scanner n = new Scanner( System.in );
    //use hasNextLine()/nextLine() to loop over
    //all of the data
    while (n.hasNextLine()) {
      Scanner scan = new Scanner(n.nextLine());
      while (scan.hasNext()) {
        String word = scan.next();
        System.out.print(pigLatinBest(word));
        System.out.print(" ");
      }
      System.out.println();
    }
    //If you want to read the input word by word
    //this can be replaced with hasNext() and next()
  }
}
