import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();


        for(String word: strs){
            int[] count = new int[26];
            char[] charArray = word.toCharArray();
            for(char c :charArray){
                count[ c- 'a']++;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());

    }


    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(strs));
    }
}
