import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {


        int[] arr = nums.clone();
        int product =1;
        for(int a : nums){
            product*=a;
        }
        int count =0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]==0){
                count++;
                if(count>=2){
                    nums[i]=0;
                }
                else{
                int newProduct = 1;
                arr[i]=1;
                for(int j=0;j<arr.length;j++){
                    newProduct*= arr[j];
                }

                nums[i]=newProduct;

                }

            }
            else {
            nums[i]= product/nums[i];

            }
        }
        return nums;


    }







    public static void main(String[] args) {


        int[] arr = new int[]{1,0,7,0,5};



        System.out.println(Arrays.toString(productExceptSelf(arr)));

    }
}
