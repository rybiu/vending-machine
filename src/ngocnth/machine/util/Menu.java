/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 *
 * @author Ruby
 */
public class Menu {

    private Consumer<Integer> handler;
    private List<String> options;

    public Menu() {
    }

    public Menu(String... options) {
        this.options = Arrays.asList(options);
    }

    public Menu(Consumer<Integer> handler, String... options) {
        this.handler = handler;
        this.options = Arrays.asList(options);
    }

    public void display() {
        System.out.println("# Choose next action");
        for (int i = 0; i < this.options.size(); i++) {
            System.out.format("%3d) %s%n", i + 1, this.options.get(i));
        }
    }

    public int inputChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.print("# Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > this.options.size()) {
                    System.out.println(">>> Invalid option");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Invalid option");
            }
        } while (choice < 1 || choice > this.options.size());
        return choice;
    }

    public void execute() {
        if (this.handler == null) {
            throw new MissingResourceException("Missing menu handler", "Consumer<Integer>", "");
        }
        this.display();
        int choice = this.inputChoice();
        this.handler.accept(choice);
    }

}
