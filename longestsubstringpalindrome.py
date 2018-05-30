#Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

#Example 1:

#Input: "babad"
#Output: "bab"
#Note: "aba" is also a valid answer.

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
#         dynamic programming

        # n*n matrix - diagonal - len 1 hence palindrome 
#       Case Even: aa
#       Case Odd: aba

#       b a b a d       So we will look ar [i+1][j-1]
#     b 1 0 1 0 0       How do we get the length / substring
#     a   1 0 1 0       max length = can be updated
#     b     1 0 0       start index= look at the farthest one right? start index should be that row.
#     a       1 0
#     d         1
    
        if len(s)==0:
            return 0
        
        maxlength=0
        n = len(s)
        # matrix= np.zeros((n-1,n-1))
        matrix = [[0 for x in range(n)] for y in range(n)]
        startindex=0
        
        
#         Base Case where the length is 1        
        for i in range(0,n):
            matrix[i][i]=1
#         Base Case setting for when the length is 2
        for i in range(0,n-1):
            if(s[i]==s[i+1]):
                matrix[i][i+1]=1
                maxlength=1
                startindex=i
                
                
#         Thinking about the others
        for l in range (2,n):
            for i in range(0,n-l):
                j=i+l
                if (matrix[i+1][j-1]==1 and s[i]==s[j]):
                    matrix[i][j]=1
                    if(maxlength < l):
                        maxlength = l
                        # print (start)
                        startindex=i
        print (matrix)
        return s[startindex:startindex+maxlength+1]
