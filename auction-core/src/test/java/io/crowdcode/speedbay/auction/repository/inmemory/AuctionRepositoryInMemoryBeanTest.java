package io.crowdcode.speedbay.auction.repository.inmemory;

import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import io.crowdcode.speedbay.auction.service.AuctionService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by SU00079 on 27.09.2016.
 */
public class AuctionRepositoryInMemoryBeanTest {

    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testApplicationContextWithIntegration() throws Exception {
        AuctionRepository repository = context.getBean("auctionRepository", AuctionRepository.class);
        assertNotNull(repository);

        AuctionService service = context.getBean("auctionService", AuctionService.class);
        assertNotNull(service);


        // TODO Plaziere eine Auction (AuctionFixture.buildProductDetail) verwenden

        Auction auction = AuctionFixture.buildAuction();

        Long auctionId = service.placeAuction(
                auction.getTitle(),
                auction.getDescription(),
                auction.getMinAmount());

        assertThat(auctionId, is(notNullValue()));

        service.bidOnAuction(auctionId, BigDecimal.valueOf(11));

        Auction found = service.findAuction(auctionId);

        assertThat(found.getHighestBid().getAmount().doubleValue(), is(11.0));
    }
}
