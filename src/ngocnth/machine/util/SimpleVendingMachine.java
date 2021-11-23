/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import java.util.ArrayList;
import java.util.List;
import ngocnth.machine.entity.Note;
import ngocnth.machine.entity.Order;
import ngocnth.machine.entity.Product;
import ngocnth.machine.exception.NotFullPaidException;
import ngocnth.machine.exception.NoteNotFoundException;
import ngocnth.machine.exception.ProductNotFoundException;

/**
 *
 * @author Ruby
 */
public class SimpleVendingMachine implements IVendingMachine {

    private final List<Product> products;
    private final Inventory<Note> notes;
    private final IPromotionEngine promotion;
    private Product cart;

    public SimpleVendingMachine() {
        this.products = new ArrayList<>();
        this.notes = new NoteInventory();
        this.promotion = new SimplePromotionEngine(this.products);
        this.initializeData();
    }

    private void initializeData() {
        this.products.add(new Product(1, "Coke", 10000));
        this.products.add(new Product(2, "Pepsi", 10000));
        this.products.add(new Product(3, "Soda", 20000));
    }

    @Override
    public void displayProduct() {
        this.products.forEach(System.out::println);
    }

    @Override
    public void selectProduct(String productId) throws ProductNotFoundException {
        try {
            int id = Integer.parseInt(productId);
            if (this.products.contains(new Product(id))) {
                int index = this.products.indexOf(new Product(id));
                Product product = this.products.get(index);
                this.cart = product;
            } else {
                throw new ProductNotFoundException("Product with id = %s is invalid", productId);
            }
        } catch (NumberFormatException e) {
            throw new ProductNotFoundException("Product with id = %s is invalid", productId);
        }
    }

    @Override
    public void addNote(String noteValue) throws NoteNotFoundException {
        Note note = Note.getByValue(noteValue);
        this.notes.put(note);
    }

    @Override
    public long getNotesBalance() {
        return this.notes.getTotal();
    }

    @Override
    public Order checkout() throws NotFullPaidException {
        long balance = this.notes.getTotal();
        long total = this.cart.getPrice();
        if (balance < total) {
            throw new NotFullPaidException("Balance is not enough");
        }
        Product gift = this.promotion.processPurchaseRequest(this.cart);
        Order order = new Order(this.cart, total, balance - total);
        order.setGift(gift);
        this.resetData();
        return order;
    }

    @Override
    public long refund() {
        long balance = this.getNotesBalance();
        this.resetData();
        return balance;
    }

    private void resetData() {
        this.notes.clear();
        this.cart = null;
    }

    @Override
    public void goNextDay() {
        this.promotion.processGoNextDayRequest();
    }

}
