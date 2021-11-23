/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.entity;

/**
 *
 * @author Ruby
 */
public class Order {

    private Product product;
    private Product gift;
    private long total;
    private long change;

    public Order() {
    }

    public Order(Product product, long total, long change) {
        this.product = product;
        this.total = total;
        this.change = change;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getGift() {
        return gift;
    }

    public void setGift(Product gift) {
        this.gift = gift;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getChange() {
        return change;
    }

    public void setChange(long change) {
        this.change = change;
    }

    public void display() {
        System.out.println(">>> Order detail: ");
        System.out.println(this.product + "; Quantity:  1");
        if (gift != null) {
            System.out.println(">>> Gift detail: ");
            System.out.println(this.gift + "; Quantity:  1");
        }
        System.out.println(">>> Total : " + this.total);
        System.out.println(">>> Remaining Change: " + this.change);
    }

}
