package yonzon.bsit2b;

import java.util.Scanner;

public class YonzonBSIT2B {

    public static void main(String[] args) {
   
        Scanner sc = new Scanner(System.in);
        String response;
        do{
            System.out.println("Welcome to BaragayDocs");
            System.out.println("\n1.Add Citizen");
            System.out.println("\n2.View Citizen");
            System.out.println("\n3.Update Citizen");
            System.out.println("\n4.Delete CItizen");
            System.out.println("\n5.Exit");
            System.out.println("\nSelect Option: ");
            int options = sc.nextInt();                                  
            YonzonBSIT2B amoy = new YonzonBSIT2B();
            switch(options){
                
                case 1:
                    amoy.addCitizen();
                     break;
                case 2:
                    amoy.viewCitizens();
                    break;
                case 3:
                    amoy.updateCitizen();
                    break;
                case 4:
                    amoy.deleteCitizen();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
                
            }
            System.out.println("Would you like to continue? (y/n): ");
            response = sc.next();
            
        }while(response.equalsIgnoreCase("y"));
        
        System.out.println("Thank you, Come back again!");
    }
    
    //ADD CITIZEN METHOD0
    public void addCitizen(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Citizen First Name: ");
        String fname = sc.next();
        System.out.print("Citizen Last Name: ");
        String lname = sc.next();
        System.out.print("Citizen Email: ");
        String email = sc.next();
        System.out.print("Citizen Status: ");
        String status = sc.next();
        System.out.println("Citizen Postal Code: ");
        String pcode = sc.next();
        System.out.println("Request a Document: ");
        String document = sc.next();
        int quantity = 0;
        
    while (true) {
        System.out.print("Document Quantity (1-5): ");
        String input = sc.next();
        try {
            quantity = Integer.parseInt(input);
            if (quantity < 1 || quantity > 5) {
                System.out.println("Please enter a quantity between 1 and 5.");
            } else {
                break; // Valid quantity; exit the loop
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }
        String sql = "INSERT INTO citizen (c_fname, c_lname, c_email, c_status, c_pcode, Document, document_quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, email, status, pcode, document, quantity);
    }
    
    private void viewCitizens() {
        config conf = new config();
        String amoyQuery = "SELECT * FROM citizen";
        String[] amoyHeaders = {"ID","Citizen First Name", "Cititzen Last Name", "Citizen Email", "Postal Code", "Citizen Status","Requested Document","Document Quantity"};
        String[] amoyColumns = {"c_id","c_fname", "c_lname", "c_email", "c_pcode", "c_status", "Document", "document_quantity"};

        conf.viewRecords(amoyQuery, amoyHeaders, amoyColumns);
    }
    private void updateCitizen() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Citizen ID to Update: ");
        int id = sc.nextInt();

        System.out.print("New First Name: ");
        String fname = sc.next();
        System.out.print("New Last Name: ");
        String lname = sc.next();
        System.out.print("New Email: ");
        String email = sc.next();
        System.out.print("New Status: ");
        String status = sc.next();
        System.out.print("New Postal Code: ");
        String pcode = sc.next();
        System.out.println("New Desired Document: ");
        String document = sc.next();
        
        int quantity = 0;
        while (true) {
        System.out.print("Document Quantity (1-5): ");
        String input = sc.next();
        try {
            quantity = Integer.parseInt(input);
            if (quantity < 1 || quantity > 5) {
                System.out.println("Please enter a quantity between 1 and 5.");
            } else {
                break; // Valid quantity; exit the loop
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }
        String sql = "UPDATE citizen SET c_fname = ?, c_lname = ?, c_email = ?,  c_pcode = ?, c_pcode = ?, Document = ?, document_quantity = ? WHERE c_id = ?";
        conf.updateRecord(sql, fname, lname, email, status, pcode, document, quantity, id);
    }
     private void deleteCitizen() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Citizen ID to Delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM citizen WHERE c_id = ?";
        conf.deleteRecord(sql, id);
    }
}