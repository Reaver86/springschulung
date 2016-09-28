package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.service.AuctionService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by SU00079 on 27.09.2016.
 */
public class BusinessLogicConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(BusinessLogicConfiguration.class);
    }

    @Test
    public void testApplicationContextWithIntegration() throws Exception {
        AuctionService service = context.getBean("auctionService", AuctionService.class);

        Auction auction = AuctionFixture.buildDefaultAuction();

        Long auctionId = service.placeAuction(
                auction.getTitle(),
                auction.getDescription(),
                auction.getMinAmount());

        assertNotNull(auctionId);

        service.bidOnAuction(auctionId, BigDecimal.valueOf(11));
        Auction found = service.findAuction(auctionId);
        assertThat(found.getHighestBid().getAmount().doubleValue(), is(11.0));
    }

    @After
    public void tearDown() {
        context.close();
    }
}
