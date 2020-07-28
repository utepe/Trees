package BST;

public class binarySearchTree<E> {
    BSTNode<E> root;

    static class BSTNode<E> implements Comparable<E> {
        E value;
        BSTNode<E> left;
        BSTNode<E> right;
    
        public BSTNode(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        
        @Override
        public int compareTo(E o) {
            int o1 = Integer.parseInt(this.value.toString());
            int o2 = Integer.parseInt(o.toString());
            return o1-o2;
        }
    }

    public binarySearchTree(){
        this.root = null;
    }

    /**
     * insert Method
     * inserts the entered value into the BST
     * @param value
     */
    public void insert(E value){
        if(search(value)){
            System.out.println("Entered Value is already in the BST - Did not re-insert");
            return;
        }
        BSTNode<E> newNode = new BSTNode<E>(value);
        if(this.root == null) this.root = newNode;
        else{
            BSTNode<E> current = this.root;
            while(true){
                if(newNode.compareTo(current.value) < 0){
                    if(current.left == null){
                        current.left = newNode;
                        return;
                    }
                    current = current.left;
                }
                else{
                    if(current.right == null) {
                        current.right = newNode;
                        return;
                    }
                    current = current.right;
                }
            }
        }
    }
    
    /**
     * search Method
     * searchs for entered value in the tree
     * returns boolean true if found, false if not
     * @param value
     * @return boolean
     */
    public boolean search(E value){
        if(this.root == null) return false;
        BSTNode<E> current = this.root;
        while(current != null){
            if(current.compareTo(value) > 0){
                current = current.left;
            }
            else if(current.compareTo(value) < 0){
                current = current.right; 
            }
            else if(value == current.value){
                return true;
            }
        }
        return false;
    }

    /**
     * remove Base Method
     * calls the overloaded remove method
     * replaces this.root with the new tree
     */
    public void remove(E value){
        if(search(value) == false){
            System.out.println("Entered value is not in BST - Cannot Remove");
            return;            
        }
        this.root = remove(this.root, value);
    }

    /**
     * remove Overloaded Method
     */
    private BSTNode<E> remove(BSTNode<E> current, E value){
        if(current.compareTo(value) > 0){
            current.left = remove(current.left, value);
        }
        else if(current.compareTo(value) < 0){
            current.right = remove(current.right, value);
        }
        else{
            // recursion base cases
            if(current.left == null) return current.right;
            else if(current.right == null) return current.left;
            else{
                // get data from rightMost in left subtree of current
                current.value = getValue(current.left);
                // remove the rightMost node in left subtree
                current.left = remove(current.left, current.value);
            }
        }
        return current;
    }

    private E getValue(BSTNode<E> current){
        while(current.right != null)
            current = current.right;
        return current.value;
    }

    /**
     * inOrder Method
     * returns a List of the Tree in
     * @return LinkedList
     */
    public void inOrder() {
        traverseInOrder(this.root);
        System.out.println();
    }
    
    /**
     * traverseInOrder Method 
     * traverses the tree using DFS and adds each node to a list inOrder
     * @param node
     */
    private void traverseInOrder(BSTNode<E> node) {
        if(node == null) return;
        if(node.left != null){
            traverseInOrder(node.left);
        }
        System.out.print(node.value + " ");
        if(node.right != null){
            traverseInOrder(node.right);
        }
    }
}