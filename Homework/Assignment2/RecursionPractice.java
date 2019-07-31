

public class RecursionPractice {

	public static int recursiveProduct(int m, int n){
		// complete this method
		
	}
	
	public static void findFixedSumPairs(int[] a, int k){
		recursiveFixedSumPairs(/* determine parameters here */);
	}
	
	// this is a recursive method
	private static void recursiveFixedSumPairs(/* determine parameters here */){
		// complete this method
		
	}


	public static void main(String[] args) {
		
		System.out.print("\nRecursive product: ");
		int m, n, p;
		m = 10; n = -20;
		p = recursiveProduct(m, n);		
		System.out.println(m + " times " + n + " is " + p);
		
		System.out.println("\nFixed sum pairs: ");
		int[] a = {1, 5, 8, 11, 12, 14, 15, 20, 21, 22, 23, 25, 28, 30, 34, 36};
		int k;
		k = 60;
		System.out.print("k = " + k + "\na = [");
		for (int i=0; i<a.length-1; i++){
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[a.length-1] + "]\n");
		findFixedSumPairs(a, k);
		System.out.println();
	}

}
