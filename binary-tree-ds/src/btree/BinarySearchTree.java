package btree;

public class BinarySearchTree extends BinaryTree{
    Node root;

    public static void main(String[] args) {
        var bts = new BinarySearchTree();

        bts.root = bts.insert(bts.root, 8);
        bts.insert(bts.root, 7);
        bts.insert(bts.root, 9);

        var nodeFound = bts.search(bts.root, 7);
        var nodeNotFound = bts.search(bts.root, 15);

        System.out.println("---found------> " + nodeFound);
        System.out.println("---notFound---> " + nodeNotFound);
        System.out.println("---ascending------> ");
        bts.printAscending(bts.root);
        System.out.println("\n---descending------> ");
        bts.printDescending(bts.root);
        var lca = bts.lca(bts.root, bts.search(bts.root, 7), bts.search(bts.root, 9));
        System.out.println("\n---lca 7 9------> "+lca.value);
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

    public void printAscending(Node parent){
        if (parent == null){
            return;
        } else {
            this.printAscending(parent.left);
            System.out.print(parent.value);
            this.printAscending(parent.right);
        }
    }

    public void printDescending(Node parent){
        if (parent == null){
            return;
        } else {
            this.printDescending(parent.right);
            System.out.print(parent.value);
            this.printDescending(parent.left);
        }
    }

    public Node lca(Node parent, Node x, Node y) {
        if(parent.value < x.value && parent.value < y.value) {
            return lca(parent.right, x, y);
        }
        if(parent.value > x.value && parent.value > y.value) {
            return lca(parent.left, x, y);
        }
        return parent;
    }
}
