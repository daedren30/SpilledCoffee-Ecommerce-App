/**
 * The finance, marketing, and sales departments want to understand customers better but need the historical data to do so.
 * They want to have a database/pseudo-DB that stores all of the customer order
 * information along with the time and date of their orders.
 * [This database will grow each simulated “day”.]
 *
 * This will program will function as a database that the employee is able to:
 *
 * **View the inventory of the product**
 *   -- This will allow the user to look product inventory
 *
 * **Placing the order of the product
 *   -- This will have the employee place an order for the customer.
 *   -- Review the order
 *   -- Adding confirmation to the user if the data is correct
 *
 * **Cancelling the order of the product
 *   -- Will view the previous order made by the customer
 *   -- Have the order be cancelled by also adding in confirmation
 *
 * **Viewing the orders made within the database as similar to (LookUP from previous sprint)
 *   -- Will search the database by finding the product ID and user_email
 *   -- View the current order
 *
 * **Print the receipt to the employee or customer
 *   -- Print customer order
 *   ** Format depends on who ever works on it **
 *
 *   example:
 *   ----------------------------------------------------
 *   QTY | DESCRIPTION            | UNIT PRICE | AMOUNT |
 *   ----------------------------------------------------
 *    1  | Hawaiian Blend         | $2.50      |    25
 *    2  | Arabic Blend           | $0.50      |    53
 *    3  | Jamaican Blend         | $1.75      |    23
 *
 *
 *
 *                                Subtotal:       $129.25
 *                                Sales Tax 0.5%  $6.46
 *                                Total:          $135.71
 *
 *
 *  ------------------------------------------------------
 *  THANK YOU
 *  ------------------------------------------------------
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class CustomerOrder {


    private Scanner console;
    private ArrayList<OrderItems> orderInfo;
    private static String FILE_NAME = "customer_orders_team1.csv";


    public CustomerOrder(){
        orderInfo = new ArrayList<>(4000000);
        console = new Scanner(System.in);
        try {
            loadFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void loadFile() throws FileNotFoundException {
        try {
            Scanner in = new Scanner(new FileInputStream(FILE_NAME));
            //This will get past the first line that is just the titles of the collums and not data
            String titles = in.nextLine();

            //This loop will extrapolate the data from each line and create the entryItem with the line's data
            while(in.hasNextLine()) {
                String line = in.nextLine();
                int end = line.indexOf(",", 0);
                String date = line.substring(0, end);
                int start = end + 1;
                end = line.indexOf(",", start);
                String cust_email = line.substring(start, end);
                start = end + 1;
                end = line.indexOf(",", start);
                String tempLocation = line.substring(start, end);
                int cust_location = Integer.parseInt(tempLocation);
                start = end + 1;
                end = line.indexOf(",", start);
                String product_id = line.substring(start,end);
                start = end + 1;
                end = line.indexOf(",", start);
                String tempQuantity = line.substring(start, end);
                int product_quantity = Integer.parseInt(tempQuantity);


                OrderItems orderItems = new OrderItems(date,cust_email,cust_location,product_id,product_quantity);
                orderInfo.add(orderItems);
            }
            in.close();

        }catch (FileNotFoundException e) {}
        System.out.print(orderInfo.size());

    }
    //This will take all the elemnts in the array and save them back onto the CSV file
    public void saveFile() throws FileNotFoundException {
        try {
            PrintWriter out = new PrintWriter(FILE_NAME);
            //This puts back the labels that the loadFile removed
            out.println();
            int i = 0;

            while(i < orderInfo.size()){
                String saved = orderInfo.get(i).toString();
                out.println(saved);
                i++;
            }
            out.close();
        } catch(FileNotFoundException e){}

    }

    public static void main(String[]args) throws IOException{

        //Initializing the constructor
        CustomerOrder custOrder = new CustomerOrder();

    }


    //This method will make accessible to the employee to look at the inventory.
    private void viewInventory(){

    }

    //This method will have the employee be able to place the customer
    //order and be review the order, and be asked for confirmation from the user
    private void placeOrder(){

    }

    //This method will view the order the user looked up and will be given
    //the option whether they would like to cancel the order.
    private void cancelOrder(){

    }



    //This method will view the order specifically with the
    // date,customer_email,customer_location, productID, quality
    private void viewOrder(){

    }

    //This method will receive data from previous method to print out the customer order.
    //**Optional Function** This method will also send the customer the confirmation of the order with
    //the receipt as well.
    private void printRecipt(){

    }


}