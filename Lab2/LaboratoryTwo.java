package Lab2;

import java.util.Arrays;

public class LaboratoryTwo {

    /**
     * Name: Francisco Lopez
     * Group code: IIfu-15
     * Student code: 20170478
     */

    //Constants for saving N, M, A and B.
    private static int N = 4;
    private static int M = 78;
    private static int A = 0;
    private static int B = 8;

    public static void main(String[] args) {

        //Creating bi-dimensional array.
        int[][] bidimArray = new int[N][M];

        //Filling and printing bi-dimensional array with random numbers from A to B.
        System.out.println("BI-DIMENSIONAL RANDOM "+N+"x"+M+" ARRAY:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bidimArray[i][j] = (int) (Math.random() * (B + 1 - A) + A);
                System.out.print(bidimArray[i][j] + " ");
                if (j == M - 1) System.out.println();
            }
        }

        //Creating averages array.
        double[] avArray = new double[N];

        //Auxiliary array for storing total sum of each row.
        double[] sum = new double[N];
        for (int i = 0; i < N; i++) sum[i] = 0;

        //Filling and printing averages array with row averages.
        System.out.println("\nROW AVERAGES:");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sum[i] += bidimArray[i][j];
            avArray[i] = sum[i] / M;
            //System.out.println(sum[i]);           Just for testing.//
            System.out.println("Row " + i + " average = " + avArray[i]);
        }

        //Counting how many 'B' are there in the array.
        int count = 0;                              //Auxiliary vble for counting the B's.

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (bidimArray[i][j] == B) count++;

        System.out.println("\nThe number of " + B + "'s in the array is: " + count);


        //TASK 0: Finding and printing maximum value in the averages array excluding 0th element.
        double max = 0;
        for (int i = 1; i < N; i++)
            if (avArray[i] > max) max = avArray[i];
        System.out.println("Task 0: Maximum value in the averages array excluding row "+A+"'s one is: " + max);


        //TASK 4: Showing 0th column sorted values (from min to max).
        int[] ordArray = new int[N];
        for (int i = 0; i < N; i++)
            ordArray[i] = bidimArray[i][0];
        Arrays.sort(ordArray);
        System.out.println("Task 4: Sorted first column values: " + Arrays.toString(ordArray));

        //TASK 7: Counting even values excluding 0th row.
        int counter = 0;
        for (int i=1; i<N; i++)
            for (int j=0; j<M; j++)
                if (bidimArray[i][j]%2==0) counter++;

        System.out.println("Task 7: There are "+counter+" (of the "+M*N+") even numbers, excluding row "+A+".");

        //TASK 8: Counting odd values excluding 0th column.
        int aCount = 0;
        for (int i=0;i<N;i++)
            for (int j=1;j<M;j++)
                if (bidimArray[i][j]%2!=0) aCount++;

        System.out.println("Task 8: There are "+aCount+" (of the "+M*N+") odd numbers, excluding column "+A+".");

    }
}