package divide;

import common.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * @author lichuangjian
 * @date 2023/8/2
 */
public class IsSymmetricTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (Objects.nonNull(left.right) && Objects.nonNull(right.left) && left.right.val != right.left.val) {
            return false;
        }
        if (Objects.nonNull(left.left) && Objects.nonNull(right.right) && left.left.val != right.right.val) {
            return false;
        }
        if (!isSymmetric(left.left, right.right)) {
            return false;
        }
        return isSymmetric(left.right, right.left);
    }

}