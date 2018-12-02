package Backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Database implements Serializable {
    protected ArrayList<Category> Categories;
    protected ArrayList<Product> Products;
    protected int revenue;

    public Database()
    {
        Categories = new ArrayList<Category>();
        Products = new ArrayList<Product>();
        revenue =0;
    }
    public Category find(String a)
    {
        for ( int j = 0; j<= Categories.size()-1;j++ )
        {
            if ( Categories.get(j).getName().equalsIgnoreCase(a) )
            {
                return Categories.get(j);
            }
        }
        return null;
    }

    public void insert(String cat, Product pro) throws ProductAlredayExistsException
    {
        String[] cats = cat.split(">");
        Category temp;
        temp = find(cats[0]);
        if ( temp == null)
        {
            Categories.add(new Category(cats[0]));
            temp = find(cats[0]);
        }
        for ( int i = 1; i<= cats.length-1; i++)
        {
            Category x;
            x = temp.find(cats[i]);
            if ( x == null)
            {
                temp.getClist().add(new Category(cats[i]));
                temp = temp.find(cats[i]);
            }
        }
        Product p  = temp.findp(pro.getID());
        if ( p != null )
        {
            throw (new ProductAlredayExistsException());
        }
        else
        {

            p.setPath(cat);
            temp.getPlist().add(p);
            Products.add(p);
        }
    }

    public void delete(Product pro) throws InvalidPathException
    {
        String del = pro.getPath();
        String[] dels = del.split(">");
        Category temp;
        temp = find(dels[0]);
        if ( temp == null)
        {
            throw(new InvalidPathException());
            //return;
        }
        if ( dels.length == 1)
        {
            Categories.remove(find(dels[0]));
            return;
        }
        for ( int i = 1; i<= dels.length-2; i++)
        {
            temp = temp.find(dels[i]);
            if ( temp == null)
            {
                throw(new InvalidPathException());
                //return;
            }
        }
       /* if ( temp.findp(dels[dels.length-1]) == null && temp.find(dels[dels.length-1])== null )
        {
            throw (new InvalidPathException());
        }*/
        if (temp.findp(pro.getID()) != null)
        {
             temp.getPlist().remove(temp.findp(pro.getID()));
             Products.remove(temp.findp(pro.getID()));
        }
        else if (temp.find(dels[dels.length-1])!= null)
        {
            temp.getClist().remove(temp.find(dels[dels.length-1]));
        }
    }

    public int getRevenue() {
        return revenue;
    }

    public Product search(int id) throws ProductNotFoundException
    {


        for ( int j = 0; j<= Products.size()-1;j++ )
        {
            if ( Products.get(j).getID() == id )
            {
                String src = Products.get(j).getPath();
                String[] dels = src.split(">");
                Category temp;
                temp = find(dels[0]);
                if ( temp == null)
                {
                    throw(new ProductNotFoundException());
                }
                for ( int i = 1; i<= dels.length-1; i++)
                {
                    temp = temp.find(dels[i]);
                    if ( temp == null)
                    {
                        throw(new ProductNotFoundException());
                    }
                }

                return temp.findp(id);
            }
        }
        throw(new ProductNotFoundException());
    }

    public void modify(Product pro, Product n)
    {
        Product p;
        try {
             p = search(pro.getID());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }

        p = pro;
    }

    public int sale (Product pro, int qty, int funds) throws UnavailableStockException
    {
        Product p;
        try {
            p = search(pro.getID());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() +" : "+ pro);
            return funds;
        }
        System.out.println(p.getQuantity() + " " + qty);
        if ( p.getQuantity() < qty)
            throw (new UnavailableStockException());
        funds= funds - p.getPrice()*qty;

        if ( funds >= 0)
        {
            p.setQuantity(p.getQuantity()-qty);
            revenue+= p.getPrice()*qty;
            System.out.println(revenue);
        }

        return funds;
    }

}

