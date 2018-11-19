import java.io.Serializable;
import java.util.Scanner;

public class Administrator implements Serializable {
    private Scanner s;
    private Database dbs;
    public Administrator(Database d)
    {
        dbs = d;
        s = new Scanner(System.in);
    }
    public Database Insert()
    {

        System.out.println("Enter path without spaces");

        String a = s.next();
        //System.out.println(a);
        System.out.println("Enter product name");
        String b = s.next();
        System.out.println("Enter product price");
        int price = s.nextInt();
        System.out.println("Enter product quantity"); 
        int qnt = s.nextInt();
        try{
            dbs.insert(a,b,price,qnt); 
            return dbs;                                      
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return dbs;
    }

    public Database Delete()
    {
        System.out.println("Enter Product to be deleted");
        String a = s.next();
        if ( a.equalsIgnoreCase(""))
            a = s.next();
        try
        {
            dbs.delete(a);
            return dbs;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return dbs;
    }

    public Database Modify()
    {
        System.out.println("Enter Product to be modified");
        String a = s.next();
        if ( a.equalsIgnoreCase(""))
            a = s.next();
        System.out.println("Enter new Price");
        Scanner s = new Scanner(System.in);
        int price = s.nextInt();
        System.out.println("Enter new Quantity ");
        int qty = s.nextInt();
        dbs.modify(a,price,qty);
        return dbs;
    }

    public int  Sale(String a, int b, int c )
    {
        try
        {
            int k = dbs.sale(a,b,c);
            return  k;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage() + " : " + a);
            return c;
        }

    }

    public void Search()
    {
        System.out.println("Enter product to be searched");
        String a  = s.next();
        if ( a.equalsIgnoreCase(""))
            a = s.next();
        try
        {
            Product p = dbs.search(a);
            System.out.println( p.getPath());
            System.out.println("Price : " +  p.getPrice() + " Quantity : " +  p.getQuantity());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
    }
}
