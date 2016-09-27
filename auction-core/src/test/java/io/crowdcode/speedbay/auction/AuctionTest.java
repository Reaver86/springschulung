package io.crowdcode.speedbay.auction;

import io.crowdcode.speedbay.fixture.AuctionFixture;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by SU00079 on 27.09.2016.
 */
public class AuctionTest {

    @Test
    public void testGetHighestBid() throws Exception {
        Assert.assertThat(AuctionFixture
                .buildDefaultAuction()
                .getHighestBid()
                .getAmount()
                .doubleValue(), is(10.0));
    }
}
