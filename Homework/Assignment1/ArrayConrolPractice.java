package HW1;

/**
 *
 * @author SHAO
 */
public class ArrayConrolPractice {

    public static void main(String[] args) {
        //sumOfEvenNumbers() Method Test
        System.out.println("Function: sumOfEvenNumbers()");
        System.out.println("n = 100, return " + sumOfEvenNumbers(100));
        System.out.println("n = 200, return " + sumOfEvenNumbers(200));

        System.out.println();

        //allDistinct() Method Test
        System.out.println("Function: allDistinct()");
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 5, 8, 1, 15, 16, 17, 18, 19, 2};
        System.out.println("distinct(true) / deplicate(false): " + allDistinct(test1));

        int[] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println("distinct(true) / deplicate(false): " + allDistinct(test2));

        System.out.println();

        //statistics() Method Test
        System.out.println("Function: statistics()");
        double[] test3 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        double[] result3 = statistics(test3); //Call statistics() function
        System.out.print("10 double numbers, return (max, min, average): ");
        //Print result array
        for (int i = 0; i < 3; i++) {
            System.out.print(result3[i] + " ");
        }

        System.out.println();

        double[] test4 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0};
        double[] result4 = statistics(test4); //Call statistics() function
        System.out.print("15 double numbers, return (max, min, average): ");
        //Print result array
        for (int i = 0; i < 3; i++) {
            System.out.print(result4[i] + " ");
        }
    }

    public static int sumOfEvenNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            //if i is even
            if (i % 2 == 0) {
                //add into sum variable
                sum += i;
            }
        }
        return sum;
    }

    public static boolean allDistinct(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                //if there exists same value with different array index, deplicate
                if ((arr[i] == arr[j]) && (i != j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double[] statistics(double[] arr) {
        double[] result = new double[3];
        //Check array is empty or not
        if (arr.length == 0) {
            System.out.println("Input is empty!");
        } else {
            double min = arr[0];
            double max = arr[0];
            double sum = 0.0;
            
            //When array only has one element
            if (arr.length == 1) {
                result[0] = arr[0];
                result[1] = arr[0];
                result[2] = arr[0];
                return result;
            }
            for (int i = 0; i < arr.length; i++) {
                //find max value
                if (arr[i] > max) {
                    max = arr[i];
                }
                //find min value
                if (arr[i] < min) {
                    min = arr[i];
                }
                //calculate the sum
                sum += arr[i];
            }

            result[0] = max;
            result[1] = min;
            result[2] = sum / arr.length; //calculate average
        }
        return result;
    }
}
