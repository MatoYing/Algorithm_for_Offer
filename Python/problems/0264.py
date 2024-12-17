import heapq

"""
首先将1，也就是最小的丑数放入堆中，之后每次pop出最小的丑数，然后分别乘2、3、5，再放入堆中，依次循环。
"""
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        unique = set()
        heap = [1]
        heapq.heapify(heap)

        for i in range(n - 1):
            min_element = heapq.heappop(heap)

            if 2 * min_element not in unique:
                unique.add(2 * min_element)
                heapq.heappush(heap, 2 * min_element)
            if 3 * min_element not in unique:
                unique.add(3 * min_element)
                heapq.heappush(heap, 3 * min_element)
            if 5 * min_element not in unique:
                unique.add(5 * min_element)
                heapq.heappush(heap, 5 * min_element)

        return heapq.heappop(heap)