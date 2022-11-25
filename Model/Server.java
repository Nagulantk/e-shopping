package Model;

import java.io.*;
import java.util.ArrayList;

public class Server {
    private ArrayList<Seller> sellerList=new ArrayList<>();
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Customer> customerList=new ArrayList<>();
    private ArrayList<Long> phoneNumberList=new ArrayList<>();
   static Server server=new Server();
    private Server()
    {

    }

    public ArrayList<Seller> getSellerList() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/nagulan-pt6205/Documents/sellerList.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                 System.out.println("i");
            sellerList = (ArrayList<Seller>) objectInputStream.readObject();
            System.out.println("i");
            objectInputStream.close();
        }
        catch (Exception e) {

            System.out.println(e.toString());
        }
        return sellerList;
    }

    public void setSellerList(Seller seller)
    {

        sellerList.add(seller);
        File productListFile=new File("/Users/nagulan-pt6205/Documents/sellerList.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(productListFile);
            ObjectInputStream fin = new ObjectInputStream(fileInputStream);
            ArrayList<Seller> products1 = (ArrayList<Seller>) fin.readObject();
            if(products1==null) {
                FileOutputStream writer = new FileOutputStream(productListFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer);
                objectOutputStream.writeObject(sellerList);
                writer.flush();
                objectOutputStream.flush();
                objectOutputStream.close();
                writer.close();
            }
            else {
                products1.add(seller);
                FileOutputStream writer = new FileOutputStream(productListFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer);
                objectOutputStream.writeObject(products1);
                writer.flush();
                objectOutputStream.flush();
                objectOutputStream.close();
                writer.close();

            }


        }
        catch(Exception e)
        {
            System.out.println("Good");
        }

    }

    public ArrayList<Product> getProductList()
    {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/nagulan-pt6205/Documents/productList.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Product> products1;
            productList = (ArrayList<Product>) objectInputStream.readObject();

            objectInputStream.close();
        }
        catch (Exception e) {

            System.out.println(e.toString());
        }
        return productList;
    }

    public void setProductList(Product product) {
        productList.add(product);
        File productListFile=new File("/Users/nagulan-pt6205/Documents/productList.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(productListFile);
            ObjectInputStream fin = new ObjectInputStream(fileInputStream);
            ArrayList<Product> products1 = (ArrayList<Product>) fin.readObject();
            if(products1==null) {
                FileOutputStream writer = new FileOutputStream(productListFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer);
                objectOutputStream.writeObject(productList);
                writer.flush();
                objectOutputStream.flush();
                objectOutputStream.close();
                writer.close();
            }
            else {
                products1.add(product);
                FileOutputStream writer = new FileOutputStream(productListFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer);
                objectOutputStream.writeObject(products1);
                writer.flush();
                objectOutputStream.flush();
                objectOutputStream.close();
                writer.close();

            }


        }
        catch(Exception e)
        {
            System.out.println("Good");
        }

    }
    public void setProductList(ArrayList<Product> products) {
        productList=products;
    }

    public ArrayList<Long> getPhoneNumberList()
    {
        phoneNumberList=new ArrayList<>();
        File file=new File("/Users/nagulan-pt6205/Documents/phoneNumberList.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String phoneNo=bufferedReader.readLine();
            while(phoneNo!=null)
            {
               phoneNumberList.add(Long.valueOf(phoneNo));
               phoneNo=bufferedReader.readLine();
            }
          bufferedReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return phoneNumberList;
    }
    public void setPhoneNumberList(long phoneNumber)
    {
        phoneNumberList.add(phoneNumber);
        File phoneNumberFile=new File("/Users/nagulan-pt6205/Documents/phoneNumberList.txt");
        try
        {
            phoneNumberFile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(phoneNumberFile,true);

        BufferedWriter  bufferedWriter= new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(String.valueOf(phoneNumber));
        bufferedWriter.newLine();
        bufferedWriter.close();

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }


    public ArrayList<Customer> getCustomerList() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/nagulan-pt6205/Documents/customerList.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            customerList = (ArrayList<Customer>)objectInputStream.readObject();

        }
        catch (Exception e) {

            System.out.println(e.toString());
        }
        return customerList;
    }

    public void setCustomerList(Customer customer) {


        File customerListFile=new File("/Users/nagulan-pt6205/Documents/customerList.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(customerListFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Customer> products1 = (ArrayList<Customer>) objectInputStream.readObject();
                products1.add(customer);
                FileOutputStream writer = new FileOutputStream(customerListFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer);
                objectOutputStream.writeObject(products1);
                writer.flush();
                objectOutputStream.flush();

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    public static Server getServer()
    {
        return server;
    }


}
