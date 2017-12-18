package Sem1FinalPractice;


/**
 * Write a description of class PersonWithZip here.
 *
 * @author Kieran Sutton
 * @version 12/18/17
 */
public class PersonWithZip {
    private String firstName;
    private String lastName;
    private int zipCode;
    
    public PersonWithZip(String firstNameInit, String lastNameInit, int zipCodeInit) {
        this.firstName = firstNameInit;
        this.lastName = lastNameInit;
        this.zipCode = zipCodeInit;
    }
    
    public int getZip() {
        return this.zipCode;
    }
    
    public String toString() {
        String output = "\nName: " + this.firstName + " " + this.lastName + 
                        "\nZip Code: " + this.zipCode;
        return output;
    }
}