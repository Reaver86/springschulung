package io.crowdcode.speedbay.auction.service;

import io.crowdcode.speedbay.auction.exception.AuctionExpiredException;
import io.crowdcode.speedbay.auction.exception.AuctionNotFoundException;
import io.crowdcode.speedbay.auction.exception.BidTooLowException;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static io.crowdcode.speedbay.common.AnsiColor.green;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Setter
@Slf4j
public class AuctionServiceBean implements AuctionService {

    private String name;

    public AuctionServiceBean() {
        log.info(green("Here I am!"));
    }

    public AuctionServiceBean(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private AuctionRepository auctionRepository;

    @Override
    public Long placeAuction(String title, String description, BigDecimal minAmount) {
        return null;
    }

    @Override
    public Auction findAuction(Long auctionId) {
        return null;
    }

    @Override
    public List<Auction> findRunningAuctions() {
        return auctionRepository
                .findAll()
                .parallelStream()
                .filter(Auction::isRunning)
                .collect(Collectors.toList());
    }

    @Override
    public List<Auction> findExpiredAuctions() {
        return auctionRepository
                .findAll()
                .parallelStream()
                .filter(Auction::isExpired)
                .collect(Collectors.toList());
    }

    @Override
    public void bidOnAuction(Long auctionId, BigDecimal amount) throws AuctionNotFoundException, AuctionExpiredException, BidTooLowException {

    }
}
