package ir.aut;

class Order {
    private String serviceName;
    int urgency;
    private String costumerName;
    int time;

    Order(String serviceName, int urgency, String costumerName) {
        this.serviceName = serviceName;
        this.urgency = urgency;
        this.costumerName = costumerName;
        time = 0;
    }

    void setTime(int time) {
        this.time = time;
    }

    public String toString() {
        return "serviceName: " + serviceName + "\nPriority : " + urgency + "\ncostumerName : " + costumerName;

    }
}


