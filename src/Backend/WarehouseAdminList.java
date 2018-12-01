package Backend;

import java.util.ArrayList;

public class WarehouseAdminList {
    private ArrayList<WarehouseAdmin> warehouseAdmins;

    public WarehouseAdminList()
    {
        warehouseAdmins = new ArrayList<WarehouseAdmin>();
    }

    public WarehouseAdminList(ArrayList<WarehouseAdmin> warehouseAdmins) {
        this.warehouseAdmins = warehouseAdmins;
    }

    public ArrayList<WarehouseAdmin> getWarehouseAdmins() {
        return warehouseAdmins;
    }

    public void setWarehouseAdmins(ArrayList<WarehouseAdmin> warehouseAdmins) {
        this.warehouseAdmins = warehouseAdmins;
    }
}
