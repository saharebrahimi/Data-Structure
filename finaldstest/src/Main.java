import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        //"C:/Users/ASUS/Desktop/test.csv"
        System.out.println("insert file location");
        Read read =new Read();
        Scanner sc;
        sc = new Scanner(System.in);
        String address = sc.next();
        read.csvReader(address);

        while (true) {
            System.out.println();
            System.out.println("What is your demand? Choose a number from the list below");
            System.out.println("1.RUN LinkedList Quick");
            System.out.println("2.RUN Matrix Quick");
            System.out.println("3.RUN LinkedList Insertion");
            System.out.println("4.RUN Matrix Insertion ");
            System.out.println("5.RUN LinkedList Merge ");
            System.out.println("6.RUN Matrix Merge ");
            System.out.println("7.RUN LinkedList Bubble");
            System.out.println("8.RUN Matrix Bubble ");
            System.out.println("9.RUN LinkedList Optimum Insertion N ");
            System.out.println("10.RUN Matrix Optimum Insertion N");
            System.out.println("11.RUN LinkedList Optimum Bubble N ");
            System.out.println("12.RUN Matrix Optimum Bubble N ");
            System.out.println("13.Exit");
            System.out.println();
            sc = new Scanner(System.in);
            int req = sc.nextInt();
            if (req == 1) {
                read.toAdjacencyList("quick");
            }
            if (req == 2) {
                read.toSparseMatrix("quick");

            }
            if (req == 3) {

                read.toAdjacencyList("insertion");
            }
            if (req == 4) {
                read.toSparseMatrix("insertion");


            }
            if (req == 5) {
                read.toAdjacencyList("merge");

            }
            if (req == 6) {
                read.toSparseMatrix("merge");



            }
            if (req == 7) {
                read.toAdjacencyList("bubble");


            }
            if (req == 8) {
                read.toSparseMatrix("bubble");


            }
            if (req == 9) {
                System.out.println("insert the n");
                sc = new Scanner(System.in);
                int n = sc.nextInt();
                read.toAdjacencyListWithOptimum("optimum",n);

            }
            if (req == 10) {
                System.out.println("insert the n");
                sc = new Scanner(System.in);
                int n = sc.nextInt();
                read.toSparseMatrixWithOptimum("optimum",n);



            }
            if (req == 11) {
                System.out.println("insert the n");
                sc = new Scanner(System.in);
                int n = sc.nextInt();
                read.toAdjacencyListWithOptimum("optimum",n);


            }
            if (req == 12) {
                System.out.println("insert the n");
                sc = new Scanner(System.in);
                int n = sc.nextInt();
                read.toSparseMatrixWithOptimum("optimum",n);



            }
            if (req == 13) {
              break;

            }
    }
}
}
