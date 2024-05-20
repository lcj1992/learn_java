package leetcode;

/**
 * @author lichuangjian
 * @date 2023/7/8
 */
public class FindMaxAverageSolution {

    public static void main(String[] args) {
        FindMaxAverageSolution solution = new FindMaxAverageSolution();
        int[] nums = new int[]{0, 4, 0, 3, 2};
        double maxAverage = solution.findMaxAverage(nums, 1);
        System.out.println(maxAverage);
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = nums[i] + max;
        }
        int windowSum = max;
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            max = Math.max(max, windowSum);
        }
        return 1.0 * max / k;
    }
}