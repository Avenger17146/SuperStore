package Backend;

public class StoreAdmin {
    public String ID;
    private String password;
    private Store store;

    public StoreAdmin(String ID, String password, Store store) {
        this.ID = ID;
        this.password = password;
        this.store = store;
    }
}
