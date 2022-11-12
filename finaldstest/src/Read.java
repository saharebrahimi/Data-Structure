import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Read {
    private BufferedReader br = null;
    private ArrayList<String> readFromFile = new ArrayList<>();
    private ArrayList<String> edge = new ArrayList<>();
    private ArrayList<String> halfEdge = new ArrayList<>();
    private int max;

    public void csvReader(String address) {

        try {
            br = new BufferedReader(new FileReader(address));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String line = "";
            while ((line = br.readLine()) != null) {
                edge.add(line);
                String[] graph = line.split(",");
                for (String str : graph) {
                    readFromFile.add(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toAdjacencyList(String sort) throws IOException {
        for (int i = 0; i < readFromFile.size() - 1; i = i + 2) {
            if (max < Integer.parseInt(readFromFile.get(i)))
                max = Integer.parseInt(readFromFile.get(i));
        }
        for (int i = 0; i < edge.size(); i++) {
            String temp[] = edge.get(i).split(",");
            if (Integer.parseInt(temp[0]) < Integer.parseInt(temp[1]))
                halfEdge.add(edge.get(i));
        }
        AdjacencyList adjacencyList = new AdjacencyList(max, halfEdge, sort);
        for (int i = 0; i < readFromFile.size() - 1; i = i + 2) {
            adjacencyList.addEdge(Integer.parseInt(readFromFile.get(i)), (readFromFile.get(i + 1)));
        }
        adjacencyList.print();
    }

    public void toAdjacencyListWithOptimum(String sort, int n) throws IOException {
        for (int i = 0; i < readFromFile.size() - 1; i = i + 2) {
            if (max < Integer.parseInt(readFromFile.get(i)))
                max = Integer.parseInt(readFromFile.get(i));
        }
        for (int i = 0; i < edge.size(); i++) {
            String temp[] = edge.get(i).split(",");
            if (Integer.parseInt(temp[0]) < Integer.parseInt(temp[1]))
                halfEdge.add(edge.get(i));
        }
        AdjacencyList adjacencyList = new AdjacencyList(max, halfEdge, sort, n);
        for (int i = 0; i < readFromFile.size() - 1; i = i + 2) {
            adjacencyList.addEdge(Integer.parseInt(readFromFile.get(i)), (readFromFile.get(i + 1)));
        }
        adjacencyList.print();
    }


    public void toSparseMatrix(String sort) throws IOException {
        for (int i = 0; i < edge.size(); i++) {
            String temp[] = edge.get(i).split(",");
            if (Integer.parseInt(temp[0]) < Integer.parseInt(temp[1]))
                halfEdge.add(edge.get(i));
        }


        for (int i = 0; i < readFromFile.size() - 1; i = i + 2) {
            if (max < Integer.parseInt(readFromFile.get(i)))
                max = Integer.parseInt(readFromFile.get(i));
        }
        AdjacencyList adjacencyList = new AdjacencyList(max, halfEdge, sort);
        SparseMatrix sparseMatrix = new SparseMatrix(readFromFile.size() / 2, max, sort);
        for (
                int i = 0; i < readFromFile.size() - 1; i = i + 2)

        {
            sparseMatrix.addEdge(Integer.parseInt(readFromFile.get(i)), Integer.parseInt(readFromFile.get(i + 1)));
        }

        sparseMatrix.myResult(sparseMatrix.countingSort());
        sparseMatrix.last();


    }

    public void toSparseMatrixWithOptimum(String sort, int n) throws IOException {
        for (int i = 0; i < edge.size(); i++) {
            String temp[] = edge.get(i).split(",");
            if (Integer.parseInt(temp[0]) < Integer.parseInt(temp[1]))
                halfEdge.add(edge.get(i));
        }


        for (int i = 0; i < readFromFile.size() - 1; i = i + 2) {
            if (max < Integer.parseInt(readFromFile.get(i)))
                max = Integer.parseInt(readFromFile.get(i));
        }
        AdjacencyList adjacencyList = new AdjacencyList(max, halfEdge, sort);
        SparseMatrix sparseMatrix = new SparseMatrix(readFromFile.size() / 2, max, sort, n);
        for (
                int i = 0; i < readFromFile.size() - 1; i = i + 2)

        {
            sparseMatrix.addEdge(Integer.parseInt(readFromFile.get(i)), Integer.parseInt(readFromFile.get(i + 1)));
        }

        sparseMatrix.myResult(sparseMatrix.countingSort());
        sparseMatrix.last();


    }

}