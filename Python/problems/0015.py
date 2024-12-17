from typing import List

"""
核心点：
1.将求三数之和变成求两数之和（为了用双指针）。
2.threeSum调twoSum时，记得传left，避免用用过的值。
"""
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        ans = []

        for i in range(len(nums)):
            # 避免第一个数字重复，[1,1,2,3]，1遍历过一次就不用遍历了
            # 不能用set，因为要传start
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # 0 - nums[i]，最核心的地方，将求三数之和转换成求两数之和
            res = self.twoSum(nums, i + 1, 0 - nums[i])
            for j in res:
                ans.append([nums[i], j[0], j[1]])

            # i是for循环的控制变量，手动增加i在for循环中不起作用。
            # while i + 1 < len(nums) and nums[i + 1] == nums[i]:
            #     i += 1

        return ans

    def twoSum(self, nums: List[int], start, target) -> List[List[int]]:
        # 为什么要限制start？
        # 让遍历过的不在遍历，比如[-1,0,1]，第一回你传-1，找到了0和1；第二回传0又找到了-1和1，但这是同样的结果
        # 简单来说三个值里只要有-1，剩下两个数就是固定的，所以遍历过的就不要让它遍历了
        left = start
        right = len(nums) - 1

        res = []

        while left < right:
            if nums[left] + nums[right] < target:
                # 这里其实也能跳nums[left] == left_value，但我觉的这样写更清晰
                left += 1
            elif nums[left] + nums[right] > target:
                right -= 1
            else:
                res.append([nums[left], nums[right]])
                left_value = nums[left]
                right_value = nums[right]
                # 不能用set，比如要2，数组是[1,1]
                while left < right and nums[left] == left_value:
                    left += 1
                while left < right and nums[right] == right_value:
                    right -= 1

        return res