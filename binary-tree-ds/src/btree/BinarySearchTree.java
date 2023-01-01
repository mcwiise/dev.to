package btree;

public class BinarySearchTree extends BinaryTree{
    Node root;

    public static void main(String[] args) {
        var bts = new BinarySearchTree();

        bts.root = bts.insert(bts.root, 9);
        bts.insert(bts.root, 10);
        bts.insert(bts.root, 11);

        var nodeFound = bts.search(bts.root, 10);
        var nodeNotFound = bts.search(bts.root, 15);

        System.out.println("---found------> " + nodeFound);
        System.out.println("---notFound---> " + nodeNotFound);
    }

    public Node search(Node parent, int key){
        if (parent == null || key == parent.value) {
            return parent;
        } else if (key < parent.value){
            return search(parent.left, key);
        } else {
            return search(parent.right, key);
        }
    }

    public Node insert(Node parent, int key){
        if (parent == null){
            return new Node(key);
        } else if (key < parent.value) {
            parent.left = insert(parent.left, key);
        } else {
            parent.right = insert(parent.right, key);
        }
        return parent;
    }

    public Node delete(Node parent, int key){
        if(parent == null){
            return parent;
        } else if (key < parent.value){
            parent.left = this.delete(parent.left, key);
        } else if (key > parent.value){
            parent.right = this.delete(parent.right, key);
        } else {
            var predecessor = this.inOrderPredecessor(parent);
            parent.value = predecessor.value;
            parent.left = this.delete(parent.left, key);
        }
        return parent;
    }
}
