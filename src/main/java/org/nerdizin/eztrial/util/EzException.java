package org.nerdizin.eztrial.util;

//@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "An internal error occured")
public class EzException extends RuntimeException {

    public EzException(final String message) {
        super(message);
    }
}
