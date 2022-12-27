package in.ravi.practice.grokking.dfs;

class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return findSum(root,0);
    }


    public static int findSum(TreeNode root, int currentSum){
        if (root == null){
            System.out.println("inside root null");
            return 0;
        }
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null){
            return currentSum;
        }
        return findSum(root.left, currentSum) + findSum(root.right,currentSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
