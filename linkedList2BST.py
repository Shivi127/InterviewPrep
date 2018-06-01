# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Example [1,2,3,4,5,6,7,8,9]
#                     5
#                    / \
#                   3   8
                   /\   /\
                  2  4 7  9
                 /\ /\ /\ /\
                1 nn n 6
class Solution(object):
    def __init__(self):
        self.curr= None


    def getSize(self, head):
        s=0
        cur= head
        while head:
            head=head.next
            s+=1
        return s
    
    def buildTree(self, n):
        if n<=0:
            return None
        else:
            l= self.buildTree(n/2)
            root = TreeNode(self.curr.val)
            self.curr= self.curr.next
            r= self.buildTree(n-(n/2)-1)
            root.left =l
            root.right=r
        
            return root
    
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        n= self.getSize(head)
        self.curr= head
        return self.buildTree(n)
    
    
        
