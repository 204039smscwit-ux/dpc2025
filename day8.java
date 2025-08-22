import java.util.*;
import java.util.Arrays;
public class ReverseWords {
    public static String reverseWords(String s) {
        
        String[] words = s.trim().split("\\s+");
        
        
        Collections.reverse(Arrays.asList(words));
        
        
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();

        String result = reverseWords(s);
        System.out.println("Output: \"" + result + "\"");
        sc.close();
    }
}
