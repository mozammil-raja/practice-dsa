// QUESTION: LEETCODE-3637

// You are given an integer array nums of length n.

// An array is trionic if there exist indices 0 < p < q < n − 1 such that:

// nums[0...p] is strictly increasing,
// nums[p...q] is strictly decreasing,
// nums[q...n − 1] is strictly increasing.
// Return true if nums is trionic, otherwise return false.

// SOLUTION

class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int peak = n - 1, valley = 0;

        for (int i = 0; i < n - 1; i++) {
            if (peak == n - 1 && nums[i] >= nums[i + 1])
                peak = i;
            if (valley == 0 && nums[n - 1 - i] <= nums[n - 2 - i])
                valley = n - 1 - i;
            if (peak < valley)
                return isDecreasing(nums, peak, valley);
        }

        return false;
    }

    public boolean isDecreasing(int[] A, int a, int b) {
        if (a == 0 || b == A.length - 1) return false;
        for (int i = a; i < b; i++)
            if (A[i] <= A[i + 1]) return false;
        
        return true;
    }
}
