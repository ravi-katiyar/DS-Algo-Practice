package in.ravi.practice.grokking.dfs;

import java.util.*;

class CountAllPathSum {
    public static int countPaths(TreeNode root, int sum) {
        LinkedList<Integer> currentPath = new LinkedList<Integer>();
        return countPathSums(root,currentPath,sum);
    }

    public static int countPathSums(TreeNode root,LinkedList<Integer> currentPath, int sum) {

        if(root == null){
            return 0;
        }

        currentPath.add(root.val);

        int pathSumCount = 0;
        int currentSum = 0;

        Iterator<Integer> listIterator = currentPath.descendingIterator();
        while (listIterator.hasNext()){
            currentSum += listIterator.next();
            if(currentSum == sum) {
                pathSumCount++;
            }
        }

        pathSumCount += countPathSums(root.left,currentPath,sum) ;
        pathSumCount += countPathSums(root.right,currentPath,sum);

        currentPath.remove(currentPath.size() -1);

        return pathSumCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(7);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
