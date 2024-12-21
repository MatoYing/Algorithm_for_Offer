"""
非常标准、基础的差分数组。
"""
class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        nums = [0 for _ in range(length)]
        diff = [0 for _ in range(length)]
        diff[0] = nums[0]

        for i in range(1, length):
            diff[i] = nums[i] - nums[i - 1]

        for i, j, val in updates:
            diff[i] += val
            if j + 1 < length:
                diff[j + 1] -= val

        res = [0 for _ in range(length)]
        res[0] = diff[0]
        for i in range(1, length):
            res[i] = res[i - 1] + diff[i]

        return res