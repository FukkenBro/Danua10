package report;

import report.models.Customer;
import report.models.Worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {

    private static ReportManager instance;
    private HashMap<Integer, ServiceAct> reports = new HashMap<>();

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    void addReport(ServiceAct report) {
        reports.put(report.getId(), report);
    }

    public void checkout(ServiceAct report) {
        report.setOrderStatus(ServiceAct.status.CLOSED);
    }

    public ArrayList<ServiceAct> getReportsByCustomer(Customer customer) {
        ArrayList<ServiceAct> result = new ArrayList<>();
        for (Map.Entry<Integer, ServiceAct> entry : reports.entrySet()) {
            if (entry.getValue().getCustomer().equals(customer)) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public ArrayList<ServiceAct> getReportsByWorker(Worker worker) {
        ArrayList<ServiceAct> result = new ArrayList<>();
        for (Map.Entry<Integer, ServiceAct> entry : reports.entrySet()) {
            for (Worker w : entry.getValue().getWorkers()) {
                if (w.equals(worker)) {
                    result.add(entry.getValue());
                }
            }
        }
        return result;
    }

}
