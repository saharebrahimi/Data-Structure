import java.util.ArrayList;

public class MergeSort {

    public ArrayList<Double> sort(ArrayList<Double> unsorted, int low, int high) {
        if (low < high) {

            int middle = (low + high) / 2;

            sort(unsorted, low, middle);

            sort(unsorted, middle + 1, high);

            merge(unsorted, low, middle, high);
        }
        return unsorted;
    }

    void merge(ArrayList<Double> unsorted, int low, int middle, int high) {
        double[] temp = new double[unsorted.size()];
        for (int i = low; i <= high; i++) {
            temp[i] = unsorted.get(i);
        }

        int tempLeft = low;
        int tempRight = middle + 1;
        int current = low;

        while (tempLeft <= middle && tempRight <= high) {

            if (temp[tempLeft] <= temp[tempRight]) {

                unsorted.set(current, temp[tempLeft]);
                tempLeft++;

            } else {
                unsorted.set(current, temp[tempRight]);


                tempRight++;
            }
            current++;
        }

        int remain = middle - tempLeft;
        for (int i = 0; i <= remain; i++) {

            unsorted.set(current + i, temp[tempLeft + i]);
        }
    }


}
