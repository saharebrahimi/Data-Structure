import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class AdjacencyList {
    private int numVertices;
    static Node adjLists[];
    private ArrayList<Integer> z = new ArrayList<Integer>();
    private ArrayList<Double> c = new ArrayList<Double>();
    private ArrayList<Double> unsorted = new ArrayList<Double>();
    private ArrayList<String> edge;
    private int numberOfAdj[];
    private String sort;
    private InsertionSort insertionSort;
    private BubbleSort bubbleSort;
    private MergeSort mergeSort;
    private QuickSort quickSort;
    private OptimumSort optimumSort;
    private int n = 0;
    private FileWriter remove = new FileWriter("remove.txt", false);
    private BufferedWriter re = new BufferedWriter(remove);


    AdjacencyList(int vertices, ArrayList edge, String sort) throws IOException {

        this.sort = sort;
        numVertices = vertices;
        this.edge = edge;
        adjLists = new Node[vertices + 1];
        numberOfAdj = new int[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            adjLists[i] = new Node();
            adjLists[i].data = String.valueOf(i);
        }

    }

    AdjacencyList(int vertices, ArrayList edge, String sort, int n) throws IOException {

        this.n = n;
        this.sort = sort;
        numVertices = vertices;
        this.edge = edge;
        adjLists = new Node[vertices + 1];
        numberOfAdj = new int[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            adjLists[i] = new Node();
            adjLists[i].data = String.valueOf(i);
        }

    }

    public void add(int src, String dest) {
        Node data = new Node();
        data.setData(dest);
        Node ptr;
        if (adjLists[src].getLink() == null) {
            adjLists[src].setHasEdge(1);
            adjLists[src].setLink(data);
        } else {
            ptr = adjLists[src].getLink();
            while (ptr.getLink() != null) {
                ptr = ptr.getLink();
            }
            ptr.setLink(data);
        }

    }

    void addEdge(int src, String dest) {
        add(src, dest);

    }

    public void findTheNumber() {
        int count = 0;
        for (int i = 0; i < edge.size(); i++) {
            String[] split = edge.get(i).split(",");
            Node p = adjLists[Integer.parseInt(split[0])].getLink();
            Node q = adjLists[Integer.parseInt(split[1])].getLink();
            while (p != null) {
                while (q != null) {
                    if (q.data.equals(p.data)) {
                        count++;
                    }
                    q = q.getLink();
                }
                q = adjLists[Integer.parseInt(split[1])].getLink();
                p = p.getLink();
            }

            z.add(count);
            count = 0;

        }

    }

    public void numOfAdj() {
        int num = 0;
        for (int i = 1; i <= numVertices; i++) {
            Node p = adjLists[i].getLink();
            if (p == null)
                numberOfAdj[i] = 0;
            while (p != null) {
                num++;
                p = p.getLink();
            }
            numberOfAdj[i] = num;
            num = 0;

        }

    }

    public ArrayList<Double> c() {
        double cij;
        for (int i = 0; i < edge.size(); i++) {
            String[] split = edge.get(i).split(",");
            int min;
            if (numberOfAdj[Integer.parseInt(split[0])] < numberOfAdj[Integer.parseInt(split[1])])
                min = numberOfAdj[Integer.parseInt(split[0])] - 1;
            else
                min = numberOfAdj[Integer.parseInt(split[1])] - 1;


            cij = ((double) z.get(i) + 1) / (min);
            if (min == 0)
                cij = 10000000.0;
            unsorted.add(cij);
            c.add(cij);

        }

        return c;
    }

    public ArrayList<Double> sorting() {
        if (sort.equals("insertion")) {
            insertionSort = new InsertionSort();
            return insertionSort.sort(c);
        } else if (sort.equals("bubble")) {
            bubbleSort = new BubbleSort();
            return bubbleSort.sort(c);
        } else if (sort.equals("merge")) {
            mergeSort = new MergeSort();
            return mergeSort.sort(c, 0, c.size() - 1);
        } else if (sort.equals("quick")) {
            quickSort = new QuickSort();
            return quickSort.sort(c, 0, c.size() - 1);
        } else if (sort.equals("optimum")) {
            optimumSort = new OptimumSort();
            return optimumSort.sort(c, 0, c.size() - 1, n);
        } else {
            return c;
        }


    }

    public String[] delete(ArrayList<Double> s) throws IOException {

        int temp = 0;
        for (int i = 0; i < unsorted.size(); i++) {
            if (s.get(0).equals(unsorted.get(i))) {
                temp = i;
                s.remove(0);
                break;
            }
        }
        String[] yall = edge.get(temp).split(",");
        re.newLine();
        re.write(yall[0]);
        re.write("        ");
        re.write((yall[1]));
        re.newLine();
        Node first = adjLists[Integer.parseInt(yall[0])];
        Node second = adjLists[Integer.parseInt(yall[1])];
        numberOfAdj[Integer.parseInt(yall[0])]--;
        numberOfAdj[Integer.parseInt(yall[1])]--;
        edge.remove(temp);
        unsorted.remove(temp);
        z.remove(temp);

        Node p = first;
        Node q = first.getLink();
        Node r = second;
        Node w = second.getLink();

        while (q != null) {
            if (q.getData().equals(second.getData())) {
                p.setLink(q.getLink());
                break;
            }
            p = q;
            q = q.getLink();
        }
        while (w != null) {
            if (w.getData().equals(first.getData())) {
                r.setLink(w.getLink());
                break;
            }
            r = w;
            w = w.getLink();

        }
        return yall;


    }

    public int source() {
        int t = 0;
        for (int i = 1; i <= numVertices; i++) {
            if (adjLists[i].hasEdge == 1) {
                t = i;
                break;
            }
        }
        return t;

    }

    public String[] last() throws IOException {
        String[] yall = new String[0];
        while (CheckBfs.bfs(source())) {
            findTheNumber();
            re.write("z:" + z);
            numOfAdj();
            re.newLine();
            re.write("number of agency : ");
            re.newLine();
            for (int i = 1; i < numberOfAdj.length; i++)
                re.write(numberOfAdj[i] + "  ");
            re.newLine();
            re.write("has edge : ");
            for (int i = 1; i < adjLists.length; i++)
                re.write(adjLists[i].getHasEdge() + "  ");
            re.newLine();
            c();
            re.write("unsorted:" + unsorted);
            yall = delete(sorting());
            z.clear();
            c.clear();
            unsorted.clear();


        }
        re.flush();
        re.close();
        return yall;

    }


    public void print() throws IOException {
        FileWriter writer;
        long startTime = System.currentTimeMillis();
        writer = new FileWriter("Result.txt", false);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String yall[] = last();
        int visited1[] = CheckBfs.visited(Integer.parseInt(yall[0]));
        int visited2[] = CheckBfs.visited(Integer.parseInt(yall[1]));
        for (int i = 0; i < visited1.length; i++) {
            if (visited1[i] == 1) {

                bufferedWriter.write("#" + i + " : " + "A");
                bufferedWriter.newLine();
            }
        }
        for (int i = 0; i < visited2.length; i++) {
            if (visited2[i] == 1) {
                bufferedWriter.write("#" + i + " : " + "B");
                bufferedWriter.newLine();
            }
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        bufferedWriter.write("total time" + " : " + totalTime);


        bufferedWriter.close();


    }


}

