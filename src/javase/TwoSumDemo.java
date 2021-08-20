package javase;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDemo {
    public int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(target-nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }


    public int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int part = target - nums[i];
            if(map.containsKey(part)){
                return new int[]{map.get(part),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }
}
