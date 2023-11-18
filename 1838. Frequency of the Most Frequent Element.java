class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int answer = 1;
        long windowSum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            windowSum += nums[right];
            int windowSize = right - left + 1;
            long targetSum = windowSize * nums[right];
            while (targetSum - windowSum > k) {
                windowSum -= nums[left];
                left++;
                targetSum -= nums[right];
                windowSize--;
            }
            answer = Math.max(answer, windowSize);
        }
        return answer;
    }
}
