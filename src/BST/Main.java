package BST;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        binarySearchTree<Integer> bst1 = new binarySearchTree<Integer>(); 
        for (int i = 0; i < arr1.length; i++) {
            bst1.insert(arr1[i]);
        }
        System.out.println("Printing BST1 in order: ");
        bst1.inOrder();
        System.out.println("Checking if 15 exists in BST1: " + bst1.search(15));
        System.out.println("Checking if 25 exists in BST1: " + bst1.search(25));
        
        System.out.println("Removing 13 then Printing: ");
        bst1.remove(13);
        bst1.inOrder();
        System.out.println("Removing 8 then Printing: ");
        bst1.remove(8);
        bst1.inOrder();

        int[] arr2 = {8, 12, 14, 10, 4, 6, 13, 11, 2, 5, 9, 1, 7, 3, 15};
        binarySearchTree<Integer> bst2 = new binarySearchTree<Integer>(); 
        for (int i = 0; i < arr1.length; i++) {
            bst2.insert(arr2[i]);
        }
        System.out.println("\nPrinting BST2 in order: ");
        bst2.inOrder();
        System.out.println("Checking if 15 exists in BST1: " + bst2.search(15));
        System.out.println("Checking if 25 exists in BST1: " + bst2.search(25));

        System.out.println("Removing 13 then Printing: ");
        bst2.remove(13);
        bst2.inOrder();

        System.out.println("Removing 8 then Printing: ");
        bst2.remove(8);
        bst2.inOrder();

    }
}