package Controller;
import java.io.*;

public class GeneratingIDNumbers {
    private  int sellerID;
    private  int productID;
    private int orderID=1;
    private int couponID;
    static GeneratingIDNumbers generatingIDNumbers=new GeneratingIDNumbers();
    private GeneratingIDNumbers()
    {

    }

    public static GeneratingIDNumbers getGeneratingIDNumbers() {
        return generatingIDNumbers;
    }

    public int getSellerID() {
        File sellerIDFile = new File("/Users/nagulan-pt6205/Documents/sellerIDFile.txt");

        try {

            FileReader fileReader=new FileReader(sellerIDFile);
            sellerID=(int)fileReader.read();
            sellerID++;
            FileWriter fileWriter=new FileWriter(sellerIDFile);
            fileWriter.write(sellerID);
            fileWriter.flush();
            fileWriter.close();
            fileReader.close();
        }
        catch(Exception e) {


        }

        return sellerID ;
    }

    public int getProductID()
    {
        File productIDFile = new File("/Users/nagulan-pt6205/Documents/productIDFile.txt");

        try {
            productIDFile.createNewFile();
            FileReader fileReader=new FileReader(productIDFile);
            productID=fileReader.read();
            productID++;
            FileWriter fileWriter=new FileWriter(productIDFile);
            fileWriter.write(productID);
            fileWriter.flush();
            fileWriter.close();
            fileReader.close();
        }
        catch(Exception e) {


        }
        return productID;
    }
    public int getOrderID()
    {
        return orderID++;
    }
    public int getCouponID()
    {
        return couponID++;
    }
}
