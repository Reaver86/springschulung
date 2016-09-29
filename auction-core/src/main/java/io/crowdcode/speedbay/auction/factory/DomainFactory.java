package io.crowdcode.speedbay.auction.factory;

import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.model.Bid;
import org.springframework.stereotype.Component;

/**
 * Created by SU00079 on 28.09.2016.
 */
@Component
public interface DomainFactory {
    public Auction createAuction();
    public Bid createBid();
}
