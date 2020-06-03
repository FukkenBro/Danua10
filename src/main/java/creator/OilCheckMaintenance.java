package creator;

import products.OilCheck;
import products.Service;

public class OilCheckMaintenance extends Maintenance {

    @Override
    public Service getService() {
        return new OilCheck();
    }
}
