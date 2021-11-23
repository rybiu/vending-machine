/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import ngocnth.machine.entity.Order;
import ngocnth.machine.exception.NotFullPaidException;
import ngocnth.machine.exception.NoteNotFoundException;
import ngocnth.machine.exception.ProductNotFoundException;

/**
 *
 * @author Ruby
 */
public interface IVendingMachine {

    void displayProduct();

    void selectProduct(String productId) throws ProductNotFoundException;

    void addNote(String noteValue) throws NoteNotFoundException;

    long getNotesBalance();

    Order checkout() throws NotFullPaidException;

    long refund();

    void goNextDay();
}
