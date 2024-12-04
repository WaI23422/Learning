# 13ms 17.57MB
class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        if len(str1)==len(str2):
            for i in range(len(str1)):
                if str2[i]=='a' and str1[i]=='z':
                    continue
                elif str1[i]==str2[i]:
                    continue
                elif ord(str2[i])-ord(str1[i])!=1:
                    return False
            return True

        l=[]
        if len(str2)>len(str1):
            return False
        for i in str2:
            if i not in str1:
                l.append(i)
        c=0
        for i in l:
            if chr(ord(i)-1) in str1:
                c+=1
            if i=='a' and 'z' in str1:
                c+=1
        return c==len(l)

# 48ms 17.5MB
class Solution:
    def canMakeSubsequence(self, source: str, target: str) -> bool:
        targetIdx, targetLen = 0, len(target)  
        for currChar in source:
            if targetIdx < targetLen and (ord(target[targetIdx]) - ord(currChar)) % 26 < 2:
                targetIdx += 1  
        return targetIdx == targetLen