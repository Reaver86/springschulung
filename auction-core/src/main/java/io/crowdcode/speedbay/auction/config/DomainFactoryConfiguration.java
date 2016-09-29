package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.factory.DomainFactory;
import io.crowdcode.speedbay.auction.factory.DomainFactoryBean;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by SU00079 on 28.09.2016.
 */
@Configuration
public class DomainFactoryConfiguration {

    @Bean
    public DomainFactory domainFactory() {
        return new DomainFactoryBean();
    }

    @Bean
    @Scope("prototype")
    public Auction auction() {
        return new Auction();
    }

    @Bean
    @Scope("prototype")
    public Bid bid() {
        return new Bid();
    }
}
