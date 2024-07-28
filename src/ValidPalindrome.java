import java.util.Locale;

public class ValidPalindrome {

    public static boolean isPalindrome(String s){

        String text = removeNonAlphanumeric(s);
        StringBuilder stringBuilder = new StringBuilder(text);

        String reversedString = stringBuilder.reverse().toString();
        return reversedString.equals(text);


    }

    public static String removeNonAlphanumeric(String input) {
        // Regular expression to match alphanumeric characters (both uppercase and lowercase)
        String regex = "[^A-Za-z0-9]";
        // Replace all alphanumeric characters with an empty string and convert to lowercase
        return input.replaceAll(regex, "").toLowerCase(Locale.ENGLISH);
    }

    public static boolean isPalindrome2(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        String input = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(input));
    }
}
