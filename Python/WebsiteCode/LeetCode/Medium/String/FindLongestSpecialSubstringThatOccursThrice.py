from collections import defaultdict

# 7ms 17.50MB
class Solution:
    def maximumLength(self, s: str) -> int:
        hash = defaultdict(list)
        
        n = len(s)
        i = 0
        while i < n:
            temp = 1
            ch = s[i]
            while i < n-1 and s[i] == s[i+1]:
                temp += 1
                i += 1
            hash[ch].append(temp)
            i += 1
            
        maxi = -1
        for ch, lis in hash.items():
            lis.sort(reverse=True)
            if lis[0] >= 3:
                maxi = max(maxi, lis[0]-2)
            if len(lis) >= 2:
                if lis[0] >= 2:
                    maxi = max(maxi, min(lis[0]-1, lis[1]))
                if len(lis) >= 3:
                    maxi = max(maxi, lis[2])
                
        return maxi
        
# 15ms 17.11MB
class Solution:
    def maximumLength(self, s: str) -> int:
        n = len(s)
        l, r = 1, n

        if not self.helper(s, n, l):
            return -1

        while l + 1 < r:
            mid = (l + r) // 2
            if self.helper(s, n, mid):
                l = mid
            else:
                r = mid

        return l

    def helper(self, s: str, n: int, x: int) -> bool:
        cnt = [0] * 26
        p = 0

        for i in range(n):
            while s[p] != s[i]:
                p += 1
            if i - p + 1 >= x:
                cnt[ord(s[i]) - ord('a')] += 1
            if cnt[ord(s[i]) - ord('a')] > 2:
                return True

        return False