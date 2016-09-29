package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.exception.ApplicationException;
import io.crowdcode.speedbay.auction.factory.DomainFactory;
import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.Bid;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import io.crowdcode.speedbay.auction.service.AuctionService;
import io.crowdcode.speedbay.common.AnsiColor;
import io.crowdcode.speedbay.common.inmemory.InMemoryStore;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by SU00079 on 28.09.2016.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DomainFactoryConfiguration.class)
public class DomainFactoryConfigurationTest {

    @Autowired
    private DomainFactory domainFactory;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testConfigTest() throws Exception {
        assertNotNull(domainFactory);
    }

    @Test
    public void testIfBeansAreCorrectlyWiredTogether() throws Exception {
        Auction auction = domainFactory.createAuction();
        assertNotNull(auction);
        Bid bid = domainFactory.createBid();
        assertNotNull(bid);

    }

    @Test
    public void testScope() throws Exception {
        assertTrue(domainFactory.createAuction() != domainFactory.createAuction());

    }

    @Test
    public void testLogBeanNames() throws Exception {
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            log.info(AnsiColor.red(beanName));
        }
    }
}