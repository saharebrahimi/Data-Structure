package ir.aut;

class Service {
    private Node start;
    private boolean flag;

    Service() {
        start = null;
        flag = false;
    }

    boolean addServices(String service, String model, String explanationsForCostumer, String explanationsForAgency, int expense) {
        Node ser = new Node();
        ser.setName(service);
        ser.setModel(model);
        ser.setExplanationForAgencies(explanationsForAgency);
        ser.setExplanationsForCostumer(explanationsForCostumer);
        ser.setExpense(expense);
        Node ptr = start;
        while (ptr != null) {
            if (ptr.name.equals(service)) {
                System.out.println("this service already exist");
                return false;
            }

            ptr = ptr.getLink();
        }
        if (start == null) {
            start = ser;
        } else if (start.getLink() == null) {
            start.setLink(ser);
        } else {
            ptr = start.getLink();
            while (ptr.getLink() != null) {
                ptr = ptr.getLink();
            }
            ptr.setLink(ser);
        }
        return true;

    }

    private boolean addSub(String subService, String service, Node p) {
        Node subSer = new Node();
        subSer.setName(subService);
        if (p == null) {
            return false;
        }
        Node q = p;
        while (q != null) {
            if (q.tag == 0) {
                if (q.name.equals(service)) {
                    q.setdLink(subSer);
                    q.setTag(1);
                }

            } else if (q.tag == 1) {
                if (q.name.equals(service)) {
                    Node temp = q.getdLink();
                    while (temp.getLink() != null) {
                        temp = temp.getLink();
                    }
                    temp.setLink(subSer);
                } else

                    addSub(subService, service, q.getdLink());
            }
            q = q.getLink();
        }
        return true;
    }


    private boolean subSearch(String subService, String service, Node p) {
        if (p == null) {
            flag = false;
        }
        Node q = p;
        while (q != null) {
            if (q.tag == 0) {
                if (q.name.equals(service)) {
                    flag = true;
                }
            } else if (q.tag == 1) {
                if (q.name.equals(service)) {
                    Node temp = q.getdLink();
                    while (temp != null) {
                        if (temp.name.equals(subService)) {
                            flag = false;
                            break;
                        }
                        temp = temp.getLink();
                        flag = true;
                    }

                } else
                    subSearch(subService, service, q.getdLink());
            }
            q = q.getLink();
        }
        return flag;

    }

    private Node nodeSearch(String service, Node p) {
        if (p == null) {
            return null;
        }
        Node q = p;
        while (q != null) {
            if (q.name.equals(service)) {
                break;
            }
            q = q.getLink();
        }

        return q;
    }

    Node myNodeSearch(String service) {
        return nodeSearch(service, start);
    }

    boolean addSubServices(String subService, String service) {
        return subSearch(subService, service, start) && addSub(subService, service, start);
    }

    private void printSub(Node p) {
        if (start == null) {
            System.out.println("there is no service");
        }
        while (p != null) {
            if (p.tag == 0) {
                System.out.print("<");
                System.out.print(p.getName());
            } else {
                System.out.print("<");
                System.out.print(p.getName());
                printSub(p.getdLink());

            }

            p = p.getLink();
            System.out.print(">");

        }
    }

    void delete(String name) {
        Node q = start;
        Node p = start.getLink();
        while (p != null) {
            if (start.getName().equals(name)) {
                start = start.getLink();
            }
            if (p.getName().equals(name)) {
                q.setLink(p.getLink());
            }
            q = p;
            p = p.getLink();
        }
    }


    void listServices() {
        printSub(start);
    }


    void listServicesFrom(String service) {
        Node p = myNodeSearch(service);
        if (p == null) {
            System.out.println("this service is not exist");
        } else if (p.getdLink() == null) {
            System.out.println("this service has no subServices");
        } else
            printSub(p.getdLink());
    }


}