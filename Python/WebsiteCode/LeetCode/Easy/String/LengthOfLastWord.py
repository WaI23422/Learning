# 33 ms 16.6 MB 
class Solution1:
    def lengthOfLastWord(self, s: str) -> int:
        words = s.strip().split()
        
        if not words:
            return 0
        
        return len(words[-1])

# 32 ms 16.6 MB
class Solution2:
    def lengthOfLastWord(self, s: str) -> int:
        length = 0
        i = len(s) - 1
        while i >= 0 and s[i] == ' ':
            i -= 1
        while i >= 0 and s[i] != ' ':
            length += 1
            i -= 1
        return length
        
        
if __name__ == "__main__":
    tests = [
        "Hello World",
        "   fly me   to   the moon  ",
        "luffy is still joyboy"   
    ]
    
    for test in tests:
        print(Solution2().lengthOfLastWord(test))