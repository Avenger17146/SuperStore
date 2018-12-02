package Backend;

import java.io.Serializable;

public class Product implements Serializable {

        protected String Name, path;
        protected int Quantity, Price, ID,H, D, K;



        public String getName() {
            return Name;
        }

        public int getQuantity() {
            return Quantity;
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

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getK() {
        return K;
    }

    public void setK(int k) {
        K = k;
    }

    public Product(String name, int quantity, int price, int ID, int h, int d, int k) {
        Name = name;
       // this.path = path;
        Quantity = quantity;
        Price = price;
        this.ID = ID;
        H = h;
        D = d;
        K = k;
    }

    public void setPath(String path) {
            this.path = path;
        }

        public void setQuantity(int quantity) {
            Quantity = quantity;
        }

        public void setPrice(int price) {
            Price = price;
        }

    public String getPath() {
        return path;
    }

    public int getPrice() {
            return Price;
        }

        public Boolean equals(String a)
        {
            if ( Name.equalsIgnoreCase(a))
                return true;
            else
                return false;
        }
}


