/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

/**
 *
 * @author Ruby
 */
public abstract class PurchaseFlow {

    protected final IVendingMachine machine;

    public PurchaseFlow() {
        this.machine = new SimpleVendingMachine();
    }

    public void execute() {
        do {
            this.displayMenu();
            this.enterNote();
            this.selectProduct();

            Menu checkoutMenu = new Menu("Check out", "Cancel");
            checkoutMenu.display();
            int choice = checkoutMenu.inputChoice();
            if (choice == 1) {
                this.checkoutOrder();
            } else {
                this.cancelOrder();
            }

            Menu finishMenu = new Menu("Continue", "Go to next day & continue", "Exit");
            finishMenu.display();
            choice = finishMenu.inputChoice();
            if (choice == 2) {
                this.machine.goNextDay();
            } else if (choice == 3) {
                System.out.println(">>> Thank you for using!!!");
                break;
            }
        } while (true);
    }

    public abstract void displayMenu();

    public abstract void enterNote();

    public abstract void selectProduct();

    public abstract void checkoutOrder();

    public abstract void cancelOrder();

    public abstract void goToNextDay();

}
