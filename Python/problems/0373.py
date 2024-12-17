from typing import Optional, List
import heapq

"""
和“有序矩阵中的第K小的元素”同样的思路。
"""
class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        heap = []
        heapq.heapify(heap)
        heapq.heappush(heap, (nums1[0] + nums2[0], 0, 0))

        unique = set()
        # 不能将可变类型[]添加到set中
        unique.add((0, 0))

        res = []

        for _ in range(k):
            _, i, j = heapq.heappop(heap)
            res.append([nums1[i], nums2[j]])
            if i + 1 < len(nums1) and (i + 1, j) not in unique:
                heapq.heappush(heap, (nums1[i + 1] + nums2[j], i + 1, j))
                unique.add((i + 1, j))
            if j + 1 < len(nums2) and (i, j + 1) not in unique:
                heapq.heappush(heap, (nums1[i] + nums2[j + 1], i, j + 1))
                unique.add((i, j + 1))

        return res