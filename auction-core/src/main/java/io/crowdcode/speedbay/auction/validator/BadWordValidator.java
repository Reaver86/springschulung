package io.crowdcode.speedbay.auction.validator;

import io.crowdcode.speedbay.auction.exception.BadWordException;
import org.springframework.stereotype.Component;

/**
 * Created by SU00079 on 29.09.2016.
 */
@Component
public interface BadWordValidator {
    void checkBadWords(String title) throws BadWordException;
    boolean isInvalid(String title);
}
