/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import java.util.List;
import java.util.Random;
import ngocnth.machine.entity.Product;

/**
 *
 * @author Ruby
 */
public class SimplePromotionEngine implements IPromotionEngine {

    public static final long DEFAULT_BUDGET = 50000;
    public static final int DEFAULT_RATE = 10;
    public static final int ADVANCED_RATE = 50;
    public static final int CONSECUTIVE_PURCHASE_COUNT = 3;
    private final int MAX_RANDOM_TIMES = 1000;

    private long budget;
    private Product lastProduct;
    private int purchaseCount;
    private int currentRate;
    private final List<Product> products;

    public SimplePromotionEngine(List<Product> products) {
        this.budget = DEFAULT_BUDGET;
        this.currentRate = DEFAULT_RATE;
        this.products = products;
    }

    @Override
    public Product processPurchaseRequest(Product product) {
        this.updateData(product);
        if (this.purchaseCount == CONSECUTIVE_PURCHASE_COUNT) {
            this.purchaseCount = 0;
            if (this.budget > 0 && this.randomChange()) {
                return this.randomGift();
            }
        }
        return null;
    }

    private void updateData(Product product) {
        if (this.lastProduct != null && this.lastProduct.equals(product)) {
            this.purchaseCount++;
        } else {
            this.lastProduct = product;
            this.purchaseCount = 1;
        }
    }

    private boolean randomChange() {
        int startRange = new Random().nextInt(100);
        if (startRange + this.currentRate > 100) {
            startRange = 100 - this.currentRate;
        }
        int point = new Random().nextInt(100);
        return point >= startRange && point < startRange + this.currentRate;
    }

    private Product randomGift() {
        int index;
        int randomCount = 0;
        do {
            index = new Random().nextInt(this.products.size());
            randomCount++;
        } while (this.budget < this.products.get(index).getPrice() && randomCount < MAX_RANDOM_TIMES);
        if (this.budget >= this.products.get(index).getPrice()) {
            Product gift = this.products.get(index);
            this.budget -= gift.getPrice();
            return gift;
        }
        return null;
    }

    @Override
    public void processGoNextDayRequest() {
        if (this.budget > 0) {
            this.currentRate = ADVANCED_RATE;
        } else {
            this.currentRate = DEFAULT_RATE;
        }
        this.budget = DEFAULT_BUDGET;
        this.lastProduct = null;
        this.purchaseCount = 0;
    }

}
