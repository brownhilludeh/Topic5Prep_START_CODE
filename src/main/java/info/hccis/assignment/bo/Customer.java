package info.hccis.assignment.bo;

import info.hccis.assignment.util.CisUtility;

/**
 * Customer class
 *
 * @author bjmaclean
 * @since 20190521
 */
public class Customer {

    private String name;
    private String address1;
    private String address2;
    private String postalCode;
    private String phoneNumber;

    String phoneFormat = "\\d{3}-\\d{3}-\\d{4}";

    /**
     * Get values for the attributes.
     *
     * @since 20190521
     * @author BJM
     */
    public void getInformation() {

        // TODO to be implemented
        System.out.println("Customer Details");

        // getting the username
        name = CisUtility.getInputString("Enter Firstname and Lastname");
        postalCode = CisUtility.getInputString("Enter postal code");
        phoneNumber = CisUtility.getInputString("Phone number (999-999-9999):");
        while (!phoneNumber.matches(phoneFormat)) { 
            phoneNumber = CisUtility.getInputString("@Phone number (999-999-9999):");
        }

        // name = name.trim();

        // // spliting the username
        // String[] nameByParts = name.split(" ");

        // // spliting name firstname and lastname
        // String firstnameString = nameByParts[0];
        // String lastnameString = nameByParts[1];

        // // return uppercase
        // String newName = firstnameString.substring(0, 1).toUpperCase() +
        // firstnameString.substring(1).toLowerCase();
        // String newName2 = lastnameString.substring(0, 1).toUpperCase() +
        // lastnameString.substring(1).toLowerCase();

        // System.out.println(newName + " " + newName2);

        // String regex = "^()";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString() {
        String output = "Customer: " + name;
        output += "\n" + address1;
        output += "\n" + address2;
        output += "\n" + postalCode;
        output += "\n" + phoneNumber;
        return output;
    }
}
