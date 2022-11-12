import java.util.ArrayList;

public class InsertionSort {
    ArrayList<Double> sort(ArrayList<Double> unsorted) {
        int n = unsorted.size();
        for (int i = 0; i < n; i++) {
            double key = unsorted.get(i);
            int j = i - 1;

            while (j >= 0 && unsorted.get(j) > key) {
                unsorted.set(j + 1, unsorted.get(j));
                j = j - 1;
            }
            unsorted.set(j + 1, key);
        }
        return unsorted;
    }


}
