package completeBT;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Tree<Integer> tree = new Tree<Integer>();
        tree.insert(arr);

        System.out.print("Printing Tree InOrder: ");
        tree.InOrder();
        
        System.out.print("\nPrinting Tree PreOrder: ");
        tree.PreOrder();

        System.out.print("\nPrinting Tree PostOrder: ");
        tree.PostOrder();
    }
}