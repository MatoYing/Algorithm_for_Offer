from typing import List

"""
不能直接无脑的那样算，这个要考察前缀和。使得在计算sum时只需要O(1)即可，而不用写个for去遍历。
"""
class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.preSum = [0 for _ in range(len(nums))]

        for i in range(len(nums)):
            if i == 0:
                self.preSum[i] = nums[i]
            else:
                self.preSum[i] = self.preSum[i - 1] + nums[i]

    def sumRange(self, left: int, right: int) -> int:
        return self.preSum[right] - self.preSum[left] + self.nums[left]