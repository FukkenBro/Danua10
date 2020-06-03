package creator;

import products.OilChange;
import products.Service;

public class OilChangeMaintenance extends Maintenance {
    @Override
    public Service getService() {
        return new OilChange();
    }
}
