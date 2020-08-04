package completeBT;

public class Tree<E> {
    TreeNode<E> root;

    static class TreeNode<E>{
        E value;
        TreeNode<E> left, right;

        // Constructor
        public TreeNode(E value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Tree(){
        this.root = null;
    }

    /**
     * insert Base Method
     * calls overloaded insert method
     * @param arr 
     */
    public void insert(E[] arr){
        this.root = insert(arr, this.root, 0);
    }

    /**
     * insert Overloaded Method
     * inserts each element in the array into the Complete BT
     * @param arr
     * @param node
     * @param pos
     * @return TreeNode
     */
    private TreeNode<E> insert(E[] arr, TreeNode<E> node, int pos){
        //recursive base case
        if(pos < arr.length){
            TreeNode<E> newNode = new TreeNode<E>(arr[pos]);
            node = newNode;

            //insert left child
            node.left = insert(arr, node.left, 2*pos+1);

            //insert right child
            node.right = insert(arr, node.right, 2*pos+2);
        }
        
        //return after done inserting all elements into the tree
        return node;
    }

    /**
     * inOrder Method
     * returns a List of the Tree Node Values InOrder
     */
    public void InOrder(){
        traverseInOrder(this.root);
        System.out.println();
    }

    /**
     * PreOrder Method
     * returns a List of the Tree Node Values PreOrder
     */
    public void PreOrder(){
        traversePreOrder(this.root);
        System.out.println();
    }

    /**
     * PostOrder Method
     * returns a List of the Tree Node Values PostOrder
     */
    public void PostOrder(){
        traversePostOrder(this.root);
        System.out.println();
    }

    /**
     * traverseInOrder Method 
     * traverses the tree using DFS and adds each node to a list inOrder
     * @param node
     */
    private void traverseInOrder(TreeNode<E> node) {
        if(node == null) return;
        if(node.left != null){
            traverseInOrder(node.left);
        }
        System.out.print(node.value + " ");
        if(node.right != null){
            traverseInOrder(node.right);
        }
    }

    /**
     * traversePreOrder Method
     * traverses the tree using DFS and adds each node to a list preOrder
     * @param node
     */
    private void traversePreOrder(TreeNode<E> node) {
        if(node == null) return;
        System.out.print(node.value + " ");
        if(node.left != null){
            traversePreOrder(node.left);
        }
        if(node.right != null){
            traverseInOrder(node.right);
        }
    }

    /**
     * traversePostOrder Method
     * traverses the tree using DFS and adds each node to a list postOrder
     * @param node
     */
    private void traversePostOrder(TreeNode<E> node) {
        if(node == null) return;
        if(node.left != null){
            traversePreOrder(node.left);
        }
        if(node.right != null){
            traverseInOrder(node.right);
        }
        System.out.print(node.value + " ");
    }
    
}