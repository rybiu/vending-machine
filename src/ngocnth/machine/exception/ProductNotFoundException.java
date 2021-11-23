/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.exception;

/**
 *
 * @author Ruby
 */
public class ProductNotFoundException extends BusinessException {

    public ProductNotFoundException(String patternMsg, Object... args) {
        super(patternMsg, args);
    }

}
