/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import ngocnth.machine.entity.Product;

/**
 *
 * @author Ruby
 */
public interface IPromotionEngine {

    Product processPurchaseRequest(Product product);

    void processGoNextDayRequest();

}
