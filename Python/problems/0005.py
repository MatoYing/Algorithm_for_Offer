"""
从一个点扩散！
for 0 <= i < len(s):
    找到以 s[i] 为中心的回文串
    找到以 s[i] 和 s[i+1] 为中心的回文串
    更新答案
"""
class Solution:
    def longestPalindrome(self, s: str) -> str:
        max_value = 0
        max_str = ""

        for i in range(len(s)):
            left = i
            right = i
            length = 1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
                length += 2
            if length > max_value:
                max_str = s[left + 1:right]
                max_value = length

        for i in range(len(s)):
            left = i
            right = i + 1
            length = 2
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
                length += 2
            if length > max_value:
                max_str = s[left + 1:right]
                max_value = length

        return max_str