package Shao_Yichang_hw5;

import net.datastructures.LinkedBinaryTree;
import java.util.Comparator;
import net.datastructures.DefaultComparator;
import net.datastructures.Position;

// generic binary search tree
public class MyBST<E> extends LinkedBinaryTree<Integer> {

    private Comparator<E> comp;
    private int size = 0;

    // compare by non-naturing ordering
    public MyBST(Comparator<E> c) {
        comp = c;
    }

    // compare by natural ordering
    public MyBST() {
        this(new DefaultComparator<E>());
    }

    // size of tree
    public int size() {
        return size;
    }

    // check whether is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // successor() function
    public Position<Integer> successor(Position<Integer> p) {
        // Find right child's min child
        if (right(p) != null) {
            return findMinNode(right(p));
        }
        // Go up to find parent
        Position<Integer> parent = parent(p);
        //Do loop when is the right child; if left, return back.
        while ((parent != null) && (p == right(parent))) {
            p = parent;
            parent = parent(parent);
        }
        return parent;
    }

    // predecessor() function
    public Position<Integer> predecessor(Position<Integer> p) {
        // Find left child's max child 
        if (left(p) != null) {
            return findMaxNode(left(p));
        }
        // Go up to find parent
        Position<Integer> parent = parent(p);
        //Do loop when is the left child; if right, return back.
        while ((parent != null) && (p == left(parent))) {
            p = parent;
            parent = parent(parent);
        }
        return parent;
    }

    // delete() function
    public Integer delete(Position<Integer> p, Integer e) {
        // check whether the tree is empty
        if (root == null) {
            System.out.println("The tree is empty now.");
            return null;
        }

        //try catch, 
        try {
            // search the node should be deleted
            // if e < p's value
            if (e < p.getElement()) {
                // call delete() function for p's left node
                delete(left(p), e);
            } else if (e > p.getElement()) {
                // call delete() function for p's right node
                delete(right(p), e);
            } else {
                // if number children of p is 0
                if (numChildren(p) == 0) {
                    //remove p directly
                    remove(p);
                } else if (numChildren(p) == 1) { // if number children of p is 1
                    //remove p directly
                    remove(p);
                } else {
                    // when having two children, find the max value node
                    Position<Integer> maxPosition = findMaxNode(left(p));
                    // set p's value with the max node's value
                    set(p, maxPosition.getElement());
                    // remove the max value node
                    remove(maxPosition);
                }
                System.out.println("Successfully delete the node: " + e);
            }
        } catch (Exception ex) {
            // the node cannot be found in the tree
            System.out.println("The node doesn't exist.");
            return null;
        }
        return e;
    }

    // findMinNode(), find min left value node
    public Position<Integer> findMinNode(Position<Integer> p) {
        // if p doesn't have left child
        if (left(p) == null) {
            return p;
        } else {
            // find min left value node
            return findMinNode(left(p));
        }
    }

    // findMaxNode(), find max right value node
    public Position<Integer> findMaxNode(Position<Integer> p) {
        // if p doesn't have right child
        if (right(p) == null) {
            return p;
        } else {
            // find max right value node
            return findMaxNode(right(p));
        }
    }

    //Add function
    public Position<Integer> add(Position<Integer> p, Integer e) {
        //If this is a empty tree
        if (p == null) {
            p = addRoot(e);
            size++;
            return p;
        }

        //Declare x,y Node variables
        Node<Integer> x = validate(p);
        Node<Integer> y = x;

        while (x != null) {
            if (x.getElement().equals(e)) {
                return null;//Exist, return null
            } else if (x.getElement() > e) {
                y = x;
                x = x.getLeft();//Left child of x
            } else {
                y = x;
                x = x.getRight();//Right child of y
            }
        }

        //Temp node used to return
        Node<Integer> temp = createNode(e, y, null, null);

        if (y.getElement() > e) {
            addLeft(y, temp.getElement());
        } else {
            addRight(y, temp.getElement());
        }

        size++;
        return temp;
    }

    //Print a binary tree horizontally using indentation
    public void print(Position<Integer> p, int depth) {

        Node<Integer> n = validate(p);
        int i;

        for (i = 1; i <= depth; i++) {
            System.out.print("    ");
        }
        System.out.println(n.getElement());

        if (n.getLeft() != null) {
            print(n.getLeft(), depth + 1);
        } else if (n.getRight() != null) {
            for (i = 1; i <= depth + 1; i++) {
                System.out.print("    ");
            }
            System.out.println("--");
        }

        if (n.getRight() != null) {
            print(n.getRight(), depth + 1);
        } else if (n.getLeft() != null) {
            for (i = 1; i <= depth + 1; i++) {
                System.out.print("    ");
            }
            System.out.println("--");
        }
    }

    //Print a binary tree using inorder tree traversal
    public void inorderPrint(Position<Integer> p) {
        if (p == null) {
            return;
        }
        Node<Integer> n = validate(p);
        inorderPrint(n.getLeft());
        System.out.print(n.getElement() + "  ");
        inorderPrint(n.getRight());
    }

    public static void main(String[] args) {
        //Create MyBST
        MyBST<Integer> t = new MyBST<>();

        //test add method
        t.add(t.root, 100);
        t.add(t.root, 50);
        t.add(t.root, 150);
        t.add(t.root, 70);
        t.add(t.root, 30);
        t.add(t.root, 130);
        t.add(t.root, 140);
        t.add(t.root, 120);

        //Tree Size
        System.out.println("Number of nodes is: " + t.size);

        //Show Tree Elements
        System.out.println("Print tree horizontally using indentation: ");
        t.print(t.root, 0);
        System.out.println("\n");

        //Inorder Traversal
        System.out.println("Print tree by inorder traversal: ");
        t.inorderPrint(t.root);
        System.out.println("\n");

        // Test delete()
        int delete1 = t.delete(t.root, 30);
        t.print(t.root, 0);
        System.out.print("After delete " + delete1 + ", the inorder is: ");
        t.inorderPrint(t.root);
        System.out.println("\n");

        int delete2 = t.delete(t.root, 140);
        t.print(t.root, 0);
        System.out.print("After delete " + delete2 + ", the inorder is: ");
        t.inorderPrint(t.root);
        System.out.println("\n");

        int delete3 = t.delete(t.root, 100);
        t.print(t.root, 0);
        System.out.print("After delete " + delete3 + ", the inorder is: ");
        t.inorderPrint(t.root);
        System.out.println("\n");

        // Test successor() and predecessor()
        Position<Integer> p1 = t.left(t.root);

        try {
            Position<Integer> successor1 = t.successor(p1);
            System.out.println("The successor of " + p1.getElement() + " is: " + successor1.getElement());
        } catch (Exception e) {
            System.out.println("The successor of " + p1.getElement() + " is null");
        }

        try {
            Position<Integer> predecessor1 = t.predecessor(p1);
            System.out.println("The predecessor of " + p1.getElement() + " is: " + predecessor1.getElement());
        } catch (Exception e) {
            System.out.println("The predecessor of " + p1.getElement() + " is null");
        }
    }
}
