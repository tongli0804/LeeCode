package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dylan.ll
 * @date 2022/3/6 21:06
 */
public class IsSubtree_572_另一棵树的子树 {


    public boolean isSubtree优化(TreeNode root, TreeNode subRoot) {
        List<Integer> rootVisited=new ArrayList<>();
        dfsFillNull(root,rootVisited);

        List<Integer> subRootVisited=new ArrayList<>();
        dfsFillNull(subRoot,subRootVisited);

        for (int i = 0; i <= rootVisited.size()-subRootVisited.size(); i++) {
            if(Arrays.equals(subRootVisited.toArray(new Integer[0]), rootVisited.subList(i,i+subRootVisited.size()).toArray(new Integer[0])) ){
                return true;
            }
        }

        return false;

    }

    private void  dfsFillNull(TreeNode root, List<Integer> visitedValue){
        if(root==null){
            return;
        }
        visitedValue.add(root.val);
        if(root.left==null){
            visitedValue.add(Integer.MAX_VALUE);
        }else {
            dfsFillNull(root.left,visitedValue);
        }

        if(root.right==null){
            visitedValue.add(Integer.MAX_VALUE);
        }else {
            dfsFillNull(root.right,visitedValue);
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isEquals(root,subRoot)){
            return true;
        }
        if(root.left!=null){
            if(isSubtree(root.left,subRoot)){
                return true;
            }
        }
        if(root.right!=null){
            if(isSubtree(root.right,subRoot)){
                return true;
            }
        }
        return false;
    }

    private boolean isEquals(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }
        if(root.val!=subRoot.val){
            return false;
        }
        if(!isEquals(root.left,subRoot.left)){
            return false;
        }
        if(!isEquals(root.right,subRoot.right)){
            return false;
        }
        return true;
    }

   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(12);
        TreeNode subRoot=new TreeNode(2);

        System.out.println(new IsSubtree_572_另一棵树的子树().isSubtree优化(root,subRoot));
    }

}



