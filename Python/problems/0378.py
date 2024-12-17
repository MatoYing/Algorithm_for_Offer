from typing import List
import heapq

class Solution:
    """
    有点像“将多个有序链表合并”这道题的思路，heap每次进入加上行和列。
    之后每次pop出时，再把这个元素的后一个加进去。
    """
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        heapq.heapify(heap)
        value = None

        for n, m in enumerate(matrix):
            heapq.heappush(heap, (m[0], n, 0))

        for i in range(k):
            value, row, column = heapq.heappop(heap)
            if column == len(matrix[row]) - 1:
                continue
            else:
                heapq.heappush(heap, (matrix[row][column + 1], row, column + 1))

        return value