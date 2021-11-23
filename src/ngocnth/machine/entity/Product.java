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
public class Product {

    private int id;
    private String name;
    private long price;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return this.id == ((Product) obj).getId();
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("    ID: %4s; Name: %7s; Price: %4d", this.id, this.name, this.price);
    }

}
