from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 1

        slow = 0
        fast = 1

        flag = False
        while fast < len(nums):
            if nums[slow] != nums[fast]:
                flag = False
                slow += 1
                nums[slow] = nums[fast]
                fast += 1
            else:
                if flag:
                    fast += 1
                else:
                    flag = True
                    slow += 1
                    nums[slow] = nums[fast]
                    fast += 1

        return slow + 1