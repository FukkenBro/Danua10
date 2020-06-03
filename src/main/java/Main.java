import creator.Maintenance;
import creator.OilChangeMaintenance;
import creator.OilCheckMaintenance;
import creator.TyresChangeMaintenance;
import report.ReportManager;
import report.ServiceAct;
import report.models.Customer;
import report.models.Product;
import report.models.Worker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public enum type {
        TYRES_CHANGE, OIL_CHANGE, OIL_CHECK
    }

    private static Maintenance maintenance;
    private static String serviceType;
    private static ServiceAct report;
    private static ReportManager rm = ReportManager.getInstance();
    private static Customer customer = new Customer("Mister Customer");
    private static ArrayList<Worker> workers = new ArrayList<>();


    public static void main(String[] args) {
        Worker workerA = new Worker("Alex");
        workers.add(workerA);
        Worker workerB = new Worker("Ben");
        workers.add(workerB);
        configureNewOrder(customer, type.TYRES_CHANGE, workers);
        performService();
        rm.checkout(report);
        System.out.println("\n\n" + report.toString());

    }

    private static void performService() {
        maintenance.performService();
    }

    private static void configureNewOrder(Customer customer, type serviceType, ArrayList<Worker> workers) {
        report = new ServiceAct();
        Scanner scanner = new Scanner(System.in);
        report.setCustomer(customer);
        switch (serviceType.toString()) {
            case "OIL_CHECK":
                maintenance = new OilCheckMaintenance();
                break;

            case "OIL_CHANGE":
                maintenance = new OilChangeMaintenance();
                System.out.println("Purchase oil?  true\\false");
                boolean purchaseOil = scanner.nextBoolean();
                if (purchaseOil) {
                    report.addProduct(new Product(100, "Sunflower Oil"));
                }
                break;

            case "TYRES_CHANGE":
                maintenance = new TyresChangeMaintenance();
                System.out.println("Purchase Tyres?  true\\false");
                boolean purchaseTyres = scanner.nextBoolean();
                if (purchaseTyres) {
                    for (int i = 0; i < 4; i++) {
                        report.addProduct(new Product(500, "Super Wheel"));
                    }
                }
                break;
        }

        report.addService(maintenance.getService());

        for (Worker w : workers) {
            report.addWorker(w);
        }

    }
}