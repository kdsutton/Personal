import java.util.StringTokenizer;

/**
 * Write a description of class palindrome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Palindrome {
    private String word;
    
    public Palindrome(String wordInit) {
        this.word = wordInit;
    }
    
    public void setPalindrome(String wordNew) {
        this.word = wordNew;
    }
    
    public boolean isPalindrome() {
        String forward = "";
        String[] wordSplit = this.word.split("\\W");
        for(String token : wordSplit) {
            forward += token;
        }
        String reverse = "";
        for(int i = forward.length() - 1; i >= 0; i--) {
            reverse += forward.charAt(i);
        }
        boolean isPalindrome = false;
        if(forward.compareToIgnoreCase(reverse) == 0) {
            isPalindrome = true;
        }
        return isPalindrome;
    }
}