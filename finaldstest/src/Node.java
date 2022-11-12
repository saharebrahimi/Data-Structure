class Node {
    String data;
    private Node link;
    public int row;
    public int column;
    public int hasEdge;

    Node() {
        link = null;
        data = null;

    }

    public int getHasEdge() {
        return hasEdge;
    }

    public void setHasEdge(int hasEdge) {
        this.hasEdge = hasEdge;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Node getLink() {
        return link;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
