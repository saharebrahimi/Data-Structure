package ir.aut;

class PriorityQueue {
    private int time = 0;
    private int size;
    private Order[] maxHeap;

    PriorityQueue(int capacity) {
        int newCapacity = capacity + 1;
        maxHeap = new Order[newCapacity];
        size = 0;
    }

    void addToQueue(Order order) {

        time++;
        order.setTime(time);
        maxHeap[++size] = order;
        int index = size;
        while (index != 1 && ((order.urgency > maxHeap[index / 2].urgency) || ((order.urgency == maxHeap[index / 2].urgency) && (order.time < maxHeap[index / 2].time)))) {
            maxHeap[index] = maxHeap[index / 2];
            index = index / 2;
        }


        maxHeap[index] = order;
    }

    Order deleteFromQueue() {
        int parent, child;
        Order root, temp;
        if (size == 0) {
            System.out.println("maxheap is empty");
            return null;
        }
        root = maxHeap[1];
        temp = maxHeap[size--];
        parent = 1;
        child = 2;
        while (child <= size) {
            if (child < size && (maxHeap[child].urgency < maxHeap[child + 1].urgency || ((maxHeap[child].urgency == maxHeap[child + 1].urgency) && (maxHeap[child].time > maxHeap[child + 1].time))))
                child++;


            if (temp.urgency > maxHeap[child].urgency || (temp.urgency == maxHeap[child].urgency) && (temp.time <= maxHeap[child].time))
                break;

            maxHeap[parent] = maxHeap[child];

            parent = child;
            child = child * 2;
        }


        maxHeap[parent] = temp;
        return root;
    }
}
