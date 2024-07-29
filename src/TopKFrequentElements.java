import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] freqArray = new List[nums.length+1];

        for(int i =0;i<freqArray.length;i++){
            freqArray[i]= new ArrayList<>();
        }
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            freqArray[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index =0;
        for(int i=freqArray.length-1; index<k  && i >0;i--){
            for (int a : freqArray[i]){
                result[index++]=a;
            }
        }

        return result;




    }
    public static int[] topKFrequent_2(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        int[] result = new int[k];
        for(int i =0; i<k;i++){
            result[i]=pq.poll().getKey();
        }
        return result;




    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,3,3,3};
        int k = 2;
        int[] resultArray= topKFrequent_2(nums,k);
        for (int a : resultArray){
            System.out.println(a);
        }

    }
}
