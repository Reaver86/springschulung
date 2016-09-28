package io.crowdcode.speedbay.auction;

import io.crowdcode.speedbay.auction.config.BusinessLogicConfiguration;
import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.service.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by SU00079 on 28.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogicConfiguration.class})
public class IntegrationTest {
    @Autowired
    private AuctionService auctionService;

    @Test
    @Repeat(10)
    @DirtiesContext
    public void testApplicationContextWithIntegration() throws Exception {
        Auction auction = AuctionFixture.buildDefaultAuction();
        Long auctionId = auctionService.placeAuction(
                auction.getTitle(),
                auction.getDescription(),
                auction.getMinAmount());


        auctionService.bidOnAuction(auctionId, BigDecimal.valueOf(11));
        Auction found = auctionService.findAuction(auctionId);

        assertThat(found.getHighestBid().getAmount().doubleValue(), is(11.0));
        assertThat(auctionService.findRunningAuctions(), hasSize(1));
    }
}
