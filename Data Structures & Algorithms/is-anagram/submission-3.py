class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
# Bước 1: Nếu độ dài khác nhau thì không thể là anagram
        if len(s) != len(t):
            return False

        count_s = {}
        count_t = {}

    # Bước 2: Đếm tần suất ký tự của s
        for char in s:
            count_s[char] = count_s.get(char, 0) + 1

    # Bước 3: Đếm tần suất ký tự của t
        for char in t:
            count_t[char] = count_t.get(char, 0) + 1

    # Bước 4: So sánh 2 dictionary
        return count_s == count_t