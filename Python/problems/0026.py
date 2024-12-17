from typing import List

"""
1）非严格递增排列：意思是，不是[1,2,3,4]一直增；而是[1,2,2,3,3]这种。
2）注意它的判题标准，得到了你返回的k，然后会遍历nums的前k个。
也就是[1,2,2,3,3]“原地”变成[1,2,3,3,3]。

思路：
快慢指针
如果nums[fast]所对的与nums[slow]所对的不同，那就让slow加1，并且将这个变为nums[fast]。
"""
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 1
        slow = 0
        fast = 1
        while fast < len(nums):
            if nums[slow] == nums[fast]:
                fast += 1
            else:
                slow += 1
                nums[slow] = nums[fast]
                fast += 1
        # 注意这里返回的是长度，不是坐标
        return slow + 1