package btree;

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;
    public BinaryTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node7.right = node8;
        node5.left = node6;
        node5.right = node7;
        node2.left = node4;
        node2.right = node5;
        node1.left = node2;
        node1.right = node3;
        root = node1;
    }

    public static void main(String[] args) {
        var bt = new BinaryTree();
        System.out.print("---inorder----> ");
        bt.inOrderTraversal(bt.root);
        System.out.print("\n---preorder---> ");
        bt.preOrderTraversal(bt.root);
        System.out.print("\n---postorder--> ");
        bt.postOrderTraversal(bt.root);
    }

    public void inOrderTraversal(Node parent) {
        if (parent == null){
            return;
        } else {
            inOrderTraversal(parent.left);
            System.out.print(parent.value);
            inOrderTraversal(parent.right);
        }
    }

    public void preOrderTraversal(Node parent) {
        if (parent == null){
            return;
        } else {
            System.out.print(parent.value);
            preOrderTraversal(parent.left);
            preOrderTraversal(parent.right);
        }
    }

    public void postOrderTraversal(Node parent) {
        if (parent == null){
            return;
        } else {
            postOrderTraversal(parent.left);
            postOrderTraversal(parent.right);
            System.out.print(parent.value);
        }
    }
}

