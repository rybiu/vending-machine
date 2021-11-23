/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import java.util.Scanner;
import ngocnth.machine.entity.Order;
import ngocnth.machine.exception.NotFullPaidException;
import ngocnth.machine.exception.NoteNotFoundException;
import ngocnth.machine.exception.ProductNotFoundException;

/**
 *
 * @author Ruby
 */
public class SimplePurchaseFlow extends PurchaseFlow {

    @Override
    public void displayMenu() {
        System.out.println("*********************************************");
        System.out.println("       WELCOME TO THE VENDING MACHINE        ");
        System.out.println("*********************************************");
        this.machine.displayProduct();
        System.out.println("*********************************************");
    }

    @Override
    public void enterNote() {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("# Enter note (press q to quit): ");
            String input = scan.nextLine().trim();
            try {
                if (input.equalsIgnoreCase("q")) {
                    break;
                }
                this.machine.addNote(input);
            } catch (NoteNotFoundException e) {
                System.out.println(">>> " + e.getMessage());
            }
        } while (true);
        System.out.println(">>> Completed, your current balance is " + this.machine.getNotesBalance());
    }

    @Override
    public void selectProduct() {
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.print("# Enter product id: ");
                String id = scan.nextLine().trim();
                this.machine.selectProduct(id);
                break;
            } catch (ProductNotFoundException e) {
                System.out.println(">>> " + e.getMessage());
            }
        } while (true);
        System.out.println(">>> Completed, the product has been added to cart");
    }

    @Override
    public void checkoutOrder() {
        try {
            Order order = this.machine.checkout();
            order.display();
        } catch (NotFullPaidException e) {
            System.out.println(">>> " + e.getMessage());
            this.cancelOrder();
        }
    }

    @Override
    public void cancelOrder() {
        long refund = this.machine.refund();
        System.out.println(">>> Your request has been canceled, refund: " + refund);
    }

    @Override
    public void goToNextDay() {
        this.machine.goNextDay();
    }

}
