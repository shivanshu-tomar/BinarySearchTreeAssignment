package implementation;

import myinterface.TreeNode;

public class BSTNode<E extends Comparable<E>> implements TreeNode<E> {
    E data;
    BSTNode<E> right;
    BSTNode<E> left;

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                ", right=" + right +
                ", left=" + left +
                '}';
    }

    public BSTNode(E data) {
        this.data = data;
        right = null;
        left = null;
    }
}
