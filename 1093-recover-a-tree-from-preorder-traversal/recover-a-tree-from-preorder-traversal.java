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
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root = null;
        index = 0;
        root = new TreeNode(parseNumber(traversal));
        util(root, 0, traversal);
        return root;
    }
    private int index;
    private int util(TreeNode root, int depth, String s) {
        int d = 0;
        while(index < s.length() && s.charAt(index) == '-') {
            d++;
            index++;
        }
        if(d == depth + 1) {
            // left node
            root.left = new TreeNode(parseNumber(s));
            int get = util(root.left, depth + 1, s);
            if(get == depth + 1) {
                // right node
                root.right = new TreeNode(parseNumber(s));
                return util(root.right, depth + 1, s);
            }
            return get;
        }else {
            return d;
        }
    }
    private int parseNumber(String s) {
        int idx = index;
        while(idx < s.length() && Character.isDigit(s.charAt(idx))) {
            idx++;
        }
        String no = s.substring(index, idx);
        index = idx;
        return Integer.parseInt(no);
    }
}