import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeAndDecodeStrings {


    public static String encode_alpnanumeric(List<String> strs) {



        StringBuilder stringBuilder = new StringBuilder();

        for (String str : strs) {
            char[] charArray = str.toCharArray();

            for (int i = 0; i < charArray.length; i++) {

                int value = charArray[i] - 'a';
                value = (value + 1);
                charArray[i] = (char) (value + 'a');


            }
            stringBuilder.append(String.valueOf(charArray)).append(",");



        }
        if(strs.size()>=1){
            String res = stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
            return res;
        }

        return "LIST_IS_EMPTY";


    }


    public static List<String> decode_alphanumeric(String str) {


        if(str.equals("LIST_IS_EMPTY")){
            return Collections.emptyList();
        }

        String[] stringArray = str.split(",");
        List<String> result = new ArrayList<>();

        for(String s : stringArray){
            char[] charArray = s.toCharArray();
            for(int i =0; i< charArray.length;i++){
                int value = charArray[i]- 'a';
                value=  (value -1);
                charArray[i]= (char) (value + 'a');
            }
            result.add(String.valueOf(charArray));

        }
        return result;

    }

    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }


    public static void main(String[] args) {


        List<String> list = new ArrayList<>(List.of("neet","code","love","youz"));
        String res = encode(list);
        List<String> list2 = decode(res);
        System.out.println(res);
        list2.stream().forEach(System.out::println);


    }
}
