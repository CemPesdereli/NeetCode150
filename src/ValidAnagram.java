import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            set.add(c);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!set.contains(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] t_charArray = t.toCharArray();

        for (char c : t_charArray) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }

        }

        return map.isEmpty();


    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        String s = "racecar";
        String t = "carrace";
        System.out.println(isAnagram(s, t));
    }
}
