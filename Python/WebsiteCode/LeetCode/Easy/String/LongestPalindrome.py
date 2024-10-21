from typing import Counter

# 27 ms 16.5 MB
class Solution:
    def longestPalindrome(self, s: str) -> int:
        character_set = set()
        res = 0

        # Loop over characters in the string
        for c in s:
            # If set contains the character, match found
            if c in character_set:
                character_set.remove(c)
                # Add the two occurrences to our palindrome
                res += 2
            else:
                # Add the character to the set
                character_set.add(c)

        # If any character remains, we have at least one unmatched
        # character to make the center of an odd length palindrome.
        if character_set:
            res += 1

        return res
    
# 34 ms 16.6 MB
class Solution2:
    def longestPalindrome(self, s: str) -> int:
        charFrequency = Counter(s)
        oddFrequencyCount = 0
        for frequency in charFrequency.values():
            if frequency % 2 == 1:
                oddFrequencyCount += 1
        if oddFrequencyCount > 1:
            return len(s) - oddFrequencyCount + 1
        return len(s)
    
# 35 ms 16.5 MB
class Solution3:
    def longestPalindrome(self, s: str) -> int:
        ss = set()
        for letter in s:
            if letter not in ss:
                ss.add(letter)
            else:
                ss.remove(letter)
        if len(ss) != 0:
            return len(s) - len(ss) + 1
        else:
            return len(s)
        

if __name__ == "__main__":
    tests = [
        "abccccdd",
        "a",
    ]
    
    for test in tests:
        print(Solution().longestPalindrome(test))