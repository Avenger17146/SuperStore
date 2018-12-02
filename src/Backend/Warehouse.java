package Backend;



import java.io.Serializable;
import java.util.ArrayList;

public class Warehouse implements Serializable {
    private Database db;
    private String Name;
    private String ID;
    private ArrayList<Message> messages;

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
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

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public Warehouse(String name, String ID) {
        Name = name;
        this.ID = ID;
    }
    public String toString()
    {
        return Name;
    }
}
