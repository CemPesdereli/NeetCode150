import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[] {map.get(nums[i]),i};
            }

            map.put(target-nums[i],i);
        }

        return new int[2];


    }














    public static void main(String[] args) {

        int[] nums = {3,4,5,6};
        int target = 7;


        System.out.println(Arrays.toString(twoSum(nums, target)));

    }
}
