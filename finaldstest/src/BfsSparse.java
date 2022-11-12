
public class BfsSparse {
        private static Node[] vertices = AdjacencyList.adjLists;
        private static MakeQueue makeQueue = new MakeQueue(vertices.length);

        public static boolean bfs(int source) {

            int nodes = vertices.length - 1;

            int[] visited = new int[nodes + 1];

            int i, element;
            visited[source] = 1;
            makeQueue.addTOQueue(source);
            while (!makeQueue.isEmpty()) {
                element = makeQueue.remove();
                i = 1;
                while (i <= nodes) {
                    if (hasAdjacency(element, i) && visited[i] == 0) {
                        makeQueue.addTOQueue(i);
                        visited[i] = 1;
                    }
                    i++;
                }

            }
            int num=0;
            for(int j =1; j<vertices.length ; j++)
                if(visited[j]==1 )
                    num++;
            return num == vertices.length - 1;
        }




    public static Boolean hasAdjacency(int ver, int adj) {
            int star = SparseMatrix.start(ver);
            while (SparseMatrix.newMatrix.get(star).getRow() == ver&& star<SparseMatrix.newMatrix.size()-1) {

                if (SparseMatrix.newMatrix.get(star).getColumn() == adj)
                    return true;
                else
                    star++;

            }
            return false;
        }



    }


