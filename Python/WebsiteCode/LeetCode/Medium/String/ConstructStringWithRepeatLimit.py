from typing import Counter

# 106ms 19.78MB
class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        chars = Counter(s)
        sorted_chars = sorted(chars.items(), reverse=True)
        
        ans = []
        
        while sorted_chars:
            char, freq = sorted_chars[0]
            if freq <= repeatLimit:
                ans.append(char * freq)
                sorted_chars.pop(0)
            else:
                ans.append(char * repeatLimit)
                sorted_chars[0] = (char, freq - repeatLimit)
                
                if len(sorted_chars) > 1:
                    next_char, next_freq = sorted_chars[1]
                    ans.append(next_char)
                    if next_freq == 1:
                        sorted_chars.pop(1)
                    else:
                        sorted_chars[1] = (next_char, next_freq - 1)
                else:
                    break
        
        return ''.join(ans)

# 381ms 20.04MB
class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        s = sorted(s, reverse=True)
        result = []
        freq = 1
        pointer = 0

        i = 0
        while i < len(s):
            if result and result[-1] == s[i]:
                if freq < repeatLimit:
                    result.append(s[i])
                    freq += 1
                else:
                    pointer = max(pointer, i + 1)
                    while pointer < len(s) and s[pointer] == s[i]:
                        pointer += 1

                    if pointer < len(s):
                        result.append(s[pointer])
                        s[i], s[pointer] = s[pointer], s[i]
                        freq = 1
                    else:
                        break
            else:
                result.append(s[i])
                freq = 1

            i += 1

        return ''.join(result)