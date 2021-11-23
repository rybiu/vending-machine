/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnth.machine.exception;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Ruby
 */
public class BusinessException extends RuntimeException {

    private HashMap<String, Object> errorParams;

    public BusinessException() {
        super();
        this.initialize();
    }

    public BusinessException(String patternMsg, Object... args) {
        super(String.format(patternMsg, Arrays.toString(args)));
        this.initialize();
    }

    private void initialize() {
        this.errorParams = new HashMap<>();
    }

    public HashMap<String, Object> getErrorParams() {
        return errorParams;
    }

    public void setErrorParams(HashMap<String, Object> errorParams) {
        this.errorParams = errorParams;
    }

}
