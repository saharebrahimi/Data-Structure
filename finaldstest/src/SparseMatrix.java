import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SparseMatrix {
    private int numVertices;
    private Node[] matrix;
    private int count = 0;
    private int max;
    private int start[];
    private ArrayList<Node> newMatrixHalf;
    static ArrayList<Node> newMatrix;
    private ArrayList<Integer> zij;
    private ArrayList<Double> cij;
    private ArrayList<Double> unsorted;
    private String sort;
    private InsertionSort insertionSort;
    private BubbleSort bubbleSort;
    private MergeSort mergeSort;
    private QuickSort quickSort;
    private OptimumSort optimumSort;
    int n = 0;
    FileWriter spars = new FileWriter("matrix.txt", false);
    BufferedWriter mat = new BufferedWriter(spars);


    SparseMatrix(int vertices, int max, String sort) throws IOException {
        this.sort = sort;
        this.matrix = new Node[vertices + 1];
        this.max = max;
        numVertices = vertices;
        for (int i = 0; i <= numVertices; i++) {
            matrix[i] = new Node();
        }


    }

    SparseMatrix(int vertices, int max, String sort, int n) throws IOException {
        this.sort = sort;
        this.matrix = new Node[vertices + 1];
        this.max = max;
        numVertices = vertices;
        for (int i = 0; i <= numVertices; i++) {
            matrix[i] = new Node();
        }
        this.n = n;
    }


    void addEdge(int row, int column) {
        matrix[count].setRow(row);
        matrix[count].setColumn(column);
        count++;
    }

    public Node[] countingSort() {
        int n = matrix.length - 1;
        Node result[] = new Node[n];
        start = new int[max + 1];
        for (int i = 0; i < max + 1; ++i)
            start[i] = 0;

        for (int i = 0; i < n; ++i)
            ++start[matrix[i].getRow()];

        for (int i = 1; i <= max; ++i)
            start[i] += start[i - 1];

        for (int i = 0; i < n; ++i) {
            Node node = new Node();
            node.setRow(matrix[i].getRow());
            node.setColumn(matrix[i].getColumn());
            result[start[matrix[i].getRow()] - 1] = node;
            --start[matrix[i].getRow()];
        }

        return result;
    }

    public void myResult(Node[] result) {
        newMatrixHalf = new ArrayList<>();
        newMatrix = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i].getRow() < result[i].getColumn()) {
                newMatrixHalf.add(result[i]);
            }
        }
        for (int i = 0; i < result.length; i++) {
            {
                newMatrix.add(result[i]);
            }
        }

    }

    public static int start(int vertex) {
        int t = 0;
        for (int i = 0; i < newMatrix.size(); i++) {
            if (newMatrix.get(i).getRow() == vertex) {
                t = i;
                break;

            }


        }
        return t;
    }

    public void z() throws IOException {
        int same = 0;
        zij = new ArrayList<>();
        for (int i = 0; i < newMatrixHalf.size(); i++) {
            same = 0;
            int x = newMatrixHalf.get(i).getRow();
            int y = newMatrixHalf.get(i).getColumn();
            int lenofx = start(x);
            int lenofy = start(y);
            while (lenofx < newMatrix.size() && newMatrix.get(lenofx).getRow() == x) {
                while (lenofy < newMatrix.size() && newMatrix.get(lenofy).getRow() == y) {
                    if (newMatrix.get((lenofx)).getColumn() == newMatrix.get(lenofy).getColumn())
                        same++;
                    lenofy++;
                }
                lenofy = start(y);
                lenofx++;
            }
            zij.add(same);

        }
        mat.newLine();
        mat.write("z:" + zij);

    }


    public void c() {
        cij = new ArrayList<>();
        unsorted = new ArrayList<>();
        for (int i = 0; i < newMatrixHalf.size(); i++) {
            int x = newMatrixHalf.get(i).getRow();
            int y = newMatrixHalf.get(i).getColumn();
            int adjx, adjy, min;
            if (x + 1 > start.length - 1)
                adjx = newMatrix.size() - start(x);
            else
                adjx = start(x + 1) - start(x);
            if (y + 1 > start.length - 1)
                adjy = newMatrix.size() - start(y);
            else
                adjy = start[y + 1] - start[y];
            if (adjx < adjy)
                min = adjx - 1;
            else
                min = adjy - 1;
            double c = ((double) zij.get(i) + 1) / min;
            if (min == 0)
                c = 10000000.0;
            cij.add(c);
            unsorted.add(c);

        }

    }

    public ArrayList<Double> sorting() {
        if (sort.equals("insertion")) {
            insertionSort = new InsertionSort();
            return insertionSort.sort(cij);
        } else if (sort.equals("quick")) {
            quickSort = new QuickSort();
            return quickSort.sort(cij, 0, cij.size() - 1);
        } else if (sort.equals("bubble")) {
            bubbleSort = new BubbleSort();
            return bubbleSort.sort(cij);
        } else if (sort.equals("merge")) {
            mergeSort = new MergeSort();
            return mergeSort.sort(cij, 0, cij.size() - 1);
        } else if (sort.equals("optimum")) {
            optimumSort = new OptimumSort();
            return optimumSort.sort(cij, 0, cij.size() - 1, n);
        } else {
            return cij;
        }

    }

    public void delete(ArrayList<Double> s) throws IOException {
        int temp = 0;
        mat.newLine();
       mat.write("sorted:" + cij);
        mat.newLine();
        mat.write("unsorted:" + s);
        mat.newLine();
        for (int i = 0; i < unsorted.size(); i++) {
            if (s.get(0).equals(unsorted.get(i))) {
                temp = i;
                s.remove(0);
                break;
            }
        }
        int row = newMatrixHalf.get(temp).getRow();
        int column = newMatrixHalf.get(temp).getColumn();
        newMatrixHalf.remove(temp);
        int startrow = start(row);
        int startcoloumn;

        while (newMatrix.get(startrow).getRow() == row) {
            if (newMatrix.get(startrow).getColumn() == column) {
                newMatrix.remove(startrow);
                break;
            } else
                startrow++;
        }
        startcoloumn = start(column);

        while (newMatrix.get(startcoloumn).getRow() == column) {
            if (newMatrix.get(startcoloumn).getColumn() == row) {
                newMatrix.remove(startcoloumn);
                break;
            } else
                startcoloumn++;
        }
        for (int i = 0; i < newMatrix.size(); i++) {
            mat.newLine();
            mat.write(newMatrix.get(i).getRow() + "      " + newMatrix.get(i).getColumn());
            mat.newLine();

        }
    }

    public void last() throws IOException {
        while (BfsSparse.bfs(1)) {
            z();
            c();
            delete(sorting());
            zij.clear();
            cij.clear();
            unsorted.clear();


        }

        mat.flush();
        mat.close();


    }
}


