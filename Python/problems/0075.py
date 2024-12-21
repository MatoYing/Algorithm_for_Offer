from typing import List

"""
思路1:
第一次遍历，将2全部移动到末尾；第二次遍历，将1全部移动到末尾（2的前面）。

思路2（无法实现，或者说需要加更多if）:
（[0,0,1,2,1,2,2],[0,0],[0,2],[1,0,1]）
维护左右两个指针，
left遇到0，后移；遇到1不动；遇到2和right交换；
right遇到2，前移；遇到1不动，遇到0和left交换。

思路3：
维护左右两个指针，left卡住0，right卡住1，让cur去一个一个遍历；
cur遇到0，和left交换，left+1；cur遇到2，和right交换，right-1.
这样保证了每个元素都被遍历到（[0,0,1,2,1,2,2],[1,0,1]），不会越界（[0,0]），因为左右卡死了，不会将2和0交换（[0,2]）。
"""
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        left = 0
        right = len(nums) - 1
        cur = 0

        while cur <= right:
            if nums[cur] == 0:
                nums[left], nums[cur] = nums[cur], nums[left]
                left += 1
                # 不能这样，这样的话交换过来的值就无法判断，被跳过了
                # 也不能不加1，比如[0,2,1,2]，这样cur一直在判断第一个0
                # cur += 1
                if left > cur:
                    cur += 1
            elif nums[cur] == 2:
                nums[right], nums[cur] = nums[cur], nums[right]
                right -= 1
            else:
                cur += 1

        # 无法解决[1,0,1]
        # left = 0
        # right = len(nums) - 1

        # while left < right:
        #     if nums[left] == 0:
        #         left += 1
        #     elif nums[left] == 2:
        #         nums[left], nums[right] = nums[right], nums[left]
        #         right -= 1
        #     elif nums[right] == 2:
        #         right -= 1
        #     elif nums[right] == 0:
        #         nums[right], nums[left] = nums[left], nums[right]
        #         left += 1
        #     elif nums[left] == 1 and nums[right] == 1:
        #         left += 1
        #         right -= 1


        # 通过这个学到了！当用while left < right，不要多个if，那样，每个if里面还得判断有没有越界，while left < right就没用了
        # [0,2]无法解决，需要更多if
        # left = 0
        # right = len(nums) - 1

        # while left < right:
        #     if nums[left] == 0:
        #         left += 1
        #         if left > len(nums) - 1:
        #             break

        #     if nums[left] == 2:
        #         nums[left], nums[right] = nums[right], nums[left]
        #         right -= 1
        #         if right < 0:
        #             break

        #     if nums[right] == 2:
        #         right -= 1
        #         if right < 0:
        #             break

        #     if nums[right] == 0:
        #         nums[right], nums[left] = nums[left], nums[right]
        #         left += 1
        #         if left > len(nums) - 1:
        #             break

        #     if nums[left] == 1 and nums[right] == 1:
        #         left += 1
        #         right -= 1
        #         if left > len(nums) - 1 or right < 0:
        #             break