package io.crowdcode.speedbay.auction.factory;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by SU00079 on 28.09.2016.
 */
@Component
public class DomainFactoryBean implements DomainFactory {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Auction createAuction() {
        return applicationContext.getBean(Auction.class);
    }

    @Override
    public Bid createBid() {
        return applicationContext.getBean(Bid.class);
    }
}
