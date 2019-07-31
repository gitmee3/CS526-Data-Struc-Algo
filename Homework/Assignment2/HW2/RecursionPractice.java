package HW2;

/**
 *
 * @author SHAO
 */
public class RecursionPractice {

    public static void main(String[] args) {
        //Part 1: recursiveProduct() Function
        System.out.println("\nRecursive product: \n");

        int m1 = 10;
        int n1 = 20;
        System.out.println(m1 + " times " + n1 + " is " + recursiveProduct(m1, n1));

        int m2 = -10;
        int n2 = -20;
        System.out.println(m2 + " times " + n2 + " is " + recursiveProduct(m2, n2));

        int m3 = -10;
        int n3 = 20;
        System.out.println(m3 + " times " + n3 + " is " + recursiveProduct(m3, n3));

        int m4 = 10;
        int n4 = -20;
        System.out.println(m4 + " times " + n4 + " is " + recursiveProduct(m4, n4));

        int m5 = 0;
        int n5 = -20;
        System.out.println(m5 + " times " + n5 + " is " + recursiveProduct(m5, n5));

        int m6 = 10;
        int n6 = 0;
        System.out.println(m6 + " times " + n6 + " is " + recursiveProduct(m6, n6));
        
        //Part2: findFixedSumPairs() and recursiveFixedSumPairs() Functions
        System.out.println("\nFixed sum pairs: \n");
        int[] a = {1, 5, 8, 11, 12, 14, 15, 20, 21, 22, 23, 25, 28, 30, 34, 36};
        int k;
        k = 60;
        //Print data set
        System.out.print("k = " + k + "\na = [");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]\n");
        
        //Call findFixedSumPairs() function
        findFixedSumPairs(a, k);
        System.out.println();
    }

    public static int recursiveProduct(int m, int n) {
        //Judgement for m and n (> 0 or < 0)
        if (m > 0 && n > 0) {
            //addition operation
            return m + recursiveProduct(m, n - 1);
        } else if (m < 0 && n < 0) {
            return -m + recursiveProduct(-m, -n - 1);
        } else if (m < 0 && n > 0) {
            return m + recursiveProduct(m, n - 1);
        } else if (m > 0 && n < 0) {
            //exchange m and n
            return recursiveProduct(n, m);
        } else {
            return 0;
        }
    }

    public static void findFixedSumPairs(int[] a, int k) {
        recursiveFixedSumPairs(a, k, 0, a.length - 1);
    }

    private static void recursiveFixedSumPairs(int[] a, int k, int from, int to) {
        // If array size is empty or only one element
        if (from >= to) {
            System.out.println("End, if nothing shown that means no solution.");
            return;
        } else {
            //When a[from] add a[to] equal to K, print pairs
            if (a[from] + a[to] == k) {
                System.out.println("a[" + from + "] = " + a[from] + ", a[" + to + "] = " + a[to]);
            }
            //When a[from] add a[to] less than K, increase 'from' index with 1
            if (a[from] + a[to] < k) {
                recursiveFixedSumPairs(a, k, from + 1, to);
                //When a[from] add a[to] large than K, minus 'to' index with 1
            } else {
                recursiveFixedSumPairs(a, k, from, to - 1);
            }
        }
    }
}
