/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.main;

import ngocnth.machine.util.PurchaseFlow;
import ngocnth.machine.util.SimplePurchaseFlow;

/**
 *
 * @author Ruby
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PurchaseFlow flow = new SimplePurchaseFlow();
        flow.execute();
    }

}
