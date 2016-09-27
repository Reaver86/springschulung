package io.crowdcode.speedbay.auction.repository.inmemory;

import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import io.crowdcode.speedbay.common.inmemory.InMemoryStore;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

/**
 * Created by SU00079 on 27.09.2016.
 */
@Setter
public class AuctionRepositoryInMemoryBean implements AuctionRepository {

    private InMemoryStore<Auction> store;

    @Override
    public Optional<Auction> find(Long auctionId) {
        return store.find(auctionId);
    }

    @Override
    public Auction findOne(Long auctionId) {
        return store.find(auctionId);
    }

    @Override
    public List<Auction> findAll() {
        return null;
    }

    @Override
    public Auction save(Auction auction) {
        return store.save(auction);
    }
}
