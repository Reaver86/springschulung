package io.crowdcode.speedbay.auction.exception;

/**
 * Created by SU00079 on 29.09.2016.
 */
public class BadWordException extends ApplicationException {
    public BadWordException(String title) {
        super("Bad Word found: " + title);
    }
}
