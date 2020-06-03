package creator;

import products.Service;
import products.TyresChange;

public class TyresChangeMaintenance extends Maintenance {
    @Override
    public Service getService() {
        return new TyresChange();
    }
}
