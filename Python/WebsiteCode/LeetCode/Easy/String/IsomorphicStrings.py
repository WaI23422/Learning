# 39 ms 16.7 MB
class Solution1:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        mapS2T = {}
        mapT2S = {}

        for charS, charT in zip(s, t):
            # If the character in s already has a mapping, check if it maps to the correct character in t
            if charS in mapS2T:
                if mapS2T[charS] != charT:
                    return False
            else:
                # If the character in t is already mapped to a different character in s, return false
                if charT in mapT2S:
                    return False

                # Map the characters in s to t and vice versa
                mapS2T[charS] = charT
                mapT2S[charT] = charS

        return True

# 42 ms 16.7 MB
class Solution2:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(set(s))==len(set(t))==len(set(zip(s,t)))

# 50 ms 16.7 MB
class Solution3:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dicS = {}
        dicT = {}
        for i in range(len(s)):
            if s[i] in dicS:
                if dicS[s[i]] != t[i]:
                    return False
            else:
                dicS[s[i]] = t[i]
            
            if t[i] in dicT:
                if dicT[t[i]] != s[i]:
                    return False
            else:
                dicT[t[i]] = s[i]
        return True
        
if __name__ == "__main__":
    tests = [
        ["egg","add"],
        ["foo","bar"],
        ["paper","title"]
    ]
    
    for test in tests:
        s = test[0] 
        t = test[1]
        print(Solution2().isIsomorphic(s,t))
     