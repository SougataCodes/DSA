/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void rec(TreeNode root, int arr1[],int arr2[],int s1, int e1, int s2, int e2){
        if(s1>e1 || s2>e2) return;
        if(arr1[s1]!=arr2[e2]){
            root.left = new TreeNode(arr1[s1]);
            root.right = new TreeNode(arr2[e2]);
            int i = s1;
            int j = s2;
            for(;i<=e1;i++){
                if(arr1[i]==arr2[e2]) break;
            }
            for(;j<=e2;j++){
                if(arr1[s1]==arr2[j]) break;
            }
            rec(root.left,arr1,arr2,s1+1,i-1,s2,j-1);
            rec(root.right,arr1,arr2,i+1,e1,j+1,e2-1);
        }
        else{
            root.left = new TreeNode(arr1[s1]);
            rec(root.left,arr1,arr2,s1+1,e1,s2,e2-1);
        }

    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        rec(root,preorder,postorder,1,preorder.length-1,0,postorder.length-2);
        return root;
    }
}