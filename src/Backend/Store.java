package Backend;

import java.io.Serializable;

public class Store implements Serializable {
    private String Name;
    private String ID;
    private Database db;
    private Warehouse linked;

    public Store(String name, String ID) {
        Name = name;
        this.ID = ID;
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

    public void setLinked(Warehouse linked) {
        this.linked = linked;
    }
}
