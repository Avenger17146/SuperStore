package Backend;

import java.io.Serializable;
import java.util.ArrayList;

public class WarehouseList implements Serializable {
    private ArrayList<Warehouse> warehouses;

    public WarehouseList(ArrayList<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(ArrayList<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
