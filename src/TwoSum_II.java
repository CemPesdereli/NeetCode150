import java.util.Arrays;

public class TwoSum_II {

    public static int[] twoSum(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        while (left<right){
            int sum = nums[left]+nums[right];
            if(sum<target){
                left++;
            }
            else if(sum>target){
                right--;
            }
            else{

                return new int[] {left,right};

            }

        }


        return new int[2];





    }












    public static void main(String[] args) {

        int[] nums = {3,4,5,6};
        int target = 7;


        System.out.println(Arrays.toString(twoSum(nums, target)));


    }
}
