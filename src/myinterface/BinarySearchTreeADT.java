package myinterface;

import implementation.BSTNode;

public interface BinarySearchTreeADT<T extends Comparable<T>> {
    void insert(T data);
    boolean search(T searchElement);
    void inOrder(BSTNode<T> node);
    void preOrder(BSTNode<T> node);
    void postOrder(BSTNode<T> node);
    void reverseInOrder(BSTNode<T> node);
    void delete(T data);
    int height(BSTNode<T> node);
}
