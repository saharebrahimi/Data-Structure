import java.util.ArrayList;

public class BubbleSort {
    ArrayList<Double> sort(ArrayList<Double> unsorted)
    {
        int n = unsorted.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)

                if (unsorted.get(j) > unsorted.get(j+1))
                {
                    double temp = unsorted.get(j);

                    unsorted.set(j,unsorted.get(j+1)) ;

                    unsorted.set(j+1,temp) ;
                }
                return unsorted;
    }


}
