package Sem1FinalPractice;
import java.util.Scanner;

/**
 * Write a description of class ZipTest here.
 *
 * @author Kieran Sutton
 * @version 12/18/17
 */
public class ZipTest {
    public static void main() {
        PersonWithZip[] arrayZips = new PersonWithZip[3];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < arrayZips.length; i++) {
            System.out.print("Please enter a first and last name: ");
            String firstName = scanner.next();
            String lastName = scanner.next();
            System.out.print("Please enter " + firstName + " " + lastName + "'s zip code: ");
            int zipCode = scanner.nextInt();
            arrayZips[i] = new PersonWithZip(firstName, lastName, zipCode);
        }
        
        for(PersonWithZip person : arrayZips) {
            System.out.println(person);
        }
        
        PersonWithZip lowestZip = new PersonWithZip("", "", 99999);
        for(PersonWithZip person : arrayZips) {
            if(person.getZip() < lowestZip.getZip()) {
                lowestZip = person;
            }
        }
        System.out.println("Person with lowest zip: " + lowestZip);
    }
}