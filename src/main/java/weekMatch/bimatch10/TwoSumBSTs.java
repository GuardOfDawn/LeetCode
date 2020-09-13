package weekMatch.bimatch10;

import java.util.LinkedList;
import java.util.Queue;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        boolean res = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res = search(root2, target-cur.val);
            if (res) {
                return true;
            }
            if (cur.left!=null) {
                queue.add(cur.left);
            }
            if (cur.right!=null) {
                queue.add(cur.right);
            }
        }
        return res;
    }

    private boolean search(TreeNode root, int target) {
        if (root==null) {
            return false;
        }
        if (root.val==target) {
            return true;
        } else if (root.val<target) {
            return search(root.right, target);
        } else {
            return search(root.left, target);
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}