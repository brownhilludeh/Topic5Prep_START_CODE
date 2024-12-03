package info.hccis.assignment.bo;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class to represent a flower shop order.
 *
 * @author bjmaclean
 * @since 20190521
 */
public class Order {

    public static final String BUSINESS_NAME = "Bernadette's Flowers";
    public static final String BUSINESS_ADDRESS = "25 Hopeton Road\nStratford, PE\nC1B 1H6";

    public static final double TAX_RATE = 0.15;
    public static final double COST_WELCOME_BABY_BOY = 90;
    public static final double COST_WELCOME_BABY_GIRL = 85;
    public static final double COST_VERY_SPECIAL_DELIVERY = 100;
    public static final double COST_LARGE = 500;

    public static final double COST_STUFFED_SMALL = 10;
    public static final double COST_STUFFED_MEDIUM = 20;
    public static final double COST_STUFFED_LARGE = 30;

    //instance attributes
    private int numberWelcomeBabyBoy;
    private int numberWelcomeBabyGirl;
    private int numberVerySpecialDelivery;
    private int stuffedAnimalOption;

    private Customer customer;
    
    /**
     * Custom constructor
     *
     * @param numberWelcomeBabyBoy
     * @param numberWelcomeBabyGirl
     * @param numberVerySpecialDelivery
     * @since 20190521
     * @author BJM
     */
    public Order(int numberWelcomeBabyBoy, int numberWelcomeBabyGirl, int numberVerySpecialDelivery,
            int stuffedAnimalOption) {
        this.numberWelcomeBabyBoy = numberWelcomeBabyBoy;
        this.numberWelcomeBabyGirl = numberWelcomeBabyGirl;
        this.numberVerySpecialDelivery = numberVerySpecialDelivery;
        this.stuffedAnimalOption = stuffedAnimalOption; //BJM 20190521 Added for assignment 4
    }

    /**
     * Default constructor
     *
     * @since 20190521
     * @author BJM
     */
    public Order() {
        //Default constructor.
    }

    /**
     * Show the business information to the console. Note that this method is
     * static. The information being displayed to the console is not dependent
     * on the instance attributes of any specific object.
     *
     * @since 20190521
     * @author BJM
     */
    public static void showBusinessInformation() {
        //Show the business information
        System.out.println(BUSINESS_NAME);
        System.out.println(BUSINESS_ADDRESS);
        System.out.println(""); //Empty line after display

    }

    /**
     * Get the object details from the user.
     *
     * @since 20190521
     * @author BJM
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);

        // Customer customer = new Customer();
        // customer.getInformation();

        //First of get the customer information
        customer = new Customer();
        customer.getInformation();
        
        //BJM 20190521 Added continual prompt for assignment 5
        boolean valid = true;
        do {
            valid = true; //Set to true.  Will be false if invalid.
            System.out.println("\nHow many 'Welcome Baby Boy' bouquets?");
            numberWelcomeBabyBoy = input.nextInt();
            input.nextLine();

            if (numberWelcomeBabyBoy < 0 || numberWelcomeBabyBoy > 20) {
                System.out.println("Invalid amount, please enter an amount between 0-20");
                valid = false;
            }
        } while (!valid);

        //BJM 20190521 Added continual prompt for assignment 5
        do {
            valid = true;
            System.out.println("How many 'Welcome Baby Girl' bouquets?");
            numberWelcomeBabyGirl = input.nextInt();
            input.nextLine();

            //BJM 20190521 Added for assignment 4
            if (numberWelcomeBabyGirl < 0 || numberWelcomeBabyGirl > 20) {
                System.out.println("Invalid amount, please enter an amount between 0-20");
                valid = false;
            }
        } while (!valid);

        //BJM 20190521 Added continual prompt for assignment 5
        do {
            valid = true;
            System.out.println("How many 'Very Special Delivery' bouquets?");
            numberVerySpecialDelivery = input.nextInt();
            input.nextLine();

            //BJM 20190521 Added for assignment 4
            if (numberVerySpecialDelivery < 0 || numberVerySpecialDelivery > 20) {
                System.out.println("Invalid amount, please enter an amount between 0-20");
                valid = false;
            }
        } while (!valid);

        //BJM 20190521 Added continual prompt for assignment 5
        do {
            valid = true;
            System.out.println("Stuffed animal option (1=Small 2=Medium 3=Large 0=None):");
            stuffedAnimalOption = input.nextInt();
            input.nextLine();  //burn
            //BJM 20190521 Added for assignment 4
            if (stuffedAnimalOption < 0 || stuffedAnimalOption > 3) {
                System.out.println("Invalid amount, please enter an amount between 0-3");
                valid = false;
            }
        } while (!valid);

        System.out.println(""); //empty line after input gathered

    }

    /**
     * Method which will calculate and return the subtotal.
     *
     * @return subtotal
     * @since 20190521
     * @author BJM
     */
    public double getSubtotal() {
        //Calculations
        double subtotal = numberWelcomeBabyBoy * COST_WELCOME_BABY_BOY
                + numberWelcomeBabyGirl * COST_WELCOME_BABY_GIRL
                + numberVerySpecialDelivery * COST_VERY_SPECIAL_DELIVERY;

        double stuffedAnimalCost = 0;
        switch (stuffedAnimalOption) {
            case 1:
                subtotal += COST_STUFFED_SMALL;
                break;
            case 2:
                subtotal += COST_STUFFED_MEDIUM;
                break;
            case 3:
                subtotal += COST_STUFFED_LARGE;
                break;
        }
        return subtotal;
    }

    /**
     * Calculate and return the tax amount
     *
     * @return Tax amount
     * @since 20190521
     * @author BJM
     */
    public double getTax() {
        return TAX_RATE * getSubtotal();
    }

    /**
     * Calculate and return the total amount due.
     *
     * @return Order total
     * @since 20190521
     * @author BJM
     */
    public double getTotal() {
        return getSubtotal() + getTax();
    }

    public int getNumberWelcomeBabyBoy() {
        return numberWelcomeBabyBoy;
    }

    public void setNumberWelcomeBabyBoy(int numberWelcomeBabyBoy) {
        this.numberWelcomeBabyBoy = numberWelcomeBabyBoy;
    }

    public int getNumberWelcomeBabyGirl() {
        return numberWelcomeBabyGirl;
    }

    public void setNumberWelcomeBabyGirl(int numberWelcomeBabyGirl) {
        this.numberWelcomeBabyGirl = numberWelcomeBabyGirl;
    }

    public int getNumberVerySpecialDelivery() {
        return numberVerySpecialDelivery;
    }

    public void setNumberVerySpecialDelivery(int numberVerySpecialDelivery) {
        this.numberVerySpecialDelivery = numberVerySpecialDelivery;
    }

    public int getStuffedAnimalOption() {
        return stuffedAnimalOption;
    }

    public void setStuffedAnimalOption(int stuffedAnimalOption) {
        this.stuffedAnimalOption = stuffedAnimalOption;
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString() {

        double total = getTotal();

        String output = "Order Summary";

        //BJM 20190521 Assignment 4 added large order indicator
        if (total >= COST_LARGE) {
            output += " (Large Order!)";
        }
        
        //BJM 20190521 Assignment 4 stuffed animal description
        String stuffedAnimalDescription = "";
        switch (stuffedAnimalOption) {
            case 1:
                stuffedAnimalDescription = "Small";
                break;
            case 2:
                stuffedAnimalDescription = "Medium";
                break;
            case 3:
                stuffedAnimalDescription = "Large";
                break;
            default:
                stuffedAnimalDescription = "None";
        }

        //Customer Details
        output += "\n\n"+customer.toString()+"\n";
        
        output += "\nNumber of Welcome Baby Boy bouquets: " + numberWelcomeBabyBoy;
        output += "\nNumber of Welcome Baby Girl bouquets: " + numberWelcomeBabyGirl;
        output += "\nNumber of Very Special Delivery bouquets: " + numberVerySpecialDelivery;
        output += "\nStuffed Animal: " + stuffedAnimalDescription;
        
        //https://kodejava.org/how-do-i-format-a-number-as-currency-string/
        //or
        //https://stackoverflow.com/questions/2379221/java-currency-number-format
        
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String subtotalCurrency = format.format(getSubtotal());
        String taxCurrency = format.format(getTax());
        
        //Using String format method
        String totalCurrency = String.format("$%,.2f", getTotal());
        
        output += "\nSubtotal:  " + subtotalCurrency;
        output += "\nTax: " + taxCurrency;
        output += "\nTotal Cost:  " + totalCurrency;
        return output;
    }
}
