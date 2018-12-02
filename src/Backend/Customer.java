package Backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *defines the functions of a customer
 */
public class Customer implements Serializable {
    private Cart Plist;
    private String name;
    private int funds;
    private StoreList Slist;
    private Store store;

    private ArrayList<Integer> qty = new ArrayList<Integer>();

    public Cart getPlist() {
        return Plist;
    }

    public void setPlist(Cart plist) {
        Plist = plist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public StoreList getSlist() {
        return Slist;
    }

    public void setSlist(StoreList slist) {
        Slist = slist;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    private ArrayList<Product> cart = new ArrayList<Product>();

    /**
     *constructor
     */
    public Customer()
    {
        try{
            Deserial();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     *deserialisning store list
     */
    public void Deserial()
    {
        ObjectInputStream inputStream = null;

        try{
            inputStream = new ObjectInputStream(new FileInputStream("Stores"+".dat"));
            Slist = (StoreList) inputStream.readObject();
            inputStream.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {

        }
    }
    /**
     *for bonus implementation
     */
    public void addFunds(int fund)
    {
        funds = fund;
    }

    public Boolean addProduct(Product pro, int qty)
    {
        if (pro.getQuantity()>= qty)
        {
            cart.add(pro);
            this.qty.add(qty);
            return true;
        }
        return false;
    }
    /**
     *removing product from cart
     */
    public void removeProduct(Product pro)
    {
        for ( int i = 0 ; i<= cart.size()-1; i++)
        {
            if ( pro.getID() == cart.get(i).getID())
                cart.remove(i);
        }
    }
    /**
     *checking out cart
     */
    public int checkOut()
    {
        int flag  = 0;
        for ( int i = 0; i<= cart.size()-1; i++ )
        {
            if ( qty.get(i)> cart.get(i).getQuantity())
            {
                return  -1;
            }
            funds  = funds - cart.get(i).getPrice()*qty.get(i);
            if ( funds < 0)
                flag = 1;
        }
        for ( int i = 0; i<= cart.size()-1; i++ )
        {
            cart.get(i).setQuantity(-qty.get(i)+ cart.get(i).getQuantity());
            if ( cart.get(i).getQuantity() < 0)
            {
                for ( int j = 0 ; j<= i; j++)
                    cart.get(i).setQuantity(qty.get(i)+ cart.get(i).getQuantity());
                return -1;
            }
        }
        for ( int i = 0; i<= cart.size()-1; i++)
            cart.remove(0);
        if ( flag ==  1)
            return 0;
        return 1;
    }





   /* public static Cart DeserializeCU(String a) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = null;
        Cart db = null;

        try{
            inputStream = new ObjectInputStream(new FileInputStream(a+".dat"));
            db = (Cart) inputStream.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            inputStream.close();
        }

        return db;
    }*/



    //public Cart getCart() {
     /*   return cart;
    }
*/
    /*public Customer(Database dat, String a)
    {
        d = dat;
        name =  a;
        funds = 0;
        try
        {
            cart = DeserializeCU(name);
        }
        catch ( Exception e )
        {
            System.out.println(e.getMessage());
            cart = new Cart(d,name);
        }
        if ( cart == null) cart = new Cart(d,a);
        s = new Scanner(System.in);
    }*/


    /*public void addFunds(int a)
    {
        cart.setFunds(a);

    }*/
/*

    public void addProduct(int id, int qty)
    {
        */
/*System.out.println("Enter product name");
        String pro = s.next();
        if ( pro.equalsIgnoreCase(""))
            pro = s.next();
        System.out.println("Enter quantity ");
        int qty = s.nextInt();*//*

        cart.add(id,qty);

    }
*/

   /* public Database checkout()
    {
        try
        {
           d =  cart.checkout();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return d;
        }
        return d;
    }*/
/*
    public void write()
    {
        try {
            SerializeCU(cart,name);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }*/
}

/*
    public static void SerializeCU(Cart db, String a) throws IOException {
        ObjectOutputStream oStream = null;

        try {
            oStream = new ObjectOutputStream(new FileOutputStream(a+".dat"));
            oStream.writeObject(db);
            System.out.println("File saved");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            oStream.close();
        }
    }
*/