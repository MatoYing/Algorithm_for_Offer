from typing import List

"""
模仿“15. 三数之和”。
"""
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()

        ans = []

        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            res = self.threeSum(nums, i + 1, target - nums[i])
            for j in res:
                ans.append([nums[i], j[0], j[1], j[2]])

        return ans

    # def threeSum(self, nums: List[int]) -> List[List[int]]:
    def threeSum(self, nums: List[int], start, target) -> List[List[int]]:
        ans = []

        for i in range(start, len(nums)):
            # if i > 0 and nums[i] == nums[i - 1]:
            if i > start and nums[i] == nums[i - 1]:
                continue

            # res = self.twoSum(nums, i + 1, 0 - nums[i])
            res = self.twoSum(nums, i + 1, target - nums[i])
            for j in res:
                # ans.append([nums[i], j[0], j[1]])
                ans.append([nums[i], j[0], j[1]])

        return ans

    def twoSum(self, nums: List[int], start, target) -> List[List[int]]:
        left = start
        right = len(nums) - 1
        res = []
        while left < right:
            if nums[left] + nums[right] < target:
                left += 1
            elif nums[left] + nums[right] > target:
                right -= 1
            else:
                res.append([nums[left], nums[right]])
                left_value = nums[left]
                right_value = nums[right]
                while left < right and nums[left] == left_value:
                    left += 1
                while left < right and nums[right] == right_value:
                    right -= 1
        return res