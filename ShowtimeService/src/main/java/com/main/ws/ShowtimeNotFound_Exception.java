
package com.main.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-04-07T18:18:14.956-07:00
 * Generated source version: 3.3.0
 */

@WebFault(name = "ShowtimeNotFound", targetNamespace = "http://ws.main.com/")
public class ShowtimeNotFound_Exception extends Exception {

    private com.main.ws.ShowtimeNotFound showtimeNotFound;

    public ShowtimeNotFound_Exception() {
        super();
    }

    public ShowtimeNotFound_Exception(String message) {
        super(message);
    }

    public ShowtimeNotFound_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ShowtimeNotFound_Exception(String message, com.main.ws.ShowtimeNotFound showtimeNotFound) {
        super(message);
        this.showtimeNotFound = showtimeNotFound;
    }

    public ShowtimeNotFound_Exception(String message, com.main.ws.ShowtimeNotFound showtimeNotFound, java.lang.Throwable cause) {
        super(message, cause);
        this.showtimeNotFound = showtimeNotFound;
    }

    public com.main.ws.ShowtimeNotFound getFaultInfo() {
        return this.showtimeNotFound;
    }
}
