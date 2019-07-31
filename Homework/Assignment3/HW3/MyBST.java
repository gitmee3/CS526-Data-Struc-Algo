package HW3;

import net.datastructures.LinkedBinaryTree;
import java.util.Comparator;
import java.util.Random;
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
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

        //Average Height Experiment
        //Random set up and seed
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
                
        int sum_height = 0;
        //Create 100 times MyBST
        for (int num = 0; num < 100; num++) {
            MyBST test = new MyBST();
            //Add 1000 different nodes
            for (int i = 0; i < 1000; i++) {
                int e = r.nextInt(1000000);
                
                Position<Integer> temp = test.add(test.root, e);
                //If node exists, random and add again
                while (temp == null) {
                    e = r.nextInt(1000000);
                    temp = test.add(test.root, e);
                }
            }
            sum_height += test.height(test.root);
            System.out.println("Height = " + test.height(test.root) + ", Size = " + test.size);
        }
        //Calculate the average height
        System.out.println();
        System.out.println("Average height = " + (double)sum_height/100);
    }
}
