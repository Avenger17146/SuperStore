package Backend;



import java.io.Serializable;
import java.util.ArrayList;

public class Warehouse implements Serializable {
    private Database db;
    private String Name;
    private int ID;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public Warehouse(String name, int ID) {
        Name = name;
        this.ID = ID;
    }
}
