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

    public void insert(String cat, String pro, int price, int qnt) throws ProductAlredayExistsException
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
        Product p  = temp.findp(pro);
        if ( p != null )
        {
            throw (new ProductAlredayExistsException());
        }
        else
        {

            p = new Product(pro,price,qnt);
            p.setPath(cat);
            temp.getPlist().add(p);
            Products.add(p);
        }
    }

    public void delete(String del) throws InvalidPathException
    {
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
        for ( int i = 1; i<= dels.length-3; i++)
        {
            temp = temp.find(dels[i]);
            if ( temp == null)
            {
                throw(new InvalidPathException());
                //return;
            }
        }
        if ( temp.findp(dels[dels.length-1]) == null && temp.find(dels[dels.length-1])== null )
        {
            throw (new InvalidPathException());
        }
        else if (temp.findp(dels[dels.length-1]) != null)
        {
             temp.getPlist().remove(temp.findp(dels[dels.length-1]));
             Products.remove(temp.findp(dels[dels.length-1]));
        }
        else if (temp.find(dels[dels.length-1])!= null)
        {
            temp.getClist().remove(temp.find(dels[dels.length-1]));
        }
    }

    public int getRevenue() {
        return revenue;
    }

    public Product search(String pro) throws ProductNotFoundException
    {


        for ( int j = 0; j<= Products.size()-1;j++ )
        {
            if ( Products.get(j).getName().equalsIgnoreCase(pro) )
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
                        Products.add(12,new Product("oneplus",24000,10));
                        throw(new ProductNotFoundException());


                    }
                }

                return temp.findp(pro);
            }
        }
        throw(new ProductNotFoundException());
    }

    public void modify(String pro, int price, int qty)
    {
        Product p;
        try {
             p = search(pro);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }

        p.setPrice(price);
        p.setQuantity(qty);
    }

    public int sale (String pro, int qty, int funds) throws UnavailableStockException
    {
        Product p;
        try {
            p = search(pro);
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

