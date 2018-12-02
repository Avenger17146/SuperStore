package Backend;

import java.io.Serializable;
/**
 *Class that defines the Store
 */
public class Store implements Serializable {
    private String Name;
    private String ID;
    private Database db;
    private Warehouse linked;

    public Store(String name, String ID) {
        Name = name;
        this.ID = ID;
        db = new Database();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public Warehouse getLinked() {
        return linked;
    }
    /**
     *link warehouse
     */
    public void setLinked(Warehouse linked) {
        this.linked = linked;
    }

    public String toString()
    {
        return Name;
    }
}
