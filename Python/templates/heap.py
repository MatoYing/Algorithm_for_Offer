import heapq


if __name__ == '__main__':


    # 创建一个堆
    heap = [3, 2, 5, 1, 4]
    heapq.heapify(heap)

    # 向堆中添加元素
    heapq.heappush(heap, 0)

    # 从堆中弹出最小元素
    min_element = heapq.heappop(heap)

    # 查找堆中的最小元素而不弹出
    min_element = heap[0]


    # 获取 n 个最小或最大元素
    small = heapq.nsmallest(3, heap)
    large = heapq.nlargest(2, heap)

    # 实现最大堆
    # heapq 模块默认实现最小堆。如果需要最大堆，可以对元素取负值
    max_heap = [1, 2, 3, 5]
    max_heap = list(map(lambda x: -x, max_heap))
    heapq.heapify(max_heap)
    max_item = -heapq.heappop(max_heap)

    # 类
    class ListNode:
        def __init__(self, x):
            self.val = x
            self.next = None
        # 重载 __lt__ 方法，让ListNode可以比大小
        def __lt__(self, other):
            return self.val < other.val

    nodes = [ListNode(3), ListNode(1), ListNode(2)]
    heapq.heapify(nodes)
    min_element = heapq.heappop(nodes).val



    # 用到了在写
    data = [("a", 2), ("b", 3), ("c", 1), ("a", 5), ("b", 4)]
