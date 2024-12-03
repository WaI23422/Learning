

from typing import List

# 39ms 49.12MB
class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        index, result = 0, []

        for space in spaces:
            result.append(s[index : space])
            index = space
        
        result.append(s[index :])
        return " ".join(result)
    
# 119ms 49.01MB
class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        # List to store characters (more efficient than string concatenation)
        result = []
        space_index = 0

        for string_index in range(len(s)):
            if (
                space_index < len(spaces)
                and string_index == spaces[space_index]
            ):
                # Insert space at the correct position
                result.append(" ")
                space_index += 1

            # Append the current character
            result.append(s[string_index])

        # Join all characters into final string
        return "".join(result)