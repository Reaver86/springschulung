package io.crowdcode.speedbay.auction.validator;

import io.crowdcode.speedbay.auction.config.BadWordValidatorConfiguration;
import io.crowdcode.speedbay.auction.exception.BadWordException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by SU00079 on 29.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BadWordValidatorBean.class)
public class BadWordValidatorBeanTest {

    @Autowired
    private BadWordValidator badWordValidator;

    @Test(expected = BadWordException.class)
    public void checkBadWords() throws Exception {
        badWordValidator.checkBadWords("Perl");
    }
//
//    @Test
//    public void isInvalid() throws Exception {
//
//    }

}