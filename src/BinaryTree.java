public class BinaryTree<E> {

    protected class BinaryTreeNode {
        protected E value;
        protected BinaryTreeNode left;
        protected BinaryTreeNode right;

        public BinaryTreeNode(E e) {
            value = e;
            left = null;
            right = null;
        }

        public BinaryTreeNode(E e, BinaryTreeNode l,
                              BinaryTreeNode r) {
            value = e;
            left = l;
            right = r;
        }
    }

    // Single protected data item
    protected BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    // public interface methods, e.g., insert, delete
    // retrieve, etc.
}
