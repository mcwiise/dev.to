package btree;

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
        System.out.print("---inorder------->\t");
        bt.inOrderTraversal(bt.root);
        System.out.print("\n---preorder------>\t");
        bt.preOrderTraversal(bt.root);
        System.out.print("\n---postorder----->\t");
        bt.postOrderTraversal(bt.root);
        System.out.print("\n---in order predecessor swapping--->");
        bt.inOrderPredecessorSwap(bt.root);
        bt.inOrderTraversal(bt.root);
        var r = bt.highestLevel(bt.root);
        System.out.print("\n---tree highest level--->\t"+r);
        var nbt = bt.copy(bt.root);
        System.out.print("\n---new tree inorder------->\t");
        bt.inOrderTraversal(nbt);
        nbt = bt.delete(nbt);
        System.out.print("\n---new tree deleted------->\t"+nbt);
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

    int predecessor = -1;
    public void inOrderPredecessorSwap(Node parent){
        if(parent == null){
            return;
        } else {
            this.inOrderPredecessorSwap(parent.left);
            this.swap(parent);
            this.inOrderPredecessorSwap(parent.right);
        }
    }
    private void swap(Node parent) {
        var temp = parent.value;
        parent.value = predecessor;
        predecessor = temp;
    }

    public Node inOrderPredecessor(Node parent) {
        var tempNode = parent.left;
        while(tempNode.right != null){
            tempNode = tempNode.right;
        }
        return tempNode;
    }

    public int highestLevel(Node parent){
        if(parent == null){
            return -1;
        }
        var hLeft = this.highestLevel(parent.left);
        var hRight = this.highestLevel(parent.right);
        if(hLeft > hRight){
            return hLeft + 1;
        } else {
            return hRight + 1;
        }
    }

    public Node copy(Node parent){
        if(parent == null){
            return parent;
        } else {
            var newParent = parent;
            newParent.left = this.copy(parent.left);
            newParent.right = this.copy(parent.right);
            return newParent;
        }
    }

    public Node delete(Node parent){
        if(parent == null){
            return parent;
        } else {
            this.delete(parent.left);
            this.delete(parent.right);
            return null;
        }
    }
}

