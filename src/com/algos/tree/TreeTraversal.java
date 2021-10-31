package com.algos.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @author g-yit
 * @description TODO类描述
 * @createtime 2021/10/30  22:54:00
 */
public class TreeTraversal {
    //==============递归遍历====================/
    public void inOrderTraversal(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                System.out.println(pRoot.val);
                pRoot = stack.pop();
                pRoot = pRoot.right;
            }

        }
    }

    /**
     * 1、申请一个栈stack，然后将头节点压入stack中。
     * <p>
     * 2、从stack中弹出栈顶节点，打印，再将其右孩子节点（不为空的话）先压入stack中，最后将其左孩子节点（不为空的话）压入stack中。
     * <p>
     * 3、不断重复步骤2，直到stack为空，全部过程结束
     *
     * @param pRoot
     * @return void
     * @author g-yit
     * @date 2021/10/30 23:28
     */
    public void preOrderTraversal(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                System.out.println(pRoot.val);
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                pRoot = pRoot.right;
            }

        }

    }

    /**
     * 1、申请一个栈s1，然后将头节点压入栈s1中。
     * <p>
     * 2、从s1中弹出的节点记为cur，然后依次将cur的左孩子节点和右孩子节点压入s1中。
     * <p>
     * 3、在整个过程中，每一个从s1中弹出的节点都放进s2中。
     * <p>
     * 4、不断重复步骤2和步骤3，直到s1为空，过程停止。
     * <p>
     * 5、从s2中依次弹出节点并打印，打印的顺序就是后序遍历的顺序。
     *
     * @param pRoot
     * @return void
     * @author g-yit
     * @date 2021/10/30 23:28
     */
    public void postOrderTraversal(TreeNode pRoot) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        if (pRoot != null) {
            stack1.push(pRoot);
            while (!stack1.empty()) {
                pRoot = stack1.pop();
                stack2.push(pRoot);
                if (pRoot.left != null) {
                    stack1.push(pRoot.left);
                }
                if (pRoot.right != null) {
                    stack1.push(pRoot.right);
                }
            }
            while (!stack2.empty()) {
                list.add(stack2.pop().val);
            }
        }
    }

    public void sequenceOrderTraversal(TreeNode pRoot) {

    }

    //==============非递归遍历====================/
}
