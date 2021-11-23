/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Ruby
 * @param <T>
 */
public abstract class Inventory<T> {

    private final int DEFAULT_AMOUNT = 1;

    protected TreeMap<T, Integer> storage;

    public Inventory() {
        this.storage = new TreeMap<>();
    }

    public TreeMap<T, Integer> getStorage() {
        return storage;
    }

    public void put(T item, int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        int quantity = 0;
        if (this.storage.containsKey(item)) {
            quantity = this.storage.get(item);
        }
        this.storage.put(item, quantity + amount);
    }

    public void put(T item) {
        this.put(item, DEFAULT_AMOUNT);
    }

    public Map.Entry<T, Integer> getEntry(T item) {
        Iterator<Map.Entry<T, Integer>> i = this.storage.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<T, Integer> entry = i.next();
            if (entry.getKey().equals(item)) {
                return entry;
            }
        }
        return null;
    }

    public boolean isExisted(T item) {
        return this.storage.containsKey(item);
    }

    public void display() {
        this.storage.forEach((item, quantity) -> {
            System.out.format("%30s; Quantity: %5d%n", item, quantity);
        });
    }

    public void clear() {
        this.storage.clear();
    }

    public int size() {
        return this.storage.size();
    }

    public abstract long getTotal();

}
