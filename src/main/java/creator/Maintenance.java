package creator;

import products.Service;

public abstract class Maintenance {

    public void performService() {
        Service service = getService();
        service.perform();
    }

    public abstract Service getService();
}
