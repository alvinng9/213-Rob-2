package org.example;

public class Solution {
    public int rob(int[] nums) {
        //deal with cases when the length of the int array is 1, 2
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //create two new arrays for 2 different scenarios the robbery can happen
        int[] numsOne = new int[nums.length - 1];
        int[] numsTwo = new int[nums.length - 1];

        //one robbery will start at the beginning and will go to the second to last house
        //one robbery will start at the second house and will go to the last house
        for (int i = 0; i < nums.length - 1; i++) {
            numsOne[i] = nums[i];
            numsTwo[i] = nums[i + 1];
        }

        //return the higher robbed value from the two scenarios
        return Math.max(robHelp(numsOne), robHelp(numsTwo));
    }

    public int robHelp(int[] nums) {
        // deal with cases when the length of the int array is 1, 2, or 3
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        // since all integers in the array is bigger or equal to 0,
        // the sum of nums[0] and nums[2] will always be equal or bigger
        // than nums[0]
        nums[2] += nums[0];

        // initialize int result as the maximum between nums[1] and nums[0]
        int result = Math.max(nums[2], nums[1]);

        // start going through the rest of the int array
        for (int i = 3; i < nums.length; i++) {
            // find the maximum case of nums[i] as the combination of nums[i]
            // and the bigger number between nums[i - 2] and nums[i - 3] since
            // the robber cannot rob 2 houses next to another
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
            // compare the result and nums[i] to see which is the bigger number
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}
