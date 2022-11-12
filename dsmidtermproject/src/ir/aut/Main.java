package ir.aut;

import java.util.Scanner;

public class Main {
    static Service services;

    public static void main(String[] args) {
        services = new Service();
        Agency agency = new Agency();
        Scanner sc;

        while (true) {

            System.out.println();
            System.out.println("What is your demand? Choose a number from the list below");
            System.out.println("1.add service");
            System.out.println("2.add subService");
            System.out.println("3.add offer");
            System.out.println("4.delete a service from agency");
            System.out.println("5.add agency");
            System.out.println("6.display agencies list");
            System.out.println("7.display all services and subServices");
            System.out.println("8.display subService from specific services");
            System.out.println("9.order specific service to specific agency");
            System.out.println("10.display all orders of specific agency");
            System.out.println("11.exit");
            System.out.println();
            sc = new Scanner(System.in);
            int req = sc.nextInt();
            if (req == 1) {
                System.out.println("insert the name of the service");
                sc = new Scanner(System.in);
                String service = sc.next();
                System.out.println("insert the model");
                sc = new Scanner(System.in);
                String model = sc.next();
                System.out.println("insert explanation for agency");
                sc = new Scanner(System.in);
                String explanationsForAgency = sc.next();
                System.out.println("insert explanation for costumer");
                sc = new Scanner(System.in);
                String explanationsForCostumer = sc.next();
                System.out.println("insert the expense of the service");
                sc = new Scanner(System.in);
                int expense = sc.nextInt();
                services.addServices(service, model, explanationsForCostumer, explanationsForAgency, expense);
            }
            if (req == 2) {
                System.out.println("insert the name of the service");
                sc = new Scanner(System.in);
                String service = sc.next();
                System.out.println("insert the name of the subService");
                sc = new Scanner(System.in);
                String subService = sc.next();
                services.addSubServices(subService, service);

            }
            if (req == 3) {
                System.out.println("insert the name of the service");
                sc = new Scanner(System.in);
                String service = sc.next();
                System.out.println("insert the name of the agency");
                sc = new Scanner(System.in);
                String ag = sc.next();
                agency.addOffer(service, ag);

            }
            if (req == 4) {
                System.out.println("insert the name of the service");
                sc = new Scanner(System.in);
                String service = sc.next();
                System.out.println("insert the name of the agency");
                sc = new Scanner(System.in);
                String ag = sc.next();
                agency.deleteFrom(service, ag);

            }
            if (req == 5) {
                System.out.println("insert the name of the agency");
                sc = new Scanner(System.in);
                String ag = sc.next();
                agency.addAgencies(ag);

            }
            if (req == 6) {
                agency.listAgency();

            }
            if (req == 7) {
                services.listServices();

            }
            if (req == 8) {
                System.out.println("insert the name of the service");
                sc = new Scanner(System.in);
                String service = sc.next();
                services.listServicesFrom(service);

            }
            if (req == 9) {
                System.out.println("insert the name of the service");
                sc = new Scanner(System.in);
                String service = sc.next();
                System.out.println("insert the name of the agency");
                sc = new Scanner(System.in);
                String ag = sc.next();
                System.out.println("insert your name");
                sc = new Scanner(System.in);
                String name = sc.next();
                System.out.println("what is the urgency of your order from 1 to 3? (3 has the highest urgency)");
                sc = new Scanner(System.in);
                int urgency = sc.nextInt();
                agency.order(service, ag, name, urgency);

            }
            if (req == 10) {
                System.out.println("insert the name of the agency");
                sc = new Scanner(System.in);
                String ag = sc.next();
                agency.listOrder(ag);

            }
            if (req == 11) {
                break;

            }


        }
    }
}
