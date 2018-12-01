package Backend;

import java.io.Serializable;
import java.util.ArrayList;

public class WarehouseAdminList implements Serializable {
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

    public WarehouseAdmin authenticate(String a, String b)
    {
        for ( int i = 0; i<= warehouseAdmins.size()-1; i++)
        {
            if (warehouseAdmins.get(i).getID().equals(a)&&warehouseAdmins.get(i).getPassword().equals(b))
                return warehouseAdmins.get(i);
        }
        return null;
    }
}
