import java.util.ArrayList;

public class QuickSort {

    int part(ArrayList<Double> unsorted, int low, int high) {
        double pivot = unsorted.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {


            if (unsorted.get(j) <= pivot) {
                i++;
                double temp = unsorted.get(i);

                unsorted.set(i, unsorted.get(j));

                unsorted.set(j, temp);
            }
        }

        double temp = unsorted.get(i + 1);

        unsorted.set(i + 1, unsorted.get(high));

        unsorted.set(high, temp);
        return i + 1;
    }

    ArrayList<Double> sort(ArrayList<Double> unsorted, int low, int high) {
        if (low < high) {
            int t = part(unsorted, low, high);

            sort(unsorted, low, t- 1);

            sort(unsorted, t + 1, high);
        }
        return unsorted;
    }


}
