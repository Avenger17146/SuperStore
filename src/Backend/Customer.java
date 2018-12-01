package Backend;

import java.io.*;
import java.util.Scanner;

public class Customer implements Serializable {
    private Cart cart;
    private String name;
    private int funds;
    private Database d;
    Scanner s;

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

    public static Cart DeserializeCU(String a) throws IOException, ClassNotFoundException {
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
    }

    public Cart getCart() {
        return cart;
    }

    public Customer(Database dat, String a)
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
    }

    public void addFunds(int a)
    {
        cart.setFunds(a);

    }

    public void addProduct()
    {
        System.out.println("Enter product name");
        String pro = s.next();
        if ( pro.equalsIgnoreCase(""))
            pro = s.next();
        System.out.println("Enter quantity ");
        int qty = s.nextInt();
        cart.add(pro,qty);

    }

    public Database checkout()
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
    }

    public void write()
    {
        try {
            SerializeCU(cart,name);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
