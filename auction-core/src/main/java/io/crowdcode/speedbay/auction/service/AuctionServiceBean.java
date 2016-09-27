package io.crowdcode.speedbay.auction.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of Auction Service
 */
@Getter
@Setter
@Slf4j
public class AuctionServiceBean implements AuctionService {

    private String name;

    public void testMethod(){
        log.debug("Test Method was executed!");
    }



}
