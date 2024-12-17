class Solution:
    def isPalindrome(self, s: str) -> bool:
        new_s = ""
        for i in s:
            if i.isalpha():
                new_s += i.lower()
            elif i.isdigit():
                new_s += i

        left = 0
        right = len(new_s) - 1

        while left < right:
            if new_s[left] == new_s[right]:
                left += 1
                right -= 1
            else:
                return False

        return True