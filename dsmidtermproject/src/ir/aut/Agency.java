package ir.aut;

import static ir.aut.Main.services;

class Agency {
    private Node start;

    Agency() {
        start = null;
    }

    private Node nodeSearch(String service, Node p) {
        if (p == null) {
            return null;
        }
        Node q = p;
        while (q != null) {
            if (q.nameAgencies.equals(service)) {
                break;
            }
            q = q.getLink();
        }
        return q;
    }

    private Node myNodeSearch(String service) {
        return nodeSearch(service, start);
    }

    boolean addOffer(String service, String Agencies) {
        Node ser = services.myNodeSearch(service);
        Node agencies = myNodeSearch(Agencies);
        if (agencies != null && ser != null) {
            if (agencies.getServices().contains(ser)) {
                System.out.println("this agency already present this order");
                return false;
            } else {
                int num = ser.getRef();
                num++;
                ser.setRef(num);
                agencies.getServices().add(ser);


                return true;
            }
        } else {
            System.out.println("service or agency not exist");
            return false;
        }
    }

    void listAgency() {
        Node p = start;
        if(p==null)
            System.out.println("there is no agency ");
        while (p != null) {
            System.out.println(p.getNameAgencies());
            p = p.getLink();
        }

    }

    boolean addAgencies(String agency) {
        Node ag = new Node();
        ag.nameAgencies = agency;
        Node ptr = start;
        while (ptr != null) {
            if (ptr.nameAgencies.equals(agency))
                return false;
            ptr = ptr.getLink();
        }
        if (start == null) {
            start = ag;
        } else if (start.getLink() == null) {
            start.setLink(ag);
        } else {
            ptr = start.getLink();
            while (ptr.getLink() != null) {
                ptr = ptr.getLink();
            }
            ptr.setLink(ag);
        }
        return true;
    }

    boolean deleteFrom(String service, String agency) {
        Node agencies = myNodeSearch(agency);
        Node serv = services.myNodeSearch(service);

        if (agencies == null) {
            System.out.println("this agency not exist");
            return false;
        }
        if (serv == null) {
            System.out.println("this service not exist");
            return false;
        }
        int temp = serv.getRef();

        if (serv.getRef() != 1) {
            if (agencies.getServices().contains(serv)) {
                temp--;
                serv.setRef(temp);
                agencies.getServices().remove(serv);
                return true;
            } else
                System.out.println("this agency doesn't present this service");
            return false;


        } else {
            {
                if (agencies.getServices().contains(serv)) {
                    agencies.getServices().remove(serv);
                    services.delete(service);
                    return true;
                } else
                    System.out.println("this agency doesn't present this service");
                return false;

            }

        }


    }

    void order(String service, String agency, String costumer, int urgency) {
        Order order = new Order(service, urgency, costumer);
        Node agencies = myNodeSearch(agency);
        Node ser = services.myNodeSearch(service);
        if (agencies == null) {
            System.out.println("This agency doesn't exist");
        } else if (agencies.getServices().contains(ser))
            agencies.getOrder().add(order);
        else
            System.out.println("this agency doesn't present this service");
    }

    void listOrder(String agency) {
        Node agencies = myNodeSearch(agency);
        if (agencies == null) {
            System.out.println("This agency doesn't exist");
        } else {
            PriorityQueue pq = new PriorityQueue(agencies.getOrder().size());
            for (int i = 0; i < agencies.getOrder().size(); i++) {
                Order temp = (Order) agencies.getOrder().get(i);
                pq.addToQueue(temp);
            }
            for (int i = 0; i < agencies.getOrder().size(); i++) {
                Order print = pq.deleteFromQueue();
                System.out.println(print);


            }
        }
    }
}
