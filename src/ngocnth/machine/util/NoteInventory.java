/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.util;

import ngocnth.machine.entity.Note;

/**
 *
 * @author Ruby
 */
public class NoteInventory extends Inventory<Note> {

    @Override
    public long getTotal() {
        long total = this.storage.entrySet()
                .stream()
                .reduce(0L, (subTotal, item) -> subTotal + item.getKey().getValue() * item.getValue(), Long::sum);
        return total;
    }

}
