package io.crowdcode.speedbay.auction.repository;

import io.crowdcode.speedbay.auction.model.Auction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Repository
public interface AuctionRepository {

    Optional<Auction> find(Long auctionId);

    Auction findOne(Long auctionId);

    List<Auction> findAll();

    Auction save(Auction auction);

}
