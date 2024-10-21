class Solution(object):
    # 18 ms 11.7 MB
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        
        i, j = 0, 0
        result = []
        
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                result.append(nums1[i])
                i += 1
                j += 1
                
        return result
    
    def intesect2(self,nums1,nums2):
        toreturn = []
        dicto = {}
        for num in nums1:
            dicto[num] = dicto.get(num,0) + 1
        for num in nums2:
            if num in dicto and dicto[num] > 0:
                toreturn.append(num)
                dicto[num] -= 1
        return toreturn
    
    def intesect3(self,nums1,nums2):
        from collections import Counter
        
        c1=Counter(nums1)
        c2=Counter(nums2)
        re=[]
        for i in c1.keys():
            if i in c2:
                re+=[i]*min(c1[i],c2[i])
        return re
    
    def intersect4(self, nums1, nums2):
        from collections import Counter
        # Count the frequency of each element in both arrays
        count1 = Counter(nums1)
        count2 = Counter(nums2)
        
        # Find the intersection of two counters
        intersection = count1 & count2
        
        # Expand the intersection into a list of elements
        result = []
        for num in intersection.elements():
            result.append(num)
        
        return result

if __name__ == "__main__":
    nums1 = [1,2,2,1]
    nums2 = [2,2]
    
    s = Solution()
    print(s.intersect(nums1,nums2))