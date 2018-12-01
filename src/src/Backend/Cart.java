package Backend;
import java.io.Serializable;
import java.util.ArrayList;


public class Cart implements Serializable {
    private Database dbs;
    private int funds;
    private String Name;
    ArrayList<Product> plist;
    ArrayList<Integer> qlist;

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds += funds;
    }

    public Cart(Database d, String name )
    {
        dbs = d;
        Name = name;
        plist = new ArrayList<Product>();
        qlist = new ArrayList<Integer>();
    }

    public void add(int id, int qty)
    {
        try
        {
            Product p = dbs.search(id);
            plist.add(p);
            qlist.add(qty);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }

    }

    public Database checkout() throws InsufficientFundsException
    {
        int a = plist.size();
        for ( int i = 0; i<= a-1; i++)
        {
            try
            {
                funds = dbs.sale(plist.get(i),qlist.get(i),funds);
                plist.remove(i);
                if ( funds < 0)
                    throw (new InsufficientFundsException());
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                plist.remove(i);
            }
        }
        return  dbs;
    }
}
