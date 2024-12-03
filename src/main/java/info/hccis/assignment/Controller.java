package info.hccis.assignment;

import info.hccis.assignment.bo.Order;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Main class which will control overall program flow.
 *
 * @author bjmaclean
 * @since 20190521
 */
public class Controller {

    private static double totalSoFar = 0;

    public static final String MENU = "\nMain Menu\n1 – Add an order\n"
            + "2 – Show total of all orders since program start\n"
            + "0 – Exit";

    public static void main(String[] args) {

        //Show the business information
        Order.showBusinessInformation();

        String option = "";
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(MENU);
            option = input.nextLine();
            switch (option) {
                case "1":
                    addOrder();
                    break;
                case "2":
                    showTotalOfAllOrders();
                    break;
                case "0":
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (!option.equalsIgnoreCase("0"));

    }

    /**
     * Allow the user to add a new order.
     *
     * @since 20190521
     * @author BJM
     */
    public static void addOrder() {
        Order order = new Order();
        order.getInformation();
        order.display();
        totalSoFar += order.getTotal();
    }

    public static void showTotalOfAllOrders() {
        //https://kodejava.org/how-do-i-format-a-number-as-currency-string/
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        System.out.println("Total so far: " + format.format(totalSoFar));
    }
}
