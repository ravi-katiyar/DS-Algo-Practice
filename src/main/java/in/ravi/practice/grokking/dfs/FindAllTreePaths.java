package in.ravi.practice.grokking.dfs;

import java.util.*;

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPath(root,currentPath,sum,allPaths);
        return allPaths;
    }

    public static void findPath(TreeNode node, List<Integer> currentPath, int sum, List<List<Integer>> allPaths) {
        if (node == null)
            return;

        currentPath.add(node.val);

        if (node.left == null && node.right == null && (sum -node.val == 0))
            allPaths.add(new ArrayList<Integer>(currentPath));

        if (node.left != null) {
            findPath(node.left,currentPath,sum - node.val, allPaths);
        }
        if (node.right != null) {
            findPath(node.right,currentPath,sum - node.val, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
