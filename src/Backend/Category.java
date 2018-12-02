package Backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable, Comparable<Category> {
    protected String Name;
    protected ArrayList<Product> Plist;
    protected ArrayList<Category> Clist;

    public ArrayList<Product> getpList(){return Plist;}
    public ArrayList<Category> getcList() {return Clist; }

    public Category( String a, Category b )
    {
        Name = a;
        Plist = new ArrayList<Product>();
        Clist = new ArrayList<Category>();
        Clist.add(b);
    }

    public Category( String a, Product b )
    {
        Name = a;
        Plist = new ArrayList<Product>();
        Clist = new ArrayList<Category>();
        Plist.add(b);
    }

    public Category(String a)
    {
        Name = a;
        Plist = new ArrayList<Product>();
        Clist = new ArrayList<Category>();
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Product> getPlist() {
        return Plist;
    }

    public ArrayList<Category> getClist() {
        return Clist;
    }



    public Category find(String a)
    {
        for ( int j = 0; j<= Clist.size()-1;j++ )
        {
            if ( Clist.get(j).getName().equalsIgnoreCase(a) )
            {
                return Clist.get(j);
            }
        }
        return null;
    }
    public Product findp(String a)
    {
        for ( int j = 0; j<= Plist.size()-1;j++ )
        {
            if ( Plist.get(j).getID().equals(a) )
            {
                return Plist.get(j);
            }
        }
        return null;
    }
    public int compareTo(Category a)
    {
        return a.getName().compareTo(this.Name);
    }

    public Boolean eqauls(Category a)
    {
        return (a.getName().equalsIgnoreCase(Name));

    }
}
