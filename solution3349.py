class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        x = 0
        y = 0
        z = 0
        n = len(nums)
        for i, s in enumerate(nums):
            z += 1

            if i == n - 1 or nums[i] >= nums[i + 1]:
                x = max(x, z // 2, min(y, z))
                y = z
                z = 0
        return x >= k        
