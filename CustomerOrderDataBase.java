/**
 * The finance, marketing, and sales departments want to understand customers better but need the historical data to do so.
 * They want to have a database/pseudo-DB that stores all of the customer order
 * information along with the time and date of their orders.
 * This database will grow each simulated day.
 *
 * This will program will function as a database that the employee is able to:
 *
 * **View the inventory of the product**
 *   -- This will allow the user to look product inventory
 *
 * **Adding the order of the product
 *   -- This will add in a new entry into the database.
 *
 * **Updating the order
 *   -- Will update the entry within the database.
 *
 * **Deleting the order of the product
 *   -- Will be able to delete an entry in the database.
 *
 *
 * **Viewing the orders made within the database
 *   -- Will search the database by finding the product ID and user_email
 *   -- View the current order
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class CustomerOrderDataBase {


    private Scanner console;
    private ArrayList<OrderItem> orderInfo;
    private static String FILE_NAME = "customer_orders_team1.csv";


    public CustomerOrderDataBase() {
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
            //Test System.out.println(titles);

            //This loop will extrapolate the data from each line and create the entryItem with the line's data
            while (in.hasNextLine()) {
                String[] parsedLine = in.nextLine().split(",");
                String date = parsedLine[0];
                String cust_email = parsedLine[1];
                String cust_location = parsedLine[2]
                String product_id = parsedLine[3];
                int product_quantity = Integer.parseInt(parsedLine[4]);

                OrderItem orderItem = new OrderItem(date, cust_email, cust_location, product_id, product_quantity);
                orderInfo.add(orderItem);
                //TEST System.out.println(orderItem.toString());
            }
                in.close();


        } catch (FileNotFoundException e) {
        }
        //TEST System.out.print(orderInfo.size());

    }

    //This will take all the elemnts in the array and save them back onto the CSV file
    public void saveFile() throws FileNotFoundException {
        try {
            PrintWriter out = new PrintWriter(FILE_NAME);
            //This puts back the labels that the loadFile removed
            out.println();
            int i = 0;

            while (i < orderInfo.size()) {
                String saved = orderInfo.get(i).toString();
                out.println(saved);
                i++;
            }
            out.close();
        } catch (FileNotFoundException e) {
        }

    }

    public static void main(String[] args) throws IOException {

        //Initializing the constructor
        CustomerOrderDataBase custOrder = new CustomerOrderDataBase();

        /*If the load isn't working try running the saveFile method.
        The save file will create a new file has the proper name and location in your computer to run.
        Then just copy and past the data into the new file that it creates.

        custOrder.saveFile();


         */
    }

    //This method will have the employee add in customer data into the database
    private void addOrder() {

    }

    //This method will update the current entry within the database
    private void updateOrder() {

    }

    //This method will delete the current entry within the database
    private void deleteOrder() {

    }

    //This method will view the order specifically with the
    // date,customer_email,customer_location, productID, quality
    private void viewOrder() {

    }

    public void displayMenue(){
        boolean quit = false;
        System.out.println("Welcome to the Customer Order Data Base!");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("Please type in the corresponding letter to proceed.");
        System.out.println();
        while (!quit) {
            // Printing out prompts to the user
            System.out.print("a.    Create a new order\n" +
                    "b.    View an order\n" +
                    "c.    Update an order\n" +
                    "d.    Delete an order\n" +
                    "f.    Quit\n");


            //This will receive the user input and process the correct char to
            //the correct if statement to proceed to the methods
            String input = console.next();
            if (input.contains("a")) {
                addOrder();
            }
            else if (input.contains("b")) {
                viewOrder();
            }
            else if (input.contains("c")) {
                updateOrder();
            }
            else if (input.contains("d")) {
                deleteOrder();
            }
            else if(input.contains("f")){ ;
                quit = true;
            }
            else{
                System.out.println("Invalid selection");
                System.out.println("Please type the corresponding letter next to the option you want.");
            }
        }
    }
    
}//FIN
