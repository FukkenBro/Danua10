package report;

import products.Service;
import report.models.Customer;
import report.models.Product;
import report.models.Worker;

import java.util.ArrayList;

public class ServiceAct {
    public enum status {
        OPEN, CLOSED
    }

    private status orderStatus;
    private int id;
    private Customer customer;
    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public ServiceAct() {
        ReportManager rm = ReportManager.getInstance();
        this.id = (int) System.currentTimeMillis();
        this.orderStatus = status.OPEN;
        rm.addReport(this);
    }

    public void setOrderStatus(status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        double total = 0;
        sb.append("Act#").append(id);
        sb.append("\n\nOrder status: ").append(orderStatus.toString());
        sb.append("\n\nCustomer: ").append(customer);
        sb.append("\n\nService: ");
        for (Service service : services) {
            sb.append("\n").append(service.getClass().getSimpleName()).append(" .......... ");
            sb.append(service.getPrice());
            total += service.getPrice();
        }
        sb.append("\n\nProducts: ");
        for (Product product : products) {
            sb.append("\n").append(product.getProductName()).append(" .......... ");
            sb.append(product.getPrice());
            total += product.getPrice();
        }
        sb.append("\n\nWorkers: ");
        for (Worker worker : workers) {
            sb.append("\n").append(worker.getName());
        }
        sb.append("\n\n_____________________________________________");
        sb.append("\nOrder total: .................... ").append(total);
        return sb.toString();
    }
}
