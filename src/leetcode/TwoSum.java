package leetcode;

import java.util.HashMap;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution.
//
//        Example:
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

//http://www.mamicode.com/info-detail-513290.html
// 因为Hashmap仅提供通过key获得value,故
// HashMap value放置与numers[index]匹配的数值,key放置index；，故
// 在下面循环时每一次查询map中的value是否有相等的值，有即相互匹配
// 其思想在于用index的value表示数组中的该数据，map中的key与之匹配，并在数组中寻找匹配值

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            } else {
                //以值为key,index为value
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] test = {1, 2, 3, 9};
        int[] target = twoSum.twoSum(test, 10);
        System.out.println(target[0] + " " + target[1]);
    }
}
