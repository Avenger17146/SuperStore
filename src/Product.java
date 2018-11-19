import java.io.Serializable;

public class Product implements Serializable {

        protected String Name, path;
        protected int Quantity, Price;

        public Product(String a, int b, int c)
        {
            Name = a;
            Price = b;
            Quantity = c;
        }

        public String getName() {
            return Name;
        }

        public int getQuantity() {
            return Quantity;
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


