# 123ms 17.12MB
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        freqs = [0] * 3
        n = len(s)
        
        for c in s:
            freqs[ord(c) - ord('a')] += 1
        
        i = 0
        j = 0
        if freqs[0] < k or freqs[1] < k or freqs[2] < k:
            return -1
        
        for j in range(n):
            freqs[ord(s[j]) - ord('a')] -= 1
            
            if freqs[0] < k or freqs[1] < k or freqs[2] < k:
                freqs[ord(s[i]) - ord('a')] += 1
                i += 1
            

        return n - (j - i + 1)
                
        
            

# 221ms 17.24MB
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        count = [0] * 3
        n = len(s)

        # Count total occurrences
        for c in s:
            count[ord(c) - ord("a")] += 1

        # Check if we have enough characters
        for i in range(3):
            if count[i] < k:
                return -1

        window = [0] * 3
        left, max_window = 0, 0

        # Find the longest window that leaves k of each character outside
        for right in range(n):
            window[ord(s[right]) - ord("a")] += 1

            # Shrink window if we take too many characters
            while left <= right and (
                count[0] - window[0] < k
                or count[1] - window[1] < k
                or count[2] - window[2] < k
            ):
                window[ord(s[left]) - ord("a")] -= 1
                left += 1

            max_window = max(max_window, right - left + 1)

        return n - max_window