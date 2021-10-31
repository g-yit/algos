package com.algos.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author g-yit
 * @description 关于数的相关算法
 * @createtime 2021/10/30  21:31:00
 */
public class TreeAlgos {
    /**
     * 返回二叉树的深度
     *
     * @param root
     * @return int
     * @author g-yit
     * @date 2021/10/30 21:32
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    /***
     * 之字形打印二叉树
     * @author g-yit
     * @date 2021/10/30 21:40
     * @param pRoot
     * @return java.util.ArrayList<java.util.ArrayList < java.lang.Integer>>
     */
    public ArrayList<ArrayList<Integer>> PrintZTree(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        boolean reverse = false;

        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();//这一步时关键
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                tmp.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (reverse) {
                Collections.reverse(tmp);
            }
            reverse = !reverse;
            result.add(tmp);
        }
        return result;

    }

    /**
     * 层次遍历
     *
     * @param root
     * @return java.util.ArrayList<java.lang.Integer>
     * @author g-yit
     * @date 2021/10/30 21:59
     */
    public ArrayList<Integer> printTreeRow(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return list;
    }

    /**
     * 左边的节点比它小，右边的节点比它大
     * 中序遍历时有序的
     * 二叉搜索树的第k个节点
     *
     * @param pRoot
     * @param k
     * @return com.algos.tree.TreeNode
     * @author g-yit
     * @date 2021/10/30 22:34
     */
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        recursive(pRoot, list);
        return list.get(k);
    }

    /***
     * 从上到下打印二叉树
     * @author g-yit
     * @date 2021/10/31 10:24
     * @param root
     * @return java.util.ArrayList<java.lang.Integer>
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            result.add(root.val);
            final TreeNode left = root.left;
            if (left != null) {
                queue.offer(left);
            }
            final TreeNode right = root.right;
            if (right != null) {
                queue.offer(right);
            }
        }
        return result;
    }

    /**
     * 树的子结构
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
     * 假如给定A为{8,8,7,9,2,#,#,#,#,4,7}，B为{8,9,2}，2个树的结构如下，可以看出B是A的子结构
     *
     * @param root1
     * @param root2
     * @return boolean
     * @author g-yit
     * @date 2021/10/31 10:29
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        return isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }

    /**
     * 重新构建二叉树
     * 已知树的前序遍历和中序遍历
     *
     * @param pre
     * @param vin
     * @return com.algos.tree.TreeNode
     * @author g-yit
     * @date 2021/10/31 10:40
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre == null || vin == null) {
            return null;
        }
        if (pre.length != vin.length) {
            return null;
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] vin, int vinStart, int vinEnd) {
        if (preStart > preEnd || vinStart > vinEnd) {
            return null;
        }
        int preRootIndex = preStart;
        int inRootIndex = vinStart - 1;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = vinStart; i <= vinEnd; i++) {
            if (vin[i] == pre[preRootIndex]) {
                inRootIndex = i;
            }
        }
        if (inRootIndex < vinStart) {
            return null;
        }
        leftCount = inRootIndex - vinStart;
        rightCount = vinEnd - inRootIndex;
        TreeNode root = new TreeNode(pre[preRootIndex]);
        int preLeftStart = preStart + 1;
        int preLeftEnd = preStart + leftCount;
        int preRightStart = preLeftEnd + 1;
        int preRightEnd = preEnd;

        int inLeftStart = vinStart;
        int inLeftEnd = vinStart + leftCount - 1;
        int inRightStart = vinEnd - rightCount + 1;
        int inRightEnd = vinEnd;
        root.left = reConstructBinaryTree(pre, preLeftStart, preLeftEnd, vin, inLeftStart, inLeftEnd);
        root.right = reConstructBinaryTree(pre, preRightStart, preRightEnd, vin, inRightStart, inRightEnd);
        return root;

    }

    public void recursive(TreeNode pRoot, ArrayList<TreeNode> list) {
        if (pRoot == null) {
            return;
        }
        recursive(pRoot.left, list);
        list.add(pRoot);
        recursive(pRoot.right, list);
    }


    /**
     * 二叉树的镜像
     * 给定一颗树返回二叉树的镜像
     *
     * @param pRoot
     * @return com.algos.tree.TreeNode
     * @author g-yit
     * @date 2021/10/31 11:20
     */
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null)
            return null;
        if (pRoot.left == null && pRoot.right == null)
            return pRoot;
        //处理根节点，交换左右节点
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        //处理左子树
        Mirror(pRoot.left);
        //处理右子树
        Mirror(pRoot.right);
        return pRoot;
    }

    /**
     * 判断是否为搜索二叉树的后续遍历序列
     *
     * @param sequence
     * @return boolean
     * @author g-yit
     * @date 2021/10/31 15:48
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {

//        int leftStartIndex = start;
        int rightStartIndex = -1;
        if (start > end || start < 0 || end < 0) {
            return true;
        }
        int root = sequence[end];
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                rightStartIndex = i;
                break;
            }
        }
        if (rightStartIndex != -1) {
            for (int i = rightStartIndex; i <= end; i++) {
                if (sequence[i] < root) {
                    return false;
                }
            }
        } else {//右子树为空
            return VerifySquenceOfBST(sequence, start, end - 1);
        }
        if (rightStartIndex == start) {//左子树为空
            return VerifySquenceOfBST(sequence, start, end - 1);
        }
        return VerifySquenceOfBST(sequence, start, rightStartIndex - 1) && VerifySquenceOfBST(sequence, rightStartIndex, end - 1);
    }

    /**
     * 判断树是否为平衡二叉树
     * 左右子树高度相差不超过1
     *
     * @param root
     * @return boolean
     * @author g-yit
     * @date 2021/10/31 16:09
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int r = Math.abs(deepthOfTree(root.left) - deepthOfTree(root.right));
        return r < 2 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int deepthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(deepthOfTree(root.left), deepthOfTree(root.right));
    }

    /**
     * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     *
     * @param node
     * @return com.algos.tree.TreeLinkNode
     * @author g-yit
     * @date 2021/10/31 16:24
     */
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) return null;
        if (node.right != null) {    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.next != null) { //没右子树，则找第一个当前节点是父节点左孩子的节点
            if (node.next.left == node) {
                return node.next;
            }
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }

    /**
     * 判断二叉树是否是对称的
     *
     * @param pRoot
     * @return boolean
     * @author g-yit
     * @date 2021/10/31 18:15
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

}
