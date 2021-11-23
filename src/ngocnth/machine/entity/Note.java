/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.entity;

import ngocnth.machine.exception.NoteNotFoundException;

/**
 *
 * @author Ruby
 */
public enum Note {
    NO_VALUE(0),
    TEN_THOUSAND(10000),
    TWENTY_THOUSAND(20000),
    FIFTY_THOUSAND(50000),
    ONE_HUNDRED_THOUSAND(100000),
    TWO_HUNDRED_THOUSAND(200000);

    private final long value;

    Note(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public static Note getByValue(String valueStr) throws NoteNotFoundException {
        try {
            long value = Long.parseLong(valueStr);
            for (Note note : Note.values()) {
                if (note.getValue() == value) {
                    return note;
                }
            }
            throw new NoteNotFoundException("Note with value = %s is invalid", valueStr);
        } catch (NumberFormatException e) {
            throw new NoteNotFoundException("Note with value = %s is invalid", valueStr);
        }
    }

}
