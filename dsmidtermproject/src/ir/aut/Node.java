package ir.aut;

import java.util.ArrayList;

class Node {
    String name;
    private String model;
    private String explanationsForCostumer;
    private String explanationForAgencies;
    private int expense;
    private Node link;
    int tag;
    private Node dLink;
    String nameAgencies;
    private ArrayList services;
    private int ref;
    private ArrayList order;

    Node() {
        link = null;
        name = null;
        model = null;
        explanationsForCostumer = null;
        explanationForAgencies = null;
        expense = 0;
        tag = 0;
        dLink = null;
        services = new ArrayList<Node>();
        order = new ArrayList<Order>();
    }

    public void setOrder(ArrayList order) {
        this.order = order;
    }

    ArrayList getOrder() {
        return order;
    }

    void setLink(Node n) {
        link = n;
    }

    Node getLink() {
        return link;
    }

    public void setNameAgencies(String nameAgencies) {
        this.nameAgencies = nameAgencies;
    }

    ArrayList getServices() {
        return services;
    }

    int getRef() {
        return ref;
    }

    void setRef(int ref) {
        this.ref = ref;
    }

    public void setServices(ArrayList services) {
        this.services = services;
    }

    String getNameAgencies() {
        return nameAgencies;
    }


    void setdLink(Node dLink) {
        this.dLink = dLink;
    }

    Node getdLink() {
        return dLink;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getExpense() {
        return expense;
    }

    public void setExplanationForAgencies(String explanationForAgencies) {
        this.explanationForAgencies = explanationForAgencies;
    }

    public String getExplanationForAgencies() {
        return explanationForAgencies;
    }

    public void setExplanationsForCostumer(String explanationsForCostumer) {
        this.explanationsForCostumer = explanationsForCostumer;
    }

    public String getExplanationsForCostumer() {
        return explanationsForCostumer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setTag(int t) {
        tag = t;
    }

    public int getTag() {
        return tag;
    }

}
