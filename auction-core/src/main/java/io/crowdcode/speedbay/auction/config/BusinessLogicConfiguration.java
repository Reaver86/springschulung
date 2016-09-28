package io.crowdcode.speedbay.auction.config;

import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import io.crowdcode.speedbay.auction.repository.inmemory.AuctionRepositoryInMemoryBean;
import io.crowdcode.speedbay.auction.service.AuctionService;
import io.crowdcode.speedbay.auction.service.AuctionServiceBean;
import io.crowdcode.speedbay.common.inmemory.InMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SU00079 on 27.09.2016.
 */
@Configuration
public class BusinessLogicConfiguration {

    @Bean
    public AuctionService auctionService(AuctionRepository auctionRepository) {
        AuctionServiceBean service = new AuctionServiceBean();
        service.setAuctionRepository(auctionRepository);
        return service;
    }

    @Bean
    public AuctionRepository auctionRepositoryInMemoryBean(InMemoryStore<Auction> store) {
        AuctionRepositoryInMemoryBean repository = new AuctionRepositoryInMemoryBean();
        repository.setStore(store);
        return repository;
    }

    @Bean
    public InMemoryStore<Auction> storeAuction() {
        InMemoryStore<Auction> store = new InMemoryStore<>();
        store.init();
        return store;
    }

}
