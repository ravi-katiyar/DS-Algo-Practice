package in.ravi.practice.grokking.dfs;

class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPathHelper(root,sequence,0);
    }

    public static boolean findPathHelper(TreeNode node, int[] sequence, int currentIndex){
        if (node == null)
            return false;

        if (currentIndex >= sequence.length || sequence[currentIndex] != node.val)
            return false;

        if (node.left == null && node.right == null && sequence[currentIndex] == node.val && currentIndex == sequence.length -1 )
            return true;

        return findPathHelper(node.left,sequence,currentIndex + 1) || findPathHelper(node.right,sequence,currentIndex + 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(7);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 5 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 5, 7}));
    }
}
