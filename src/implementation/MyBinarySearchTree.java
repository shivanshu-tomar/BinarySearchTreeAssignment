package implementation;

import myinterface.BinarySearchTreeADT;

public class MyBinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {
    public BSTNode<T> root;

    @Override
    public void insert(T data) {
        if(root==null){
            root = new BSTNode<T>(data);
        }
        else {
            BSTNode<T> temp=root,parent= null;
            while(temp!=null){
                parent = temp;
                if(data.compareTo(temp.data)<0){
                    temp = temp.left;
                }
                else temp = temp.right;
            }
            if(data.compareTo(parent.data)<0) parent.left = new BSTNode<>(data);
            else parent.right = new BSTNode<>(data);
        }
    }
    // recurcive
    public BSTNode<T> insertNode(BSTNode<T> root,T data){
        if(root== null){
            if(this.root==null) this.root =new BSTNode<>(data);
            return new BSTNode<>(data);
        }
        else{
            if(data.compareTo(root.data)<0) root.left = insertNode(root.left,data);
            else root.right = insertNode(root.right,data);
        }
        return root;
    }
    public BSTNode<T> getSuccessor(BSTNode<T> root) {
        if(root==null){
            return null;
        }
        if(root.right!= null){
            BSTNode<T> temp = root.right;
            while(temp.left != null){
                temp =temp.left;
            }
            return temp;
        }
        return null;
    }

    @Override
    public boolean search(T searchElement) {
        BSTNode<T> temp=root;
        while(temp!=null){
            if(searchElement.compareTo(temp.data)==0){
                return true;
            }
            if(searchElement.compareTo(temp.data)<0){
                temp =temp.left;
            }
            if(searchElement.compareTo(temp.data)>0){
                temp =temp.right;
            }
        }
        return false;
    }

    @Override
    public void inOrder(BSTNode<T> node) {
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    @Override
    public void preOrder(BSTNode<T> node) {
            if(node!=null){
                System.out.println(node.data);
                preOrder(node.left);
                preOrder(node.right);
            }
    }

    @Override
    public void postOrder(BSTNode<T> node) {
        if(node != null){
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data);
        }
    }

    @Override
    public void reverseInOrder(BSTNode<T> node) {

    }

    @Override
    public void delete(T data) {

    }
    //recursive delete
    public BSTNode<T> deleteNode(BSTNode<T> root, T data){
        if(root == null){
            return null;
        }
        if(data.compareTo(root.data)<0) root.left = deleteNode(root.left,data);
        else if(data.compareTo(root.data)>0) root.right  = deleteNode(root.right,data);
        else {
            // If node has only one child or a leaf node
            if(root.left ==null||root.right==null){
                BSTNode temp =null;
                temp= root.left==null?root.right:root.left;
                return temp;
            }
            else {
                BSTNode<T> temp = getSuccessor(root);
                root.data =  temp.data;
                root.right = deleteNode(root.right,temp.data);
            }
        }
        return null;
    }
    @Override
    public int height(BSTNode<T> node) {
        return 0;
    }

}
