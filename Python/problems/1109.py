class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        nums = [0 for _ in range(n)]
        diff = [0 for _ in range(n)]

        diff[0] = nums[0]
        for i in range(1, n):
            diff[i] = nums[i] - nums[i - 1]

        for i, j, val in bookings:
            diff[i - 1] += val
            if j - 1 + 1 < n:
                diff[j - 1 + 1] -= val

        res = [0 for _ in range(n)]
        res[0] = diff[0]
        for i in range(1, n):
            res[i] = res[i - 1] + diff[i]

        return res