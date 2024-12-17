from typing import List

"""
类似“26. 删除有序数组中的重复项”，快慢指针。
"""
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        slow = 0
        fast = 0
        while fast < len(nums):
            if nums[fast] == val:
                fast += 1
            else:
                nums[slow] = nums[fast]
                slow += 1
                fast += 1

        return slow